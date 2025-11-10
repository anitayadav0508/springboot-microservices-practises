# Detailed Code Flow Documentation

## Step-by-Step: Form Submission

### 1. User Submits Form with Checkboxes

```html
<input name="timings" value="Morning" />
<input name="timings" value="Afternoon" />
```

### 2. Spring Receives HTTP Request

Spring receives the form data as URL-encoded parameters:
```
timings=Morning&timings=Afternoon
```

### 3. Spring Creates Student Object and Calls Setter

Spring MVC's data binding mechanism automatically:
- Creates a new `Student` object
- Detects multiple values for `timings` parameter
- Creates a `String[]` array from the checkbox values
- Calls the setter method

```java
Student student = new Student();
student.setTimings(new String[]{"Morning", "Afternoon"});  // ← setTimings() called
```

### 4. Inside setTimings() Method

```java
public void setTimings(String[] timingsArray) {
    this.timingsArray = timingsArray;  // Store array
    this.timings = String.join(",", timingsArray);  // Convert to "Morning,Afternoon"
}
```

**What happens:**
- `timingsArray` is stored in the transient field (not persisted to DB)
- `timings` is set to a comma-separated string for database storage

### 5. Controller Receives Bound Student Object

```java
@PostMapping("/saveStudent")
public String handleRegBtnClick(Student student, Model model) {
    // student.timings = "Morning,Afternoon" (String)
    // student.timingsArray = ["Morning", "Afternoon"] (String[])
    
    // Controller can now use the bound Student object
    model.addAttribute("student", student);
    return "saved";
}
```

---

## Step-by-Step: Displaying Data

### 1. JSP Template Code

In `saved.jsp` (lines 91-92):

```jsp
<c:forEach var="timing" items="${student.timings}">
    ${timing}
</c:forEach>
```

### 2. JSP Expression Language Evaluation

When JSP encounters `${student.timings}`, it:
- Evaluates the expression
- Internally calls `student.getTimings()` to retrieve the value

### 3. Inside getTimings() Method

```java
public String[] getTimings() {
    if (timingsArray != null) {
        return timingsArray;  // Return array for JSP to iterate
    }
    if (timings != null && !timings.isEmpty()) {
        return timings.split(",");  // Fallback: split string if array is null
    }
    return new String[0];  // Return empty array if no data
}
```

**What happens:**
- Returns `String[]` array for JSP `<c:forEach>` to iterate over
- JSP loops through each timing value and displays it

### 4. Complete Display Flow

```
JSP renders saved.jsp
    ↓
Encounters ${student.timings}
    ↓
Calls student.getTimings()
    ↓
Returns String[] array
    ↓
<c:forEach> iterates over array
    ↓
Displays each timing value
```

---

## Summary

| Method | When Called | Who Calls It | Purpose |
|--------|-------------|--------------|---------|
| `setTimings(String[])` | Form submission (POST) | Spring MVC Data Binding | Bind form checkbox data to Student object |
| `getTimings()` | JSP rendering | JSP Expression Language | Get data as array for display in view |
| `getTimings()` | After loading from DB | Your code (via `@PostLoad`) | Convert String to String[] for display |

---

## Key Points

1. **Form Binding**: Spring automatically converts multiple checkbox values into a `String[]` and calls `setTimings()`
2. **Data Storage**: The `setTimings()` method stores both:
   - `timingsArray` (transient) - for form binding and display
   - `timings` (persistent) - comma-separated string for database storage
3. **Data Display**: JSP calls `getTimings()` which returns a `String[]` that can be iterated with `<c:forEach>`
4. **Database Loading**: When loading from DB, `@PostLoad` converts the comma-separated string back to an array


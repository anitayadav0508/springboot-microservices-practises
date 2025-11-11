# Spring Boot Validation MVC Project - Code Flow Documentation

## Table of Contents
1. [Project Overview](#project-overview)
2. [Architecture](#architecture)
3. [Project Structure](#project-structure)
4. [Request Flow](#request-flow)
5. [Validation Flow](#validation-flow)
6. [Component Details](#component-details)
7. [Step-by-Step Execution Flow](#step-by-step-execution-flow)
8. [Validation Rules](#validation-rules)

---

## Project Overview

This is a Spring Boot MVC application that demonstrates form validation using Jakarta Bean Validation (formerly Java Bean Validation). The application allows users to submit a user registration form with validation for username, password, email, and phone number.

**Technology Stack:**
- Spring Boot 3.5.7
- Java 17
- Jakarta Bean Validation
- JSP (JavaServer Pages)
- Bootstrap 5.3.2
- Apache Tomcat (Embedded)

---

## Architecture

```
┌─────────────┐
│   Browser   │
└──────┬──────┘
       │ HTTP Request
       ▼
┌─────────────────────────────────────┐
│     Spring Boot Application         │
│  ┌───────────────────────────────┐ │
│  │   DispatcherServlet           │ │
│  │   (Request Routing)           │ │
│  └───────────┬───────────────────┘ │
│              │                       │
│  ┌───────────▼───────────────────┐ │
│  │   UserController              │ │
│  │   (@Controller)               │ │
│  └───────────┬───────────────────┘ │
│              │                       │
│  ┌───────────▼───────────────────┐ │
│  │   Validation Framework        │ │
│  │   (@Valid, BindingResult)    │ │
│  └───────────┬───────────────────┘ │
│              │                       │
│  ┌───────────▼───────────────────┐ │
│  │   User Model                 │ │
│  │   (Bean Validation)         │ │
│  └──────────────────────────────┘ │
└─────────────────────────────────────┘
       │
       │ Response (JSP View)
       ▼
┌─────────────┐
│   Browser   │
└─────────────┘
```

---

## Project Structure

```
spring.boot.validation-mvc-project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/spring/boot/validation_mvc_project/
│   │   │       ├── Application.java              # Main Spring Boot Application
│   │   │       ├── ServletInitializer.java        # WAR deployment support
│   │   │       ├── binding/
│   │   │       │   └── User.java                 # User model with validation annotations
│   │   │       └── controller/
│   │   │           └── UserController.java       # Request handler
│   │   ├── resources/
│   │   │   └── application.properties            # Configuration
│   │   └── webapp/
│   │       └── pages/
│   │           ├── index.jsp                      # User form page
│   │           └── dashboard.jsp                # Success page
│   └── test/
│
└── pom.xml                                       # Maven dependencies
```

---

## Request Flow

### 1. GET Request Flow (Loading Form)

```
User Browser
    │
    │ GET /user-form
    ▼
DispatcherServlet (Spring MVC)
    │
    │ Routes to @GetMapping("/user-form")
    ▼
UserController.loadUserForm()
    │
    │ 1. Creates new User object
    │ 2. Adds to Model with key "user"
    │ 3. Returns view name "index"
    ▼
View Resolver
    │
    │ Resolves "index" → /pages/index.jsp
    │ (Based on application.properties:
    │  spring.mvc.view.prefix=/pages/
    │  spring.mvc.view.suffix=.jsp)
    ▼
JSP Engine (Tomcat Jasper)
    │
    │ Renders JSP with Spring form tags
    │ Binds form to modelAttribute="user"
    ▼
HTML Response
    │
    ▼
User Browser (Displays Form)
```

### 2. POST Request Flow (Form Submission)

```
User Browser
    │
    │ POST /saveUser
    │ Form Data: uname, pwd, email, phno
    ▼
DispatcherServlet
    │
    │ Routes to @PostMapping("/saveUser")
    ▼
UserController.saveUser()
    │
    │ 1. Spring binds form data to User object
    │ 2. @Valid triggers validation
    ▼
Validation Framework
    │
    │ Validates User object against annotations:
    │ - @NotEmpty, @Size, @Pattern, @Email, @Digits
    │
    │ Results stored in BindingResult
    ▼
    │
    ├─► If Validation Fails
    │   │
    │   │ bindingResult.hasErrors() = true
    │   │
    │   ▼
    │   Return "index" (re-display form with errors)
    │
    └─► If Validation Succeeds
        │
        │ bindingResult.hasErrors() = false
        │
        ▼
        Process User data
        Add success message to Model
        Return "dashboard" (success page)
```

---

## Validation Flow

```
Form Submission
    │
    ▼
Data Binding (Spring MVC)
    │
    │ Form fields → User object properties
    │ uname → user.uname
    │ pwd → user.pwd
    │ email → user.email
    │ phno → user.phno
    ▼
@Valid Annotation Triggered
    │
    ▼
Validation Framework Processes Annotations
    │
    ├─► Username Validation
    │   ├─► @NotEmpty: Check if not empty
    │   └─► @Size(min=3, max=20): Check length
    │
    ├─► Password Validation
    │   ├─► @NotEmpty: Check if not empty
    │   ├─► @Size(min=8): Check minimum length
    │   └─► @Pattern: Check regex pattern
    │       (Capital letter + Special character)
    │
    ├─► Email Validation
    │   ├─► @NotEmpty: Check if not empty
    │   └─► @Email: Check email format
    │
    └─► Phone Number Validation
        ├─► @NotNull: Check if not null
        └─► @Digits(integer=10, fraction=0): Check 10 digits
    │
    ▼
Validation Results → BindingResult
    │
    ├─► Errors Found
    │   │
    │   ▼
    │   Each error contains:
    │   - Field name (path)
    │   - Error message
    │
    └─► No Errors
        │
        ▼
        Validation Successful
```

---

## Component Details

### 1. Application.java
**Purpose:** Main entry point for Spring Boot application

**Key Features:**
- `@SpringBootApplication`: Enables auto-configuration, component scanning, and configuration
- Starts embedded Tomcat server on port 8087 (configured in application.properties)

**Code:**
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

---

### 2. UserController.java
**Purpose:** Handles HTTP requests and manages form submission

**Methods:**

#### loadUserForm()
- **Mapping:** `@GetMapping("/user-form")`
- **Purpose:** Displays the user registration form
- **Flow:**
  1. Creates a new empty `User` object
  2. Adds it to the Model with key "user"
  3. Returns view name "index" (resolves to `/pages/index.jsp`)

#### saveUser()
- **Mapping:** `@PostMapping("/saveUser")`
- **Purpose:** Processes form submission with validation
- **Parameters:**
  - `@Valid User user`: Validates the User object
  - `BindingResult bindingResult`: Contains validation errors
  - `Model model`: For passing data to view
- **Flow:**
  1. Spring binds form data to User object
  2. `@Valid` triggers validation
  3. Checks `bindingResult.hasErrors()`
  4. If errors: return "index" (re-display form)
  5. If valid: process data, add success message, return "dashboard"

---

### 3. User.java (Binding/Model Class)
**Purpose:** Data model with validation constraints

**Fields and Validations:**

| Field | Type | Validations |
|-------|------|-------------|
| `uname` | String | @NotEmpty, @Size(min=3, max=20) |
| `pwd` | String | @NotEmpty, @Size(min=8), @Pattern |
| `email` | String | @NotEmpty, @Email |
| `phno` | Long | @NotNull, @Digits(integer=10, fraction=0) |

**Key Annotations:**
- `@NotEmpty`: Field must not be null or empty
- `@Size`: Validates string length
- `@Pattern`: Validates against regex pattern
- `@Email`: Validates email format
- `@NotNull`: Field must not be null
- `@Digits`: Validates numeric format (integer and fraction parts)

---

### 4. index.jsp (User Form)
**Purpose:** Displays the user registration form

**Key Components:**
- Spring Form Tag Library: `<form:form>`, `<form:input>`, `<form:errors>`
- Model Binding: `modelAttribute="user"`
- Form Action: `/saveUser` (POST)
- Error Display: `<form:errors path="fieldName">` shows validation errors

**Form Fields:**
1. Username: `<form:input path="uname">`
2. Password: `<form:password path="pwd">`
3. Email: `<form:input path="email" type="email">`
4. Phone Number: `<form:input path="phno" type="number">`

---

### 5. dashboard.jsp (Success Page)
**Purpose:** Displays success message after successful form submission

**Features:**
- Shows success message: `${msg}`
- Link to return to form: `<a href="user-form">`

---

### 6. application.properties
**Configuration:**
```properties
spring.application.name=spring.boot.validation-mvc-project
server.port=8087
spring.mvc.view.prefix=/pages/
spring.mvc.view.suffix=.jsp
```

**Explanation:**
- `server.port`: Application runs on port 8087
- `spring.mvc.view.prefix`: JSP files location prefix
- `spring.mvc.view.suffix`: JSP file extension

---

## Step-by-Step Execution Flow

### Scenario 1: User Loads Form (First Time)

1. **User Action:** Navigates to `http://localhost:8087/user-form`

2. **HTTP Request:**
   ```
   GET /user-form
   ```

3. **DispatcherServlet:**
   - Receives GET request
   - Routes to `UserController.loadUserForm()`

4. **Controller Execution:**
   ```java
   User useObj = new User();  // Creates empty User object
   model.addAttribute("user", useObj);  // Adds to model
   return "index";  // Returns view name
   ```

5. **View Resolution:**
   - ViewResolver resolves "index" → `/pages/index.jsp`
   - JSP engine processes the JSP file

6. **JSP Rendering:**
   - Spring form tags bind to `modelAttribute="user"`
   - Empty form fields are rendered
   - HTML sent to browser

7. **Browser Display:**
   - User sees empty form with four input fields
   - Form is ready for user input

---

### Scenario 2: User Submits Valid Form

1. **User Action:** Fills form and clicks "save" button

2. **HTTP Request:**
   ```
   POST /saveUser
   Content-Type: application/x-www-form-urlencoded
   
   uname=john123&pwd=Password1!&email=john@example.com&phno=1234567890
   ```

3. **DispatcherServlet:**
   - Receives POST request
   - Routes to `UserController.saveUser()`

4. **Data Binding:**
   - Spring MVC binds form parameters to User object:
     ```java
     user.setUname("john123");
     user.setPwd("Password1!");
     user.setEmail("john@example.com");
     user.setPhno(1234567890L);
     ```

5. **Validation Trigger:**
   - `@Valid` annotation triggers validation framework
   - All field-level annotations are evaluated

6. **Validation Checks:**
   - ✅ Username: Not empty, length 3-20 ✓
   - ✅ Password: Not empty, length ≥8, has capital, has special char ✓
   - ✅ Email: Not empty, valid format ✓
   - ✅ Phone: Not null, exactly 10 digits ✓

7. **Controller Logic:**
   ```java
   if(bindingResult.hasErrors()) {  // false
       return "index";  // Not executed
   }
   
   // Validation passed
   System.out.println("User: " + user);  // Logs user data
   model.addAttribute("msg", "user saved sucessfully!!");
   return "dashboard";
   ```

8. **View Resolution:**
   - Returns "dashboard" → `/pages/dashboard.jsp`

9. **Browser Display:**
   - Success message displayed
   - Link to return to form

---

### Scenario 3: User Submits Invalid Form

1. **User Action:** Submits form with invalid data
   ```
   uname=ab&pwd=weak&email=invalid&phno=123
   ```

2. **Steps 1-5:** Same as Scenario 2

3. **Validation Checks:**
   - ❌ Username: Length < 3 (fails @Size)
   - ❌ Password: Length < 8, no capital, no special char (fails @Size, @Pattern)
   - ❌ Email: Invalid format (fails @Email)
   - ❌ Phone: Not 10 digits (fails @Digits)

4. **BindingResult:**
   ```java
   bindingResult.hasErrors() = true
   bindingResult.getFieldErrors():
     - uname: "Username must be between 3 and 20 characters"
     - pwd: "Password must be at least 8 characters long, contain at least one capital letter and one special character"
     - email: "Please enter valid email"
     - phno: "PhoneNumber must be 10 long digits"
   ```

5. **Controller Logic:**
   ```java
   if(bindingResult.hasErrors()) {  // true
       return "index";  // Re-display form
   }
   ```

6. **View Resolution:**
   - Returns "index" → `/pages/index.jsp`
   - User object (with entered values) is still in model

7. **JSP Rendering:**
   - Form fields show previously entered values
   - `<form:errors>` tags display error messages next to each field

8. **Browser Display:**
   - Form displayed with error messages
   - User can correct errors and resubmit

---

## Validation Rules

### Username (uname)
- **@NotEmpty:** Cannot be empty
- **@Size(min=3, max=20):** Must be 3-20 characters
- **Example Valid:** "john123", "user_name"
- **Example Invalid:** "ab" (too short), "" (empty)

### Password (pwd)
- **@NotEmpty:** Cannot be empty
- **@Size(min=8):** Must be at least 8 characters
- **@Pattern:** Must contain:
  - At least one uppercase letter (A-Z)
  - At least one special character (!@#$%^&*()_+-=[]{};':"\|,.<>/?)
- **Example Valid:** "Password1!", "MyPass@123"
- **Example Invalid:** "password" (no capital, no special), "Pass1" (too short)

### Email (email)
- **@NotEmpty:** Cannot be empty
- **@Email:** Must be valid email format
- **Example Valid:** "user@example.com", "test.email@domain.co.uk"
- **Example Invalid:** "invalid", "user@", "@domain.com"

### Phone Number (phno)
- **@NotNull:** Cannot be null
- **@Digits(integer=10, fraction=0):** Must be exactly 10 digits, no decimals
- **Example Valid:** 1234567890, 9876543210
- **Example Invalid:** 123 (too short), 12345678901 (too long), null

---

## Key Spring MVC Concepts Used

### 1. Model-View-Controller (MVC) Pattern
- **Model:** User.java (data model)
- **View:** index.jsp, dashboard.jsp (presentation)
- **Controller:** UserController.java (request handling)

### 2. Data Binding
- Spring automatically binds form data to Java objects
- Uses setter methods matching form field names

### 3. Validation Framework
- Jakarta Bean Validation (JSR 380)
- Annotations-based validation
- Automatic error collection in BindingResult

### 4. View Resolution
- ViewResolver maps logical view names to actual JSP files
- Configured via application.properties

### 5. Form Tag Library
- Spring JSP tags for form binding
- Automatic error display
- Model attribute binding

---

## Dependencies (Key)

```xml
<!-- Validation Support -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Web Support -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- JSP Support -->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

---

## Error Handling Flow

```
Validation Error Occurs
    │
    ▼
Error added to BindingResult
    │
    ▼
Controller checks bindingResult.hasErrors()
    │
    ▼
Returns view name "index"
    │
    ▼
JSP renders with <form:errors> tags
    │
    ▼
Error messages displayed next to fields
    │
    ▼
User sees errors and can correct them
```

---

## Best Practices Demonstrated

1. **Separation of Concerns:** Controller, Model, and View are separated
2. **Validation at Model Level:** Business rules in the model class
3. **User-Friendly Error Messages:** Custom messages for each validation
4. **Form Data Persistence:** Invalid form data is preserved for user correction
5. **RESTful URLs:** Clean URL structure (/user-form, /saveUser)

---

## Troubleshooting

### Common Issues:

1. **Form not submitting:**
   - Check form action path matches controller mapping
   - Verify method="POST" in form tag

2. **Validation not working:**
   - Ensure @Valid annotation is present
   - Check BindingResult parameter is after @Valid parameter
   - Verify validation dependencies in pom.xml

3. **Errors not displaying:**
   - Ensure <form:errors> tags are present in JSP
   - Check error path matches field name
   - Verify model attribute name matches form modelAttribute

4. **JSP not rendering:**
   - Check view prefix/suffix in application.properties
   - Verify JSP files are in correct location
   - Ensure tomcat-embed-jasper dependency is present

---

## Summary

This application demonstrates a complete Spring Boot MVC form validation workflow:

1. **GET Request:** Loads empty form
2. **POST Request:** Submits and validates form data
3. **Validation:** Checks all constraints
4. **Error Handling:** Displays errors if validation fails
5. **Success:** Shows success message if validation passes

The flow is clean, maintainable, and follows Spring Boot best practices for form validation in MVC applications.


![img.png](img.png)

# INSERT INTO genders (gender_id, gender_name) VALUES (1, 'Male');
# INSERT INTO genders (gender_id, gender_name) VALUES (2, 'Fe-Male');
# INSERT INTO courses (course_id, course_name) VALUES (1, 'Java');
# INSERT INTO courses (course_id, course_name) VALUES (2, 'Python');
# INSERT INTO courses (course_id, course_name) VALUES (3, 'Testing');
# INSERT INTO timings (timing_id, timing_name) VALUES (1, 'Morning');
# INSERT INTO timings (timing_id, timing_name) VALUES (2, 'Afternoon');
# INSERT INTO timings (timing_id, timing_name) VALUES (3, 'Evening');


# ------------------Explaination-----------------------------------------
 # Am i writing to logic to capture the formdata or dispatcher servlet will write logic to write the formdata that is known as pre-processing of the logic
#  we are showing gender options,course options and timing option from database tables/entity
# genders,courses,timings table in db.
# ![img_1.png](img_1.png) ![img_2.png](img_2.png) ![img_3.png](img_3.png)
# we are using three respositories to load data from the database
# create service class that is studentService , here we have logic to load data from database
# create form  binding class which is used to bind the  form data , form data can store to object and object data can store into the form.i.e Student class
# create student controller class i.e StudentController then create the presentation files , i.e index.jsp,saved.jsp

# How model object works ?
      @GetMapping("/loadForm")
    public String displayForm(Model model){
        model.addAttribute("genders",studentService.getGenders());
        model.addAttribute("courses",studentService.getCourses());
        model.addAttribute("timings",studentService.getTimings());
        Student student = new Student();
        model.addAttribute("student",student);

        return "index";
    }

# dispatcher servlet called this method , so in order to call this method dispatcher servlet will create the model and it will pass the model object as a parameter to this method, whatever data are you storing 
# dispatcher servlet will get data and will send to view component that means whatever you store in model object it will be available to that view file , mapping will be taken care by dispatcher servlet , model is just like a map which store data in key-value pair ,
# this map data available for index view file, whatever data you store in model object in the method , whatever view name return by method that model data available for view file. whenever you go view file
# it access modelAttribute="student", initially data will go from controller to view, in starting our student object don't have any data thats why form load which empty data i.e line 29 of above snipped code 


# dispatcher servlet fetch formdata, did we write the logic to capture data from form ans is no so dispatcher servlet will capture the formdata
# and store data into object pass  the form data as parameter i.e student object parameter  to method handleRegBtnClick() . that's reason we are able to access formdata by student object
    @PostMapping("/saveStudent")
    public String handleRegBtnClick(Student student, Model model){
        System.out.println(student);
        model.addAttribute("student", student);
        return "saved";


    }




------------------------------------need to understand-----------------------------------------------
Flow diagram
1. User fills form → 2. Clicks Register → 3. Form submits (POST)         ↓4. Spring MVC receives request         ↓5. Spring calls setTimings() [BINDING]         ↓6. Controller receives Student object         ↓7. Service saves to database         ↓8. Controller returns "saved" view         ↓9. JSP renders → 10. Calls getTimings() [DISPLAY]
   When setTimings() is called
   Scenario 1: Form submission (POST request)
   Who calls it: Spring MVC's Data Binding mechanism
   When:
   User fills the form in index.jsp (lines 181-182):
   <input type="checkbox" name="timings" value="${timing}" />
   User clicks "Register" button
   Form submits to /saveStudent (POST request)
   Spring MVC's DispatcherServlet processes the request
   Spring sees the controller method:
   @PostMapping("/saveStudent")   public String handleRegBtnClick(Student student, Model model)
   Spring automatically:
   Creates a new Student object
   Reads form parameters: name, email, phno, gender, course, timings
   For timings, it sees multiple values (checkboxes) and creates a String[]
   Calls student.setTimings(String[] array) to bind the data
   Call stack:
   DispatcherServlet.doDispatch()  → RequestMappingHandlerAdapter.invokeHandlerMethod()    → ServletModelAttributeMethodProcessor.resolveArgument()      → DataBinder.bind()        → BeanWrapperImpl.setPropertyValue()          → Student.setTimings(String[])  ← HERE!
   When getTimings() is called
   Scenario 1: JSP rendering (displaying data)
   Who calls it: JSP Expression Language (EL) / JSTL
   When:
   Controller returns "saved" view (line 34 in StudentController)
   Spring renders saved.jsp
   JSP encounters this code (line 91-92 in saved.jsp):
   <c:forEach var="timing" items="${student.timings}">
   JSP EL evaluates ${student.timings}
   This triggers: student.getTimings() to get the value
   Call stack:
   DispatcherServlet.render()  → InternalResourceView.renderMergedOutputModel()    → JspServlet.service()      → index_jsp._jspService()        → JSP EL evaluates ${student.timings}          → Student.getTimings()  ← HERE!
   Scenario 2: When loading from database
   Who calls it: JPA/Hibernate (indirectly)
   When:
   studentRespository.save(student) is called (line 59 in StudentService)
   Later, when you load the student from DB:
   Student student = studentRespository.findById(id);
   JPA calls @PostLoad method (line 37-43 in Student.java)
   @PostLoad converts String timings → String[] timingsArray
   When you access student.getTimings(), it returns the array
   Detailed code flow
   Step-by-step: Form submission
   // 1. User submits form with checkboxes://    <input name="timings" value="Morning" />//    <input name="timings" value="Afternoon" />// 2. Spring receives: timings=Morning&timings=Afternoon// 3. Spring creates Student object and calls:Student student = new Student();student.setTimings(new String[]{"Morning", "Afternoon"});  // ← setTimings() called// 4. Inside setTimings():public void setTimings(String[] timingsArray) {    this.timingsArray = timingsArray;  // Store array    this.timings = String.join(",", timingsArray);  // Convert to "Morning,Afternoon"}// 5. Controller receives bound Student:@PostMapping("/saveStudent")public String handleRegBtnClick(Student student, Model model) {    // student.timings = "Morning,Afternoon" (String)    // student.timingsArray = ["Morning", "Afternoon"] (String[])}
   Step-by-step: Displaying data
<!-- In saved.jsp line 91-92 --><c:forEach var="timing" items="${student.timings}">    ${timing}</c:forEach><!-- JSP EL evaluates ${student.timings} --><!-- This internally calls: student.getTimings() --><!-- Inside getTimings(): -->public String[] getTimings() {    if (timingsArray != null) {        return timingsArray;  // Return array for JSP to iterate    }    // ... other logic}
Summary
Method	When Called	Who Calls It	Purpose
setTimings()	Form submission (POST)	Spring MVC Data Binding	Bind form data to Student object
getTimings()	JSP rendering	JSP Expression Language	Get data to display in view
getTimings()	After loading from DB	Your code (via @PostLoad)	Convert String to String[] for display
Visual flow
┌─────────────────┐│  User fills     ││  form & clicks  ││  Register       │└────────┬────────┘         │         ▼┌─────────────────┐│  Browser sends  ││  POST request   ││  timings=...    │└────────┬────────┘         │         ▼┌─────────────────┐│ Spring MVC      ││ Data Binding    │└────────┬────────┘         │         ▼┌─────────────────┐│ setTimings()    │ ← CALLED HERE│ converts array  ││ to String       │└────────┬────────┘         │         ▼┌─────────────────┐│ Controller      ││ receives Student│└────────┬────────┘         │         ▼┌─────────────────┐│ Service saves   ││ to database     │└────────┬────────┘         │         ▼┌─────────────────┐│ JSP renders     ││ saved.jsp       │└────────┬────────┘         │         ▼┌─────────────────┐│ getTimings()    │ ← CALLED HERE│ returns array   ││ for display     │





------------------------------------------END--------------------------------------------------
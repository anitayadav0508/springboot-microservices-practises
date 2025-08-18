# Spring Boot Project 2 – Autowired Concept
# Spring Boot Project 2 – Autowired Concept

#This is a spring boot application which start from start class(i.e in which main method lies)
first  SpringApplication.run() method start IOC Container now IOC container perform component scanning
. Component scanning perform from base package(the package in which start class present) from top to bottom
so first component scanning perform at com.practise.SB_Autowired_Concept_1 for start class i.e create bean for start class
due to annotation @springbootApplication(which  already contain annotation @enableAutoConfigurable + Component+ """) so Start class is
spring bean so its object created by IOC by using component scanning
2. Now IOC scan sub-package from top to bottom so userDao is first sub-base-package and it contain UserDao which is spring bean due to @Reporsitory annotation
   so IOC container use default constructor(if no any constructor) for creating object for dao bean class.
3. Now IOC scan sub-package from top to bottom i.e UserService is 2nd sub-base-package which contain
   parametrized constructor so IOC use parametrized constructor for object creation of userService but
   UserService class constructor expect UserDao object as a parameter , so Ioc having the responsibility to pass
   UserDao object to UserService constructor so here we inject a  object into a class using constructor which
   known as constructor injection. if userDao object is not created earlier by IOC and if it demanding in
   UserService constructor in that case target object creation is perform first .Note if we have default constructor
   in userService then IOC use default constructor for userService object creation because default constructor having
   high precedence in that case we have to write @Autowired annotation which is mandatory i.e to force IOC container
   to create userService object from parameterized constructor only.

4.after component scanning all object are created by IOC for all spring beans, now run method return IOC container
refernce i.e ConfigurableApplicationContext ctx =  SpringApplication.run(SbAutowiredConcept1Application.class, args);

//now i want to call userService mehtod i.e getRegisterUser(); for this i need UserServiceObject. here i will ask IOC
to give me userService object because IOC create object for userService.
UserService userService = ctx.getBean(UserService.class); //getBean() method have the capability to return userService
object // we are asking for object for IOC , not creating.
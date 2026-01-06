# To define Many to Many annotation , internally what w ill happen , it will crate a join table between my employee and project entity tables
# basically where it will have two columns one will be associated with the employee id which is a primary key here for employee entity and the other will be projectId which will be primary key in project entity , JPA will create join table based on combine employee and project entity name
# like employee_project and respective join columns but if you want to customize  table name and join columns name as below

@ManyToMany
@JoinTable(name = "employee_project",

             joinColumns =  @JoinColumn(name = "employee_id",referencedColumnName = "empId"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "projectId")
    )

# so we have join table and join columns , we have  join column which hold primary key of employee table i.e empId, while we have inverse join column which hole primary key of project table i.e projectId

# mappedBy :- we have to define that we are mapping this employee set by which property so basically it is assignedProjects

# In this project we have circular reference problem because Project having list of employees and similary employee having list of projects facing problems like stack over flow so on.
# so to avoid this problem we have to use @JsonIgnore on Project entity like this

# it means we are ignoring list of employees from project entity.

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectName;

    /* I don't  want to assign duplicate project to same employee */
    // mappedBy :- we have to define that we are mapping this employee set by which property so basically it is assignedProjects
    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    Set<Employee> employees =  new HashSet<>();
}

# *************************** To Run project*************************************************************************
# 1. POST  http://localhost:9090/employee/save
{
"empName":"Akash"
}

# 2. GET http://localhost:9090/employee/getEmployees

# 3.POST  http://localhost:9090/project/save

{
"projectName":"Akash"
}

# 4. GET http://localhost:9090/employee/getProjects

# 5 Assigned project to employee
# PUT  http://localhost:9090/employee/2/project/2



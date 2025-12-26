# POST http://localhost:9090/placeOrder

#   "customer": {
    "name": "Basant",
    "email": "b@gmail.com",
    "gender": "male",
    "products": [
      {
        "pid": 201,
        "productName": "Mobile",
        "price": 10000,
        "qty": 1
      },
      {
        "pid": 399,
        "productName": "Laptop",
        "price": 200000,
        "qty": 3
      }
    ]
}
}


# POST http://localhost:9090/purchase

{
"student": {
"rollno": 123,
"name": "anita",
"marks": 87,
"laptops": [
{
"id": 1,
"lname": "DELL"
},
{
"id": 2,
"lname": "HP"
},
{
"id": 3,
"lname": "MacBook"
}
]
}
}

GET http://localhost:9090/getInfoLaptopAssignToWhichStudent

# ************************************************** One To Many (Unidirectional) (More Preferable)and whose' own the Entity------------------------------------


# Whenever you make a mapping either one to Many to many to many you have to tell which entity own the relationship.
 # i.e in case of one to many i have customer and product entity , one customer can order multiple product so it is one To Many relationship.if you write below code

# 1. Way)

public class Customer {                                         

@Id
@GeneratedValue
private Integer id;
private String name;
private String email;
private String gender;
/*A customer can purchase a list of products*/

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
      private List<Product> products;

    /* Note: Customer id will act as foreign key in product table */
}
public class Product {
@Id
private Integer pid;
private String productName;
private Integer qty;
private Integer price;



}

in that case 3 tables will be created:

## Table 1: customer
| Column Name | Data Type | Constraint |
|-------------|-----------|------------|
| id          | INTEGER   | PRIMARY KEY (Auto Generated) |
| name        | VARCHAR   |            |
| email       | VARCHAR   |            |
| gender      | VARCHAR   |            |

## Table 2: product
| Column Name  | Data Type | Constraint |
|--------------|-----------|------------|
| pid          | INTEGER   | PRIMARY KEY |
| product_name | VARCHAR   |            |
| qty          | INTEGER   |            |
| price        | INTEGER   |            |

## Table 3: customer_products (Join Table - Auto Created)
| Column Name  | Data Type | Constraint |
|--------------|-----------|------------|
| customer_id  | INTEGER   | FOREIGN KEY → customer(id) |
| products_pid | INTEGER   | FOREIGN KEY → product(pid) |

> **Note:** JPA creates a JOIN TABLE because `@JoinColumn` is not specified.
> The join table name follows pattern: `{parent_table}_{child_field_name}`

# 2. Way ) ------------------------------------------------To avoid above problem you have to tell which Entity own the relationship in this case i am telling to hibernate/jpa Customer Entity-------------------------------------------------
# own the relationship
scenario : Unidirectional with @JoinColumn
──────────────────────────────────────────

Customer (OWNER)                    Product
─────────────────                   ───────
@OneToMany                          (no reference to Customer)
@JoinColumn("customer_id")   
│
│  "I control the FK"
│
▼
┌─────────────────┐
│ product table   │
│ - customer_id   │  ← FK managed by Customer
# ------------------------------------------------------------------------------------*****************************************------------------------------
## To Avoid Join Table (Use @JoinColumn)

```java
@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
@JoinColumn(name = "customer_id")  // FK goes directly in product table
private List<Product> products;
```

This creates only 2 tables:


## Table 1: customer
| Column Name | Data Type | Constraint |
|-------------|-----------|------------|
| id          | INTEGER   | PRIMARY KEY (Auto Generated) |
| name        | VARCHAR   |            |
| email       | VARCHAR   |            |
| gender      | VARCHAR   |            |


## Table 2: product (with FK column)
| Column Name  | Data Type | Constraint |
|--------------|-----------|------------|
| pid          | INTEGER   | PRIMARY KEY |
| product_name | VARCHAR   |            |
| qty          | INTEGER   |            |
| price        | INTEGER   |            |
| customer_id  | INTEGER   | FOREIGN KEY → customer(id) |



# -------------ONE TO MANY (BIDIRECTIONAL)(Complex so less preferable)------------------------------------------------------------------------------------------

# In Bidirectional, BOTH entities know about each other
# The @ManyToOne side (Child) ALWAYS owns the relationship
# The @OneToMany side uses `mappedBy` to indicate it's the inverse/non-owning side

## Code Structure:

```java
// Customer.java - INVERSE SIDE (does NOT own the relationship)
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String gender;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;
    
    // Helper method to sync both sides
    public void addProduct(Product product) {
        products.add(product);
        product.setCustomer(this);
    }
    
    public void removeProduct(Product product) {
        products.remove(product);
        product.setCustomer(null);
    }
}

// Product.java - OWNING SIDE (controls the FK)
@Entity
public class Product {
    @Id
    private Integer pid;
    private String productName;
    private Integer qty;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "customer_id")  // FK column in this table
    private Customer customer;
}
```

## Tables Created (Only 2 tables - NO join table):

## Table 1: customer
| Column Name | Data Type | Constraint |
|-------------|-----------|------------|
| id          | INTEGER   | PRIMARY KEY (Auto Generated) |
| name        | VARCHAR   |            |
| email       | VARCHAR   |            |
| gender      | VARCHAR   |            |

## Table 2: product (with FK column)
| Column Name  | Data Type | Constraint |
|--------------|-----------|------------|
| pid          | INTEGER   | PRIMARY KEY |
| product_name | VARCHAR   |            |
| qty          | INTEGER   |            |
| price        | INTEGER   |            |
| customer_id  | INTEGER   | FOREIGN KEY → customer(id) |

## Visual Representation:

```
Bidirectional OneToMany / ManyToOne
────────────────────────────────────

   Customer (INVERSE)                     Product (OWNER)
   ──────────────────                     ────────────────
   @OneToMany(mappedBy)      ◄──────►     @ManyToOne
   "I'm just a mirror"                    @JoinColumn("customer_id")
                                          "I control the FK"
```

## Who Owns the Relationship?

| Side | Annotation | Owner? | Has mappedBy? |
|------|-----------|--------|---------------|
| Customer | @OneToMany(mappedBy="customer") | ❌ NO | ✅ YES |
| Product | @ManyToOne + @JoinColumn | ✅ YES | ❌ NO |

> **Rule:** The side with `mappedBy` is NEVER the owner.
> **Rule:** The @ManyToOne side is ALWAYS the owner in bidirectional.

## Important: Syncing Both Sides

When saving, you MUST set the relationship from the OWNING side (Product):

```java
// In Controller - WRONG (won't persist the FK)
Customer customer = new Customer();
customer.getProducts().add(product);  // ❌ This is ignored!
customerRepository.save(customer);

// In Controller - CORRECT (set from owning side)
Customer customer = new Customer();
for (Product product : customer.getProducts()) {
    product.setCustomer(customer);  // ✅ Set the back-reference
}
customerRepository.save(customer);

// OR use helper method
customer.addProduct(product);  // ✅ Syncs both sides automatically
```

## JSON Serialization (Avoid Infinite Loop)

```java
// Customer.java
@JsonManagedReference
@OneToMany(mappedBy = "customer")
private List<Product> products;

// Product.java  
@JsonBackReference
@ManyToOne
private Customer customer;
```

#

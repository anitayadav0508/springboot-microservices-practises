# POST http://localhost:9090/student/course

{
"name": "santosh",
"age": 33,
"dept": "UI",
"courses": [
{
"title": "Angular",
"abbreviation": "ng",
"modules": 12,
"fee": 5000
},
{
"title": "React JS",
"abbreviation": "RJS",
"modules": 10,
"fee": 4500
},
{
"title": "Spring Boot",
"abbreviation": "SB",
"modules": 15,
"fee": 6000
}
]
}



# ---------------------------- How to run customer/product ManytoMany relationship------

POST - http://localhost:9090/customer/saveProduct

{
"name": "Anita Yadav",
"products": [
{
"productName": "MACBOOK",
"price": 100000.00
},
{
"productName": "DOVE SHAMPOO",
"price": 550.89
},
{
"productName": "FaceWash",
"price": 300
}
]
}

# GET  http://localhost:9090/customer/product/list

GET  http://localhost:9090/student/course/search/5000
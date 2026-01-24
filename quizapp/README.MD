# ---------------Project Implement Quiz Monolith Application-------------------------------------------------------------------

# ---------------------------------Question -----------------------------------------------------------------------------------------------

# Get all question from database

GET - http://localhost:8080/question/allQuestions
# Get all questions based on category

GET - http://localhost:8080/question/category/JAVA
# Create a new Question to database
POST - http://localhost:8080/question/add
{
"id": 3,
"questionTitle": " is event loop synchronous or not ?",
"option1": "yes",
"option2": "no",
"option3": "extends",
"option4": "implements",
"rightAnswer": "no",
"difficultylevel": "Easy",
"category": "node"
}

# Update existing question with new Question Field
PUT :- http://localhost:8080/question/update/3
{

    "questionTitle": " is event loop asynchronous or not ?",
    "option1": "yes",
    "option3": "extends",
     "difficultylevel": "Easy",
    "category": "node"
}

# Delete question from databases.
DELETE - http://localhost:8080/question/delete/3


# ------------------------------------------------Question End here--------------------------------------


# --------------------Quiz--------------------------------------------------------------------

# create a quiz of 5 java question whose title is JQUIZ 
POST - http://localhost:8080/quiz/create?category=JAVA&numQ=5&title=JQuiz

# Get all question of a specific quiz whose id is 1

GET - http://localhost:8080/quiz/get/1
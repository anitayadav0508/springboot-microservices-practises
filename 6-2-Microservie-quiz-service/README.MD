POST - http://localhost:9096/quiz/create
{
"category":"JAVA",
"numQuestions":5,
"title":"JQUIZ"
}

GET - http://localhost:9096/quiz/get/1

Via API Gateway (port 8765): use **lowercase** service ID `quiz-service`:
- GET - http://localhost:8765/quiz-service/quiz/get/1

POST - http://localhost:9096/quiz/submit/1
[{
"id":5,
"response":"All of the above"
},
{
"id":15,
"response":"To iterate over a sequence of numbers."
},
{
"id":7,
"response":"final int x = 5;"
},
{
"id":3,
"response":"extends"
},
{
"id":12,
"response":"size()"
}



]
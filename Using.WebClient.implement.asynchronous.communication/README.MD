# To run application use 
# Run first WebClient Project first
# ---------------------QuoteRestController -------------------------------------------------------------------
GET - http://localhost:9090/api/async/quote
GET - http://localhost:9090/api/sync/quote

# --------------------CustomerEventController-----------------------------------------------------------
# Run Mono vs Flux project first 
GET - http://localhost:9090/rest/flux
GET - http://localhost:9090/rest/mono


# -----------------------------------Ticket RestController-------------------------------------------------------
# Run FIRST IRCTC application first
POST - http://localhost:9090/ticket/async
Payload -
{
"name": "PAWANYADAV97",
"dob": "05-08-1992",
"gender": "Male",
"doj": "25-08-2026",
"from": "chennai",
"to": "HARYANA",
"train": "PNR1234"
}

POST - http://localhost:9090/ticket/sync
Payload -
{
"name": "PAWANYADAV97",
"dob": "05-08-1992",
"gender": "Male",
"doj": "25-08-2026",
"from": "chennai",
"to": "HARYANA",
"train": "PNR1234"
}

# what is webclient:- To consumes the rest api either in synchronous or asynchronous way.
# Webclient is a api which introduce in spring 5.x version, which is used to communicate with servers. 
# Q why webclient if we have already i market webclient:- Ans:- By WebClient we can perform both synchronous and Asynchronous communication. 
# what type of communication/request is required , synchronous or asynchronous?
# Ans: It depends on requirement of application,suppose my first api call response depends on 2nd api call request then refer synchronous request i.e if one api call depends on first api call result or any cor-relation b/w api refer
# synchronous request/communication otherwise refer asynchronous request/communication.By WebClient we can implement both type communication (synchronous/asynchronous). refer asynchronous_communication.png & synchronousCommunication.png


# WebClient is lies spring webflux reactive dependency.WebClient is an interface , you can't create object of the interface so what you need to do, you need to get the object of webclient interface implement class. while RestTemplate is class whose object can be created using new keyword.
# WebClient webclient = WebClient.create(), create() method will give us the implementation class object for WebClient.
# How we can represent a request is synchronous in webclient ?
# Ans:- block()
# How we can represent a request is asynchronous using webclient?
# Ans:- subscribe() method.


# ------------------------------Explanation how webClient is work-------------------------------------

# 1. first we get the webclient object using WebClient.create() method
   webclient.get()
            .uri(apiUrl)
            .retrieve()
             .bodyToMono(String.class)
             .block()

# 2  .get()- tell about the Request Type which in Get in this case
# 3 .uri() -  tell what is the  url of the 3rd party api
# 4 .retrieve()- getting the response which is sent by the 3rd party api
# 5 .bodyToMono()- once you get the response, whatever the response in the body, bind the response to this String object/ or store into the string variable, Here Mono represent we get single object or single response from api we use Mono
# 6 .block()- To make this request as synchronous, i.e we are blocking the thread execution until we get response from api.
 # accept(MediaType.APPLICATION_JSON):-  : To inform the api in which format client expect the response format.
# ----------------End of explanation here---------------------------------------------------------------------------------

# How async communication work:
# whenever client send a request , webclient assign that request to handler or Consumer and execute next line of code, when response from 3rd party api is comes it assign to handler and handler return result to webclient. By using subscribe() method wa are registered the handler.
# synchronous_Vs_AsynchronousRequest_Flow.png refer this image how synchronous and Asynchronous Request flow works:-

# UserCase-1(Sync):-
1. UI send a request to our API.
2. Our API send request to Quote API.
3. Quote Api send response to Our API.
4. Our API send request to UI.

# UseCase-2(Async Client):- 
 1. UI send a request to Our API.
 2. Our API call 3rd party api (i.e Quote Api)
 3. Quote Api registered a handler(using subscribe method.)
4. Dummy response send to UI(i.e request is in processing mode..)
5. Quote Api return response to handler 
6. Once Handler get the  response it to kafka stream
# Note whenever you perform async you need a handler who will handle the response when you receive.because immediately you don't get the response , after some time you get response then how you will deal with response for that we need to develop handler . Whenever you go for synchronous request webclient use block() method, for asynchronous request webclient use subscribe() method. Subscribe() method is used to configure the handler and handler will execute when you receive  response  from 3rd party api.
# Qus:- when to use which one sync/async client?
# Ans:- whenever you receive a request and you wait for response  and after getting response you send response to your UI api GO for synchronous request and whenever you receive a request and you don't want  to send response immediately from 3rd party api. or if we get delay response form 3rd party we will go for asynchronous request.

# ************************************** Real Life example fo Sync/Async Client*******************************************************************
# FastTrack application which work on asynchronous client/request, suppose you have a vehicle which having a fastTrack, it scan and instead of waiting of confirmation you leave from tollgate,and after sometime you get a message your tall tax is deducted that much amount. so it is Asynchronous Request. While earlier before FastTrack in tollgate  vehicle are paying amount of tall tax and until it didn't get slip of payment it wait for receipt. So it is synchronous Communication/Request.



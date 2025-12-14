# In this project i am going to design restapi for IRCTC(Railway) APPLICATION

# ![img.png](img.png)

# Procedure to follow to develop REST API
# --------------------------------------------------------------------------------
# 1) Understand the requirement
# 2) Decide consumes & produces formats.
# 3) Decide Endpoint input data structure.
# 4) Create Request Binding classes based on Input data structure.
# 5) Create Response Binding classes based on Output data structure.
# 6) Create Rest controller with Endpoint method.
# 7) Test endpoint behaviour using postman

# Q: why we are taking java classes in rest api method as parameter?
# A: if i develop my request/response on objects i can achieve interoperability because message convertor are their otherwise if i take end point directly with json as input then xml client can't access if i write my logic xml as input, json client cannot access, i want to support for both client if my client want data as json/xml it must be supported by our restapi.thats why i want to develop my restapi method with loosely coupling thats why for request structure i create one binding class and for response structure i also create one binding class
# To support Interoperability i.e if interoperability not supported then client can send data only in one format.

# Interoperability :- interoperability means your API can accept and return data in multiple formats (like JSON and XML), allowing different clients (Java, Python, .NET, mobile apps) to interact with it regardless of their technology stack.


# http://localhost:9092/bookticket
# {
    "name": "John Doe",
    "dob": "1990-05-15",
    "gender": "Male",
    "doj": "2025-12-25",
    "from": "Delhi",
    "to": "Mumbai",
    "train": "Rajdhani Express"
}
# headers -> content-type : application/json

# for xml type 
 ![img_1.png](img_1.png)
 # consume :- in which format method can take input
  # produce : in which format method can provide the response.

# method is directly taking data in json/xml format or dispatcher servlet convert data into respective object using message convertor and taking data from requestbody and pass to method as parameter.

# HttpMessageBodyReader:- Read data from request body.
 # HttpMessageBodyWriter:- Write data to response body.

# How Request/Response flow work or How Restapi works?
![img_3.png](img_3.png)
![img_5.png](img_5.png)

# let say client making request to server , dispatcher servlet will receive the request,dipatcher servlet will open the data packet and taking url from data packet , after that dispatcher servlet will find out based on url which controller is going to handle this request using HandleMapper class, handleMapper class tells that IRCTCController and bookTicket method will handle the request to dispatcher servlet ,dispatcher servlet will also see this method will diretly called answer is no , that method is expecting an object as a parameter , that object is a simple object or it have a annotation ? answer is yes it have @RequestBody annotation now dispatcher servlet will understand it having a annotation it is expecting a object as parameter and object data came into request body and if i don't annotate PassengerRequest passengerrequest with @RequestBody then dispatcher servlet will create empty object and pass empty object but we use @Requestbody, client(postman act as client) send data in the request body  to the server then dispatcher servlet immediately talk to HttpMsgbodyReader that i got a packet which having some data is in their body , please give me that data   HttpMsgBodyReader is available to read the data from the request body and give it to the message convertor, Message Convertor convert data based on content-type  from xml/json to object, whenever client send a request along with content-type,content-type will represent in which format client is sending data to api, suppose client send data in json format 
# then somebody read the data from requestbody, who is responsible to read data from request body,that is HttpMsgBodyReader, HttpMsgBodyReader will read data from request body and give it to the MessageConverters then MessageConverter will convert data to request binding class(In our method it is PassengerRequest object) then method bookTicket is executed and method is going to return an object(which is TicketResponse object) and method return data object will be converted by MessageConverter, i.e object data is converted  by MessageConverter to respective format of data by specify  Accept of header i.e in which format client accept data from api, now who is responsible to write data to response body 
# i.e HttpMsgBodyWriter is responsible to write data to response body, so then send the response to client.
# requestbody data will take care by HttpMsgBodyReader 
# response data will be take care by HttpMsgBodyWriter
# what is MessageConverter:- who will convert json/xml data to object and vice-versa.
# dispatcher servlet how do know which type of data is send by client:- by content-type of header

# how to run application
# ![img_4.png](img_4.png)

# What is Idempotent?
# Idempotent means that making the same request multiple times produces the same result as making it once. The server state remains the same regardless of how many times the request is repeat

# HTTP Methods - Idempotent vs Non-Idempotent
Method	Idempotent		Description
GET	      Yes		        Fetching data multiple times returns same result
HEAD	  Yes	            Same as GET but no body
PUT	      Yes		        Updating same resource with same data = same state
DELETE	  Yes		        Deleting same resource multiple times = still deleted
POST	  ❌ No		        Creates new resource each time
PATCH	  ❌ No	 	        May have different effects based on current state





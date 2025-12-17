# Instead of using postman/browser as client i am using java code/application as rest client in this project.
# It is used to send get request to this url https://dummyjson.com/quotes/random" by using getForEntity() method & we using string.class to store json data
# to string variables.

# image1.png :- in this Quote API(3rd party api) get request http request form Quote-client and Quote Api send response to Quoteclient so now QuoteClient need to save response in some variable either it is string or java class type.

# RestTemplate rt = new RestTemplate();
 # ResponseEntity<String> responseEntity = rt.getForEntity(apiUrl, String.class);
# 2nd parameter how the response you want to return at client side.
# String body = responseEntity.getBody();
# to perform a httpRequest we created RestTemplate Object.

# can i say my restapi which i develop on local system i.e this application/project is acting as client for Quote Api , my rest api act as just pass through api, so client is send request to my rest api, my rest api sending request to Quote Api, Quote Api will send response to json but at client side dealing with json directly is difficult i want to hold java object data at  client side  so first i need to design binding class.

# --------------------------------- Design---------------------------------------------------------------------------------
# Refer Image1.png who play role of ashok,raju & Rod Johnson
# Implement we need to develop a rest api which will get a random quotation and display that quotation in Upper case format.
# we need to develop a api which get a request  from end user  with random quotation value and provide quotation in upper case do i need to write code to generate random quotation or already we have Quote Api to get random quotation.can we integrate these two applications  Quote client and Quote api ? Ans is Yes,
# Can my client application communicate with Quote Api yes that is why RestTemplate come into picture.
# RestTemplate is predefined class which is used to send http request to server, request will go in synchronous manner , synchronous manner means whenever we called  getForEntity method it will wait for response until or unless we don't get response, thread will not execute the execution of code , thread is block till now  that is the reason
# it is called as synchronous. whatever raw response we get from Quote Api i need to represent into string format that is the reason i m taking 2nd parameter as string ,suppose if i want to take value in the form of object then client side conversion is required , server will provide raw data as response instead of object so at client side we need to do conversion in our case we do conversion in string from raw data.
# rt.getForEntity(apiUrl, String.class); :- first parameter will tell us that to which url request is to be send. Here Quote Api is 3rd party api
# what is the response given by QuoteApi i.e Json Value(Raw Data) in camel cases but my requirement to get Quotation in Upper Case.
# can we communicate from one application to another application? Ans: Yes, thats why distributed application comes into the pictures
# why we are learning Rest api :To develop the distributed application, i.e one application can communicate with another application with interoperability, our 39-SB-RS (Quote Client) application  should  communicate with Quote API , Here Quote API is developed by us or it is 3rd party application, here 39-SB-RS application developed by me on localhost server while Quote API is running on a server/internet so that anybody can access that it means it is Resource while 39-SB-RS is a application , which develop client program , In order to develop client application 
# we used a predefined class named RESTTemplate which is used to send a request to http server , rest template is synchronous client that means by using RESTTemplate when you are sending  http request to server that RestTemplate will block the thread until it receive response from the server.How we get response from rest api(Quote Api) did we send same response to our client (ie.Quote-Client) or send different response just like Raju is client for Ashok and Ashok is client for Rod Johnson, Raju access my Quote-Client api for get random quotation, Now in my application i don't have t
# the logic to generate the quotation , but Rod Johnson already developed the logic/api for generating the random quotation so our application will communicate with Rod Johnson Quote Rest api  which is running in US.My application is communicate with Rod Johnson api using Rest Template.Rod Johnson Quote Api will give response in json , JSON is Interoperable , can i give json response to end user Raju ? No, because it expecting Quotation in upper case . Here Raju is client for Ashok and Ashok act as Resource for Raju. Rod Johnson is Resource  for Ashok, And Ashok act as client.so Raju is access my Api and my api access Rod Johnson Api , in real time  this is microservice.Microservice is a design pattern which develop rest api.
# Raju sending a request to ashok application , ashok application will communicate with Rod Johnson . but Raju expect quotation in upper case , so conversion at Ashok or Quote-client is required convert json to object or client is responsible for this conversion(convert json to object using jackson api's , api won't do that ) so that object can easily changeable/ or we can perform operation easily like to convert to  upper case and so on this is universal requirement, so many people develop the restclient so to convert json to object at client side is universal requirement.Do we need to write logic to convert json to object or spring will write that logic ?Ans-Springmvc will do by the help of resttemplate which uses jackson api to convert json to object.
# In short our application is act as Rest-client for 3rd Party API while for end user it act as resource(Rest-server)


# for give below response we need two binding class first which having class variables
# like id and quote while other class having type and value variable which contain 

#     {
     "type": "success",
     "value": {
       "id": ...,
       "quote": "@SpringBoot with @springframwork is pure productivity!..."
     }
}

#  ResponseEntity<Value> responseEntity = rt.getForEntity(apiUrl, Value.class);
# Note:- With the above line, RestTemplate will receive response in json format and it will convert json response to java obj using jackson api.
# Message convertor happens only at server side  or client side both ? Ans is Both side, so as a programmer we are dealing/working with object but messageConvertor will convert to interoperable format.
# My application is communicate with 3rd party api (like 3rd Party Quote Api/3rd Party Flight Api)so it is distributed application.Did we know in which technology 3rd party api is implemented ans is No but we able to access 3rd party api due to interoperability we get response in json format.
# 
# ------------------- Refer image3,image4  for this----------------------------
# Design image4 how will it implement

# Just like an example
# MakeMyTrip (UI) -> call -> MakeMyTrip API(Backend Service) ->(call) -> 3rd Party Airline(Which list flights)
# Here MakeMyTrip calls serveral 3rd party api's of flights and list all flights to one pages(like Indigo 3rd party return json of Indigo flights let assume it is first json, like vistara 3rd party return json of vistara flight assume 2nd json and so on combine all json and retun one json array which listed all different type of  flights lists ) thats  why it known as distributed applications.
  MakeMyTrip -> Indigo(3rd party api)
  MakeMyTrip -> Vistara(3rd Party api)
  MakeMyTrip -> AirAsia      (3rd party api)
# Inshort Makemytrip calls serveral 3rd party api's and combine response of json from all 3rd party and preparing final json and return to MakeMyTrip UI.
# ------------ WHO IS THE RESOURCE-----------------------------------------------------------------------------------
# Here Airline act as resource for MakeMyTrip and MakeMyTrip act as resource for UI.
# --------------- WHO IS THE CLIENT---------------------------------------------------------
 # MakeMyTrip act as client for Airlines and UI is act as client for MakeMyTrip, 
# here MakeMyTrip play both roles it is acting as client as well as resource



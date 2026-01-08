# To Represent this application as client for service registry we use @EnableDiscoveryClient annotation  @EnableDiscoveryClient annotation is used to register this application with the service registry.It is a Spring Cloud annotation that is used to register the application with the service registry.
# Ques:- Do i need to start eureka server(service registry) first or eureka client first? Ans:-  first i need to start eureka server first if server is up & running only then i can register my client to server. Did i do any configuration change to register eureka client to eureka server? ANS:- No,The reason is the server port no i.e 8761 if eureka server is running on port no 8761 in that case eureka client will register to server automatically that is default port will be used by client for  serach for the service registry.Eureka server will use default port i.e 8761 then client will register to server automatically.

# Note:- Eureka sever itself register to service registry as client , do you want same application register itself as client ? Ans:- We should not register same application as client which act as eureka server or service registry. It must act as a eureka server.
eureka:
client:
register-with-eureka:false
# above property telling that don't register yourself with eureka you act as service registry don't act as client.(Write this configuration properties in 1-Microservice project)

# Q : Here Eureka client are registered automatically  or do i need to do manually register the eureka client to eureka server. Ans:- they automatically registered, because eureka server and client both are in same machine and eureka server is running on  port 8761.


# Q: How welcome-api registering with eureka server ?
# Ans:- IF our rest api contain annotation @EnableDiscoveryClient it automatically search for eureka server with port no 8761, if eureka server is running on same machine(in image why_we_need_service_registry.png both eureka server & client running on same machine) with port no 8761 then this client application registered with eureka server and how it registering that logic available in netflix-library code given by spring cloud , they already write that logic, 


# Q:- how to differentiate with is Client application or Server application ? Ans:-  by using annotations @EnableEurekaServer and @EnableDiscoverClient , @EnableEurekaServer annotation application known as Server application while application which contain @EnableDiscoveryClient annotation known as Client application.

# Q :- why to register welcome-api with eureka ?
# Ans:- Our microservice based architecture application means we have several api assume that i have 150 api in our project, can i remember all api's url and api's name ? or do i need a registry to manage,maintain and monitoring all the api's.That's why Service registry come into the picture,
# Advantage of service registry:- 
# 1. At one place you can know how many api's are running and what are the url of the api's and how many api's are up & running and how many are downs ?
# 2. By service registry you are able to do  inter-service communication.
# 3. service registry will help client side load balancing. 


#   Q   :- Now assume Eureka server running on one machine and Eureka client (Welcome-api) running on different i.e 2nd machine and assume we have another Eureka client i.e Greet-api which running on 3rd machine and so on then how to register client application to eureka server?
# Ans:- we have to add some configurations.

# Q :- how to tell eureka client is that eureka server is running on different location ?
# Ans:- I will give url of the eureka server to the client so that it will search eureka server on that url or location and registered. by this property  we are telling the client use this property and registered.   who is providing this facility?Ans:-spring cloud netflix library provide this facility to registered our application to eureka server.@EnableDiscoveryClient annotation is available and if this below property is available it will go and register with eureka server based on given url and if this property is not available it will search for eureka server with same machine with port no 8761 if it available it will registered or not available not registered.
client:
      service-url:
        defaultZone: ${DISCOVERY_URL:http://localhost:9090/eureka}

# if eureka server is running on different machine then give http://<ip-address>:9090/eureka in our case eureka server and client both are running on same machine so we can give http://localhost:9090/eureka.


# suppose user send a request to  REST-API-1 now REST-API-1 communicate with REST-API-2 inter-communication can be perform by 3 ways:-
# 1. restTemplate 2. webclient 3. feign client, To communicate with REST-API-2 we need url of REST-API-2 and give this hardcode url to restTemplate & webclient, but suppose REST-API-02 is deployed by cluster on multiple server which leads to multiple url to access REST API  but in rest template and webclient we can configure only one url to restTemplate or webclient.So when you are going to talk to inter-services restTemplate and webclient are recommended or not ? Ans:- Not recommended, Tomorrow my rest api is deploying on multiple server then multiple url will come if i go to the restclient or webclient always i send the request to only one url but my application is deploying on 3 different server and 3 different url are available thats why for inter-service communication we use Feign client.To achieve inter-service communication with dynamic url, we are going to use a concept called Feign client

# We can do interservice communication by 3 way but what is the problem ?:- if our rest api is deployed on more than one server in that case our program is hard-code the only one url but actually rest api is running more than one url it means it running on more than one server due to load balancing concept.if we use only when url of restapi in webclient/rest template in that case burden is on one server to reduce the burden we are running the rest-api is more than one server to distribute the load but resttemplate and webclient will talk to only one server by using hard-coded url.To avoid that problem feign client came into picture. Now i am create feign client  to REST-API-O1 which is used to access REST-API=02, Now for this feign client i will not configure any url directly for the feign client i configure the application name i.e which application i want to access  that application name i will configure for the feign client. what will the feign client will do ?Feign client will go to service registry and will identify the what is the url of the given service based on that url it will going to make a request.

# Q:- Am i am giving the url of the REST-API-02 to the feign client ? or feign client will get the rest-API-02 get the url from the service registry based on the application name? Ans:- feign client will get the url of the REST-API-02 based on the application name from the service registry.Tomorrow if you are running your rest api on 3 server am i hardcode the url or feign client will get the url on dynamically.Ans:- Dynamically it will get the url from service registry.

# Q:- Diff between webclient and feign client ?:- if you go for webclient you need to hard-code the url or you need to configure the url of your endpoint/application.Only one url you can configure but when you go for feign client yo no need to configure the url , you just tell which application you want to access, that application is already register with eureka, feign client will go to eureka/service-registry and get the url of the application based on the application name to achieve the communication this is called inter-service communciation. whenever you go inter-service communication by feign client loosely coupling is their.among the services. if the restapi url change or rest api is running on multiple server , feign client will get the url dynamically from the service registry.

# feign client is one of the component given by spring cloud netflix library which is used to achieve inter-service communication. if we use feign client to achieve inter-service communication our application will be loosely coupled no need to hard code the url to achieve the communication , url will be available into the  service-registry , feign client will get the url from the service registry based on the name of the application. 

# whenever a request comes to WELCOME-API i.e 2-Microsercice project then WELCOME-API will talk to GREET-API i.e 3-Microservice project so tell me where we put the Feign client should i create feign client to WELCOME-API or GREET-API which one ?Ans:-i had to create feign client to WELCOME-API because WELCOME-API wants to talk to GREET-API, so feign client should be available WELCOME-API.

# Q :- How communication is happen b/w rest-services and eureka server and feign client ?
# Ans:- whenever we make a request to WELCOME-API, WELCOME-API talk to feign client, feign client talk to service-registry and get the url of the GREET-API.


# Here welcome api talk to greet api by using feign client. So we get combined response from welcome api + greet api in case of /welcome request mapping.

# I have created an interface and for this interface i have specified one annotation called @FeignClient(name="GREET-API")and i have specifices  this client class is communicate to which rest-api for which api it is acting as client i have configure that.And i have written  a method what request we need to send this
# GREET-API , I have specified by using GetMapping annotation it means we need to send Get request with the slash greet (i.e /greet), /greet is the url pattern.

@FeignClient(name = "GREET-API-02")
public interface GreetClient {

    @GetMapping("/greet")
    public String invokeGreetApi();
}
# Here GREET-API-02 is the name of the application to which rest-api our welcome-api want to communicate.
# Q:- is this method is mandatory ?
@GetMapping("/greet")
public String invokeGreetApi();

# Ans:- YES,whenever we call this method it will make a request to this url pattern /greet(i.e @GetMapping("/greet)) based on the url of this api(GREET-API) which is @FeignClient().And if i don't write this method how request will go ? only when you write this method then request will go . So this is required.So whenever you call this method , this method get url of the GREET-API from the service registry and it will make a request to /greet url .
# Here GreetClient is an interface how this happening?Ans: In the background proxy classes will be created for the feign client.

# Run the complete project.
# Run project 1-Microservice then 2-Microservice then 3-Microservice
# localhost:9090
# open eureka server you see WELCOME-API AND GREET-API-02 click on GREET-API-02 and make url like this
http://192.168.1.101:3333/greet and then run welcome-api because its response depends on greet-api
http://192.168.1.101:1111/welcome/message

http://localhost:9090/
http://192.168.1.101:3333/greet
http://192.168.1.101:1111/welcome/message

# Advantage of service registry we are able to develop loosely coupled communication among one application to another application, without service registry can i configure the name of the application ? aNS:- No



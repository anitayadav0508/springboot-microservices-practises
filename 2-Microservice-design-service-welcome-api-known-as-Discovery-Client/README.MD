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

Q :- how to tell eureka client is that eureka server is running on different location ?
Ans:- I will give url of the eureka server to the client so that it will search eureka server on that url or location and registered. by this property  we are telling the client use this property and registered.   who is providing this facility?Ans:-spring cloud netflix library provide this facility to registered our application to eureka server.@EnableDiscoveryClient annotation is available and if this below property is available it will go and register with eureka server based on given url and if this property is not available it will search for eureka server with same machine with port no 8761 if it available it will registered or not available not registered.
client:
      service-url:
        defaultZone: ${DISCOVERY_URL:http://localhost:9090/eureka}

if eureka server is running on different machine then give http://<ip-address>:9090/eureka in our case eureka server and client both are running on same machine so we can give http://localhost:9090/eureka.

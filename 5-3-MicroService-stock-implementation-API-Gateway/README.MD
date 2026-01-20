# All the api manage by API-Gateway, what is in API-Gateway API-Gateway having the routing , what is the routing pattern ? Ans:-  if calc is in the url patttern  then request goes to calc-api , what calc-api will do ? it will using feign client to access the STOCK-PRICE-API and what will STOCK-PRICE-API will do it will take data from DB and give as respnse to STOCk-PRICE-CALC api. Now STOCK-PRICE-CALC api will calculate the totalcost based on response or companyStockprice which was given by STOCK-PRICE-API

# To run this application by using gateway how to run
# http://localhost:8080/price/HCL
# http://localhost:8080/stock/calc/HCL/2


# Whenever request comes  from this url http://localhost:8080/stock/calc/HCL/2it will go to API-Gateway and API-Gateway having REST API name i.e   uri: lb://STOCK-PRICE-API this property , but api gateway need url of this api so api gateway communicate with service registry and based on name, service registry provide url of the rest-api microservice.

# 

# http://localhost:8080/stock/calc/HCL/2(suppose this request comes to API-GATEWAY)
API-GATEWAY - > EUREKA SERVER -> RELEVANT-REST-API-MICROSERVICE -> NOW-REST-API-USING - USING FEIGN CLIENT -> USING-MICROSERVICE-NAME-WHICH-WAS-PROVIDED-TO-FEIGN-CLIENT ->COMMUNICATE-WITH-THAT-MICROSERVICE


# Load balancing:- 

# To reduce burden on one server we use load balancing, LBR(Load balancer) will decide which server will handle the which request if we have multiple server on which our application is running, LBR using following algorithm to decide which server handle the which request
#  1) Round-robin :- It will follow sequence manner to handle the request like first request handle by first server and so on...
 #  2) Sticky-session:- my application having a session  and my request process by first server and created session on first server,and if request go to second server my session is not their then how to manage whenever your application dealing with session use sticky-session algorithm.How it work?Ans:-whenever request comes it goes to LBR and request process by first server and session created on first server then your all request will go to first server. so on which server your session is created, all request will be handle by 
# that server only. 
 #  3) ip-hashing:- They will write on hash function which will generate number based on your ip address b/w 1 to 9 server.I write a function for that function i passed ip address as a parameter and  inside that function they wrote logic in that manner request will be handle by 1 to 9 server only because in our scenario's we have only 9 server. which  will return server no(b/w 1 to 9) and assign request to that server.

# has(ip){
return serverNum;
}

# just taking an example like facebook handle billion of request a at time so they  use LBR concept , did they give different-different url on which server request was handle ? Ans:- only one url (www.facebook.com)which was given to all the users and that url is of load balancer instead of every server url.

# All nine server having the same war and they connect to same database because database property for all server war is same/common.application which running on 9's server is it same or not ans:- same war/application difference is only that when x user send a request to application it handle by suppose 1st server, when y user send request to 4th server and so on....

# Q:-  A request comes to server directly or not ? Ans:- No , first it goes to LBR then LBR will decide this request is handle by which server based on above algorithm. LBR having DNS(like facebook.com is a DNS ) ,all nine server having 9 different urls , our request go to LBR instead of server , in LBR DNS mapping is their , like www.facebook.com which is a DNS which binds to 9's server URL,networking configuration is available in LBR.

# Scaling :- to adding more number of server know as scale up, to removing server known as scale down.
# scale up & scale down is provide high availability of system. Here 2 ways to scale-up & scale-down
# 1. Manual Scale UP/Manual Scale Down 
# 2.Automatic Scale UP/Automatic Scale down.:- Based on Incoming request server will add automatically, like if existing 9's server will not capable to handle the 1000's no of request then server will add automatically example:- Amazon Big Day Sale 
#  based on request it will identify whether no of server which are exist are they sufficient or not ? If not adding server initially 10 but if request in one seconds are coming billions then they added more server so on. suppose till at 2 am these billion of request are coming but after that request/traffic are reducing then we have to reduce the server but manually to reduce/add up  server is highly complicated so if it automatic , if traffic/request are reduce in case of automatic it will reduce/add the request.
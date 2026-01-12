# API-gateway will act as a single entry point for all the backend api's of our  application. or API-Gateway act as a front gate for all backend  api's.

# --------------------------------How Flow works:------------------------------------------------------------------------

# Request comes from UI to API-Gateway, does api gateway have the logic to process the request or actually api having the responsible to process the request,do we have the logic to API-Gateway to process the request or logic available to backend api ? In order to process the request the logic
# is available to backend api's.From the UI request will send that request will receive by API-Gateway, API-Gateway contains the logic of routing, i.e routing nothing but routing will helps or understand this request will be process by which backend api. Here we have a WELCOME-API OR GREET-API, whenever a request comes to API-Gateway whether that request process by WELCOME-API OR GREET-API decided by
# Routings which we configure at API Gateway. Routing will help the API-Gateway that which request will process by which backend api.Based on  URL-Pattern i am going to  configure the routing.

# I am sending request with /api1 url-pattern, request will go to api gateway and now based on routing api gateway will decide which backend api handle the request.
# According to routing configuration  if path contains api1 it will forward request  to GREET-API.

        
          uri: lb://GREET-API
          predicates:
            - Path=/ms/api1/**


# I am sending request with /api2 url-pattern, request will go to api gateway and now based on routing api gateway will decide which backend api handle the request.
# According to routing configuration  if path contains api1 it will forward request  to WELCOME-API.   
          uri: lb://WELCOME-API
          predicates:
            - Path=/ms/api2/**

# now WELCOME-API communicate with FC(Feign client ), feign client communicate with service registry based on application name it want url on which application is running and communicate with GREET-API and return the combined response of greet-api and welcome-api.
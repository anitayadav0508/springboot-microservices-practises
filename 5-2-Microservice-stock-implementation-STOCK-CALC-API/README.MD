# Here STOCK-CALC-API communicate with STOCK-REST-API(5-1_Microservice_stock_market_application_stock_price_api_1) microservice using feign client , feign client communicate with
# service-registry(i.e 5-stock-market-application-using-microservice-eureka-server-1) to know about microservice url on which it is running


# Q:- How many binding class is required refer image(HowSTOCK-CALC-API-communicate-with-STOCK-PRICE-API.)  ?
# A:-  2, Binding class is required  explanation i.e for request binding we don't need request binding class reason we are taking companyName as path variable in URI in STOCK-PRICE-API microservice, similarly in STOCK-CALC-API which taking cname & qty as pathVariable in URI. So we need
# response binding class only. One response binding class to bind response from STOCK-PRICE-API microservice and other response binding class which represent STOCK-CALC-API response.

# StockPriceApiResponse :-is used to hold response from STOCK-PRICE-API MICROSERVICE.

# StockCalcApiResponse :- is used to hold response from STOCK-CALC-API MICROSERVICE.

# @FeignClient(name = "STOCK-PRICE-API"):- annotation tells this is the client for whom ? This is the client for STOCK-PRICE-API then how to access STOCK-PRICE-API.
  @GetMapping("/price/{companyName}")
  public StockPriceApiResponse invokeStockPriceApi(@PathVariable String companyName);

# This is the feign client is exists in STOCK-PRICE-CALC Microservice  which is used to communicate with STOCK-PRICE-API MICROSERVICE from STOCK-PRICE-CALC MICROSERVICE with sending request by uri /price/{companyName} and whatever response is given by STOCK-PRICE-API microservice will represents by StockPriceApiResponse response binding class as object.

# To Run application in which order 

# http://localhost:8761/ (To run first application) (5-stock-market-application-using-microservice-eureka-server-1)

# http://192.168.1.101:1111/price/HCL  (2nd applicationURL which is REST-API STOCK-PRICE-API i.e 5-1-MicroService-market-application-stock-price-api-1)

# http://192.168.1.101:2222/stock/calc/HCL/2  (3RD ApplicationURL which is REST-API STOCK-CALC-API i.e 5-2-MicroService-stock-implementation-STOCK-CALC-API)

# why we are using portNumber :- Ans:- to showcase on which port no our REST-API are running , when we are using load balancing concept then we need port no to tell if i have more then one instance of our rest api are running which one instance of rest api  handle the request.

# Here first request which handle by STOCK-PRICE-API which give company stock price value and while STOCK-CALC-API is using STOCK-PRICE-API which calculate total cost of stocks based on quantity & price of each stock of company. 

# To run this application by using gateway how to run 
# http://localhost:8080/price/HCL
# http://localhost:8080/stock/calc/HCL/2


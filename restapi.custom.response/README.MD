
#  consumes =  {},in which format, our rest api method  take the data.
# produce = {}, in which format our rest api method returning the data.
# To bind our method to http Post request , @Postmapping
#  body in postman represent what data client send to server

# @GetMapping(value = "/customer",produces = {"application/json","application/xml"})
public Customer getCustomerDetails(){
Customer customer = new Customer();
customer.setCustomerId(101);
customer.setCustomerName("CustomerName");
customer.setCustomerPhoneNo(12345678);
return customer;
}
# produces attribute will represent data format supporting by rest api methods.Above method will support for both xml/json
# by produce we are telling supporting response format , client will use accept header in which format it want the response

# 2. Accept header is used to represent in which format client expecting the response.
# accept header attribute value must match with produces attribute values.its just like you order food according to menu only in a restaurant.

# if we provide accept header value not from produces arrays then we get 406 unsupported  it means client must choose the supported format only 
# list provided by restapi and how do client knows which supported format of rest api are by using documentation of restapi.
![img.png](img.png)

# when a client send a request with "Accept" header that value should match with produces value with only request can be processed otherwise it will return 406 not acceptable.

# Q) How client will know which formats supported for REST api method?
 #  Rest api development team should provide documentation to client team
# Note:- Now a days people are using swagger for documentation.

Q) Can client send data to rest api using GET request?
ans) Yes client application can send data to GET request method using Query Parameters & URI Parameters(Path Parameters). Query Parameter & URI Parameter will represents data in URL directly.
# Query Parm:- www.ashokit.in/courses?name=SBMS
# Path Param:- www.ashokit.in/courses/{SBMS}


# http://localhost:9090/fee?cname=java&tname=ashok
# @GetMapping(value = "/fee")
    public String getCourseFees(@RequestParam("cname")String cname,@RequestParam("tname") String tname){
      String msg = cname + "By" + tname + "is 5000 INR Only";
      return msg;
    }
# http://localhist:9090/fee?cname=java&tname="Ashok" (IN this url queryparameter is mandatory )


# client send data by query params and server/restapi read data from url using RequestParam

# http://localhost:9090/course 

# in this url (http://localhost:9090/course ) query parameter is optional because we set default value of name parameter with default value is "SBMS".

# @GetMapping(value = "/course", produces = {"text/plain"})
    public String getCourseDetails(@RequestParam(value = "name",defaultValue = "SBMS") String name){
        String msg = "";

        if("SBMS".equals(name)){
           msg = "New Batch from SBMS from 15-Jul-2021 @8:00 PM IST";
        }else if("JRTP".equals(name)){
            msg = "New Batch from JRTP from 15-Jul-2021 @8:00 PM IST";
        }else{
            msg = "New Batch for AWS From tomorrow onwards";
        }

        return msg;
    }

# Path Params:- used value directly in url. to differentiate b/w url pattern & path variable we use {} braces for path parameter.
  # http://localhost:9090/course/{cname}/trainer/{tname}

# Query params vs Path Params
# when we develop c2b application then use query params and for b2b application use path params.

# At rest api side we will use @PathVariable annotation to read Path Parameter Value.

# passing parameter in order must compulsory in case of path variable because in url they can be use anywhere but for query string parameter order no matter because they used  at the end of url.but in query parameter length is more as compare to path variable.url having limit of length.

# @GetMapping("/course/{cname}/trainer/{tname}")
    public String getCourseDetails(@PathVariable String cname, @PathVariable String tname){

        return cname + " teaches by " + tname + " by tomorrow by 8 p.m";
    }

# first we need cname then tname parameter so first parameter will assign to cname and second parameter will assign to tname and so on

# http://localhost:9090/params/course/java/trainer/ashok

# In UserRestController , addUser method is called by dispatcher servlet, to called this method dispatcher servlet need to pass user obj, in this case user object all field value pass as default value which is null because all field are wrapper class type , when User class object is created i.e print User contractor !! Client send data in json format 
# {
 "uid":101,
 "fname":"anita",
 "lname":"yaddav",
 "email":"alishayadav0508@gmail.com"

}

# below code snippet where we don't use @RequestBody annotation on User object so get null fields value.
# why i am taking User object data , because of any type of data we can take either json/xml anyone.

# public class UserRestController {

    @PostMapping(value = "/user")
    public String addUser(User user){
        System.out.println(user);

        String msg = "User saved Successfully..";
        return msg;

    }
}

# if i used http://localhost:9090/user url on the browser it consider this is a GET request , for consider this request as POST you have to hit by postman(P.M (short form of postman)) by selected httpMethod as POST.
# Getting following Errors:-(If i hit from browser)
# Sat Dec 06 15:33:18 IST 2025
#  There was an unexpected error (type=Method Not Allowed, status=405).
#  Method 'GET' is not supported. org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' is not supported
# at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.handleNoMatch(RequestMappingInfoHandlerMapping.java:267)


# ---------------How this application works internally according to above diagram.-----------------------
# client pass data in json format to server i passed data like 
![img_1.png](img_1.png) but server don't get data yet by @RequestBody annotation we are telling to dispatcher servlet data which was send by client in json and create user object based on that data,
# now dispatcher servlet will take data from client and using jax-b api or message convertor convert json to User object.



# @RequestBody:- this annotation is used to tell dispatcher servlet the data is coming in the Request body.
# why client send data in json/xml format ,reason is that if client send data in object format in that case if our client is dot net developer it will send dot net object or if our client is java developer it will send java object and so on.

![img_2.png](img_2.png)

# -----------How this application works internally according to above diagram.----------------------------

# client send data into json/xml format ({"uid":101,"fname":"Ashok","lname":"IT","email":"ashokit@gmail.com"}) but end point expected data into object format, dispatcher servlet take data , dispatcher servlet will understand this request is handle by particular controller , so dispatcher servlet will talk to handler mapper , handle mapper identify which controller handle this request , in our case UserRestController handle the request  and now dispatcher will check 
# what is the signature of this method then dispatcher servlet will understand that this method take user object as parameter and it is taking RequestBody as well then immediately dispatcher servlet take request body data from client and gives to messageConverter, message converter will convert data into java object and will give to dispatcher then dispatcher will pass
# the object to method as parameter and called our method then our method execute and provide the response.


# client send data in json format but method expect data into object format so how this miscommunication will be solved ?

# ans:- Here client send data in request body, request will go to dispatcher servlet, dispatcher servlet will understand what request coming from client, how client give the data based on that dispatcher servlet will identify respective message converter if json data comes it will use jackson convertor if xml data comes it will use jaxson-b converter and convert data to object and pass that object as parameter to our end point of the method and will call that method.

# Ques:-  how dispatcher servlet will understand that which format of data client is giving in the request payload or format of request body payload ?
# Ans:- Inside header we have content-Type: application/xml or application/json , it is the responsibility of client to tell to the server , in which format it sending the data .

# Qus:- difference b/w content-type and accept in http header request?
# Ans:- content-type will represent client sending data format to server, accept will represent client expecting data format from server.





# which message converter will be used by ?
# it decided by header's content-type if content-type is application/json it will use jackson api message convertor & if content-type is application/xml type it will used
# jackson-b convertor type.

# how content-type is work ?
![img_3.png](img_3.png)

# Q:-  client send data in that particular format (application/json) can we restrict at restapi?
# Ans:- Yes we can  using consumes = {"application/json"}
# @PostMapping(value = "/user",consumes = {"application/json"})
    public String addUser(@RequestBody User user){
        System.out.println(user);

        String msg = "User saved Successfully..";
        return msg;

    }

# @GetMapping(value = "/customer",produces = {"application/json","application/xml"})

#  consumes =  {},in which format, our rest api method  take the data.
# produce = {}, in which format our rest api method returning the data. 

# proudce = {} ,in which format our restapi method will produce the result.

# @PostMapping(value = "/user",consumes = {"application/json"})
 # consume = {}  in which format method will accept the data.


# in above case if we add our method consume={application/json} telling that restapi consume/or getting json data from client but we give xml data in payload and passing content-type:application/xml this tells that client provide payload data format in application/xml
# but rest api expect {application/json} data so get following error.
# ![img_4.png](img_4.png)

# consumes:- "consumes" attribute will represent in which format rest api method can take the input data.
# content-type:- "content-type" header is used to represent in which format client is sending data to server in request body.

# produces:- Represent method supporting response formats.
# Accept:- Represent client expecting response format.

# consumes:- Represent method supporting request formats.
# content-Type:- Represent client sending request format.
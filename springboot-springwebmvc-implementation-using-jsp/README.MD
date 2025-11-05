# We are creating three hyperLink on which click we calling  following url-pattern 

# context path of our application is 
 # localhost:9091

# /book,/product  is url pattern which append to context path of our application
#  so following url pattern hit when we navigate/click on hyperlink

# 1)  Get Book Data (first hyperlink) 
#  localhost:9091/book

# 2) Get Product Data (second hyperlink)
#  localhost:9091/product


# 2) Home (third hyperlink)
#  localhost:9091

# Click on first hyperlink(Get Book Data)
   # 1 this is a url pattern which binding to a method of controller in this case 
    #  /book is url pattern which bind to displayBookData() method of book controller 

# Click on second hyperlink(Get Product Data)
 # 2  this is a url pattern which binding to a method of controller in this case
 # /product is url pattern which bind to productDetails() method of product controller 

# Click on third hyperlink (Home)
  # 3  this is url pattern which binding to method of controller in this case localhost:9091
  # is url pattern which bind to index() method of indexController



# -----------------------annotation-----------------------------------------------------
 # 1.
# when we use @controller annotation it tells the dispatcher servlet is that it will return logical
 # view name or modelAndView object like in bookController and productController and indexController
 # both return logical view name either  by return string or modelAndView object.

# 2. if we return insurance object and annotation is @controller then dispatcher servlet expect logical view
 # name getting following error
       Whitelabel Error Page
      This application has no explicit mapping for /error, so you are seeing this as a fallback.
      There was an unexpected error (type=Not Found, status=404).
       JSP file [/pages/insurancePlan.jsp] not found

# ---------- @ResponseBody functionality and what it have to do--------------------------------------
# so if we return object or pojo class object in that case we have to add annotation @ResponseBody on method
 # level or @RestController at class level i.e on the controller

# to tell dispatcher servelet i am not returning logical view name or not using presentation technology 
# @controller + ResponseBody  = (@RestController)  whatever our method is returning that must go as response
# to our client 

# dispatcher servlet understand ihis is  not view file , this is a data directly that data send to client
# object not send to the client thats why dispatcher servlet perform post-processing i.e convert object to josn
# by using jakson api
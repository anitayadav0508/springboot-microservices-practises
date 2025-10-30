<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            text-align: center;
            padding-top: 100px;
        }
        h1 {
            color: #333;
        }
        p {
            color: #666;
            font-size: 16px;
        }
    </style>
</head>
<body>


  <a href="book">Get Book Data</a><br> <%--  this is a url pattern which binding to a method of controller in this case
                                         /book is url pattern which bind to displayBookData() method of book controller --%>

  <a href="product">Get Product Data</a>
  <%--  this is a url pattern which binding to a method of controller in this case
                                           /product is url pattern which bind to productDetails() method of product controller --%>

</body>
</html>

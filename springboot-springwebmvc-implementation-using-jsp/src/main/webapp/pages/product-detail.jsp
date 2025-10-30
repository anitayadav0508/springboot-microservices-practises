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
    <h2>Product Detail</h2>
    <b>${product.name}</b><br/> <%-- produc.name using getName() method of product pojo class --%>
      <b>${product.productId}</b><br/>
        <b>${product.price}</b><br/>
        <a href="/">Home</a>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
<font color='green'>${msg}
    <h3>User Registration Form</h3>
    
    <form:form action="createUser" modelAttribute="user" method="POST">
        <table>
            <tr>
                <td>Username:</td>
                <td><form:input path="uname" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Phno:</td>
                <td><form:input path="phno" /></td>
            </tr>
            <tr>
                <td><input type="reset" value="Reset" /></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Student Registration Form</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f5f5f5;
                        margin: 0;
                        padding: 20px;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                    }

                    .form-container {
                        background-color: white;
                        padding: 30px;
                        border: 2px solid #ccc;
                        border-radius: 4px;
                        width: 500px;
                        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                    }

                    h2 {
                        color: #333;
                        text-align: center;
                        margin-bottom: 25px;
                        font-size: 20px;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }

                    td {
                        padding: 10px 5px;
                        vertical-align: top;
                    }

                    td:first-child {
                        width: 120px;
                        font-weight: normal;
                        color: #333;
                    }

                    input[type="text"],
                    input[type="email"],
                    input[type="number"],
                    select {
                        width: 100%;
                        padding: 8px;
                        border: 1px solid #ccc;
                        border-radius: 2px;
                        box-sizing: border-box;
                        font-size: 14px;
                    }

                    .radio-group {
                        display: flex;
                        gap: 20px;
                        align-items: center;
                    }

                    .radio-group label {
                        display: flex;
                        align-items: center;
                        font-weight: normal;
                        margin: 0;
                        cursor: pointer;
                    }

                    .radio-group input[type="radio"] {
                        margin-right: 5px;
                        width: auto;
                    }

                    .checkbox-group {
                        display: flex;
                        flex-direction: column;
                        gap: 8px;
                    }

                    .checkbox-group label {
                        display: flex;
                        align-items: center;
                        font-weight: normal;
                        margin: 0;
                        cursor: pointer;
                        gap: 8px;
                    }

                    .checkbox-group input[type="checkbox"] {
                        margin: 0;
                        width: auto;
                        flex-shrink: 0;
                    }

                    .button-container {
                        text-align: center;
                        margin-top: 20px;
                    }

                    .register-btn {
                        background-color: #4CAF50;
                        color: white;
                        padding: 10px 30px;
                        border: none;
                        border-radius: 4px;
                        cursor: pointer;
                        font-size: 16px;
                        font-weight: bold;
                    }

                    .register-btn:hover {
                        background-color: #45a049;
                    }
                </style>
            </head>

            <body>
                <div class="form-container">
                    <h2>Student Registration Form</h2>

                    <form:form action="/saveStudent" method="post" modelAttribute="student">
                        <table>
                            <tr>
                                <td>Name:</td>
                                <td>
                                    <form:input path="name" />
                                </td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>
                                    <form:input path="email" type="email" />
                                </td>
                            </tr>
                            <tr>
                                <td>Phn Number:</td>
                                <td>
                                    <form:input path="phno" type="number" />
                                </td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td>
                                    <div class="radio-group">
                                        <c:forEach var="gender" items="${genders}" varStatus="status">
                                            <input type="radio" name="gender" value="${gender}"
                                                id="gender_${status.index}" />
                                            <label for="gender_${status.index}">${gender}</label>
                                        </c:forEach>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Course:</td>
                                <td>
                                    <form:select path="course">
                                        <form:option value="" label="-Select-" />
                                        <form:options items="${courses}" />
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>Timings:</td>
                                <td>
                                    <div class="checkbox-group">
                                        <c:forEach var="timing" items="${timings}" varStatus="status">
                                            <label for="timing_${status.index}">
                                                <input type="checkbox" name="timings" value="${timing}"
                                                    id="timing_${status.index}" />
                                                ${timing}
                                            </label>
                                        </c:forEach>
                                    </div>
                                </td>
                            </tr>
                        </table>

                        <div class="button-container">
                            <button type="submit" class="register-btn">Register</button>
                        </div>
                    </form:form>
                </div>
            </body>

            </html>
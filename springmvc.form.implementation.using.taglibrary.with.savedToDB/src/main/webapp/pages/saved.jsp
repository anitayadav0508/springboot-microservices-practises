<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Student Saved Successfully</title>
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

                .success-container {
                    background-color: white;
                    padding: 40px;
                    border: 2px solid #4CAF50;
                    border-radius: 4px;
                    width: 500px;
                    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                    text-align: center;
                }

                .success-icon {
                    font-size: 64px;
                    color: #4CAF50;
                    margin-bottom: 20px;
                }

                h2 {
                    color: #4CAF50;
                    text-align: center;
                    margin-bottom: 20px;
                    font-size: 24px;
                }

                .success-message {
                    color: #333;
                    font-size: 18px;
                    margin-bottom: 30px;
                    line-height: 1.6;
                }

                .button-container {
                    text-align: center;
                    margin-top: 20px;
                }

                .back-btn {
                    background-color: #4CAF50;
                    color: white;
                    padding: 10px 30px;
                    border: none;
                    border-radius: 4px;
                    cursor: pointer;
                    font-size: 16px;
                    font-weight: bold;
                    text-decoration: none;
                    display: inline-block;
                }

                .back-btn:hover {
                    background-color: #45a049;
                }
            </style>
        </head>

        <body>
            <div class="success-container">
                <div class="success-icon">✓</div>
                <h2>Success!</h2>
                <div class="success-message">
                    <p><strong>Student saved successfully!</strong></p>
                    <div
                        style="text-align: left; margin-top: 20px; padding: 15px; background-color: #f9f9f9; border-radius: 4px;">
                        <p><strong>Name:</strong> ${student.name}</p>
                        <p><strong>Email:</strong> ${student.email}</p>
                        <p><strong>Phone Number:</strong> ${student.phno}</p>
                        <p><strong>Gender:</strong> ${student.gender}</p>
                        <p><strong>Course:</strong> ${student.course}</p>
                        <p><strong>Timings:</strong>
                            <c:if test="${not empty student.timings}">
                                <c:forEach var="timing" items="${student.timings}" varStatus="status">
                                    ${timing}<c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty student.timings}">
                                None selected
                            </c:if>
                        </p>
                    </div>
                </div>
                <div class="button-container">
                    <a href="/loadForm" class="back-btn">Back to Form</a>
                </div>
            </div>
        </body>

        </html>
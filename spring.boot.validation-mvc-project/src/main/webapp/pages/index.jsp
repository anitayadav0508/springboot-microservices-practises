<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Spring Boot Validation MVC Project</title>

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                crossorigin="anonymous">

            <style>
                body {
                    padding: 20px;
                    background-color: #f8f9fa;
                }

                .container {
                    max-width: 1200px;
                    margin: 0 auto;
                    background-color: white;
                    padding: 30px;
                    border-radius: 10px;
                    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                }

                .form-table {
                    width: 100%;
                    border-collapse: separate;
                    border-spacing: 0 15px;
                }

                .form-table td {
                    padding: 8px 0;
                    vertical-align: top;
                }

                .form-table td:first-child {
                    width: 150px;
                    font-weight: 500;
                }

                /* Force enable all form inputs */
                input.form-control,
                input[type="text"],
                input[type="password"],
                input[type="email"],
                input[type="number"] {
                    pointer-events: auto !important;
                    cursor: text !important;
                    -webkit-user-select: text !important;
                    -moz-user-select: text !important;
                    user-select: text !important;
                    background-color: #fff !important;
                    border: 1px solid #ced4da !important;
                    color: #212529 !important;
                    opacity: 1 !important;
                }

                /* Override any disabled styles */
                input.form-control:disabled,
                input[type="text"]:disabled,
                input[type="password"]:disabled,
                input[type="email"]:disabled,
                input[type="number"]:disabled {
                    background-color: #fff !important;
                    opacity: 1 !important;
                    cursor: text !important;
                    pointer-events: auto !important;
                }

                input.form-control:focus,
                input[type="text"]:focus,
                input[type="password"]:focus,
                input[type="email"]:focus,
                input[type="number"]:focus {
                    border-color: #86b7fe !important;
                    outline: 0 !important;
                    box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25) !important;
                    background-color: #fff !important;
                }

                .error {
                    color: red;
                    font-size: 0.875rem;
                    margin-left: 10px;
                }
            </style>
        </head>

        <body>
            <div class="container">
                <h3 class="mb-4">User Form</h3>

                <form:form action="/saveUser" modelAttribute="user" method="POST" id="userForm">
                    <table class="form-table">
                        <tr>
                            <td>Username:</td>
                            <td>
                                <form:input path="uname" cssClass="form-control" cssStyle="max-width: 300px;" />
                            </td>
                            <td>
                                <form:errors path="uname" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td>
                                <form:password path="pwd" cssClass="form-control" cssStyle="max-width: 300px;" />
                            </td>
                            <td>
                                <form:errors path="pwd" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td>
                                <form:input path="email" type="email" cssClass="form-control"
                                    cssStyle="max-width: 300px;" />
                            </td>
                            <td>
                                <form:errors path="email" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td>Phone Number:</td>
                            <td>
                                <form:input path="phno" type="number" cssClass="form-control"
                                    cssStyle="max-width: 300px;" />
                            </td>
                            <td>
                                <form:errors path="phno" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="save" class="btn btn-primary" />
                            </td>
                            <td></td>
                        </tr>
                    </table>
                </form:form>
            </div>

            <!-- Bootstrap JS Bundle -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
                crossorigin="anonymous"></script>

           
            </script>
        </body>

        </html>
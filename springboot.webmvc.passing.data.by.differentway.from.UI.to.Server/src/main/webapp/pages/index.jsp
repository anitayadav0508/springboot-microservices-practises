<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Form</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                min-height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 20px;
            }

            .container {
                background: white;
                border-radius: 15px;
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
                padding: 40px;
                max-width: 600px;
                width: 100%;
            }

            h1 {
                color: #333;
                margin-bottom: 30px;
                text-align: center;
                font-size: 28px;
            }

            h2 {
                color: #333;
                margin-bottom: 20px;
                text-align: center;
                font-size: 24px;
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                margin-bottom: 8px;
                color: #555;
                font-weight: 600;
                font-size: 14px;
            }

            input[type="text"],
            input[type="number"],
            input[type="email"],
            textarea,
            select {
                width: 100%;
                padding: 12px;
                border: 2px solid #e0e0e0;
                border-radius: 8px;
                font-size: 14px;
                transition: border-color 0.3s;
                font-family: inherit;
            }

            input[type="text"]:focus,
            input[type="number"]:focus,
            input[type="email"]:focus,
            textarea:focus,
            select:focus {
                outline: none;
                border-color: #667eea;
            }

            textarea {
                resize: vertical;
                min-height: 100px;
            }

            .btn {
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                color: white;
                padding: 14px 30px;
                border: none;
                border-radius: 8px;
                font-size: 16px;
                font-weight: 600;
                cursor: pointer;
                width: 100%;
                transition: transform 0.2s, box-shadow 0.2s;
            }

            .btn:hover {
                transform: translateY(-2px);
                box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
            }

            .btn:active {
                transform: translateY(0);
            }

            .form-row {
                display: grid;
                grid-template-columns: 1fr 1fr;
                gap: 15px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            table td {
                padding: 10px;
            }

            @media (max-width: 600px) {
                .form-row {
                    grid-template-columns: 1fr;
                }
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h2>Save Product Details</h2>
            <form action="#" method="POST">
                <table>
                    <tr>
                        <td>Product Id:</td>
                        <td><input type="text" name="pid" /></td>
                    </tr>
                    <tr>
                        <td>Product Name:</td>
                        <td><input type="text" name="pname" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Reset" /></td>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>

    </html>
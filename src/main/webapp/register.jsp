<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    <style>
                body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f1f1f1;
        }

        .login-container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 300px;
        }

        .login-input {
            width: 90%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .login-button {
            width: 100%;
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            margin-top:20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .login-button:hover {
            background-color: #0056b3;
        }
        #notification {
               display:none;
            padding: 10px;
            margin-top: 10px;
            background-color: #ff9999;
            color: #333;
            border-radius: 4px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div class="login-container">
    	<div class="alert alert-success center" role="alert">
				<p>${notification}</p>
			</div>
        <h2>Register</h2>
        <form action="register" method="post">
            <label for="firstName">First Name</label>
            <input type="text" id="firstName" name="firstName" class="login-input" required>
            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="lastName" class="login-input" required>
            <label for="username">Username</label>
            <input type="text" id="username" name="username" class="login-input" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="login-input" required>
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="login-input" required>
            <button type="submit" class="login-button">Register</button>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>

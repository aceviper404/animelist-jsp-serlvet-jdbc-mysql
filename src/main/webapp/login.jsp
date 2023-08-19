<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
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
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" class="login-input" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" class="login-input" required>
            <button type="submit" class="login-button">Login</button>
        </form>
        <p>Don't have an account? <a href="register.jsp">Register here</a></p>
        <c:if test="${not empty loginStatus and loginStatus eq 'fail'}">
            <div id="notification"></div>
        </c:if>
    </div>
</body>
<script type="text/javascript">
	var ifLoginFail = <%=request.getAttribute("failMessage") %>;
	if(ifLoginFail){
		document.getElementById('notification').value = 'Login failed. Please check your credentials.';
		document.getElementById('notification').style.display = 'block';
	}
	
</script>
</html>

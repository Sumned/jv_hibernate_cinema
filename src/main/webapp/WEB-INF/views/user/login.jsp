<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
</head>
<body>
<div class="container">
    <h3>Hello! Please input your user details</h3>
    <form role="form" action="${pageContext.request.contextPath}/login" method="post">
        <fieldset>
            <form th:action="@{/login}" method="post">
                <div class="form-group">
                    <label for="username">Login</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="Please provide your login">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Please provide your password">
                </div>
                <div class="form-actions">
                    <button type="submit" class="btn btn-success">Login</button>
                </div>
            </form>
        </fieldset>
    </form>
        <p><a href="${pageContext.request.contextPath}/registration">Haven't account yet?</a></p>
</div>
</body>
</html>

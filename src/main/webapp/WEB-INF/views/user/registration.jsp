<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="http://code.jquery.com/jquery-2.2.4.js"></script>
</head>
<body>
<div class="container">
    <h3>Hello! Please provide your user details</h3>
    <form role="form" action="${pageContext.request.contextPath}/registration" method="post">
        <div class="form-group">
            <label for="login">Login</label>
            <input type="text"  name="login" class="form-control" id="login" placeholder="Please provide your login">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Please provide your password">
        </div>
        <div class="form-group">
            <label for="passwordRepeat">Password</label>
            <input type="password" name="passwordRepeat" class="form-control" id="passwordRepeat" placeholder="Please repeat your password">
        </div>
        <button type="submit" id="submit" value="Submit" class="btn btn-success">Registration</button>
    </form>
    <p><a href="${pageContext.request.contextPath}/inject">inject</a></p>
    <p><a href="${pageContext.request.contextPath}/login">Back to the login page</a></p>
</div>
<div id="displayDiv" style="display:none"><h3>JSON Data returned from Server after processing</h3>
    <div id="processedData"></div>
</div>
<script>
    jQuery(document).ready(function($) {
        $("#submit").click(function(){
            let userData = {};
            userData["email"] = $("#login").val();
            userData["password"] = $("#password").val();
            userData["repeatPassword"] = $("#passwordRepeat").val();
            for(u in userData) {
                console.log(u)
                console.log(userData[u])
            }
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "registration",
                data : JSON.stringify(userData),
                dataType : 'json',
                error: function(data) {
                    console.log(data.toString() + " error")
                },
                success : function(data) {
                    console.log("success")
                    $('#processedData').html(JSON.stringify(data));
                    $('#displayDiv').show();
                }
            });
        });
    });
</script>
</body>
</html>

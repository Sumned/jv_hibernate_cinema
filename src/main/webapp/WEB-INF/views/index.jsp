<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<head>
    <title>Test page</title>
    <script src="http://code.jquery.com/jquery-2.2.4.js"></script>
</head>
<body>
<h1>test page</h1>
<h3><a href="/movies">All movies</a> </h3>
<h3><a href="/halls">All cinema halls</a> </h3>
<h3><a href="/movie-sessions">Movie Sessions</a> </h3>
<h3><a href="/users/by-email">Get user by email</a> </h3>
<h3><a href="/logout">Exit</a> </h3>
<h2>Enter Movie Details</h2>
<table>
    <tr>
        <td>title</td>
        <td><input type="text" id="title"></td>
    </tr>
    <tr>
        <td>description</td>
        <td><input type="text" id="description"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="button" id="submit" value="Submit" /></td>
    </tr>
</table>

<hr/>
<div id="displayDiv" style="display:none"><h3>JSON Data returned from Server after processing</h3>
    <div id="processedData"></div>
</div>
<script>
    jQuery(document).ready(function($) {
        $("#submit").click(function(){
            let movieData = {};
            movieData["title"] = $("#title").val();
            movieData["description"] = $("#description").val();
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "movies",
                data : JSON.stringify(movieData),
                dataType : 'json',
                success : function(MovieData) {
                    $('#processedData').html(JSON.stringify(MovieData));
                    $('#displayDiv').show();
                }
            });
        });
    });
</script>

<h2>Enter Cinema Hall Details</h2>
<table>
    <tr>
        <td>capacity</td>
        <td><input type="number" id="capacity"></td>
    </tr>
    <tr>
        <td>description</td>
        <td><input type="text" id="descriptionHall"></td>
    </tr>
    <tr>
        <td colspan="2"><input type="button" id="submit1" value="Submit" /></td>
    </tr>
</table>

<hr/>
<div id="displayDiv1" style="display:none"><h3>JSON Data returned from Server after processing</h3>
    <div id="processedData1"></div>
</div>
<script>
    jQuery(document).ready(function($) {
        $("#submit1").click(function(){
            let hallData = {};
            hallData["capacity"] = $("#capacity").val();
            hallData["description"] = $("#descriptionHall").val();
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "halls",
                data : JSON.stringify(hallData),
                dataType : 'json',
                success : function(hallData) {
                    $('#processedData1').html(JSON.stringify(hallData));
                    $('#displayDiv1').show();
                }
            });
        });
    });
</script>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie Sessions</title>
    <script src="http://code.jquery.com/jquery-2.2.4.js"></script>
</head>
<body>
<h3><a href="/movie-sessions/available?movieId=1&date=12.06.2020">Movie Session available at 12.06.2020</a> </h3>
<table>
    <tr>
        <td>show time</td>
        <td><input type="date" id="showTime"></td>
    </tr>
    <tr>
        <td>movie id</td>
        <td><input type="text" id="movieId"></td>
    </tr>
    <tr>
        <td>hall id</td>
        <td><input type="text" id="hallId"></td>
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
            let movieSessionData = {};
            movieSessionData["showTime"] = $("#showTime").val();
            movieSessionData["movieId"] = $("#movieId").val();
            movieSessionData["hallId"] = $("#hallId").val();
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "movie-sessions",
                data : JSON.stringify(movieSessionData),
                dataType : 'json',
                success : function(movieSessionData) {
                    $('#processedData').html(JSON.stringify(movieSessionData));
                    $('#displayDiv').show();
                }
            });
        });
    });
</script>
</body>
</html>

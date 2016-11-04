<%--
  Created by IntelliJ IDEA.
  User: Вадимир
  Date: 04.11.2016
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/connect/facebook" method="POST">
    <input type="hidden" name="scope" value="user_posts" />
    <div class="formInfo">
        <p>You aren't connected to Facebook yet. Click the button to connect this application with your Facebook account.</p>
    </div>
    <p><button type="submit">Connect to Facebook</button></p>
</form>
</body>
</html>

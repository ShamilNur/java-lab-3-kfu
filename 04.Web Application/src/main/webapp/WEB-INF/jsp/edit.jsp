<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="post" method="/users?action=delete&user_id=${userId}">
    <input type="hidden" name="_csrf_token" value="${csrfToken}">
    <input type="submit" value="Delete">
</form>
</body>
</html>

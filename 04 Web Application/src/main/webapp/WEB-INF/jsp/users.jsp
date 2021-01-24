<%@ page import="ru.kpfu.itis.group903.nurkaev.models.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1 style="color: ${cookie.get("color").value}">USERS</h1>
    <form action="${pageContext.request.contextPath}/users" method="post">
        <label for="color_selector">
            <select id="color_selector" name="color">
                <option value="red">RED</option>
                <option value="green">GREEN</option>
                <option value="blue">BLUE</option>
            </select>
        </label>
        <input type="submit" value="OK">
    </form>
</div>
<div>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("usersForJsp");
            for (User user : users) {
        %>
        <tr>
            <td><%=user.getFirstName()%>
            </
            >
            <td><%=user.getLastName()%>
            </
            >
        </tr>
        <%}%>
    </table>
</div>

</body>
</html>

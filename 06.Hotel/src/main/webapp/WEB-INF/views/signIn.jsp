<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset='UTF-8'>
    <title>Авторизация</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/signUp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/signIn.css">
</head>

<body>
<div class="d-flex justify-content-center align-items-center flex-column">
    <form action="" method="post">
        <div class="form-group">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="E-mail" required>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Пароль" required>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-outline-primary">Войти</button>
                    </div>
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-outline-primary">Регистрация</button>
                    </div>
                </div>
                <p></p>
                <%--@elvariable id="message" type=""--%>
                <c:if test="${not empty message}">
                    <h6 class="text-danger">${message}</h6>
                </c:if>
            </div>
        </div>

    </form>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/signUp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

    <script src="${pageContext.request.contextPath}/static/js/signUp.js"></script>
</head>

<body>
<div class="d-flex justify-content-center align-items-center flex-column">
    <form action="" method="post">
        <div class="form-group">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="text" class="form-control" id="firstName" name="firstName"
                                   placeholder="Имя" required>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="text" class="form-control" id="lastName" name="lastName"
                                   placeholder="Фамилия" required>
                        </div>
                    </div>
                </div>
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
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-group col">
                            <input type="text" class="form-control" id="confirm_password" name="confirm_password"
                                   placeholder="Подтверждение пароля" required>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="consent" required>
                            <label class="form-check-label" for="consent">
                                Согласие на обработку персональных данных</label><br>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <button type="submit" class="btn btn-outline-primary">Зарегистрироваться</button>
                    </div>
                </div>
                <br>
                <div class="row justify-content-center">
                    <div class="col-sm">
                        <div class="form-check form-check-inline">
                            <div>
                                У вас уже есть аккаунт?
                                <a href="${pageContext.request.contextPath}/signIn"> Войти</a>
                            </div>
                        </div>
                    </div>
                </div>
                <p></p>
                <%--@elvariable id="message" type=""--%>
                <c:if test="${not empty message}">
                    <h6 class="text-danger">${message}</h6>
                </c:if>
            </div>
            <p></p>
        </div>
    </form>
</div>
</body>
</html>

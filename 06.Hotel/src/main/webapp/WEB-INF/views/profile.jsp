<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Профиль</title>

    <%--CSS styles--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/profile.css">
</head>

<body>
<header>
    <div class="header-section">
        <div class="menu">
            <div class="container">
                <div class="row">
                    <div class="col-md-5" style="max-width: 400px">
                        <nav>
                            <ul>
                                <li><a href="main">Главная</a></li>
                                <li><a href="availability">Бронирование</a></li>
                            </ul>
                        </nav>
                    </div>
                    <span style="margin: auto">
                        <div class="top-phone-num">
                            <img src="${pageContext.request.contextPath}static/img/phone.png" alt="">
                            <span>+7 (999) 000-54-54</span>
                        </div>
                    </span>
                    <div class="col-md-5" style="max-width: 400px">
                        <nav>
                            <ul>
                                <li><a href="signUp">Регистрация</a></li>
                                <li><a href="signIn">Вход</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="main-header-rooms">
    <div class="main-flex-rooms">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Профиль</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="room-availability spad">
    <div class="container">
        <div class="row gutters-sm">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body tab-content">
                        <div class="tab-pane active" id="profile">
                            <hr>
                            <form>
                                <div class="form-group">
                                    <label for="first-name">Имя</label>
                                    <h5 id="first-name">
                                        <%--@elvariable id="FirstName" type=""--%>
                                        <c:if test="${not empty FirstName}">
                                            ${FirstName}
                                        </c:if>
                                    </h5>
                                </div>
                                <div class="form-group">
                                    <label for="last-name">Фамилия</label>
                                    <h5 id="last-name">
                                        <%--@elvariable id="LastName" type=""--%>
                                        <c:if test="${not empty LastName}">
                                            ${LastName}
                                        </c:if></h5>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <h5 id="email">
                                        <%--@elvariable id="Email" type=""--%>
                                        <c:if test="${not empty Email}">
                                            ${Email}
                                        </c:if>
                                    </h5>
                                </div>
                                <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Выйти из
                                    аккаунта</a>
                                <a href="${pageContext.request.contextPath}/edit_profile" class="btn btn-primary">Редактировать профиль</a>
                            </form>
                            <p></p>
                            <form method="post">
                                <button class="btn btn-danger" type="submit">Удалить аккаунт</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<footer class="footer-info">
    <div class="container">
        <div class="row align-items-start">
            <div class="col">
                <h3 class="contact-name">Адрес</h3>
                <h5 class="contact-desc">Казань</h5>
            </div>
            <div class="col">
                <div class="col">
                    <h3 class="contact-name">Телефон</h3>
                    <h5 class="contact-desc">+7 (999) 000-54-54</h5>
                </div>
            </div>
            <div class="col">
                <h3 class="contact-name">E-mail</h3>
                <h5 class="contact-desc">booking@gmail.com</h5>
            </div>
        </div>
    </div>
</footer>
</body>
</html>


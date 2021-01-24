<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Главная</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
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

<div class="main-header">
    <div class="main-flex">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Надеемся, что вам понравится пребывание у нас.</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="follow-instagram">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Присоединяйтесь к нам в Instagram @hotel</h2>
            </div>
        </div>
    </div>
</section>

<div class="footer-room-pic">
    <div class="container-fluid">
        <div class="row">
            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-1.jpg" alt="">
            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-2.jpg" alt="">
            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-3.jpg" alt="">
            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-4.jpg" alt="">
        </div>
    </div>
</div>

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

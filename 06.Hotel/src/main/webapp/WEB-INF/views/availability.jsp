<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Бронирование</title>

    <%--CSS styles--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

    <%--JQuery for AJAX, Date Range Picker's files--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/allAvailableRooms.js"></script>

    <%--Date Range Picker's files--%>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
    <script src="${pageContext.request.contextPath}/static/js/daterange.js"></script>

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
                            <h1>Бронирование</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="room-availability spad">
    <div class="container">
        <div class="room-check">
            <div class="row">
                <div class="col-mg-6">
                    <div class="check-form">
                        <h2>Проверить наличие свободных мест</h2>
                        <div>
                            <div class="datepicker">
                                <div class="date-select">
                                    <label for="daterange"><p>Дата заезда и дата выезда</p></label>
                                    <input type="text" id="daterange" name="daterange"/>
                                </div>
                            </div>
                            <div class="room-quantity">
                                <div class="row">
                                    <div class="col-lg-4">
                                        <div class="single-quantity">
                                            <label for="rooms-number"><p>Комнаты</p></label>
                                            <select id="rooms-number" name="rooms-number">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="single-quantity">
                                        <div class="col-lg-4">
                                            <label for="adults-number"><p>Взрослые</p></label>
                                            <select id="adults-number" name="adults-number">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="single-quantity">
                                        <div class="col-lg-4">
                                            <label for="child-number"><p>Дети</p></label>
                                            <select id="child-number" name="child-number">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button id="check-available-rooms-btn" name="check-available-rooms-btn">ПРОВЕРИТЬ</button>
                            <p></p>
                            <%--@elvariable id="noAvailableRooms" type=""--%>
                            <c:if test="${not empty noAvailableRooms}">
                                <h6 class="text-danger">${noAvailableRooms}</h6>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="about-room">
            <div class="row">
                <div class="col-lg-10 offset-lg-1">
                    <h2>“Клиенты могут забыть, что вы сказали, но они никогда не забудут, что вы заставили их
                        почувствовать”.</h2>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="room-section spad">
    <div class="container" id="available-rooms">

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

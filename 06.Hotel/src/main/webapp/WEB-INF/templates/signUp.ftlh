<#ftl encoding="UTF-8"/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>

    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/signUp.css">
    <link rel="stylesheet" href="/static/css/style.css">

    <script src="/static/js/signUp.js"></script>
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
                            <input type="text" class="form-control" id="confirmPassword" name="confirmPassword"
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
                                <a href="/signIn"> Войти</a>
                            </div>
                        </div>
                    </div>
                </div>
                <p></p>
                <#if message??>
                    <h6 class="text-danger">${message}</h6>
                </#if>
            </div>
            <p></p>
        </div>
    </form>
</div>
</body>
</html>

<#ftl encoding="UTF-8"/>
<html lang="ru">
<head>
    <meta charset='UTF-8'>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Авторизация</title>

    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/signUp.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <link rel="stylesheet" href="/static/css/signIn.css">
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
                <#if message??>
                    <h6 class="text-danger">${message}</h6>
                </#if>
            </div>
        </div>
    </form>
</div>
</body>
</html>
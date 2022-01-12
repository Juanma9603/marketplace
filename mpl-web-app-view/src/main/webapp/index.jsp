<%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 29/11/2021
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="./includes/autenticacion.jsp"/>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Login Page</title>
</head>
<body>
<div class="container my-4">
    <h2>Login In</h2>
    <form action="./sAutentication" method="post">
        <div class="mb-3">
            <label for="exampleInputUsername" class="form-label">Username: </label>
            <input name="username" type="username" class="form-control" id="exampleInputUsername" aria-describedby="usernameHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">Iniciar Sesion</button>

        <a href="./sCreateAccount" class="btn btn-primary">Crear Cuenta </a>


    </form>
</div>
</body>
</html>


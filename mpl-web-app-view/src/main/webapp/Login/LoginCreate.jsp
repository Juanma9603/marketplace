<%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 30/11/2021
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Create Account</title>
</head>
<body>
    <h2>New User</h2>
    <div class="container my-4">
        <form action="../sCreateAccount" class="row g-3" method="post">
            <div class="col-12">
                <label for="inputAddress" class="form-label">Username</label>
                <input name="username" type="text" class="form-control" id="inputAddress" placeholder="username">
            </div>

            <div class="col-md-6">
                <label for="inputPassword4" class="form-label">Password</label>
                <input name="password" type="password" class="form-control" id="inputPassword4" placeholder="password">
            </div>

            <div class="col-12">
                <label for="inputAddress2" class="form-label">Firstname</label>
                <input name="firstname" type="text" class="form-control" id="inputAddress2" placeholder="firstname">
            </div>
            <div class="col-md-6">
                <label for="inputCity" class="form-label">Lastname</label>
                <input name="lastname" type="text" class="form-control" id="inputCity" placeholder="lastname">
            </div>

            <div class="col-md-2">
                <label for="inputZip" class="form-label">Birthday</label>
                <input name="birthday" type="text" class="form-control" id="inputZip" placeholder="01/01/2001">
            </div>
            <div class="col-md-6">
                <label for="inputEmail4" class="form-label">Email</label>
                <input name="email" type="email" class="form-control" id="inputEmail4" placeholder="example@gmail.com">
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form>
    </div>

</body>
</html>

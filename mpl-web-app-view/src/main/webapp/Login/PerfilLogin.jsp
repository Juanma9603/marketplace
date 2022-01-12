<%@ page import="Entity.Persona" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 29/11/2021
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Perfil Login</title>
</head>
<body>
    <%
        HttpSession session1=request.getSession();
        Persona objPersona=new Persona();
        if (session1.getAttribute("objpersona")!=null || session1.getAttribute("idpersona")!=null){

            objPersona =(Persona) session1.getAttribute("objpersona");
            /*int idpersona=objPersona.getID();
            session1.setAttribute("idpersona",idpersona);*/

    %>
    <div class="container my-4">
        <h2>Perfil User</h2>
        <form class="row g-3">
            <div class="col-md-6">
                <label for="inputAddress" class="form-label">Username: </label>
                <div>
                    <label class="col-sm-2 col-form-label col-form-label-lg" id="inputAddress" ><%=objPersona.getObjUser().getUsername()%></label>
                </div>
            </div>
            <div class="col-md-6">
                <label for="inputEmail4" class="form-label">Email: </label>
                <div>
                    <label class="col-sm-2 col-form-label col-form-label-lg" id="inputEmail4"><%=objPersona.getEmail()%></label>
                </div>
            </div>
            <div class="col-12">
                <label for="inputAddress2" class="form-label">Firstname</label>
                <div>
                    <label class="col-sm-2 col-form-label col-form-label-lg" id="inputAddress2"><%=objPersona.getFirstname()%></label>
                </div>
            </div>
            <div class="col-md-6">
                <label for="inputAddress3" class="form-label">Lastname</label>
                <div>
                    <label class="col-sm-2 col-form-label col-form-label-lg" id="inputAddress3"><%=objPersona.getLastname()%></label>
                </div>
            </div>
            <div class="col-12">
                <a href="../sStoreProducts" class="btn btn-primary">Ir a Comprar</a>
                <a href="../sAutentication?type=logout" class="btn btn-secondary">Logout</a>
            </div>
        </form>

    </div>
<%

    }else {
        response.sendRedirect("./index.jsp");
    }
%>
</body>
</html>

<%@ page import="Entity.Persona" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 10/01/2022
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
    <%
        Persona objPersona = (Persona) session.getAttribute("objPersona");
        if (objPersona!=null){
        }else {
            response.sendRedirect("../sOrders");
        }
    %>
    <jsp:include page="../includes/navbar.jsp"/>
    <div class="container-fluid">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Fecha y Hora</th>
                <th scope="col">Quantity Products</th>
                <th scope="col">Sub Total</th>
                <th scope="col">IGV</th>
                <th scope="col">Total</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <th scope="row"></th>
                <td>123</td>
                <td>123</td>
                <td>123</td>
                <td>123</td>
                <td>123</td>
                <td><a href="../sCarShopping?idproduct="><i class="fas fa-trash-alt"></i></a></td>
            </tr>
            <a href="../sStoreProducts" class="btn btn-secondary">Volver a Tienda</a>
            </tbody>
        </table>
    </div>

</body>
</html>

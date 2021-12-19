<%@ page import="Entity.SaleDetail" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 13/12/2021
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comprado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d68f652799.js" crossorigin="anonymous"></script>
    <title>ConfirmSale</title>
</head>
<body>

<div class="container">

    <h1>Compra Exitosa</h1>
    <%
        int counter=0;

        if (session.getAttribute("objPersona")!=null){
            ArrayList<SaleDetail> listshoppingCar=(ArrayList<SaleDetail>)session.getAttribute("listCarshopping");
            if (listshoppingCar==null){
                response.sendRedirect("../sCarShopping");
            }
    %>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Und.</th>
            <th scope="col">Name</th>
            <th scope="col">TradeMark</th>
            <th scope="col">Description</th>
            <th scope="col">Subtotal</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (SaleDetail saleDetail:listshoppingCar){
        %>
        <tr>
            <th scope="row"><%=saleDetail.getObjProduct().getID()%></th>
            <td><%=saleDetail.getUnits()%></td>
            <td><%=saleDetail.getObjProduct().getName()%></td>
            <td><%=saleDetail.getObjProduct().getTradeMark()%></td>
            <td><%=saleDetail.getObjProduct().getDescription()%></td>
            <td><%=saleDetail.getSubTotal()%></td>
        </tr>
        <%
                counter++;
            }
        %>
        </tbody>
    </table>

    <%
        }else{
            response.sendRedirect("../Login/LoginPage.jsp");
        }
    %>
</div>
</body>
</html>

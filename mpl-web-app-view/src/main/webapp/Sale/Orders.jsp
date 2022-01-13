<%@ page import="Entity.Persona" %>
<%@ page import="dto.Orders" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <script src="https://kit.fontawesome.com/d68f652799.js" crossorigin="anonymous"></script>
</head>
    <body>
        <%
            Persona objPersona = (Persona) session.getAttribute("objPersona");
            if (objPersona!=null){
                ArrayList<Orders> orders=(ArrayList<Orders>) session.getAttribute("orderList");
        %>
        <jsp:include page="../includes/navbar.jsp"/>
        <div class="container">
            <h1>Orders</h1>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Fecha y Hora</th>
                    <th scope="col">Quantity Products</th>
                    <th scope="col">Sub Total</th>
                    <th scope="col">IGV</th>
                    <th scope="col">Total</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Orders order:orders){


                %>
                <tr>
                    <th scope="row"><%=order.getIdOrder()%></th>
                    <td><%=order.getRegister_datetime()%></td>
                    <td><%=order.getQuantity()%></td>
                    <td><%=order.getSubtotal()%></td>
                    <td><%=order.getIgv()%></td>
                    <td><%=order.getTotal()%></td>
                    <td><a href="../order/detail?idSale=<%=order.getIdOrder()%>"><i class="fas fa-receipt"></i></a></td>
                <%
                    }
                %>
                </tr>
                <a href="../sStoreProducts" class="btn btn-secondary">Volver a Tienda</a>
                </tbody>
            </table>
        </div>
    <%
        }else {
            response.sendRedirect("../sOrders");
        }
    %>

    </body>
</html>

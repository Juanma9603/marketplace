<%@ page import="java.util.ArrayList" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.math.RoundingMode" %>
<%@ page import="Entity.Product" %>
<%@ page import="Entity.SaleDetail" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 24/11/2021
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/d68f652799.js" crossorigin="anonymous"></script>
    <title>BuyCar</title>
</head>
<body>

    <div class="container">

        <h1>BuyCar</h1>
        <%
            int counter=0;

            ArrayList<SaleDetail> listshoppingCar=(ArrayList<SaleDetail>)session.getAttribute("listCarshopping");
            if (listshoppingCar!=null){

        %>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Id</th>
                <th scope="col">Und.</th>
                <th scope="col">Name</th>
                <th scope="col">TradeMark</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (SaleDetail saleDetail:listshoppingCar){

            %>
                <tr>
                    <th scope="row"><%=counter+1%></th>
                    <td><%=saleDetail.getObjProduct().getID()%></td>
                    <td><%=saleDetail.getUnits()%></td>
                    <td><%=saleDetail.getObjProduct().getName()%></td>
                    <td><%=saleDetail.getObjProduct().getTradeMark()%></td>
                    <td><%=saleDetail.getObjProduct().getDescription()%></td>
                    <td><%=saleDetail.getUnitPrice()%></td>
                    <td><a href="../sCarShopping?idproduct=<%=counter%>&action=D"><i class="fas fa-trash-alt"></i></a></td>
                </tr>


            <%
                    counter++;
                }
            %>

            </tbody>
        </table>

        <%
            }else {
        %>
            <h2>El carrito esta Vacio</h2>
        <%
            }
        %>

        <a href="../sStoreProducts" class="btn btn-secondary">Seguir Comprando</a>
        <a href="../sConfirmSale" class="btn btn-primary">Pagar</a>
    </div>
</body>
</html>

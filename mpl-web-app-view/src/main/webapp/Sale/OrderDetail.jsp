<%@ page import="Entity.Sale" %>
<%@ page import="Entity.SaleDetail" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 12/01/2022
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
        <%
            Sale sale=new Sale();
            if (session.getAttribute("orderDetail")!=null){
                sale = (Sale) session.getAttribute("orderDetail");
            }else {
                response.sendRedirect("../sOrders");
            }
        %>
        <jsp:include page="../includes/navbar.jsp"/>
        <div class="container">
            <div class="row align-middle">
                <p>
                    Order Number: <%=sale.getIdSale()%>
                </p>
            </div>
            <div class="row align-middle">
                <p>
                    Date:<%=sale.getRegisterDatetime()%>
                </p>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">SKU</th>
                    <th scope="col">Product name</th>
                    <th scope="col">Units</th>
                    <th scope="col">Units Price</th>
                    <th scope="col">Sub total</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (SaleDetail detail:sale.getListSaleDetails()){


                %>
                <tr>
                    <th scope="row"><%=detail.getObjProduct().getID()%></th>
                    <td><%=detail.getObjProduct().getName()%></td>
                    <td><%=detail.getUnits()%></td>
                    <td><%=detail.getUnitPrice()%></td>
                    <td><%=detail.getSubTotal()%></td>
                    <%
                        }
                    %>
                </tr>

                </tbody>
            </table>

            <div class="row">
                <div class="col-4 align-items-center">
                    <a href="../sOrders" class="btn btn-secondary">Retornar</a>
                </div>
                <div class="col-4 align-items-center">
                    <a href="javascript:print()" class="btn btn-success">Imprimir</a>
                </div>
                <div class="col-4 align-items-center">
                    <div class="row">
                        <p>
                            IGV:<%=sale.getIgv()%>
                        </p>
                    </div>
                    <div class="row">
                        <p>
                            TOTAL:<%=sale.getTotal()%>
                        </p>
                    </div>
                </div>
            </div>

        </div>

</body>
</html>

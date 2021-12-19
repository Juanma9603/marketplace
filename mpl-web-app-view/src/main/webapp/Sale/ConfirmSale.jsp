<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.SaleDetail" %>
<%@ page import="Entity.Persona" %>
<%@ page import="Entity.Sale" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 11/12/2021
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>ConfirmSale</title>
</head>
    <body>

        <div class="container">

            <h1>Confirma Compra</h1>
            <%

                Persona objPersona=(Persona) session.getAttribute("objpersona");
                if (session.getAttribute("objPersona")!=null){
                ArrayList<SaleDetail> listshoppingCar=(ArrayList<SaleDetail>)session.getAttribute("listCarshopping");
                Sale objSale= (Sale) session.getAttribute("SaleHeader");
                if (listshoppingCar==null || objSale==null){
                        response.sendRedirect("../sCarShopping");
                }
            %>


                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Sale</h5>
                        <p class="card-text"><%=(objSale.getObjpersona().getFirstname()+" "+objSale.getObjpersona().getLastname()).trim()%></p>
                        <p class="card-text">Fecha de compra: <%=objSale.getRegisterDatetime()%></p>
                        <p class="card-text">Impuesto(Igv): <%=objSale.getIgv()%>%</p>
                        <p class="card-text">Tota de compra: <%=objSale.getTotal()%></p>
                    </div>
                </div>
                <br>
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

                    }
                %>
                </tbody>
            </table>

            <a href="../sStoreProducts" class="btn btn-secondary">Volver a Tienda</a>
            <a type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#confirmarVenta">Confirmar</a>

            <div class="modal fade" id="ConfirmarVenta" tabindex="-1" aria-labelledby="exampleModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Confirmar Venta</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Si deseas culminar tu venta, haz clic en <b>Confirmar</b>
                        </div>
                        <div class="modal-footer">
                            <a href="../sCarShopping" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</a>
                            <form method="post" action="../sConfirmSale">
                                <a  type="submit" class="btn btn-primary">Confirmar</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <%
                }else{
                    response.sendRedirect("../Login/LoginPage.jsp");
                }
            %>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 23/11/2021
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Lista de Productos</title>
</head>
<body>
<%
    ArrayList<Product>products=new ArrayList<Product>();
    if (session.getAttribute("listproducts")!=null){
        products=(ArrayList<Product>)session.getAttribute("listproducts");

    }else {
        response.sendRedirect("../Errorpage.jsp");
    }
%>
    <div class="container">
        <h2>Lista de Productos</h2>
        <a href="../Login/PerfilLogin.jsp" class="btn btn-primary">Volver al Perfil</a>
        <a href="../Store/BuyCar.jsp" class="btn btn-secondary">Ver el Carrito</a>
        <div class="row my-4">
            <%
                int j=0;
                for (Product product:products){
                    if (j%3==0 && j!=0){
            %>
        </div>
            <div class="row my-4">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><%=product.getName()%></h5>
                            <p class="card-text"><%=product.getDescription()%></p>
                            <p class="card-text"><%=product.getPrice()%></p>
                            <a href="../sCarShopping?idproduct=<%=product.getID()%>" class="btn btn-primary">Comprar</a>
                        </div>
                    </div>
                </div>
        <%
            }else{
        %>
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title"><%=product.getName()%></h5>
                        <p class="card-text"><%=product.getDescription()%></p>
                        <p class="card-text"><%=product.getPrice()%></p>
                        <a href="../sCarShopping?idproduct=<%=product.getID()%>" class="btn btn-primary">Comprar</a>
                    </div>
                </div>
            </div>
        <%
                }
                    j++;
            }
        %>
            </div>
    </div>

</body>
</html>

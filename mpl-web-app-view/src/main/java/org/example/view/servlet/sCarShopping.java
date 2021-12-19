package org.example.view.servlet;

import Entity.Product;
import Entity.SaleDetail;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sCarShopping", value = "/sCarShopping")
public class sCarShopping extends HttpServlet {
    private static Logger logger=Logger.getLogger(sCarShopping.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session=request.getSession();
            Product objProductTmp=new Product();

            logger.info("ingresando a session");
            if (request.getParameter("idproduct")!=null){
                int idProduct=Integer.parseInt(request.getParameter("idproduct"));
                logger.info("obteniendo el idproduct");
                ArrayList<Product>products=(ArrayList<Product>)session.getAttribute("listproducts");
                logger.info("creando una lista que obtenga los datos de la Listproductos");
                ArrayList<SaleDetail>listCarshopping=new ArrayList<SaleDetail>();

                if (session.getAttribute("listCarshopping")!=null){
                    listCarshopping=(ArrayList<SaleDetail>)session.getAttribute("listCarshopping");
                    logger.info("adicionando productos,si la lista ya los tiene");


                    String action=request.getParameter("action")+"";
                    if (request.getParameter("action")==null || action==""){
                        boolean flagListExist=false;

                        for (SaleDetail saleDetail:listCarshopping){
                            if (saleDetail.getObjProduct().getID() ==idProduct){
                                flagListExist=true;
                                saleDetail.setUnits(saleDetail.getUnits()+1);
                            }
                        }
                        logger.info("flag si existe lista"+flagListExist);
                        if (!flagListExist){
                            objProductTmp=searchProduct(idProduct,products);

                            SaleDetail objTmp=new SaleDetail();
                            logger.info("agregando producto");
                            objTmp.setObjProduct(objProductTmp);
                            objTmp.setUnits(1);
                            objTmp.setUnitPrice(objProductTmp.getPrice());
                            listCarshopping.add(objTmp);
                        }

                    }else if (action.equals("D")){
                        logger.info("eliminando el producto");
                        listCarshopping.remove(idProduct);
                    }

                }else {
                    logger.info("adicionando productos a una lista nueva");
                    objProductTmp=searchProduct(idProduct,products);
                    SaleDetail objTmp=new SaleDetail();
                    objTmp.setObjProduct(objProductTmp);
                    objTmp.setUnits(1);
                    objTmp.setUnitPrice(objProductTmp.getPrice());
                    listCarshopping.add(objTmp);
                }
                session.setAttribute("listCarshopping",listCarshopping);
            }
        }catch (Exception e){
            logger.error("error al enviar producto al carrito");
            response.sendRedirect("Errorpage.jsp");
        }
        response.sendRedirect("Store/BuyCar.jsp");
    }
    private Product searchProduct(int idProduct,ArrayList<Product> products){
        Product objProductTmp=new Product();
        for (Product product:products){
            if (product.getID()==idProduct){
                objProductTmp=product;
            }
        }
        return objProductTmp;
    }
}

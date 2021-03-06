package org.example.view.servlet;

import Entity.Persona;
import Entity.Sale;
import Entity.SaleDetail;
import Sales.SaleDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "sConfirmSale", value = "/sConfirmSale")
public class sConfirmSale extends HttpServlet {
    private Logger logger=Logger.getLogger(sConfirmSale.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            logger.info("ingresando la venta a confirmar");
            HttpSession session=request.getSession();
            if (session.getAttribute("listCarshopping")!=null && session.getAttribute("SaleHeader")!=null){
                SaleDao.getInstance().Registrar((Sale) session.getAttribute("SaleHeader"));
                logger.info("compra culminada");
                response.sendRedirect("Sale/SuccessSale.jsp");
            }else {
                logger.info("volviendo al carrito");
                response.sendRedirect("/sCarShopping");
            }

        }catch (Exception e){
            logger.error("error en el form de confirmar "+e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {

        logger.info("ingresando atributos de compra");
        HttpSession session=request.getSession();
        if (session.getAttribute("listCarshopping")!=null && session.getAttribute("objPersona")!=null){
            ArrayList<SaleDetail> saleDetails=(ArrayList<SaleDetail>) session.getAttribute("listCarshopping");

            double total=0;
            for (SaleDetail saleDetail:saleDetails){
                saleDetail.setSubTotal(saleDetail.getUnits()*saleDetail.getUnitPrice());
                total+=saleDetail.getSubTotal();
            }

            Sale objSale =new Sale();
            objSale.setObjpersona((Persona) session.getAttribute("objPersona"));
            objSale.setTotal(((total*objSale.getIgv())/100)+total);
            objSale.setRegisterDatetime(new Date());
            objSale.setListSaleDetails(saleDetails);
            session.setAttribute("SaleHeader",objSale);
        }
        response.sendRedirect("Sale/ConfirmSale.jsp");
        logger.info("datos de compra guardados");
    }catch (Exception e){
        logger.info("sConfirmSale error"+e);
    }
    }
}

package org.example.view.servlet;

import Entity.Persona;
import Entity.Sale;
import Entity.SaleDetail;
import dataAccess.SaleDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
            }

        }catch (Exception e){
            logger.error("error al form de confirmar"+e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {

        HttpSession session=request.getSession();
        if (session.getAttribute("listCarshopping")!=null && session.getAttribute("objPersona")!=null){
            ArrayList<SaleDetail> saleDetails=(ArrayList<SaleDetail>) session.getAttribute("listCarshopping");

            double itotal=0;
            for (SaleDetail saleDetail:saleDetails){
                saleDetail.setSubTotal(saleDetail.getUnits()*saleDetail.getUnitPrice());
                itotal+=saleDetail.getSubTotal();
            }
            session.setAttribute("listCarshopping",saleDetails);
            Sale objSale =new Sale();
            itotal=(((itotal*objSale.getIgv())/100)+itotal);
            BigDecimal iitotal=new BigDecimal(itotal);
            BigDecimal Total=iitotal.setScale(2, RoundingMode.HALF_DOWN);
            double total=Double.parseDouble(Total.toString());
            objSale.setObjpersona((Persona) session.getAttribute("objPersona"));
            objSale.setTotal(total);
            objSale.setRegisterDatetime(new Date());

            session.setAttribute("SaleHeader",objSale);
        }
        response.sendRedirect("Sale/ConfirmSale.jsp");
    }catch (Exception e){
        logger.info("sConfirmSale error"+e);
    }
    }
}

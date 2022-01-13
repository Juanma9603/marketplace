package org.example.view.servlet;

import Entity.Sale;
import Entity.SaleDetail;
import Sales.SaleDetailDao;
import dto.Orders;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sOrdersDetail",value = "/order/detail")
public class sOrdersDetail extends HttpServlet {
    private static Logger logger=Logger.getLogger(sOrdersDetail.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            logger.info("ingresa idSale");
            if (request.getParameter("idSale")!=null){
                String idSale=request.getParameter("idSale")+"";
                logger.info(idSale.toString());
                Sale sale=searchOrder(idSale.toString(),(ArrayList<Orders>) session.getAttribute("orderList"));
                sale.setListSaleDetails(calcSubtotal(SaleDetailDao.getInstance().get(idSale)));
                session.setAttribute("orderDetail",sale);
                logger.info("redirecciona sale orderdetail");
                response.sendRedirect("../Sale/OrderDetail.jsp");
            }
        } catch (Exception e) {
            logger.error("error al ingresar idsale del detalle" + e);
        }
    }

    private Sale searchOrder(String idSale, ArrayList<Orders>list){
        Sale sale=new Sale();

        for (Orders order:list){
            if (order.getIdOrder().equals(idSale)){
                sale.setIdSale(order.getIdOrder());
                sale.setRegisterDatetime(order.getRegister_datetime());
                sale.setIgv(order.getIgv());
                sale.setTotal(order.getTotal());
                break;
            }
        }

        return sale;
    }

    private ArrayList<SaleDetail> calcSubtotal (ArrayList<SaleDetail> lstSaleDetail){
        for (SaleDetail detail:lstSaleDetail){
            Double subTotal=detail.getUnits()*detail.getUnitPrice();
            detail.setSubTotal(subTotal);
        }

        return lstSaleDetail;
    }
}

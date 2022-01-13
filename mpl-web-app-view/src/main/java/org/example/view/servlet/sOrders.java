package org.example.view.servlet;

import Entity.Persona;
import Sales.OrderDao;
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

@WebServlet(name = "sOrders",value = "/sOrders")
public class sOrders extends HttpServlet {
    private static Logger logger=Logger.getLogger(sOrders.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        try {
            if (session.getAttribute("objPersona")!=null){
                Persona persona=(Persona) session.getAttribute("objPersona");

                ArrayList<Orders> orders = OrderDao.getInstance().getlist(persona.getID());
                session.setAttribute("orderList",orders);
                response.sendRedirect("Sale/Orders.jsp");
            }else {
                response.sendRedirect("/sAutentication");
            }
        }catch (Exception e){
            logger.error("Error al obtener lista de orders"+e);
        }

    }
}

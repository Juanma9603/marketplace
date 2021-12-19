package org.example.view.servlet;


import Entity.Product;
import dataAccess.ProductDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sStoreProducts",value = "/sStoreProducts")
public class sStoreProducts extends HttpServlet {
    private static Logger logger=Logger.getLogger(sStoreProducts.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Product> listproducts=new ArrayList<Product>();
            listproducts=ProductDao.getInstance().list();
            HttpSession session =request.getSession();
            session.setAttribute("listproducts",listproducts);
            response.sendRedirect("Store/ListProductos.jsp");
        }catch (Exception e){
            logger.error("error al llamar a la lista");
            response.sendRedirect("Errorpage.jsp");
        }


    }
}

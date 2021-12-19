package org.example.view.servlet;

import Entity.Persona;
import Entity.User;
import dataAccess.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "sCreateAccount", value = "/sCreateAccount")
public class sCreateAccount extends HttpServlet {
    private static Logger logger=Logger.getLogger(sCreateAccount.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            logger.info("ingresa a crear usuario");
            HttpSession session=request.getSession();
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            String firstname=request.getParameter("firstname");
            String lastname=request.getParameter("lastname");
            String birthday=request.getParameter("birthday");
            String email=request.getParameter("email");
            if (username!=null && password!=null && firstname!=null && birthday!=null && email!=null){
                Persona objpersona=new Persona(
                        0,
                        firstname,
                        lastname,
                        birthday,
                        email,
                        new Date(),
                        new Date(),
                        new User(
                                0,
                                username,
                                password,
                                0,
                                new Date(),
                                new Date())
                );
                UserDao.getInstance().Registrar(objpersona);
                logger.info("Cuenta Creada");
            }
            response.sendRedirect("Login/LoginPage.jsp");
        }catch (Exception e){
            logger.error("error al crear usuario");
            response.sendRedirect("ErrorPage.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Login/LoginCreate.jsp");

    }
}

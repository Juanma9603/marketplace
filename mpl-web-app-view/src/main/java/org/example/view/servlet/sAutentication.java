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

@WebServlet(name = "sAutentication", value = "/sAutentication")
public class sAutentication extends HttpServlet {
    private static Logger logger=Logger.getLogger(sAutentication.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ingresando a autentication");
        HttpSession session = request.getSession();
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if (username != null && password != null && username!="" && password!=""){
            Persona objPersona=new Persona();
            logger.info(objPersona.getObjUser().getID());
            objPersona= UserDao.getInstance().Autentication(new User(0,username,password,0,new Date(),new Date()));
            session.setAttribute("objpersona",objPersona);
            logger.info(objPersona.getObjUser().getID());
            if (objPersona.getObjUser().getID()!=0){
                logger.info("entra al perfil");
                session.setAttribute("objPersona",objPersona);
                response.sendRedirect("Login/PerfilLogin.jsp");
            }else {
                logger.info("password vacio");
                response.sendRedirect("./index.jsp");
            }
        }else {

            response.sendRedirect("./index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (request.getParameter("type")!=null){
            if (request.getParameter("type").equals("logout")){
                session.removeAttribute("objPersona");
            }
        }else {
            if (session.getAttribute("objPersona")!=null){
                response.sendRedirect("Store/ListProductos.jsp");
            }else {
                response.sendRedirect("./index.jsp");
            }
        }
    }
}

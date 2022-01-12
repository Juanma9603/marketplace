<%@ page import="Entity.Persona" %><%--
  Created by IntelliJ IDEA.
  User: Luis Enrique
  Date: 29/11/2021
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1=request.getSession();
    if (session1.getAttribute("objpersona")!=null){
        Persona objPersona=(Persona)session1.getAttribute("objpersona");
        if (objPersona.getID()==0){
            response.sendRedirect("./index.jsp");
        }
    }
%>

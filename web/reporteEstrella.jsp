<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page import="model.bd.Estrella"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <%
        Data d = new Data();
        List<Estrella> repEstrella = d.getEstrella();
    %>
    <body>
        <h1>Reporte Estrella</h1>
        <%
            for (Estrella cc : repEstrella) {
                out.println("<tr>");
                out.println("<td>" + cc.getId() + "</td>");
                out.println("<td>" + cc.getNombre() + "</td>");
                out.println("<td>" + d.getSistemaPlanetarioBy(String.valueOf(cc.getIdSistemaPlanetarioFK())) + "</td>");
                out.println("</tr>");
            }
        %>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>

    </body>
</html>

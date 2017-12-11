<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page import="model.bd.SistemaPlanetario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <%
        Data d = new Data();
        List<SistemaPlanetario> repSistemaPlanetario = d.getSistemaPlanetario();
    %>
    <body>
        <h1>Reporte Sistema Planetario</h1>
        <table border = '1'>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
            </tr>
            <%
                for (SistemaPlanetario sp : repSistemaPlanetario) {
                    out.println("<tr>");
                    out.println("<td>" + sp.getId() + "</td>");
                    out.println("<td>" + sp.getNombre() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>
    </body>
</html>

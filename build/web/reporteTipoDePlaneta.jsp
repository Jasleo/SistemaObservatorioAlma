<%@page import="model.bd.TipoDePlaneta"%>
<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <%
        Data d = new Data();
        List<TipoDePlaneta> repTipoDePlaneta = d.getTipoDePlaneta();
    %>
    <body>
        <h1>Reporte Tipo De Planeta</h1>
        <table border = '1'>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
            </tr>
            <%
                for (TipoDePlaneta tdp : repTipoDePlaneta) {
                    out.println("<tr>");
                    out.println("<td>" + tdp.getId() + "</td>");
                    out.println("<td>" + tdp.getNombre() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>

        <br>
        <a href="menu.jsp">Retornar</a>
        <br>
    </body>
</html>

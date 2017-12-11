<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page import="model.bd.TipoDeCuerpoMenor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <%
        Data d = new Data();
        List<TipoDeCuerpoMenor> repTipoDeCuerpoMenor = d.getTipoDeCuerpoMenor();
    %>
    <body>
        <h1>Reporte Tipo De Cuerpo Menor</h1>
        <table border = '1'>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
            </tr>
            <%
                for (TipoDeCuerpoMenor tdcm : repTipoDeCuerpoMenor) {
                    out.println("<tr>");
                    out.println("<td>" + tdcm.getId() + "</td>");
                    out.println("<td>" + tdcm.getNombre() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>
    </body>
</html>

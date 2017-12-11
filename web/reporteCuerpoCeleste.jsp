<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page import="model.bd.CuerpoCeleste"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <%
        Data d = new Data();
        List<CuerpoCeleste> repCuerpoCeleste = d.getCuerpoCelestes();
    %>
    <body>
        <h1>Reporte Cuerpo Celeste</h1>
        <%
            for (CuerpoCeleste cc : repCuerpoCeleste) {
                out.println("<tr>");
                out.println("<td>" + cc.getId() + "</td>");
                out.println("<td>" + cc.getNombre() + "</td>");
                out.println("<td>" + cc.getMasa() + "</td>");
                out.println("<td>" + cc.getTamano() + "</td>");
                out.println("<td>" + d.getEstrellaBy(String.valueOf(cc.getIdEstrellaFK())) + "</td>");
                out.println("<td>" + d.getTipoDeCuerpoMenorBy(String.valueOf(cc.getIdTipoDeCuerpoMenorFK())) + "</td>");
                out.println("</tr>");
            }
        %>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>


    </body>
</html>

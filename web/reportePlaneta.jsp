<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page import="model.bd.Planeta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <%
        Data d = new Data();
        List<Planeta> repPlaneta = d.getPlaneta();
    %>
    <body>
        <h1>Reporte Planeta</h1>
        <table border = '1'>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Simbologia</th>
                <th>Diametro Ecuatorial</th>
                <th>Masa</th>
                <th>Radio Orbital</th>
                <th>Periodo Orbital</th>
                <th>Periodo De Rotacion</th>
                <th>Composicion de Planeta</th>
                <th>Estrella</th>
                <th>Tipo de Planeta</th>
            </tr>
            <%
                for (Planeta pl : repPlaneta) {
                    out.println("<tr>");
                    out.println("<td>" + pl.getId() + "</td>");
                    out.println("<td>" + pl.getNombre() + "</td>");
                    out.println("<td>" + pl.getSimbologia() + "</td>");
                    out.println("<td>" + pl.getDiametroEcuatorial() + "</td>");
                    out.println("<td>" + pl.getMasa() + "</td>");
                    out.println("<td>" + pl.getRadioOrbital() + "</td>");
                    out.println("<td>" + pl.getPeriodoOrbital() + "</td>");
                    out.println("<td>" + pl.getPeriodoDeRotacion() + "</td>");
                    out.println("<td>" + pl.getComposicionAtmosfera() + "</td>");
                    out.println("<td>" + d.getEstrellaBy(String.valueOf(pl.getIdEstrellaFK())) + "</td>");
                    out.println("<td>" + d.getTipoDePlanetaBy(String.valueOf(pl.getIdTipoDePlanetaFK())) + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>
    </body>
</html>

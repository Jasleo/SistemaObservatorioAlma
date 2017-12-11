<%@page import="java.util.List"%>
<%@page import="model.bd.Satelite"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <%
            Data d = new Data();
            List<Satelite> repSatelite = d.getSatelite();


        %>
        <h1>Satelite</h1>
        <table border = '1'>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Diametro</th>
                <th>Periodo Orbital Dia</th>
                <th>Periodo Orbital Hora</th>
                <th>Periodo Orbital Minuto</th>
                <th>Planeta</th>
            </tr>
            <%            for (Satelite sat : repSatelite) {
                    out.println("<tr>");
                    out.println("<td>" + sat.getId() + "</td>");
                    out.println("<td>" + sat.getNombre() + "</td>");
                    out.println("<td>" + sat.getDiametro() + "</td>");
                    out.println("<td>" + sat.getPeridoOrbitalDia() + "</td>");
                    out.println("<td>" + sat.getPeridoOrbitalHora() + "</td>");
                    out.println("<td>" + sat.getPeridoOrbitalMInuto() + "</td>");
                    out.println("<td>" + d.getPlanetaById(String.valueOf(sat.getIdPlanetaFK())) + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>
    </body>
</html>

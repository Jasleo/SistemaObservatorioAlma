<%@page import="model.bd.Satelite"%>
<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Buscar Planeta</h1>
        <form ole="search" action="buscarBySatelite.jsp" method="get">
            <input type="text"  name="txtBuscar" placeholder="Buscar">
            <button type="submit"> Buscar </button>
        </form>

        <h2>Resultado</h2>
        <table>
            <%            String txtBuscar = request.getParameter("txtBuscar");
                if (txtBuscar != null) {
                    out.println("<tr>");
                    out.println("<th>id</th>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Diametro</th>");
                    out.println("<th>Periodo Orbital Dia</th>");
                    out.println("<th>Periodo Orbital Hora</th>");
                    out.println("<th>Periodo Orbital Minuto</th>");
                    out.println("<th>Planeta</th>");
                    out.println("</tr>");

                    Data d = new Data();
                    List<Satelite> repSatelite = d.getSatelite();

                    for (Satelite sat : repSatelite) {
                        out.println("<tr>");
                        out.println("<td>" + sat.getId() + "</td>");
                        out.println("<td>" + sat.getNombre() + "</td>");
                        out.println("<td>" + sat.getDiametro() + "</td>");
                        out.println("<td>" + sat.getPeridoOrbitalDia() + "</td>");
                        out.println("<td>" + sat.getPeridoOrbitalHora() + "</td>");
                        out.println("<td>" + sat.getPeridoOrbitalMInuto() + "</td>");
                        out.println("<td>" + d.getPlanetaById(String.valueOf(sat.getIdPlanetaFK())) + "</td>");

                        out.println("<td>");
                        out.println("<form action='eliminarSatelite.do' method='post' >");
                        out.println("<input type='submit' value='Eliminar'>");
                        out.println("<input type='hidden' value='" + sat.getId() + "' name = 'idEliminarSistema'>");
                        out.println("</form>");
                        out.println("</td>");

                        out.println("</tr>");
                    }
            %>
        </table>
        <br>
        <a href="menu.jsp">Retornar</a>
        <br>
    </body>
</html>

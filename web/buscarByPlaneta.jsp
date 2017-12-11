<%@page import="model.bd.Planeta"%>
<%@page import="java.util.List"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <h1>Buscar Planeta</h1>
        <form ole="search" action="buscarByPlaneta.jsp" method="get">
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
                    out.println("<th>Simbologia</th>");
                    out.println("<th>Diametro Ecuatorial</th>");
                    out.println("<th>Masa</th>");
                    out.println("<th>Radio Orbita</th>");
                    out.println("<th> Periodo Orbital</th>");
                    out.println("<th>Periodo De Rotacion</th>");
                    out.println("<th>Composicion de Planeta</th>");
                    out.println("<th>Estrella</th>");
                    out.println("<th> Tipo de Planeta</th>");
                    out.println("</tr>");

                    Data d = new Data();
                    List<Planeta> repPlaneta = d.getPlanetaByNombre(txtBuscar);
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

                        out.println("<td>");
                        out.println("<form action='eliminarPlaneta.do' method='post' >");
                        out.println("<input type='submit' value='Eliminar'>");
                        out.println("<input type='hidden' value='" + pl.getId() + "' name = 'idPlaneta'>");
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

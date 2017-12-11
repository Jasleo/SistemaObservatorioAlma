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
    <body>
        <h1>Buscar EStrell</h1>
        <form ole="search" action="buscarByEstrella.jsp" method="get">
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
                    out.println("<th>Sistema Planetario</th>");
                    out.println("</tr>");

                    Data d = new Data();
                    List<Estrella> resultadoEstrella = d.getEstrellaByNombre(txtBuscar);

                    for (Estrella est : resultadoEstrella) {

                        out.println("<tr>");
                        out.println("<td>" + est.getId() + "</td>");
                        out.println("<td>" + est.getNombre() + "</td>");
                        out.println("<td>" + d.getSistemaPlanetarioBy(String.valueOf(est.getIdSistemaPlanetarioFK())) + "</td>");

                        out.println("<td>");
                        out.println("<form action='eliminarEstrellla.do' method='post' >");
                        out.println("<input type='submit' value='Elimina'>");
                        out.println("<input type='hidden' value='" + est.getId() + "' name = 'idEstrella'>");
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

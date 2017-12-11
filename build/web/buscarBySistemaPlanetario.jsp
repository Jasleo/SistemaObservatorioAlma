<%@page import="java.util.List"%>
<%@page import="model.bd.SistemaPlanetario"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <h1>Buscar SistemaPlanetario</h1>
        <form ole="search" action="buscarBySistemaPlanetario.jsp" method="get">
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
                    out.println("</tr>");

                    Data d = new Data();
                    List<SistemaPlanetario> resultadoSistemaPlanetario = d.getSistemaPlanetarioByNombre(txtBuscar);

                    for (SistemaPlanetario sp : resultadoSistemaPlanetario) {
                        out.println("<tr>");
                        out.println("<td>" + sp.getId() + "</td>");
                        out.println("<td>" + sp.getNombre() + "</td>");

                        out.println("<td>");
                        out.println("<form action='eliminarSistemaPlanetario.do' method='post' >");
                        out.println("<input type='submit' value='Eliminar Sistema Planetario'>");
                        out.println("<input type='hidden' value='" + sp.getId() + "' name = 'idEliminarSistema'>");
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

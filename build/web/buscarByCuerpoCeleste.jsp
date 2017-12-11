<%@page import="model.bd.CuerpoCeleste"%>
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
        <h1>Buscar CuerpoCeleste</h1>
        <form ole="search" action="buscarByCuerpoCeleste.jsp" method="get">
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
                    out.print(" <th>Masa</th>");
                    out.print(" <th>Tamaño</th>");
                    out.print(" <th>Estrella</th>");
                    out.print(" <th>Tipo de Cuerpo Menor</th>");
                    out.println("</tr>");

                    Data d = new Data();
                    List<CuerpoCeleste> repCuerpoCeleste = d.getCuerpoCelestesByNombre(txtBuscar);

                    for (CuerpoCeleste cc : repCuerpoCeleste) {
                        out.println("<tr>");
                        out.println("<td>" + cc.getId() + "</td>");
                        out.println("<td>" + cc.getNombre() + "</td>");
                        out.println("<td>" + cc.getMasa() + "</td>");
                        out.println("<td>" + cc.getTamano() + "</td>");
                        out.println("<td>" + d.getEstrellaBy(String.valueOf(cc.getIdEstrellaFK())) + "</td>");
                        out.println("<td>" + d.getTipoDeCuerpoMenorBy(String.valueOf(cc.getIdTipoDeCuerpoMenorFK())) + "</td>");

                        out.println("<td>");
                        out.println("<form action='eliminarCuerpoCeleste.do' method='post' >");
                        out.println("<input type='submit' value='Eliminar'>");
                        out.println("<input type='hidden' value='" + cc.getId() + "' name = 'idCuerpoCeleste'>");
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

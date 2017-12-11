<%@page import="java.util.List"%>
<%@page import="model.bd.TipoDeCuerpoMenor"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>

        <h1>Buscar tipoDeCuerpoMenor</h1>
        <form ole="search" action="buscarbyTipoDeCuerpoMenor.jsp" method="get">
            <input type="text"  name="txtBuscar" placeholder="Buscar">
            <button type="submit"> Buscar </button>
        </form>

        <h2>Resultado</h2>
        <table border = '1'>
            <%            String txtBuscar = request.getParameter("txtBuscar");
                if (txtBuscar != null) {
                    out.println("<tr>");
                    out.println("<th>id</th>");
                    out.println("<th>Nombre</th>");
                    out.println("</tr>");

                    Data d = new Data();
                    List<TipoDeCuerpoMenor> resultadoTipoDeCuerpoMenor = d.getTipoDeCuerpoMenorByNombre(txtBuscar);

                    for (TipoDeCuerpoMenor tdcm : resultadoTipoDeCuerpoMenor) {
                        out.println("<tr>");
                        out.println("<td>" + tdcm.getId() + "</td>");
                        out.println("<td>" + tdcm.getNombre() + "</td>");

                        out.println("<td>");
                        out.println("<form action='eliminarTipoDeCuerpoMenor.do' method='post' >");
                        out.println("<input type='submit' value='Eliminar'>");
                        out.println("<input type='hidden' value='" + tdcm.getId() + "' name = 'idTipoDeCuerpoMenor'>");
                        out.println("</form>");
                        out.println("</td>");

                        out.println("</tr>");
                    }
            %>
        </table>

    </body>
</html>

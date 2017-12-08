<%-- 
    Document   : crearCuerpoCeleste
    Created on : 08-12-2017, 16:08:51
    Author     : dumbo
--%>

<%@page import="model.bd.Estrella"%>
<%@page import="model.bd.TipoDeCuerpoMenor"%>
<%@page import="model.bd.Data"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <h1>crear Cuerpo Celeste</h1>

        <form action="crearCuerpoCeleste.do" method="POST">
            Nombre del Cuerpo Celeste  :
            <br>
            <input name="txtNombreCuerpoCeleste" type="text" required="required">
            <br>
            Masa del Cuerpo Celeste:
            <br>
            <input name="txtMasaCuerpoCeleste" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Tamaño del Cuerpo Celeste:
            <br>
            <input name="txtTamanoCuerpoCeleste" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Tipo de De Cuerpo Menor :
            <select name="cboTipoDeCuerpoMenor">
                <%
                    for (TipoDeCuerpoMenor tcm : new Data().getTipoDeCuerpoMenor()) {
                        out.println("<option value='" + tcm.getId() + "'>" + tcm.getNombre() + "</option>");
                    }
                %>
            </select>  
            <br>
            Estrella :
            <select name="cboEstrella">
                <%
                    for (Estrella e : new Data().getEstrella()) {
                        out.println("<option value='" + e.getId() + "'>" + e.getNombre() + "</option>");
                    }
                %>
            </select>   

            <button type="submit"> Ingresar</button>
        </form>

        <form action="cerrar.do" method="post">
            <button type="submit" >Cerrar sesión</button>
        </form>
    </body>
</html>

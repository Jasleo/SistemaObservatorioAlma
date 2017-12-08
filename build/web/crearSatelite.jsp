<%-- 
    Document   : crearSatelite
    Created on : 08-12-2017, 13:45:28
    Author     : dumbo
--%>

<%@page import="model.bd.Planeta"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <h1>Creacion de Satelite</h1>
        <form action="crearSatelite.do" method="post">
            <br>
            Nombre de Satelite :
            <br><!--planetario -->
            <input name="txtNombreDeSatelite" type="text" required="required">
            <br>
            Diametro Satelite:
            <br>
            <input name="txtDiametroSatelite" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Perido Orbital Dia Satelite:
            <br>
            <input name="txtPeridoOrbitalDiaSatelite" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Perido Orbital Hora Satelite:
            <br>
            <input name="txtPeridoOrbitalHoraSatelite" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Perido Orbital MInuto Satelite:
            <br>
            <input name="txtPeridoOrbitalMInutoSatelite" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Planeta :
            <select name="cboPlaneta">
                <%
                    for (Planeta p : new Data().getPlaneta()) {
                        out.println("<option value='" + p.getId() + "'>" + p.getNombre() + "</option>");
                    }
                %>
            </select>  
        </form>
    </body>
</html>

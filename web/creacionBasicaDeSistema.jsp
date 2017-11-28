<%-- 
    Document   : creacionBasicaDeSistema
    Created on : 27-11-2017, 23:04:41
    Author     : dumbo
--%>

<%@page import="model.bd.TipoDePlaneta"%>
<%@page import="model.bd.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <h1>Creacion de Sistema/Estrella/planeta</h1>
        <form action="creacionBasicaDeSistema.do" method="post">
            <br>
            Nombre del Sistema Planetario :
            <br><!--planetario -->
            <input name="txtSistemaPlanetario" type="text" required="required">
            <br>
            Nombre de la Estrella :
            <br>
            <input name="txtEstrella" type="text" required="required" placeholder="ej :Sol">
            <br>
            Tipo de Planeta :
            <select name="cboTipoDePlaneta">
                <%
                    for (TipoDePlaneta tdp : new Data().getTipoDePlaneta()) {
                        out.println("<option value='" + tdp.getId() + "'>" + tdp.getNombre() + "</option>");
                    }
                %>
            </select>  
            <br>
            Nombre del Planeta :
            <br>
            <input name="txtNombrePlaneta" type="text" required="required">
            <br>
            Simbologia del Planeta :
            <br>
            <input name="txtSimbologiaPlaneta" type="text" required="required">
            <br>
            Diametro Ecuatorial del Planeta :
            <br>
            <input name="txtDiametroEcuatorialPlaneta" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Masa del Planeta:
            <br>
            <input name="txtMasaPlaneta" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Radio Orbital del Planeta:
            <br>
            <input name="txtRadioOrbitalPlaneta" type="number" step="any" placeholder="EJ. : 1,5" required="required">
            <br>
            Periodo Orbital del Planeta:
            <br>
            <input name="txtPeriodoOrbitalPlaneta" type="number" step="any" placeholder="Se Representan en Dias EJ :1,5" required="required">
            <br>
            Periodo De Rotación del Planeta:
            <br>
            <input name="txtPeriodoDeRotaciónPlaneta" type="number" step="any" placeholder="Se Representan en Año  EJ :1,5" required="required">
            <br>
            Composición Atmosfera Planeta: :
            <br>
            <input name="txtComposiciónAtmosferaPlaneta" type="text"  required="required">
            <br>
            <button type="submit"> Ingresar</button>
        </form>

        <form action="cerrar.do" method="post">
            <button type="submit" >Cerrar sesión</button>
        </form>

    </body>
</html>

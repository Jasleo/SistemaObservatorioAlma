<%-- 
    Document   : creacionSistemaCompleto
    Created on : 27-11-2017, 23:11:14
    Author     : dumbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alma</title>
    </head>
    <body>
        <h1>Sistema Observatorio</h1>

        <form action="crearSistemaPlanetarioCompleto.do" method="POST">
            <br>
            Nombre del Sistema Planetario :
            <br><!--planetario -->
            <input name="txtSistemaPlanetarioCompletoNombre" type="text" required="required">
            <br>
            Nombre de la Estrella :
            <br>
            <input name="txtEstrella" type="text" required="required" placeholder="ej :Sol">
            <br>

            Tipo de De Cuerpo Menor :
            <select name="cboTipoDeCuerpoMenor">
                <%
                    for (TipoDeCuerpoMenor tcm : new Data().getTipoDeCuerpoCeleste()) {
                        out.println("<option value='" + tcm.getId() + "'>" + tcm.getNombre() + "</option>");
                    }
                %>
            </select>            
            <br>
            Nombre del Cuerpo Celeste  :
            <br>
            <input name="txtCuerpoCeleste" type="text" required="required">
            <br>
            Masa del Cuerpo Celeste:
            <br>
            <input name="txtMasaCuerpoCeleste" type="number" required="required">
            <br>
            Tamaño del Cuerpo Celeste:
            <br>
            <input name="txtTamanoCuerpoCeleste" type="number" required="required">
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
            <input name="txtPlaneta" type="text" required="required">
            <br>
            Simbologia del Planeta :
            <br>
            <input name="txtSimbologiaPlaneta" type="text" required="required">
            <br>
            Diametro Ecuatorial del Planeta :
            <br>
            <input name="txtDiametroEcuatorialPlaneta" type="number" required="required">
            <br>
            Masa del Planeta:
            <br>
            <input name="txtMasaPlaneta" type= "number" >
            <br>
            Radio Orbital del Planeta:
            <br>
            <input name="txtRadioOrbitalPlaneta" type= "number" required="required">
            <br>
            Periodo Orbital del Planeta:
            <br>
            <input name="txtPeriodoOrbitalPlaneta" type="text" required="required">
            <br>
            Periodo De Rotación del Planeta:
            <br>
            <input name="txtPeriodoDeRotaciónPlaneta" type="number" required="required">
            <br>
            Composición Atmosfera Planeta: :
            <br>
            <input name="txtComposiciónAtmosferaPlaneta" type="text" required="required">
            <br>
            Nombre del Satelite :
            <br>
            <input name="txtSatelite" type="text" required="required">
            <br>
            Diametro del Satelite :
            <br>
            <input name="txtDiametroSatelite" type="number" required="required">
            <br>
            <button type="submit"> Ingresar</button>
        </form>
        <form action="cerrar.do" method="post">
            <button type="submit" >Cerrar sesión</button>
        </form>
    </body>
</html>

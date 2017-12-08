<%-- 
    Document   : crearTipoCuerpoCeleste
    Created on : 08-12-2017, 16:39:55
    Author     : dumbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ALMA</title>
    </head>
    <body>
        <h1>Crear Tipo de Cuerpo</h1>
        <form action="crecarTipoDeCuerpoMenor.do" method="POST">
            Nombre TipoDeCuerpoMenor  :
            <br>
            <input name="txtNombreTipoDeCuerpoMenor" type="text" required="required">
            <br>
            <button type="submit"> Ingresar</button>
        </form>

        <form action="cerrar.do" method="post">
            <button type="submit" >Cerrar sesión</button>
        </form>

    </body>
</html>

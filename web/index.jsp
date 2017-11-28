<%-- 
    Document   : index
    Created on : 27-11-2017, 21:07:58
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
        <h1>Sistema Observatorio "ALMA"</h1>
        <form action="iniciarSesion.do" method="post">
            Usuario : <input type="text" name="nombre" required="required" >                                                  
            Contraseña : <input type="password" name="contrasena" required="required"> 
            <%
                Error e = (Error) request.getSession().getAttribute("error");
                if (e != null) {
                    out.println("<p class='text-danger input-sm'>" + e.getMessage() + "</p>");
                    request.getSession().removeAttribute("error");
                }
            %>
            <input type="submit" value="Entrar">
        </form>

    </body>
</html>

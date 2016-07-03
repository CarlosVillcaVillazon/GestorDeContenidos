<%-- 
    Document   : usuario
    Created on : 01-07-2016, 10:35:42 AM
    Author     : VILLCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="img/SIS1.png" class="img-responsive" alt="">
        <form  method="post" action="LoginUsuario"> 
        <table border="0" >
            
            
            <tbody>
                <tr>
            
                    <td>
                        <h1>Usuario</h1>
                        <input type="text" id="username" name="username" placeholder="Ingrese usuario" class="form-control" value="" aria-describedby="sizing-addon3">
                    </td>
                </tr>
                <tr>
                
                    <td>
                        <h1>Password</h1>
                        <input type="password" id="password" name="password" placeholder="Ingrese contraseña" class="form-control" value="">
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <button id="btn-registro" type="submit" name="ingresar" value="Registrar" class="btn btn-info btn-sm btn-block" data-toggle="modal" data-target=".alerta">
                            Acceso
                        </button>
                    </td>
                </tr>
            </tbody>
            
        </table>    
    </body>
</html>

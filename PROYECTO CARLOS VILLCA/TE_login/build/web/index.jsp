<%-- 
    Document   : index
    Created on : 26-06-2016, 12:25:51 AM
    Author     : VILLCA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <BODY>
    <img src="img/SIS.png" class="img-responsive" alt="">
    <%        
        if(session.getAttribute("usuario") != null && !session.getAttribute("usuario").equals("")){
            response.sendRedirect("menus.jsp");
        }       
    %>
    <center>
    <form  method="post" action="Login"> 
        <table border="0" >
            <li>
                        <a class="page-scroll" href="usuario.jsp">Ir a la Pagina de Usuario</a>
                    </li>
            
            <tbody>
                <tr>
            
                    <td>
                        <h1>Nombre Administrador</h1>
                        <input type="text" id="username" name="username" placeholder="Ingrese nombre" class="form-control" value="" aria-describedby="sizing-addon3">
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
    </form> 
        
        
        
    </center>

</BODY>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author VILLCA
 */
@WebServlet(name = "grabador", urlPatterns = {"/grabador"})
public class estudiante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter(); 
          String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String ci = request.getParameter("ci");
        String ru = request.getParameter("ru");
        String semestre = request.getParameter("semestre");
        String username = request.getParameter("username");
        String passwords = request.getParameter("passwords");
        
        
        /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet estudiante</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>los datos adicionados son: </h1>");
            out.println("<table border='1'>");
            out.println("<h1>Nombre</h1>");
            out.println("<br>"+nombre);
            out.println("<h1>apellidos</h1>");
            out.println("<br>"+apellidos);
            out.println("<h1>ci</h1>");
            out.println("<br>"+ci);
            out.println("<h1>registro universitario</h1>");
            out.println("<br>"+ru);
            out.println("<h1>semestre</h1>");
            out.println("<br>"+semestre);
            out.println("<h1>usuario</h1>");
            out.println("<br>"+username);
            out.println("<h1>password</h1>");
            out.println("<br>"+passwords);
            
            
            
            try {
            //driver
            String driver = "com.mysql.jdbc.Driver";
                // canal de conexion 
                String canal = "jdbc:mysql://localhost:3306/dbpreuni";
                //especificar usuario
                String usuario = "root";
                //especioficar el password
                String password = "";
                
                //especificar
                Class.forName(driver);
                // crear una conexion
                Connection con = DriverManager.getConnection(canal,usuario,password);
                // crear una sentencia
                Statement sentencia = con.createStatement();
                //creamos una consulta de actualizacion
                String sql = "insert into estudiante (nombre,apellidos,ci,ru,semestre,username,password) values('"+nombre+"','"+apellidos+"','"+ci+"','"+ru+"','"+semestre+"','"+username+"','"+passwords+"')";
                //ejecutar la sentencia
                int res = sentencia.executeUpdate(sql);
                
                if (res != 0)
                    out.println("<h3>Se adiciono exitosamente</h3>");
                else
                    out.println("<h3>Errores en al adicionar</h3>");
                
                sentencia.close();
                con.close();
                
            } catch(ClassNotFoundException e){
            out.println("Error en driver: "+ e.getMessage());
            } catch(SQLException e){
            out.println("SQL Error: "+ e.getMessage());
            }
            
            out.println("</body>");
            out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package com.emergentes.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VILLCA
 */
@WebServlet(urlPatterns = {"/Listador"})
public class Listador extends HttpServlet {

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
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Listador</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{
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
                String sql = "select * from estudiante";
                //ejecutar la sentencia
                ResultSet rs = sentencia.executeQuery(sql);
                out.println("<h1>listado de contactos</h1>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Apellidos</th>");
                out.println("<th>Cedula de Identidad</th>");
                out.println("<th>Registro Universitario</th>");
                out.println("<th>Semestre</th>");
                out.println("<th>Usuario</th>");
                out.println("<th>Modificar</th>");
                out.println("<th>Eliminar</th>");
                out.println("</tr>");
                //permite recorrer
                while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("nombre")+"</td>");
                out.println("<td>"+rs.getString("apellidos")+"</td>");
                out.println("<td>"+rs.getString("ci")+"</td>");
                out.println("<td>"+rs.getString("ru")+"</td>");
                out.println("<td>"+rs.getString("semestre")+"</td>");
                out.println("<td>"+rs.getString("username")+"</td>");
                out.println("<td><a href=\"Controlador.Modificar.java>\">Modificar</a></td>");
                out.println("<td><a href=\"Controlador.Eliminar.java>\">Eliminar</a></td>");
                out.println("</tr>");
                }
                
                
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

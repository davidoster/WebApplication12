/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author George.Pasparakis
 */
public class HelloWorld extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Servlet HelloWorld</title>");            
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Servlet HelloWorld at " + request.getContextPath() + "</h1>");
            out.print("</body>");
            out.print("</html>");
        }
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
        String server = "ra1.anystream.eu:1011";
        String username;
        String password = "mydb";
        String database = "mydb";
        String query = "SELECT * FROM `mydb`.`Employee`;";
        Database db = new Database();
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloWorld at " + request.getContextPath() + "</h1>");
            username = request.getParameter("username");
            out.println("<h1> username = " + username + "</h1>");
           
            ResultSet rs = db.Database(server, database, username, password, query);
            try {
                while(rs.next()) {
                    out.println(rs.getString(1) + "&nbsp;" + rs.getString(2) + "&nbsp;" + rs.getString(3) + 
                                                  "&nbsp;" + rs.getString(4) + "<br />");
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.print("</body>");
            out.print("</html>");
        }
        
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
        //processRequest(request, response);
        String server = "ra1.anystream.eu:1011";
        String username ="mydb";
        String password = "mydb";
        String database = "mydb";
        String query = "SELECT * FROM `mydb`.`Employee`;";
        Database db = new Database();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Servlet HelloWorld</title>");            
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Servlet HelloWorld at " + request.getContextPath() + "</h1>");
            //out.print(request.getParameter("name"));
            String name = request.getParameter("name");
            String dept = request.getParameter("dept");
            query = "SELECT * FROM `mydb`.`Employee` " + 
                    "WHERE `NAME` = '" + name + "' " +
                    "AND `DEPT` = '"   + dept + "';";
            out.print("Name: " + name + "<br />");
            out.print("Dept: " + dept + "<br />");
            ResultSet rs = db.Database(server, database, username, password, query);
            try {
                while(rs.next()) {
                    out.println(rs.getString(1) + "&nbsp;" + rs.getString(2) + "&nbsp;" + rs.getString(3) + 
                                                  "&nbsp;" + rs.getString(4) + "<br />");
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloWorld.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.print("</body>");
            out.print("</html>");
        }
        
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

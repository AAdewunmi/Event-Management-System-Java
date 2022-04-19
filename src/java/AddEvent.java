/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author adrianadewunmi
 * Servlet for adding events to the database
 */

public class AddEvent extends HttpServlet {

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
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       String a1 = request.getParameter("Event_Number");
       String a2 = request.getParameter("Event_Name");
       String a3 = request.getParameter("Coordinator_Name");
       String a4 = request.getParameter("Coordinator_Number");
       String a5 = request.getParameter("Fee");
       String a6 = request.getParameter("Venue");
       String a7 = request.getParameter("Date");
       
       try{
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(AddEvent.class.getName()).log(Level.SEVERE, null, ex);
           }
           String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
           String userName = "root";
           String userPassword = "abc";
           Connection con = DriverManager.getConnection(conURL, userName, userPassword);
           
           Statement statement = con.createStatement();
           String queryStatement = "insert into Event values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"') ";
           ResultSet resultSet = statement.executeQuery(queryStatement);
           
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("CreateE.html");
           requestDispatcher.include(request, response);
           
           out.println("<br><center><h3> Event Added</h3></center>");
           System.out.println("Added to the database!!!");
           con.commit();
           con.commit();
       }catch(SQLException e){
           System.out.println("Exception caught: " + e);
       }
    }


}

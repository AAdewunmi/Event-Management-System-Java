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

/**
 *
 * @author adrianadewunmi
 */
public class Register extends HttpServlet {

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
        
       String a1 = request.getParameter("Event_Name");
       String a2 = request.getParameter("Event_Number");
       String a3 = request.getParameter("Card_Number");
       String a4 = request.getParameter("Expiry_Date");
       String a5 = request.getParameter("CVV_Number");
       String a6 = request.getParameter("Card_Name");
       
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
            String dbusername = "root";
            String dbuserpassword = "abc";
            Connection con;
            con = DriverManager.getConnection(conURL , dbusername, dbuserpassword);
            Statement statement = con.createStatement();
            String mysqlQuery = "insert into card values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"') ";
            statement.executeUpdate(mysqlQuery);
            con.commit();
            con.close();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Payment.html");
            requestDispatcher.forward(request, response);
       }catch(ServletException | IOException | ClassNotFoundException | SQLException e){
           System.out.println("Exception Caught: " + e);
       }
       
    }

}

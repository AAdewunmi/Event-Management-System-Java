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
import java.sql.Statement;


/**
 *
 * @author adrianadewunmi
 */
public class StoreP extends HttpServlet {
    
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
        
        String participantsName = request.getParameter("Pname");
        String userName = request.getParameter("Pusername");
        String userPassword = request.getParameter("Ppassword");
        String confirmUserPassword = request.getParameter("Cpassword");
        
        // EventlyDB, name of table plogindetails
        
        if(userPassword.equals(confirmUserPassword)){
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String conURL = "jdbc:mysql:// localhost:3306/";
                String dbname = "EventlyDB";
                String dbusername = "root";
                String dbuserpassword = "abc";
                Connection con;
                con = DriverManager.getConnection(conURL + dbname, dbusername, dbuserpassword);
                Statement statement = con.createStatement();
                String mysqlQuery = "insert into plogindetails values('"+userName+"','"+userPassword+"','"+participantsName+"')";
                ResultSet resultSet = statement.executeQuery(mysqlQuery);
                RequestDispatcher requestDispatcher;
                requestDispatcher = request.getRequestDispatcher("Plogin.html");
                requestDispatcher.forward(request, response);
                con.close();
            }catch(Exception e){
                System.out.println(e);
            }
        
        }else{
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Psignup.html");
            requestDispatcher.include(request, response);
        }
        
    }

}

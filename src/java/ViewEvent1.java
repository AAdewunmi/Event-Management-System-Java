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
 * This Servelet is used for registering events by participants.
 */

public class ViewEvent1 extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conURL = "jdbc:mysql://localhost:3306/EventlyDB";
            String dbusername = "root";
            String dbuserpassword = "abc";
            Connection con;
            con = DriverManager.getConnection(conURL , dbusername, dbuserpassword);
            con.setAutoCommit(false);
            response.setContentType("text/html");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Event");
            out.println("<h1 style=\"text-align: center\">Welcome To Evently ... An Event Management Portal!</h1>");
            out.println("<center><h1>Event Details</h1></center>");
            out.println("<div>");
            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Event Number</th><th>Event Name</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>");  
            //request.getParameter
            while(resultSet.next()){
                String n = resultSet.getString("Event_Number");
                String nm = resultSet.getString("Event_Name");
                String co = resultSet.getString("Coordinator_Name");
                String cono = resultSet.getString("Coordinator_Number");
                String f = resultSet.getString("Fee");
                String v = resultSet.getString("Venue");
                String d = resultSet.getString("Date");
                out.println("<tr><td>" + n + "</td><td>" + nm +"</td><td>"+co+"</td><td>"+cono+"</td><td>"+f+"</td><td>"+v+"</td><td>"+d+"</td></tr>");   
                
            }
            
            con.commit();
            con.close();
            out.println("</table>"); 
            out.println("<br>");
            out.println("</div>");
            out.println("</center>");
            out.println("<div>");
            out.println("<label class=\"topnav-right\"> © 1999-2022 Evently. All rights reserved. </label>");
            out.println("</div>");
            out.print("</body>");
            out.print("</html>");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception Caught: " + e);
        }
    }

}

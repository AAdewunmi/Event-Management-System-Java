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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            
            response.setContentType("text/html");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Event");
            
            out.println("<center><h1>Event Details</h1></center>");
            out.println("<br>");
            out.println("<div>");
                 
            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>EventNumber</th><th>EventName</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>");  
            
            while(resultSet.next()){
                String a1 = request.getParameter("Event_Number");
                String a2 = request.getParameter("Event_Name");
                String a3 = request.getParameter("Coordinator_Name");
                String a4 = request.getParameter("Coordinator_Number");
                String a5 = request.getParameter("Fee");
                String a6 = request.getParameter("Venue");
                String a7 = request.getParameter("Date");
                out.println("<tr><td>"+a1+"</td><td>"+a2+"</td><td>"+a3+"</td><td>"+a4+"</td><td>"+a5+"</td><td>"+a6+"</td><td>"+a7+"</td></tr>");
            }
            
            con.commit();
            con.close();
            out.println("</table>"); 
            out.println("<br>");
            out.println("</div>");
            out.println("</center>");
            out.print("</body>");
            out.print("</html>");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception Caught: " + e);
        }
    }

}

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
public class TraH extends HttpServlet {
    
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
       
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Transactions Page</title>");
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
            
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from card");
            
            out.println("<center><h1> Transaction  Details </h1> </center> ");
            out.println("<div>");
            out.println("<center>");
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Event No</th><th>Event Name</th><th>Name</th><th>Payment Date</th>"); 
            
            while(resultSet.next()){
                
                String en = request.getParameter("Event_Number");
                String re = request.getParameter("Event_Name");
                String pd = request.getParameter("Expiry_Date");
                String name = request.getParameter("Card_Name");
               
                out.println("<tr><td>" + en + "</td><td>" + re + "</td><td>"+name+"</td><td>" + pd +"</td></tr>"); 
             
            }
            
            con.commit();
            con.close(); 
            out.println("</table>"); 
            out.println("</h3></center>");
            out.println("</div>");
            out.print("</body>");
            out.print("</html>");
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Exception Caught: " + e);
        }
       
    }
    

}

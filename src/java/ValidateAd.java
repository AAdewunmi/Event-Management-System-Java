/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

/**
 * @author adrianadewunmi
 * Admin Login Validation Servlet
 * for administrator login
 */

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author adrianadewunmi
 */
public class ValidateAd extends HttpServlet {
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
        // Fetch username and password
        try (PrintWriter printWriterOut = response.getWriter()) {
            // Fetch username and password
            String userName = request.getParameter("Ausername");
            String userPassword = request.getParameter("Apassword");
            
            response.setContentType("text/html");
            
            // List of Admin usernames and password
            String adminUserOne = "A101";
            String adminUserOnePassword = "Admin101";
            
            String adminUserTwo = "A202";
            String adminUserTwoPassword = "Admin202";
            
            String adminUserThree = "A303";
            String adminUserThreePassword = "Admin303";
            
            String adminUserFour = "A404";
            String adminUserFourPassword = "Admin404";
            
            // Check for valid username and password
            if(userName.equals(adminUserOne) && userPassword.equals(adminUserOnePassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminEvent.html");
                requestDispatcher.forward(request, response);
            }else if(userName.equals(adminUserTwo) && userPassword.equals(adminUserTwoPassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminEvent.html");
                requestDispatcher.forward(request, response);
            }else if(userName.equals(adminUserThree) && userPassword.equals(adminUserThreePassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminEvent.html");
                requestDispatcher.forward(request, response);
            }else if(userName.equals(adminUserFour) && userPassword.equals(adminUserFourPassword)){
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminEvent.html");
                requestDispatcher.forward(request, response);
                // If username and password are invalid, enter else
            }else{
                //printWriterOut.println("<center><h4>Please Enter Valid Username & Password for Admin!!!</center></h4>");
                response.setContentType("text/html");  
                printWriterOut.println("<script type=\"text/javascript\">");  
                printWriterOut.println("alert('Please Enter Valid Username & Password for Admin!!!');");  
                printWriterOut.println("</script>");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Alogin.html");
                requestDispatcher.include(request, response);
            }
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author adrianadewunmi
 */
public class VaPa extends HttpServlet {

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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("Pausername");
        String userPassword = request.getParameter("Papassword");
        
        if(LoginDao.validate(userName, userPassword)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ParticipantEvent.html");
            requestDispatcher.forward(request, response);
        }else{
            out.print("<center><h1>Sorry username and password incorrect</h1></center>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Plogin.html");
             requestDispatcher.include(request, response);
        }
        out.close();
    }

}

package com.example.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.dao.UserDAO;
import com.example.model.ProductData;
/**
 *
 * @author makri
 */

public class login extends HttpServlet {
UserDAO dao;    
private static final long serialVersionUID = 1L;    

public void init(){
    dao = new UserDAO();
}
    //private Object result;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    

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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String barcode =  request.getParameter("barcode");
         String name = request.getParameter("name");
         String color = request.getParameter("color");
         String description = request.getParameter("description");
         ProductData newUser;
         newUser = dao.getUser(barcode);
         if(newUser != null){
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
         }
         else{
            ProductData user= new ProductData(barcode,name,color,description); 
            dao.saveUser(user);
            request.setAttribute("barcode", barcode);
            request.setAttribute("name", name);
            request.setAttribute("color", color);
            request.setAttribute("description", description);

            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
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

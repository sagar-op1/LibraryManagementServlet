package com.book.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
    	//Delete the book data when required
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        BookDao.delete(id);  
        response.sendRedirect("ViewServlet");  
    }  
}  

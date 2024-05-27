package com.book.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        //HTML
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Update Book</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }");
        out.println("h1 { color: #333; margin-bottom: 20px; }");
        out.println("form { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 300px; }");
        out.println("table { width: 100%; }");
        out.println("td { padding: 10px; }");
        out.println("input[type='text'], input[type='hidden'] { width: 100%; padding: 8px; margin: 5px 0; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }");
        out.println("input[type='submit'] { background-color: #4CAF50; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; width: 100%; }");
        out.println("input[type='submit']:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        //Fetch book details
        out.println("<h1>Update Book</h1>");
        String sid = request.getParameter("id");  
        int id = Integer.parseInt(sid);  
        Book e = BookDao.getBookById(id);  

        //update Book form
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");  
        out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + e.getTitle() + "' required/></td></tr>");  
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + e.getAuthor() + "' required/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");

        out.println("</body>");
        out.println("</html>");
        out.close();  
    }
}

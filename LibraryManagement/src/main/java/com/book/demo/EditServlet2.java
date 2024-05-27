package com.book.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
// function to update the data
        try {
            String sid = request.getParameter("id");
            int id = Integer.parseInt(sid);
            String title = request.getParameter("title");
            String author = request.getParameter("author");

            Book b = new Book();
            b.setId(id);
            b.setTitle(title);
            b.setAuthor(author);
            int status = BookDao.update(b);
            if (status > 0) {
                response.sendRedirect("ViewServlet");
            } else {
            	//HTML,CSS
                out.println("<!DOCTYPE html>");
                out.println("<html lang='en'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<title>Error</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }");
                out.println("h1 { color: #333; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Sorry! Unable to update record</h1>");
                out.println("<a href='index.html'>Back to Home</a><br>");
                out.println("<a href='ViewServlet'>View Books</a><br>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Error</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }");
            out.println("h1 { color: #333; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error occurred: " + e.getMessage() + "</h1>");
            out.println("<a href='index.html'>Back to Home</a><br>");
            out.println("<a href='ViewServlet'>View Books</a><br>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}

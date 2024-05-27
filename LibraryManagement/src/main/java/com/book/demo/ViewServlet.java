package com.book.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //HTML/CSS
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Book List</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; }");
        out.println("h1 { color: #333; }");
        out.println("table { width: 90%; border-collapse: collapse; margin-top: 20px; }");
        out.println("table, th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("a { text-decoration: none; color: #4CAF50; margin: 10px; font-size: 18px; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // Navigation links
        out.println("<a href='index.html'>Back to Home</a><br>");
        out.println("<a href='AddBook.html'>Add Book</a><br>");

     // function to show the  Book data in table 
        out.println("<h1>Book List</h1>");

        try {
            List<Book> list = BookDao.getAllBooks();

            if (list.isEmpty()) {
                out.println("<p>No books found</p>");
            } else {
                // Book list table
                out.println("<table>");
                out.println("<tr><th>Id</th><th>Title</th><th>Author</th><th>Update</th><th>Delete</th></tr>");

                for (Book book : list) {
                	out.println("<tr>");
                	out.println("<td>" + book.getId() + "</td>");
                	out.println("<td>" + book.getTitle() + "</td>");
                	out.println("<td>" + book.getAuthor() + "</td>");
                	//Update and delete button 
                	 out.println("<td><a href='EditServlet?id=" + book.getId() + "'>Update</a></td>");
                     out.println("<td><a href='DeleteServlet?id=" + book.getId() + "'>Delete</a></td>");
                     out.println("</tr>");
                }            
                out.println("</table>");
            }
        } catch (Exception e) {
            out.println("<p>Error occurred: " + e.getMessage() + "</p>");
            e.printStackTrace(out); 
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}

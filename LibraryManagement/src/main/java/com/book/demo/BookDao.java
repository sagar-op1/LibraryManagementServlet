package com.book.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
	//Mysql connectivity function
	public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books", "root", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
        }
        return con;
    }

	//Save book details function
	 public static int save(Book b) {
	        int status = 0;
	        String query = "INSERT INTO book(title, author) VALUES (?, ?)";
	        try (Connection con = BookDao.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, b.getTitle());
	            ps.setString(2, b.getAuthor());
	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	//Update book details function
	    public static int update(Book b) {
	        int status = 0;
	        String query = "UPDATE book SET title=?, author=? WHERE id=?";
	        try (Connection con = BookDao.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setString(1, b.getTitle());
	            ps.setString(2, b.getAuthor());
	            ps.setInt(3, b.getId());
	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	  //Delete book details function
	    public static int delete(int id) {
	        int status = 0;
	        String query = "DELETE FROM book WHERE id=?";
	        try (Connection con = BookDao.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setInt(1, id);
	            status = ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return status;
	    }

	  //show book detail with id detail function
	    public static Book getBookById(int id) {
	        Book b = new Book();
	        String query = "SELECT * FROM book WHERE id=?";
	        try (Connection con = BookDao.getConnection();
	             PreparedStatement ps = con.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                b.setId(rs.getInt("id"));
	                b.setTitle(rs.getString("title"));
	                b.setAuthor(rs.getString("author"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return b;
	    }

	  //show list of books with detail function
	    public static List<Book> getAllBooks() {
	        List<Book> list = new ArrayList<>();
	        String query = "SELECT * FROM book";
	        try (Connection con = BookDao.getConnection();
	             PreparedStatement ps = con.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Book b = new Book();
	                b.setId(rs.getInt("id"));
	                b.setTitle(rs.getString("title"));
	                b.setAuthor(rs.getString("author"));
	                list.add(b);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	}

package com.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		try {
			 int bookId = Integer.parseInt(req.getParameter("bookId"));
		       String bookName= req.getParameter("bookName");
		       int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));
		       
		       BookDao dao = new BookDao();
		      boolean status =  dao.saveBook(bookId, bookName, bookPrice);
		     String response = null;
		     if(status) {
		    	 response="record inserted";
		     }else {
		    	 response = "insertion failed";
		     }
			    PrintWriter pw = res.getWriter();
			    pw.append(response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	       
	}

}

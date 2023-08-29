package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.book.util.ConnectionFactory;

public class BookDao {
private static final String Insert_sql = "insert into books values(?,?,?)";
	public boolean saveBook(int bookId,String bookName,int bookPrice) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement(Insert_sql);
		ps.setInt(1, bookId);
		ps.setString(2, bookName);
		ps.setInt(3, bookPrice);
		int count = ps.executeUpdate();
		con.close();
		return count>0;
	}
}

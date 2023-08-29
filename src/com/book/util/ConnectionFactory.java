package com.book.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	
private static DataSource ds = null;

	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(ds==null) {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\laxmi\\workspace\\BookProjectwithDAO\\dbconfig.properties"));
		Properties p = new Properties();                    
		p.load(fis);
		String uname=p.getProperty("db.uname");
		String url =p.getProperty("db.url");
		String pwd=p.getProperty("db.pwd");
		HikariConfig config = new HikariConfig();
		config.setUsername(uname);
		config.setJdbcUrl(url);
		config.setPassword(pwd);
		ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}

}

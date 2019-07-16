package com.syk.jdbc;

import java.sql.*;

public class JdbcConnection  {
	
	private Connection conn;
	
	public JdbcConnection() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn=DriverManager.getConnection("jdbc:mysql://localhost/shanyikun?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "shanyikun");	
	}
	public Statement getStatement() throws ClassNotFoundException, SQLException {
		Statement stat=conn.createStatement();
		return stat;
	}
	
	public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement pstat=conn.prepareStatement(sql);
		return pstat;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
}

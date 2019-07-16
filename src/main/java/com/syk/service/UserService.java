package com.syk.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.syk.jdbc.JdbcConnection;

public class UserService {
	
	private JdbcConnection jdbcConnection=new JdbcConnection();
	
	public UserService() throws ClassNotFoundException, SQLException {
	}

	public String executeRegister(String name, String password) throws ClassNotFoundException, SQLException {
		String sqlQuery="select * from users where name=?";
		PreparedStatement pstatQuery=jdbcConnection.getPreparedStatement(sqlQuery);
		pstatQuery.setString(1, name);
		ResultSet queryResult=pstatQuery.executeQuery();
		if(!queryResult.next()) {
			String sqlInsert="insert into users values (0, ?, ?)";
			PreparedStatement pstatInsert=jdbcConnection.getPreparedStatement(sqlInsert);
			pstatInsert.setString(1, name);
			pstatInsert.setString(2, password);
			pstatInsert.executeUpdate();
			queryResult.close();
			pstatQuery.close();
			pstatInsert.close();
			jdbcConnection.closeConnection();
			return "register success!";
		}
		else {
			queryResult.close();
			pstatQuery.close();
			jdbcConnection.closeConnection();
			return "user has exists!";
		}
	}
	
	public String executeLogin(String name, String password) throws ClassNotFoundException, SQLException {
		String sqlQuery="select * from users where name=? and password=?";
		PreparedStatement pstatQuery=jdbcConnection.getPreparedStatement(sqlQuery);
		pstatQuery.setString(1, name);
		pstatQuery.setString(2, password);
		ResultSet queryResult = pstatQuery.executeQuery();
		if(queryResult.next()) {
			queryResult.close();
			pstatQuery.close();
			jdbcConnection.closeConnection();
			return "login success!";
		}
		else {
			queryResult.close();
			pstatQuery.close();
			jdbcConnection.closeConnection();
			return "username or password wrong!";
		}
	}
}

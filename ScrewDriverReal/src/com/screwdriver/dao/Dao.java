package com.screwdriver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.screwdriver.beans.Info;
import com.screwdriver.beans.UserAccount;
import com.screwdriver.conn.MySQLConnUtils;

public class Dao {
	public static int save(UserAccount user) 
			throws ClassNotFoundException, SQLException 
	{
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "insert into users(name,email,password,number,location) "
				+ "values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPassword());
		pstmt.setInt(4, user.getNumber());
		pstmt.setString(5, user.getLocation());
		int status =  pstmt.executeUpdate();
		conn.close();
		return status;
	}
	public static int saveInfo(Info info) 
			throws ClassNotFoundException, SQLException 
	{
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "insert into extra(info,description) values (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, info.getInfo());
		pstmt.setString(2, info.getDescription());
		return pstmt.executeUpdate();
	}
	public static List<UserAccount> getUsers() 
			throws ClassNotFoundException, SQLException
	{
		
		List<UserAccount> users = new ArrayList<UserAccount>(); 
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "select * from users";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			UserAccount ua = new UserAccount();
			ua.setId(rs.getInt(1));
			ua.setName(rs.getString(2));
			ua.setEmail(rs.getString(3));
			ua.setPassword(rs.getString(4));
			ua.setNumber(rs.getInt(5));
			ua.setLocation(rs.getString(6));
			users.add(ua);
		}
		return users;
	}
	public static List<Info> getInfo() 
			throws ClassNotFoundException, SQLException
	{
		Connection conn = MySQLConnUtils.getMySQLConnection();
		List<Info> infoList = new ArrayList<Info>();
		String sql = "select * from extra";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			Info info = new Info();
			info.setInfo(rs.getString(1));
			info.setDescription(rs.getString(2));
			infoList.add(info);
		}
		return infoList;
	}
	
	public static int deleteProduct(int id) 
			throws ClassNotFoundException, SQLException 
	{
		Connection conn = MySQLConnUtils.getMySQLConnection();
		String sql = "delete from users where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
	}
	public static UserAccount findUser(String email,String password) 
			throws ClassNotFoundException, SQLException 
	{
		String sql = "select * from users where email=? and password=?";
		Connection conn = MySQLConnUtils.getMySQLConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) 
		{
			UserAccount user = new UserAccount();
			int id = rs.getInt("id");
			String location = rs.getString("location");
			String name = rs.getString("name");
			int number = rs.getInt("number");
			user.setEmail(email);
			user.setId(id);
			user.setLocation(location);
			user.setName(name);
			user.setNumber(number);
			return user;
		}
		return null;
	}

}

package com.todo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.todo.model.User;
import com.todo.utils.JDBCUtil;

public class LoginDAO {

	public boolean validate(User user) throws ClassNotFoundException{
		boolean status = false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = JDBCUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement("select * from `todo_anime_list_users` where username=? and password=?;")){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			//System.out.println(rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}

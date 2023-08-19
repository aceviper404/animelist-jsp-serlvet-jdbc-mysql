package com.todo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.todo.model.User;
import com.todo.utils.JDBCUtil;

public class RegisterDAO {

	public int addUser(User user) throws ClassNotFoundException{
		int addedRow = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection = JDBCUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement("insert into todo_anime_list_users (`first_name`,`last_name`,`username`,`password`) values(?,?,?,?);")){
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			
			addedRow = ps.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return addedRow;
	}
}

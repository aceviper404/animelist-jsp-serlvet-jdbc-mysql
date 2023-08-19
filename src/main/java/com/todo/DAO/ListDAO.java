package com.todo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Anime;
import com.todo.utils.JDBCUtil;

public class ListDAO {

	public List<Anime> getList() {
		List<Anime> animelist = new ArrayList<Anime>();
		
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement("select * from todo_anime_list;")){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String animeName = rs.getString("anime_name");
				boolean watched = rs.getBoolean("watched");
				boolean watchLater = rs.getBoolean("watchLater");
				boolean completed = rs.getBoolean("completed");
				animelist.add(new Anime(id, animeName, watched, watchLater, completed ));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return animelist;
	}

	public int add(String animeName, boolean watched, boolean watchlater, boolean completed) {
		int result=0;
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"insert ignore into todo_anime_list (anime_name,watched,watchLater,completed) values(?,?,?,?)")){
			ps.setString(1, animeName);
			ps.setBoolean(2, watched);
			ps.setBoolean(3, watchlater);
			ps.setBoolean(4, completed);
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int update(String name, boolean watched, boolean watchLater, boolean completed) {
		int result=0;
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"update todo_anime_list set anime_name=?, watched=?, watchLater=?, completed=?"
						+ " where anime_name=?;")){
			ps.setString(1, name);
			ps.setBoolean(2, watched);
			ps.setBoolean(3, watchLater);
			ps.setBoolean(4, completed);
			ps.setString(5, name);
			
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public void delete(int id) {
		int result=0;
		try(Connection conn = JDBCUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"delete from todo_anime_list where id=?")){
			ps.setInt(1, id);
			
			result = ps.executeUpdate();
			if(result==1) {
				System.out.println("Anime deleted...");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import dto.User;
import jdbc.ConnectionHandler;
import jdbc.IDatabase;

public class UserDao implements IDatabase {
	@Override
	public boolean insertRow(Object obj) throws Exception {
		User user = (User)obj;
		Connection con = null;
		@SuppressWarnings("unused")
		Statement st = null;
		PreparedStatement pst = null;
		try{
			con = ConnectionHandler.CONNECTION();
			String query="insert into tbuser values(?,?,?)";
			pst = con.prepareStatement(query);
			pst.setInt(1,user.getId());
			pst.setString(2,user.getUsername());
			pst.setString(3, user.getPassword());
			pst.executeUpdate();
			
		}catch(Exception ex){
			return false;
		}finally{
			if(con!=null){
				pst.close();
				con.close();
			}
		}
		return true;
	}

	@Override
	public ArrayList<Object> selectRecord() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		@SuppressWarnings("unused")
		ResultSetMetaData rsd = null;
		ArrayList<Object> users = new ArrayList<>();
		try{
			
			con = ConnectionHandler.CONNECTION();
			st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.FETCH_FORWARD);
			String query ="select *from tbuser order by id ASC";
			rs = st.executeQuery(query);
			rsd = rs.getMetaData();
			while(rs.next()){
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return users;
	}

	@Override
	public boolean updateRecord(Object obj) throws Exception {
		User user = (User)obj;
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			con = ConnectionHandler.CONNECTION();
			String query ="update tbuser set username=?, password=? where id='"+user.getId()+"'";
			pst = con.prepareStatement(query);
			pst.setString(1,user.getUsername());
			pst.setString(2,user.getPassword());
			int rowEfect =pst.executeUpdate();
			if(rowEfect>0)
				return true;
		}finally{
			pst.close();
			con.close();
		}
		return false;
	}

	@Override
	public boolean deleteRecord(String id) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = ConnectionHandler.CONNECTION();
			String query = "delete from tbuser where id='"+id+"'";
			pst = con.prepareStatement(query);
			if(pst.executeUpdate()>0){
				return true;
			}
		}finally{
			pst.close();
			con.close();
		}
		return false;
	}

	@Override
	public ArrayList<Object> searchRecord(String search) throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		@SuppressWarnings("unused")
		ResultSetMetaData rsd = null;
		ArrayList<Object> users = new ArrayList<>();
		try{
			
			con = ConnectionHandler.CONNECTION();
			st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.FETCH_FORWARD);
			String query ="select *from tbuser where usernamelike '%"+search+"%'";
			rs = st.executeQuery(query);
			rsd = rs.getMetaData();
			while(rs.next()){
				
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return users;
	}
	
}

package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import dto.User;
import jdbc.IConnection;
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
			con = IConnection.CONNECTION();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRecord(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecord(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Object> searchRecord(String search) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

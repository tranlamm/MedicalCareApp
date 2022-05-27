package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import database.JDBCUtil;
import model.Mom;

public class MomDAO implements DAOInterface<Mom> {

	public static MomDAO getInstance()
	{
		return new MomDAO();
	}
	
	@Override
	public int insert(Mom t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			Statement st = c.createStatement();
			
			String sql = "INSERT INTO mom (id, firstName, lastName, address, "
					+ "phoneNum, email) "
					+ "VALUES ('"+t.getID()+"' , '"+t.getFirstName()+"' , '"+t.getLastName()+"' , "
							+ "'"+t.getAddress()+"' , '"+t.getPhoneNum()+"' , "
							+ "'"+t.getEmail()+"')";
			
			st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int update(Mom t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Mom t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			Statement st = c.createStatement();
			
			String sql = "DELETE from mom WHERE id = '"+t.getID()+"'";
			
			st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public Mom selectById(Mom t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mom> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mom> select(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.core.Kid;

public class KidDAO implements DAOInterface<Kid> {
	
	public static KidDAO getInstance()
	{
		return new KidDAO();
	}
	
	@Override
	public int insert(Kid t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO kid (id, firstName, lastName, dateOfBirth,"
					+ "gender, address, phoneNum, email, parentName) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getFirstName());
			pst.setString(3, t.getLastName());
			pst.setString(4, t.getDateOfBirth());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getPhoneNum());
			pst.setString(8, t.getEmail());
			pst.setString(9, t.getParentName());
			pst.executeUpdate();
			
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int update(Kid t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE kid "
					+ "SET id = ?, firstName = ?, lastName = ?, dateOfBirth = ?, "
					+ "gender = ?, address = ?, phoneNum = ?, email = ?, parentName = ?"
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getFirstName());
			pst.setString(3, t.getLastName());
			pst.setString(4, t.getDateOfBirth());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getPhoneNum());
			pst.setString(8, t.getEmail());
			pst.setString(9, t.getParentName());
			pst.setString(10, t.getID());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int updateDetail(Kid t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE kid "
					+ "SET appointment = ?, vacation = ?"
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getAppointment());
			pst.setString(2, t.getVacation());
			pst.setString(3, t.getID());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int delete(Kid t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "DELETE from kid WHERE id = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public Kid select(Kid t) {
		Kid k = null;
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM kid "
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				k = new Kid(rs.getString("id"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("dateOfBirth"), rs.getString("gender"),
						rs.getString("address"), rs.getString("email"), rs.getString("phoneNum"), rs.getString("parentName"),
						rs.getString("weightHistory"), rs.getString("appointment"), rs.getString("vacation"));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return k;
	}

	@Override
	public ArrayList<Kid> select() {
		ArrayList<Kid> k = new ArrayList<Kid>();
		try {
			Connection c = JDBCUtil.getConnection();
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM kid";
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				k.add(new Kid(rs.getString("id"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("dateOfBirth"), rs.getString("gender"),
						rs.getString("address"), rs.getString("email"), rs.getString("phoneNum"), rs.getString("parentName"),
						rs.getString("weightHistory"), rs.getString("appointment"), rs.getString("vacation")));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return k;
	}
	
	public void updateAppointment(Kid t)
	{
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE kid "
					+ "SET appointment = ?"
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getAppointment());
			pst.setString(2, t.getID());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return;
	}
	
	public void updateWeight(String id, String x)
	{
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE kid "
					+ "SET weightHistory = CONCAT(weightHistory, ?) "
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, x);
			pst.setString(2, id);
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return;
	}
}

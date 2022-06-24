package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.core.Mom;

public class MomDAO implements DAOInterface<Mom> {
	
	public static MomDAO getInstance()
	{
		return new MomDAO();
	}
	
	@Override
	public int insert(Mom t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO mom (id, firstName, lastName, dateOfBirth, "
					+ "address, phoneNum, email, weightHistory) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getFirstName());
			pst.setString(3, t.getLastName());
			pst.setString(4, t.getDateOfBirth());
			pst.setString(5, t.getAddress());
			pst.setString(6, t.getPhoneNum());
			pst.setString(7, t.getEmail());
			pst.setString(8, " ");
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int update(Mom t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE mom "
					+ "SET id = ?, firstName = ?, lastName = ?, dateOfBirth = ?, "
					+ "address = ?, phoneNum = ?, email = ?"
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getFirstName());
			pst.setString(3, t.getLastName());
			pst.setString(4, t.getDateOfBirth());
			pst.setString(5, t.getAddress());
			pst.setString(6, t.getPhoneNum());
			pst.setString(7, t.getEmail());
			pst.setString(8, t.getID());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}
	
	public int updateDetail(Mom t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE mom "
					+ "SET appointment = ?, healthStatus = ?, EDD = ? "
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getAppointment());
			pst.setString(2, t.getHealthStatus());
			pst.setString(3, t.getEDD());
			pst.setString(4, t.getID());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int delete(Mom t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "DELETE from mom WHERE id = ?";
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
	public Mom select(Mom t) {
		Mom m = null;
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM mom "
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				m = new Mom(rs.getString("id"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("dateOfBirth"), rs.getString("address"), 
						rs.getString("email"), rs.getString("phoneNum"), rs.getString("weightHistory"),
						rs.getString("appointment"), rs.getString("healthStatus"), rs.getString("EDD"));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return m;
	}

	@Override
	public ArrayList<Mom> select() {
		ArrayList<Mom> m = new ArrayList<Mom>();
		try {
			Connection c = JDBCUtil.getConnection();
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM mom";
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				m.add(new Mom(rs.getString("id"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("dateOfBirth"), rs.getString("address"), 
						rs.getString("email"), rs.getString("phoneNum"), rs.getString("weightHistory"),
						rs.getString("appointment"), rs.getString("healthStatus"), rs.getString("EDD")));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return m;
	}
	
	public void updateAppointment(Mom t)
	{
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE mom "
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
			
			String sql = "UPDATE mom "
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

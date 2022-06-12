package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.JDBCUtil;
import model.core.Clinic;

public class ClinicDAO implements DAOInterface<Clinic>{
	public static ClinicDAO getInstance()
	{
		return new ClinicDAO();
	}
	@Override
	public int insert(Clinic t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO clinic (id, clinicName, "
					+ "address, phoneNum, email,type) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getClinicName());
			pst.setString(3, t.getAddress());
			pst.setString(4, t.getPhoneNum());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getType());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int update(Clinic t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "UPDATE clinic "
					+ "SET id = ?, clinicName = ?, "
					+ "address = ?, phoneNum = ?, email = ?, type = ?"
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			pst.setString(2, t.getClinicName());
			pst.setString(3, t.getAddress());
			pst.setString(4, t.getPhoneNum());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getType());
			pst.setString(7, t.getID());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int delete(Clinic t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "DELETE from clinic WHERE id = ?";
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
	public Clinic select(Clinic t) {
		Clinic m = null;
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM clinic "
					+ "WHERE id = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getID());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				m = new Clinic(rs.getString("id"), rs.getString("clinicName"), rs.getString("address"), rs.getString("email"), rs.getString("phoneNum"),rs.getString("type"));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return m;
	}

	@Override
	public ArrayList<Clinic> select() {
		ArrayList<Clinic> m = new ArrayList<Clinic>();
		try {
			Connection c = JDBCUtil.getConnection();
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM clinic";
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				m.add(new Clinic(rs.getString("id"), rs.getString("clinicName"), rs.getString("address"), rs.getString("email"), rs.getString("phoneNum"),rs.getString("type")));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return m;
	}

	public static void main(String[] args) {
		Clinic m =new Clinic("12","2","3","4","5","6");
		ClinicDAO.getInstance().insert(m);
	}
}

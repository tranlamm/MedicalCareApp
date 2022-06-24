package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.JDBCUtil;
import model.core.HistoryMedical;

public class HistoryMedicalDAO {
	
	public static HistoryMedicalDAO getInstance()
	{
		return new HistoryMedicalDAO();
	}
	
	public int insert(HistoryMedical t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO historymedical (idKid, date, type, idVaccine,"
					+ "interaction) "
					+ "VALUES (?, ?, ?, ?, ?)";
		
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getIdKid());
			pst.setString(2, t.getDateOfInjection());
			pst.setString(3, t.getTypeOfVaccine());
			pst.setString(4, t.getIDVaccine());
			pst.setString(5, t.getInteraction());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	public ArrayList<HistoryMedical> select(String id) {
		ArrayList<HistoryMedical> h = new ArrayList<HistoryMedical>();
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM historymedical "
					+ "WHERE idKid = ?";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				h.add(new HistoryMedical(rs.getString("date"), rs.getString("type"), rs.getString("idVaccine"), rs.getString("interaction"), rs.getString("idKid")));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return h;
	}
}

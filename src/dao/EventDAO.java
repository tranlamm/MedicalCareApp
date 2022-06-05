package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.core.Event;

public class EventDAO implements DAOInterface<Event>{

	public static EventDAO getInstance()
	{
		return new EventDAO();
	}
	
	@Override
	public int insert(Event t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO event (name, date, description) "
					+ "VALUES (?, ?, ?)";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setString(2, t.getDate());
			pst.setString(3, t.getDescription());
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return 0;
	}

	@Override
	public int update(Event t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Event t) {
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "DELETE from event WHERE name = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getName());
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}

	@Override
	public Event select(Event t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Event> select() {
		ArrayList<Event> tmp = new ArrayList<Event>();
		try {
			Connection c = JDBCUtil.getConnection();
			
			Statement st = c.createStatement();
			String sql = "SELECT * FROM event";
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
			{
				tmp.add(new Event(rs.getString("name"), rs.getString("date"), rs.getString("description")));
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return tmp;
	}
}

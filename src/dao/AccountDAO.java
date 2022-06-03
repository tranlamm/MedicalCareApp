package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.core.Account;

public class AccountDAO implements DAOInterface<Account> {

	public static AccountDAO getInstance()
	{
		return new AccountDAO();
	}
	
	@Override
	public int insert(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account select(Account t) {
		Account acc = null;
		try {
			Connection c = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM account WHERE "
					+ "(taiKhoan = ?)"
					+ " AND (matKhau = ?)";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTaiKhoan());
			pst.setString(2, t.getMatKhau());
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next())
			{
				String tk = rs.getString("taiKhoan");
				String mk = rs.getString("matKhau");
				String type = rs.getString("type");
				acc = new Account(tk, mk, type);
			}
			
			JDBCUtil.closeConnection(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return acc;
	}

	@Override
	public ArrayList<Account> select() {
		return null;
	}
}

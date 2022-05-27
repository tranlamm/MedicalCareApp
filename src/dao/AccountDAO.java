package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Account;

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
	public Account selectById(Account t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> select(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}

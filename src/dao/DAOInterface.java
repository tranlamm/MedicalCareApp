package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public T selectById(T t);
	
	public ArrayList<T> select();
	
	public ArrayList<T> select(String condition);
}

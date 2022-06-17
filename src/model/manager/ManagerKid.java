package model.manager;

import java.util.ArrayList;

import dao.KidDAO;
import model.core.Kid;

public class ManagerKid {
	public ArrayList<Kid> listKid;
	
	public ManagerKid()
	{
		this.listKid = KidDAO.getInstance().select();
	}

	public ArrayList<Kid> getListKid() {
		return listKid;
	}

	public void setListKid(ArrayList<Kid> listKid) {
		this.listKid = listKid;
	}
	
	public void insert(Kid k)
	{
		this.listKid.add(k);
		KidDAO.getInstance().insert(k);
	}
	
	public void delete(Kid k)
	{
		this.listKid.remove(k);
		KidDAO.getInstance().delete(k);
	}
	
	public void update(Kid k)
	{
		KidDAO.getInstance().update(k);
		this.listKid.remove(k);
		this.listKid.add(k);
	}
	
	public static Kid search(String id)
	{
		return KidDAO.getInstance().select(new Kid(id));
	}
	
	public static boolean isExist(Kid k)
	{	
		Kid x = KidDAO.getInstance().select(k);
		if (x == null)
			return false;
		else 
			return true;
	}
	
	public ArrayList<Kid> searchByName(String name)
	{
		ArrayList<Kid> k = new ArrayList<Kid>();
		
		String tmp = name.toLowerCase();
		for (Kid x:listKid)
		{
			String fullName = (x.getFirstName() + " " + x.getLastName()).toLowerCase();
			if (tmp.equals(fullName))
			{
				k.add(x);
			}
		}
		
		return k;
	}
}

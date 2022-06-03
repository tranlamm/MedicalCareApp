package model.manager;

import java.util.ArrayList;

import dao.MomDAO;
import model.core.Mom;

public class ManagerMom {
	public ArrayList<Mom> listMom;
	
	public ManagerMom()
	{
		this.listMom = MomDAO.getInstance().select();
	}

	public ArrayList<Mom> getListMom() {
		return listMom;
	}

	public void setListMom(ArrayList<Mom> listMom) {
		this.listMom = listMom;
	}
	
	public void insert(Mom m)
	{
		this.listMom.add(m);
		MomDAO.getInstance().insert(m);
	}
	
	public void delete(Mom m)
	{
		this.listMom.remove(m);
		MomDAO.getInstance().delete(m);
	}
	
	public void update(Mom m)
	{
		MomDAO.getInstance().update(m);
		this.listMom.remove(m);
		this.listMom.add(m);
	}
	
	public static Mom search(String id)
	{
		return MomDAO.getInstance().select(new Mom(id));
	}
	
	public static boolean isExist(Mom m)
	{	
		Mom x = MomDAO.getInstance().select(m);
		if (x == null)
			return false;
		else 
			return true;
	}
}

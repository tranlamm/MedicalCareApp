package model;

import java.util.ArrayList;

import dao.MomDAO;

public class ManagerMom {
	public ArrayList<Mom> listMom;
	
	public ManagerMom()
	{
		this.listMom = new ArrayList<Mom>();
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
	
	public void load()
	{
		this.listMom = MomDAO.getInstance().select();
	}
	
	public static Mom search(String id)
	{
		return MomDAO.getInstance().select(new Mom(id));
	}
}

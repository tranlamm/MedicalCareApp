package model.manager;

import java.util.ArrayList;

import dao.ClinicDAO;
import model.core.Clinic;
import model.core.Event;


public class ManagerClinic {
public ArrayList<Clinic> listClinic;
	
	public ManagerClinic()
	{
		this.listClinic = ClinicDAO.getInstance().select();
	}

	public ArrayList<Clinic> getListClinic() {
		return listClinic;
	}

	public void setListClinic(ArrayList<Clinic> listClinic) {
		this.listClinic = listClinic;
	}
	
	public void insert(Clinic m)
	{
		this.listClinic.add(m);
		ClinicDAO.getInstance().insert(m);
	}
	
	public void delete(Clinic m)
	{
		this.listClinic.remove(m);
		ClinicDAO.getInstance().delete(m);
	}
	
	public void update(Clinic m)
	{
		ClinicDAO.getInstance().update(m);
		this.listClinic.remove(m);
		this.listClinic.add(m);
	}
	
	public ArrayList<Clinic> searchByAddress(String name)
	{
		if (name.equals(""))
			return null;
		String lowerName = name.toLowerCase();
		
		ArrayList<Clinic> list = new ArrayList<Clinic>();
		for (Clinic x : listClinic)
		{
			String lowerX = x.getAddress().toLowerCase();
			if (lowerX.contains(lowerName))
			{
				list.add(x);
			}
		}
		return list;	
	}
	
	public static Clinic search(String id)
	{
		return ClinicDAO.getInstance().select(new Clinic(id));
	}
	
	public static boolean isExist(Clinic m)
	{	
		Clinic x = ClinicDAO.getInstance().select(m);
		if (x == null)
			return false;
		else 
			return true;
	}
}

package model.manager;

import java.util.ArrayList;

import dao.EventDAO;
import model.core.Event;


public class ManagerEvent {
	public ArrayList<Event> listEvent;
	
	public ManagerEvent()
	{
		this.listEvent = EventDAO.getInstance().select();
	}

	public ArrayList<Event> getListEvent() {
		return listEvent;
	}

	public void setListEvent(ArrayList<Event> listEvent) {
		this.listEvent = listEvent;
	}
	
	public void insert(Event e)
	{
		this.listEvent.add(e);
		EventDAO.getInstance().insert(e);
		
	}
	
	public void delete(Event e)
	{
		this.listEvent.remove(e);
		EventDAO.getInstance().delete(e);
	}
	
	public ArrayList<Event> search(String name)
	{
		if (name.equals(""))
			return null;
		String lowerName = name.toLowerCase();
		
		ArrayList<Event> list = new ArrayList<Event>();
		for (Event x : listEvent)
		{
			String lowerX = x.getName().toLowerCase();
			if (lowerX.contains(lowerName))
			{
				list.add(x);
			}
		}
		return list;	
	}
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.core.Event;
import view.UserEvent;

public class UserEventController implements ActionListener{
	private UserEvent userEvent;
	
	public UserEventController(UserEvent userEvent) {
		this.userEvent = userEvent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		try {
			if (src.equals("Reset"))
			{
				reset();
			}
			else if (src.equals("Search"))
			{
				search();
			}
			else if (src.equals("Book"))
			{
				book();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void reset() {
		DefaultTableModel model_table = (DefaultTableModel) userEvent.tableEvent.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		for (Event x : userEvent.list)
		{
			model_table.addRow(new Object[] {
					x.getName(),
					x.getDate(),
					x.getDescription()
			});
		}
	}
	
	public void search() {
		String name = this.userEvent.searchTextEvent.getText();
		if (name.equals(""))
			return;
		
		DefaultTableModel model_table = (DefaultTableModel) userEvent.tableEvent.getModel();
		int soDong = model_table.getRowCount();
		for (int i=soDong-1; i>-1; i--)
		{
			model_table.removeRow(i);
		}
	
		String lowerName = name.toLowerCase();
		ArrayList<Event> list = new ArrayList<Event>();
		for (Event x : userEvent.list)
		{
			String lowerX = x.getName().toLowerCase();
			if (lowerX.contains(lowerName))
			{
				list.add(x);
			}
		}	
		
		for (Event x : list)
		{
			model_table.addRow(new Object[] {
					x.getName(),
					x.getDate(),
					x.getDescription()
			});
		}
	}
	
	public void book()
	{
		DefaultTableModel model_table = (DefaultTableModel) this.userEvent.tableEvent.getModel();
		int i_row = this.userEvent.tableEvent.getSelectedRow();
		if (i_row < 0)
			return;
		
		String appointment = model_table.getValueAt(i_row, 1) + "";
		DefaultTableModel model_table2 = (DefaultTableModel) this.userEvent.userView.table.getModel();
		model_table2.setValueAt(appointment, 0, 6);
	}
}

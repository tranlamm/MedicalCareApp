package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.core.Event;
import view.MainView;

public class EventController implements ActionListener, ControllerInterface{
	private MainView mainView;
	
	public EventController(MainView mainView) {
		this.mainView = mainView;
	}
	
	public Event getData()
	{
		String name = mainView.nameEvent.getText();
		if (name.equals("")) return null;
		String date = mainView.dateEvent.getText();
		String des = mainView.desEvent.getText();
		
		return new Event(name, date, des);
	}
	
	@Override
	public void insert() {
		Event tmp = getData();
		if (tmp == null) return;
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableEvent.getModel();
		
		this.mainView.managerEvent.insert(tmp);
		model_table.addRow(new Object[] {
				tmp.getName(),
				tmp.getDate(),
				tmp.getDescription()
		});
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableEvent.getModel();
		int i_row = this.mainView.tableEvent.getSelectedRow();
		if (i_row < 0)
			return;
		this.mainView.managerEvent.delete(new Event(model_table.getValueAt(i_row, 0) + ""));
		model_table.removeRow(i_row);
	}

	@Override
	public void reset() {
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableEvent.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		ArrayList<Event> tmp = mainView.managerEvent.getListEvent();
		for (Event x : tmp)
		{
			model_table.addRow(new Object[] {
					x.getName(),
					x.getDate(),
					x.getDescription()
			});
		}
	}

	@Override
	public void search() {
		String name = this.mainView.searchTextEvent.getText();
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableEvent.getModel();
		int soDong = model_table.getRowCount();
		for (int i=soDong-1; i>-1; i--)
		{
			model_table.removeRow(i);
		}
		
		ArrayList<Event> list = this.mainView.managerEvent.search(name);
		
		for (Event x : list)
		{
			model_table.addRow(new Object[] {
					x.getName(),
					x.getDate(),
					x.getDescription()
			});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		
		try {
			if (src.equals("Insert"))
			{
				insert();
			}
			else if (src.equals("Delete"))
			{
				int luaChon = JOptionPane.showConfirmDialog(this.mainView, "DO YOU SURE TO DELETE", "Warning", JOptionPane.YES_NO_OPTION);
				if (luaChon == JOptionPane.YES_OPTION)
				{
					delete();
				}
			}
			else if (src.equals("Reset"))
			{
				reset();
			}
			else if (src.equals("Search"))
			{
				search();
			}
			else if (src.equals("Send"))
			{
				JOptionPane.showMessageDialog(this.mainView, "Send mail error");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

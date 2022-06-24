package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import dao.HistoryMedicalDAO;
import model.core.HistoryMedical;
import view.KidHistoryMedical;

public class KidHistoryController implements ActionListener{
	private KidHistoryMedical kidHistoryMedical;
	
	public KidHistoryController(KidHistoryMedical kidHistoryMedical) {
		this.kidHistoryMedical = kidHistoryMedical;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		try {
			if (src.equals("Insert"))
			{
				insert();
			}
			else if (src.equals("Search"))
			{
				search();
			}
			else if (src.equals("Reset"))
			{
				DefaultTableModel model_table = (DefaultTableModel) kidHistoryMedical.table.getModel();
				int soDong = model_table.getRowCount();
				for (int i=soDong-1; i>-1; i--)
				{
					model_table.removeRow(i);
				}
				
				for (HistoryMedical x : this.kidHistoryMedical.list)
				{
					model_table.addRow(new Object[] {
							x.getIDVaccine(),
							x.getDateOfInjection(),
							x.getTypeOfVaccine(),
							x.getInteraction()
					});
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public HistoryMedical getData()
	{
		String id = this.kidHistoryMedical.idText.getText();
		String date = this.kidHistoryMedical.dateText.getText();
		String type = this.kidHistoryMedical.typeText.getText();
		String interaction = this.kidHistoryMedical.interactionText.getText();
		
		if (id.equals("") || date.equals("") || type.equals("") || interaction.equals(""))
			return null;
		else 
			return new HistoryMedical(date, type, id, interaction, this.kidHistoryMedical.kid.getID());
	}
	
	public void insert() 
	{	
		HistoryMedical h = getData();
		if (h == null)	return;
		
		this.kidHistoryMedical.list.add(h);
		HistoryMedicalDAO.getInstance().insert(h);
		DefaultTableModel model_table = (DefaultTableModel) kidHistoryMedical.table.getModel();
		model_table.addRow(new Object[] {
				h.getIDVaccine(),
				h.getDateOfInjection(),
				h.getTypeOfVaccine(),
				h.getInteraction()
		});
	}
	
	public void search()
	{
		String text = this.kidHistoryMedical.searchText.getText();
		if (text.equals("")) return;
		
		String des = text.trim().toLowerCase();
		DefaultTableModel model_table = (DefaultTableModel) kidHistoryMedical.table.getModel();
		int soDong = model_table.getRowCount();
		for (int i=soDong-1; i>-1; i--)
		{
			model_table.removeRow(i);
		}
		
		for (HistoryMedical x : this.kidHistoryMedical.list)
		{
			String tmp = x.getTypeOfVaccine().toLowerCase();
			if (tmp.contains(des))
			{
				model_table.addRow(new Object[] {
						x.getIDVaccine(),
						x.getDateOfInjection(),
						x.getTypeOfVaccine(),
						x.getInteraction()
				});
			}
		}
	}
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dao.KidDAO;
import model.core.Kid;
import model.manager.ManagerKid;
import view.MainView;
import view.KidHistoryMedical;
import view.KidInput;
import view.KidWeightHeight;

public class KidController implements ActionListener, ControllerInterface{
	private MainView mainView;
	
	public KidController(MainView mainView) {
		this.mainView = mainView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		
		try {
			if (src.equals("Insert"))
				insert();
			else if (src.equals("Delete"))
			{
				int luaChon = JOptionPane.showConfirmDialog(this.mainView, "DO YOU SURE TO DELETE", "Warning", JOptionPane.YES_NO_OPTION);
				if (luaChon == JOptionPane.YES_OPTION)
				{
					delete();
				}
			}
			else if (src.equals("Update"))
				update();
			else if (src.equals("Reset"))
				reset();
			else if (src.equals("Search"))
			{
				String choice = "";
				Enumeration<AbstractButton> button = this.mainView.buttonGroupKid.getElements();
				while (button.hasMoreElements()) 
				{
					AbstractButton x = button.nextElement();
					if (x.isSelected())
					{
						choice = x.getText();
						break;
					}
				}
				if (choice.equals("ID"))
					search();
				else if (choice.equals("Name"))
					searchName();
			}
			else if (src.equals("Weight Height"))
			{
				weightHeight();
			}
			else if (src.equals("History Medical"))
			{
				historyMedical();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
		
	public void insert()
	{
		new KidInput(mainView);
		return;
	}

	public void update() {
		KidInput kidInput = new KidInput(mainView);
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableKid.getModel();
		int i_row = mainView.tableKid.getSelectedRow();
		if (i_row < 0)
			return;
		
		String idKid = model_table.getValueAt(i_row, 0) + "";
		String firstNameKid = model_table.getValueAt(i_row, 1) + "";
		String lastNameKid = model_table.getValueAt(i_row, 2) + "";
		String dobKid = model_table.getValueAt(i_row, 3) + "";
		String genderKid = model_table.getValueAt(i_row, 4) + "";
		String addressKid = model_table.getValueAt(i_row, 5) + "";
		String emailKid = model_table.getValueAt(i_row, 6) + "";
		String phoneNumKid = model_table.getValueAt(i_row, 7) + "";
		String parentNameKid = model_table.getValueAt(i_row, 8) + "";
		
		kidInput.idTextKid.setText(idKid);
		kidInput.firstTextKid.setText(firstNameKid);
		kidInput.lastTextKid.setText(lastNameKid);
		kidInput.dOBTextKid.setText(dobKid);
		kidInput.genderTextKid.setText(genderKid);
		kidInput.addressTextKid.setText(addressKid);
		kidInput.emailTextKid.setText(emailKid);
		kidInput.phoneNumTextKid.setText(phoneNumKid);
		kidInput.parentNameTextKid.setText(parentNameKid);
	}
	
	public void delete()
	{
		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableKid.getModel();
		int i_row = this.mainView.tableKid.getSelectedRow();
		if (i_row < 0)
			return;
		this.mainView.managerKid.delete(new Kid(model_table.getValueAt(i_row, 0) + ""));
		model_table.removeRow(i_row);
	}

	public void reset()
	{
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableKid.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		ArrayList<Kid> k = mainView.managerKid.getListKid();
		for (Kid tmp : k)
		{
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getFirstName(),
					tmp.getLastName(),
					tmp.getDateOfBirth(),
					tmp.getGender(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
					tmp.getParentName(),
			});
		}
	}
	
	public void search()
	{
		String id = this.mainView.KidSearchById.getText().trim();
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableKid.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		
		Kid tmp = KidDAO.getInstance().select(new Kid(id));
		if (tmp == null)
			return;
		model_table.addRow(new Object[] {
				tmp.getID(),
				tmp.getFirstName(),
				tmp.getLastName(),
				tmp.getDateOfBirth(),
				tmp.getGender(),
				tmp.getAddress(),
				tmp.getPhoneNum(),
				tmp.getEmail(),
				tmp.getParentName(),
		});
	}
	
	public void searchName()
	{
		String name = this.mainView.KidSearchByName.getText().trim();
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableKid.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		
		ArrayList<Kid> k = this.mainView.managerKid.searchByName(name);
		for (Kid tmp : k)
		{
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getFirstName(),
					tmp.getLastName(),
					tmp.getDateOfBirth(),
					tmp.getGender(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
					tmp.getParentName(),
			});
		}
	}
	
	public void historyMedical()
	{
		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableKid.getModel();
		int i_row = this.mainView.tableKid.getSelectedRow();
		if (i_row < 0)
			return;
		new KidHistoryMedical(ManagerKid.search(model_table.getValueAt(i_row, 0) + ""));
	}
	
	public void weightHeight()
	{
		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableKid.getModel();
		int i_row = this.mainView.tableKid.getSelectedRow();
		if (i_row < 0)
			return;
		new KidWeightHeight(ManagerKid.search(model_table.getValueAt(i_row, 0) + ""));
	}
}

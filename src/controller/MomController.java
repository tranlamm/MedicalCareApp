package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.MomDAO;
import model.core.Mom;
import view.MainView;
import view.MomDetail;
import view.MomInput;

public class MomController implements ActionListener, ControllerInterface{
	private MainView mainView;
	
	public MomController(MainView mainView) {
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
				Enumeration<AbstractButton> button = this.mainView.buttonGroupGender.getElements();
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
			else if (src.equals("Details"))
			{
				detail();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
		
	public void insert()
	{
		new MomInput(mainView);
		return;
	}

	public void update() {
		MomInput momInput = new MomInput(mainView);
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableMom.getModel();
		int i_row = mainView.tableMom.getSelectedRow();
		if (i_row < 0)
			return;
		
		String id = model_table.getValueAt(i_row, 0) + "";
		String firstName = model_table.getValueAt(i_row, 1) + "";
		String lastName = model_table.getValueAt(i_row, 2) + "";
		String dob = model_table.getValueAt(i_row, 3) + "";
		String address = model_table.getValueAt(i_row, 4) + "";
		String email = model_table.getValueAt(i_row, 6) + "";
		String phoneNum = model_table.getValueAt(i_row, 5) + "";
		
		momInput.idText.setText(id);
		momInput.firstNameText.setText(firstName);
		momInput.lastNameText.setText(lastName);
		momInput.dobText.setText(dob);
		momInput.addressText.setText(address);
		momInput.emailText.setText(email);
		momInput.phoneNumText.setText(phoneNum);
	}
	
	public void delete()
	{
		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableMom.getModel();
		int i_row = this.mainView.tableMom.getSelectedRow();
		if (i_row < 0)
			return;
		this.mainView.managerMom.delete(new Mom(model_table.getValueAt(i_row, 0) + ""));
		model_table.removeRow(i_row);
	}

	public void reset()
	{
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableMom.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		ArrayList<Mom> m = mainView.managerMom.getListMom();
		for (Mom tmp : m)
		{
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getFirstName(),
					tmp.getLastName(),
					tmp.getDateOfBirth(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
			});
		}
	}
	
	public void search()
	{
		String id = this.mainView.idSearchTextMom.getText().trim();
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableMom.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		
		Mom tmp = MomDAO.getInstance().select(new Mom(id));
		if (tmp == null)
			return;
		model_table.addRow(new Object[] {
				tmp.getID(),
				tmp.getFirstName(),
				tmp.getLastName(),
				tmp.getDateOfBirth(),
				tmp.getAddress(),
				tmp.getPhoneNum(),
				tmp.getEmail(),
		});
	}
	
	public void searchName()
	{
		String name = this.mainView.nameSearchMom.getText().trim();
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableMom.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		
		ArrayList<Mom> m = this.mainView.managerMom.searchByName(name);
		for (Mom tmp : m)
		{
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getFirstName(),
					tmp.getLastName(),
					tmp.getDateOfBirth(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
			});
		}
	}
	
	public void detail()
	{
		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableMom.getModel();
		int i_row = this.mainView.tableMom.getSelectedRow();
		if (i_row < 0)
			return;
		Mom tmp = this.mainView.managerMom.search(model_table.getValueAt(i_row, 0) + "");
		new MomDetail(tmp);
	}
}

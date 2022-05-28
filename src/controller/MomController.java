package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.MomDAO;
import model.ManagerMom;
import model.Mom;
import view.MainView;

public class MomController implements ActionListener{
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
				search();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public Mom getData()
	{
		String id = mainView.idTextMom.getText();
		if (id.equals(""))
		{
			this.mainView.labelWarnMom.setText("Please Enter ID");
			return null;
		}
		String firstName = mainView.firstTextMom.getText();
		String lastName = mainView.lastTextMom.getText();
		String dob = mainView.dOBTextMom.getText();
		String address = mainView.addressTextMom.getText();
		String email = mainView.emailTextMom.getText();
		String phoneNum = mainView.phoneNumTextMom.getText();
		String appoint = mainView.apptTextMom.getText();
		String health = mainView.healthTextMom.getText();
		String edd = mainView.eddTextMom.getText();
		float weight = Float.valueOf(mainView.weightTextMom.getText());
		this.mainView.labelWarnMom.setText("");
		
		return new Mom(id, firstName, lastName, dob, address, email, phoneNum, weight, appoint, health, edd);
	}
	
	
	public void insert()
	{
		Mom tmp = getData();
		if (tmp == null)
			return;
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableMom.getModel();
		
		if (ManagerMom.isExist(tmp))
		{
			this.mainView.managerMom.update(tmp);
			int numbersOfRow = model_table.getRowCount();
			for (int i = 0; i < numbersOfRow; i++)
			{
				if (tmp.getID().equals(model_table.getValueAt(i, 0)))
				{
					model_table.setValueAt(tmp.getFirstName(), i, 1);
					model_table.setValueAt(tmp.getLastName(), i, 2);
					model_table.setValueAt(tmp.getDateOfBirth(), i, 3);
					model_table.setValueAt(tmp.getAddress(), i, 4);
					model_table.setValueAt(tmp.getPhoneNum(), i, 5);
					model_table.setValueAt(tmp.getEmail(), i, 6);
					model_table.setValueAt(tmp.getWeight(), i, 7);
					model_table.setValueAt(tmp.getAppointment(), i, 8);
					model_table.setValueAt(tmp.getHealthStatus(), i, 9);
					model_table.setValueAt(tmp.getEDD(), i, 10);
					break;
				}
			}
		}
		else 
		{
			this.mainView.managerMom.insert(tmp);
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getFirstName(),
					tmp.getLastName(),
					tmp.getDateOfBirth(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
					tmp.getWeight(),
					tmp.getAppointment(),
					tmp.getHealthStatus(),
					tmp.getEDD()
			});
		}
	}
	
	public void update()
	{
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
		String appoint = model_table.getValueAt(i_row, 8) + "";
		String health = model_table.getValueAt(i_row, 9) + "";
		String edd = model_table.getValueAt(i_row, 10) + "";
		float weight = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
		
		mainView.idTextMom.setText(id);
		mainView.firstTextMom.setText(firstName);
		mainView.lastTextMom.setText(lastName);
		mainView.dOBTextMom.setText(dob);
		mainView.addressTextMom.setText(address);
		mainView.emailTextMom.setText(email);
		mainView.phoneNumTextMom.setText(phoneNum);
		mainView.apptTextMom.setText(appoint);
		mainView.healthTextMom.setText(health);
		mainView.eddTextMom.setText(edd);
		mainView.weightTextMom.setText(weight + "");
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
		for (int i=soDong-1; i>-1; i--)
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
					tmp.getWeight(),
					tmp.getAppointment(),
					tmp.getHealthStatus(),
					tmp.getEDD()
			});
		}
	}
	
	public void search()
	{
		String id = this.mainView.idSearchTextMom.getText();
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableMom.getModel();
		int soDong = model_table.getRowCount();
		for (int i=soDong-1; i>-1; i--)
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
				tmp.getWeight(),
				tmp.getAppointment(),
				tmp.getHealthStatus(),
				tmp.getEDD()
		});
	}
}

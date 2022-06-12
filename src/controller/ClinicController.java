package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.ClinicDAO;
import dao.MomDAO;
import model.core.Clinic;
import model.manager.ManagerClinic;
import view.MainView;
import view.MomInput;

public class ClinicController implements ActionListener, ControllerInterface{

	public MainView mainView;
	
	
	public ClinicController(MainView mainView) {
		super();
		this.mainView = mainView;
	}
	
	@Override
	public void insert() {
		Clinic tmp = getData();
		if (tmp == null)
			return;
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableClinic.getModel();
		
		if (ManagerClinic.isExist(tmp))
		{
			this.mainView.managerClinic.update(tmp);
			int numbersOfRow = model_table.getRowCount();
			for (int i = 0; i < numbersOfRow; i++)
			{
				if (tmp.getID().equals(model_table.getValueAt(i, 0)))
				{
					model_table.setValueAt(tmp.getClinicName(), i, 1);
					model_table.setValueAt(tmp.getAddress(), i, 2);
					model_table.setValueAt(tmp.getPhoneNum(), i, 3);
					model_table.setValueAt(tmp.getEmail(), i, 4);
					model_table.setValueAt(tmp.getType(), i, 5);
					break;
				}
			}
		}
		else 
		{
			this.mainView.managerClinic.insert(tmp);
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getClinicName(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
					tmp.getType()
			});
		}
	}
		
	
	public Clinic getData()
	{
		String id = mainView.idClinic.getText().trim();
//		if (id.equals(""))
//		{
//			momInput.warning.setText("Please Enter ID");
//			return null;
//		}
		String name = mainView.nameClinic.getText().trim();
		String address = mainView.address.getText().trim();
		String phoneNum = mainView.phoneNumberClinic.getText().trim();
		String email = mainView.emailClinic.getText().trim();
		String type = mainView.type.getText().trim();
//		this.momInput.warning.setText("");
		
		return new Clinic(id, name, address, email, phoneNum, type);
	}

	@Override
	public void update() {
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableClinic.getModel();
		int i_row = mainView.tableClinic.getSelectedRow();
		if (i_row < 0)
			return;
		
		String id = model_table.getValueAt(i_row, 0) + "";
		String clinicName = model_table.getValueAt(i_row, 1) + "";
		String address = model_table.getValueAt(i_row, 2) + "";
		String email = model_table.getValueAt(i_row, 3) + "";
		String phoneNum = model_table.getValueAt(i_row, 4) + "";
		String type = model_table.getValueAt(i_row, 5) + "";
		
		this.mainView.idClinic.setText(id);
		this.mainView.nameClinic.setText(clinicName);
		this.mainView.address.setText(address);
		this.mainView.emailClinic.setText(email);
		this.mainView.phoneNumberClinic.setText(phoneNum);
		this.mainView.type.setText(type);
	}

	@Override
	public void delete() {

		DefaultTableModel model_table = (DefaultTableModel) this.mainView.tableClinic.getModel();
		int i_row = this.mainView.tableClinic.getSelectedRow();
		if (i_row < 0)
			return;
		this.mainView.managerClinic.delete(new Clinic(model_table.getValueAt(i_row, 0) + ""));
		model_table.removeRow(i_row);
	}

	@Override
	public void reset() {
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableClinic.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		ArrayList<Clinic> m = mainView.managerClinic.getListClinic();
		for (Clinic tmp : m)
		{
			model_table.addRow(new Object[] {
					tmp.getID(),
					tmp.getClinicName(),
					tmp.getAddress(),
					tmp.getPhoneNum(),
					tmp.getEmail(),
					tmp.getType(),
			});
		}
	}

	@Override
	public void search() {	
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableClinic.getModel();
		int soDong = model_table.getRowCount();
		for (int i = soDong - 1; i > -1; i--)
		{
			model_table.removeRow(i);
		}
		
		String id = this.mainView.searchClinic.getText();
		if (id.equals("")) return;
		Clinic tmp = ClinicDAO.getInstance().select(new Clinic(id));
		if (tmp == null)
			return;
		model_table.addRow(new Object[] {
				tmp.getID(),
				tmp.getClinicName(),
				tmp.getAddress(),
				tmp.getPhoneNum(),
				tmp.getEmail(),
				tmp.getType(),
		});
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
			else if (src.equals("Update"))
			{
			update();
			}
			else if (src.equals("Reset"))
			{
				reset();
			}
			else if (src.equals("Delete"))
			{
				int luaChon = JOptionPane.showConfirmDialog(this.mainView, "DO YOU SURE TO DELETE", "Warning", JOptionPane.YES_NO_OPTION);
				if (luaChon == JOptionPane.YES_OPTION)
				{
					delete();
				}
			}
			else if (src.equals("Search"))
			{
				search();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

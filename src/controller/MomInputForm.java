package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.core.Mom;
import model.manager.ManagerMom;
import view.MainView;
import view.MomInput;

public class MomInputForm implements ActionListener {
	private MomInput momInput;
	private MainView mainView;
	
	public MomInputForm(MomInput momInput, MainView mainView) {
		this.momInput = momInput;
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Confirm"))
		{
			insert();
		}
	}

	public Mom getData()
	{
		String id = momInput.idText.getText().trim();
		if (id.equals(""))
		{
			momInput.warning.setText("Please Enter ID");
			return null;
		}
		String firstName = momInput.firstNameText.getText().trim();
		String lastName = momInput.lastNameText.getText().trim();
		if (firstName.equals("") || lastName.equals(""))
		{
			momInput.warning.setText("Please Enter Name");
			return null;
		}
		String dob = momInput.dobText.getText().trim();
		if (dob.equals(""))
		{
			momInput.warning.setText("Please Enter DOB");
			return null;
		}
		String address = momInput.addressText.getText().trim();
		String email = momInput.emailText.getText().trim();
		String phoneNum = momInput.phoneNumText.getText().trim();
		this.momInput.warning.setText("");
		
		return new Mom(id, firstName, lastName, dob, address, email, phoneNum);
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
					tmp.getEmail()
			});
		}
	}
}

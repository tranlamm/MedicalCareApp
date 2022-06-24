package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.core.Kid;
import model.manager.ManagerKid;
import view.MainView;
import view.KidInput;

public class KidInputForm implements ActionListener {
	private KidInput kidInput;
	private MainView mainView;
	
	public KidInputForm(KidInput kidInput, MainView mainView) {
		this.kidInput = kidInput;
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

	public Kid getData()
	{
		String idKid = kidInput.idTextKid.getText().trim();
		if (idKid.equals(""))
		{
			kidInput.WarnKid.setText("Please Enter ID");
			return null;
		}
		String firstNameKid = kidInput.firstTextKid.getText().trim();
		String lastNameKid = kidInput.lastTextKid.getText().trim();
		if (firstNameKid.equals("") || lastNameKid.equals(""))
		{
			kidInput.WarnKid.setText("Please Enter Name");
			return null;
		}
		String dobKid = kidInput.dOBTextKid.getText().trim();
		if (dobKid.equals(""))
		{
			kidInput.WarnKid.setText("Please Enter DOB");
			return null;
		}
		String genderKid = kidInput.genderTextKid.getText().trim();
		String addressKid = kidInput.addressTextKid.getText().trim();
		String emailKid = kidInput.emailTextKid.getText().trim();
		String phoneNumKid = kidInput.phoneNumTextKid.getText().trim();
		String parentNameKid = kidInput.parentNameTextKid.getText().trim();
		this.kidInput.WarnKid.setText("");
		
		return new Kid(idKid, firstNameKid, lastNameKid, dobKid, genderKid, addressKid, emailKid, phoneNumKid, parentNameKid);
	}
	
	public void insert()
	{
		Kid tmp = getData();
		if (tmp == null)
			return;
		
		DefaultTableModel model_table = (DefaultTableModel) mainView.tableKid.getModel();
		
		if (ManagerKid.isExist(tmp))
		{
			this.mainView.managerKid.update(tmp);
			int numbersOfRow = model_table.getRowCount();
			for (int i = 0; i < numbersOfRow; i++)
			{
				if (tmp.getID().equals(model_table.getValueAt(i, 0)))
				{
					model_table.setValueAt(tmp.getFirstName(), i, 1);
					model_table.setValueAt(tmp.getLastName(), i, 2);
					model_table.setValueAt(tmp.getDateOfBirth(), i, 3);
					model_table.setValueAt(tmp.getGender(), i, 4);
					model_table.setValueAt(tmp.getAddress(), i, 5);
					model_table.setValueAt(tmp.getPhoneNum(), i, 6);
					model_table.setValueAt(tmp.getEmail(), i, 7);
					model_table.setValueAt(tmp.getParentName(), i, 8);
					break;
				}
			}
		}
		else 
		{
			this.mainView.managerKid.insert(tmp);
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
}

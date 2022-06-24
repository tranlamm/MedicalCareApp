package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dao.MomDAO;
import view.UserEvent;
import view.UserView;

public class UserController implements ActionListener{
	private UserView userView;
	
	public UserController(UserView userView) {
		this.userView = userView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		try {
			if (src.equals("Update"))
			{
				update();
			}
			else if (src.equals("Confirm"))
			{
				updateAppointment();
			}
			else if (src.equals("Event"))
			{
				new UserEvent(this.userView);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void update()
	{
		String address = this.userView.addressText.getText();
		String phone = this.userView.phoneText.getText();
		String email = this.userView.mailText.getText();
		if (address.equals("") || phone.equals("") || email.equals(""))
			return;
		
		DefaultTableModel model_table = (DefaultTableModel) this.userView.table.getModel();
		model_table.setValueAt(address, 0, 3);
		model_table.setValueAt(phone, 0, 4);
		model_table.setValueAt(email, 0, 5);
		
		this.userView.mom.setAddress(address);
		this.userView.mom.setEmail(email);
		this.userView.mom.setPhoneNum(phone);
		
		MomDAO.getInstance().update(this.userView.mom);
	}
	
	public void updateAppointment()
	{
		String appoint = this.userView.appointText.getText();
		if (appoint.equals(""))
			return;
		DefaultTableModel model_table = (DefaultTableModel) this.userView.table.getModel();
		model_table.setValueAt(appoint, 0, 6);
		
		this.userView.mom.setAppointment(appoint);
		MomDAO.getInstance().updateAppointment(this.userView.mom);
	}
	
}

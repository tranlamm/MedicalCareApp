package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dao.KidDAO;
import view.KidDetail;

public class KidDetailController implements ActionListener {
	public KidDetail kidDetail;
	
	public KidDetailController(KidDetail kidDetail) {
		this.kidDetail = kidDetail;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Confirm"))
		{
			comfirm();
		}
		else if (src.equals("Insert"))
		{
			insert();
		}
	}

	public void comfirm()
	{
		String appoint = kidDetail.appoint.getText();
		String vacation = kidDetail.vacation.getText();

		if (appoint.equals("") || vacation.equals(""))	return;
		
		kidDetail.kid.setAppointment(appoint);
		kidDetail.kid.setVacation(vacation);
		
		KidDAO.getInstance().updateDetail(kidDetail.kid);
		
		DefaultTableModel model_table = (DefaultTableModel) kidDetail.table.getModel();
		model_table.setValueAt(appoint, 0, 0);
		model_table.setValueAt(vacation, 0, 1);
	}
	
	public void insert()
	{
		String weight = kidDetail.weightText.getText();
		String date = kidDetail.dateText.getText();
		if (weight.equals("") || date.equals("")) return;
		
		double w = Double.parseDouble(weight);
		kidDetail.dataset.addValue(w, "Weight", date);
		
		String x = date + ":" + weight + " ";
		KidDAO.getInstance().updateWeight(kidDetail.kid.getID(), x);
	}
}

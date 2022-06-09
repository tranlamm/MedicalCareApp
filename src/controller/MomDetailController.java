package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import dao.MomDAO;
import view.MomDetail;

public class MomDetailController implements ActionListener {
	public MomDetail momDetail;
	
	public MomDetailController(MomDetail momDetail) {
		this.momDetail = momDetail;
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
		String appoint = momDetail.appoint.getText();
		String status = momDetail.status.getText();
		String edd = momDetail.edd.getText();
		
		if (appoint.equals("") || status.equals("") || edd.equals(""))	return;
		
		momDetail.mom.setAppointment(appoint);
		momDetail.mom.setHealthStatus(status);
		momDetail.mom.setEDD(edd);
		
		MomDAO.getInstance().updateDetail(momDetail.mom);
		
		DefaultTableModel model_table = (DefaultTableModel) momDetail.table.getModel();
		model_table.setValueAt(appoint, 0, 0);
		model_table.setValueAt(status, 0, 1);
		model_table.setValueAt(edd, 0, 2);
	}
	
	public void insert()
	{
		String weight = momDetail.weightText.getText();
		String date = momDetail.dateText.getText();
		if (weight.equals("") || date.equals("")) return;
		
		double w = Double.parseDouble(weight);
		momDetail.dataset.addValue(w, "Weight", date);
		
		String x = date + ":" + weight + " ";
		MomDAO.getInstance().updateWeight(momDetail.mom.getID(), x);
	}
}

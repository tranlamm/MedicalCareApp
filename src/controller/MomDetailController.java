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
		try {
			if (src.equals("Confirm"))
			{
				comfirm();
			}
			else if (src.equals("Insert"))
			{
				insert();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		momDetail.series1.add(momDetail.count, w);
		momDetail.count++;
		
		if (momDetail.flag == false)
		{
			momDetail.series2.add(1, w);
			momDetail.series2.add(2, w+2);
			momDetail.series2.add(3, w+4);
			momDetail.series2.add(4, w+6);
			momDetail.series2.add(5, w+9);
			momDetail.series2.add(6, w+12);
			momDetail.series2.add(7, w+16);
			momDetail.series2.add(8, w+21);
			momDetail.series2.add(9, w+26);
			momDetail.flag = true;
		}
		
		String x = weight + " ";
		MomDAO.getInstance().updateWeight(momDetail.mom.getID(), x);
	}
}

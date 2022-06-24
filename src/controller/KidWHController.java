package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.KidDAO;
import dao.MomDAO;
import view.KidWeightHeight;

public class KidWHController implements ActionListener{
	private KidWeightHeight kidWeightHeight;
	
	public KidWHController(KidWeightHeight kidWeightHeight) {
		this.kidWeightHeight = kidWeightHeight;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		try {
			if (src.equals("Add Weight"))
			{
				addWeight();
			}
			else if (src.equals("Add Height"))
			{
				addHeight();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void addWeight()
	{
		String weight = kidWeightHeight.weightText.getText();
		String age = kidWeightHeight.ageWeight.getText();
		if (weight.equals("") || age.equals("")) return;
		
		double w = Double.parseDouble(weight);
		kidWeightHeight.series1.add(kidWeightHeight.count, w);
		kidWeightHeight.count += 0.5;
		
		String x = weight + " ";
		KidDAO.getInstance().updateWeight(kidWeightHeight.kid.getID(), x);
	}
	
	public void addHeight()
	{
		String height = kidWeightHeight.heightText.getText();
		String age = kidWeightHeight.ageHeight.getText();
		if (height.equals("") || age.equals("")) return;
		
		int h = Integer.parseInt(height);
		kidWeightHeight.series1H.add(kidWeightHeight.countH, h);
		kidWeightHeight.countH += 0.5;
		
		String x = height + " ";
		KidDAO.getInstance().updateHeight(kidWeightHeight.kid.getID(), x);
	}
}

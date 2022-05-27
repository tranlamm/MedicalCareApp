package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import view.MainView;

public class NavBarController implements ActionListener{
	private MainView mainView;

	public NavBarController(MainView mainView) {
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String src = e.getActionCommand();
		if (src.equals("Mom"))
		{
			reset();
			this.mainView.mom.setVisible(true);
		}
		else if (src.equals("Kid"))
		{
			reset();
			this.mainView.kid.setVisible(true);
		}
		else if (src.equals("Clinic"))
		{
			reset();
			this.mainView.clinic.setVisible(true);
		}
		else if (src.equals("Event"))
		{
			reset();
			this.mainView.event.setVisible(true);
		}
	}
	
	public void reset()
	{
		this.mainView.mom.setVisible(false);
		this.mainView.kid.setVisible(false);
		this.mainView.clinic.setVisible(false);
		this.mainView.event.setVisible(false);

	}
	
}

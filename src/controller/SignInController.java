package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;
import view.SignInView;

public class SignInController implements ActionListener {
	private SignInView signInView;
	
	public SignInController(SignInView signInView) {
		this.signInView = signInView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("LOGIN"))
		{
			String taiKhoan = this.signInView.getTaiKhoan();
			String matKhau = this.signInView.getMatKhau();
			
			if (taiKhoan.equals("") || matKhau.equals(""))
			{
				this.signInView.setText("Vui lòng nhập tài khoản");
			}
			else if (taiKhoan.equals("admin") && matKhau.equals("admin"))
			{
				this.signInView.dispose();
				new MainView();
			}
			else 
			{
				this.signInView.setText("Sai tài khoản hoặc mật khẩu");
			}
	
		}
	}
	
}

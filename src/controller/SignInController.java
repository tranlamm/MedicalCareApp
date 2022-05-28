package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.AccountDAO;
import model.Account;
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
			int flag = 0;
			
			if (taiKhoan.equals("") || matKhau.equals(""))
			{
				this.signInView.setText("Vui lòng nhập tài khoản");
			}
			else
			{
				Account x = AccountDAO.getInstance().select(new Account(taiKhoan, matKhau));
				if (x == null)
				{
					this.signInView.setText("Sai tài khoản hoặc mật khẩu");
				}
				else
				{
					this.signInView.dispose();
					new MainView();
				}
			}
		}
	}
}

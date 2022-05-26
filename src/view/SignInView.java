package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SignInController;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;

public class SignInView extends JFrame {

	private JPanel contentPane;
	private JTextField taiKhoan;
	private JTextField matKhau;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public SignInView() {
		this.setTitle("Sign In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		
		ActionListener signInListener = new SignInController(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		taiKhoan = new JTextField();
		taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taiKhoan.setBounds(238, 74, 170, 34);
		contentPane.add(taiKhoan);
		taiKhoan.setColumns(10);
		
		matKhau = new JTextField();
		matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matKhau.setColumns(10);
		matKhau.setBounds(238, 145, 170, 34);
		contentPane.add(matKhau);
		
		JLabel labelTaiKhoan = new JLabel("T\u00E0i Kho\u1EA3n\r\n");
		labelTaiKhoan.setForeground(Color.DARK_GRAY);
		labelTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelTaiKhoan.setBounds(238, 45, 123, 34);
		contentPane.add(labelTaiKhoan);
		
		JLabel labelMatKhau = new JLabel("M\u1EADt Kh\u1EA9u\r\n");
		labelMatKhau.setForeground(Color.DARK_GRAY);
		labelMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMatKhau.setBounds(238, 112, 123, 34);
		contentPane.add(labelMatKhau);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng Nh\u1EADp\r\n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(285, 11, 88, 34);
		contentPane.add(lblNewLabel);
		
		JButton buttonLogin = new JButton("LOGIN");
		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonLogin.setBounds(284, 190, 89, 23);
		contentPane.add(buttonLogin);
		buttonLogin.addActionListener(signInListener);
		
		lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(238, 222, 196, 29);
		contentPane.add(lblNewLabel_1);
	
		this.setVisible(true);
	}


	public String getTaiKhoan() {
		return taiKhoan.getText();
	}


	public String getMatKhau() {
		return matKhau.getText();
	}

	public void setText(String s)
	{
		this.lblNewLabel_1.setText(s);
	}
}

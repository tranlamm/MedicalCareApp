package view;

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
import javax.swing.ImageIcon;

public class SignInView extends JFrame {

	private JPanel contentPane;
	private JTextField taiKhoan;
	private JTextField matKhau;
	private JLabel warning;
	private JLabel background;


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
		taiKhoan.setBackground(Color.WHITE);
		taiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taiKhoan.setBounds(238, 65, 170, 34);
		contentPane.add(taiKhoan);
		taiKhoan.setColumns(10);
		
		matKhau = new JTextField();
		matKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matKhau.setColumns(10);
		matKhau.setBounds(238, 135, 170, 34);
		contentPane.add(matKhau);
		
		JLabel labelTaiKhoan = new JLabel("T\u00E0i Kho\u1EA3n\r\n");
		labelTaiKhoan.setForeground(Color.DARK_GRAY);
		labelTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTaiKhoan.setBounds(238, 35, 123, 34);
		contentPane.add(labelTaiKhoan);
		
		JLabel labelMatKhau = new JLabel("M\u1EADt Kh\u1EA9u\r\n");
		labelMatKhau.setForeground(Color.DARK_GRAY);
		labelMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelMatKhau.setBounds(238, 110, 123, 23);
		contentPane.add(labelMatKhau);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng Nh\u1EADp\r\n");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(280, 5, 137, 34);
		contentPane.add(lblNewLabel);
		
		JButton buttonLogin = new JButton("LOGIN");
		buttonLogin.setForeground(new Color(0, 0, 0));
		buttonLogin.setBackground(new Color(255, 255, 255));
		buttonLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonLogin.setBounds(284, 180, 97, 34);
		contentPane.add(buttonLogin);
		buttonLogin.addActionListener(signInListener);
		
		warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setFont(new Font("Tahoma", Font.BOLD, 13));
		warning.setBounds(234, 228, 200, 29);
		contentPane.add(warning);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\security.jpg"));
		background.setBounds(0, 0, 434, 262);
		contentPane.add(background);
	
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
		this.warning.setText(s);
	}
}

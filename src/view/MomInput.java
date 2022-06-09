package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MomInputForm;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class MomInput extends JFrame {
	public MainView mainView;
	public JPanel contentPane;
	public JTextField idText;
	public JTextField firstNameText;
	public JTextField lastNameText;
	public JTextField dobText;
	public JTextField addressText;
	public JTextField emailText;
	public JTextField phoneNumText;
	public JLabel warning;

	public MomInput(MainView mainView) {
		this.mainView = mainView;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setTitle("Input Information");
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ActionListener listener = new MomInputForm(this, mainView);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(70, 30, 36, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setBounds(70, 80, 127, 29);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(70, 130, 94, 29);
		contentPane.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDateOfBirth.setBounds(70, 180, 127, 29);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(70, 230, 114, 29);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(70, 280, 94, 29);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoneNumber.setBounds(70, 330, 127, 29);
		contentPane.add(lblPhoneNumber);
		
		idText = new JTextField();
		idText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idText.setBounds(202, 30, 340, 29);
		contentPane.add(idText);
		idText.setColumns(10);
		
		firstNameText = new JTextField();
		firstNameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameText.setColumns(10);
		firstNameText.setBounds(202, 80, 340, 29);
		contentPane.add(firstNameText);
		
		lastNameText = new JTextField();
		lastNameText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastNameText.setColumns(10);
		lastNameText.setBounds(202, 130, 340, 29);
		contentPane.add(lastNameText);
		
		dobText = new JTextField();
		dobText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dobText.setColumns(10);
		dobText.setBounds(202, 180, 340, 29);
		contentPane.add(dobText);
		
		addressText = new JTextField();
		addressText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressText.setColumns(10);
		addressText.setBounds(202, 230, 340, 29);
		contentPane.add(addressText);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailText.setColumns(10);
		emailText.setBounds(202, 280, 340, 29);
		contentPane.add(emailText);
		
		phoneNumText = new JTextField();
		phoneNumText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumText.setColumns(10);
		phoneNumText.setBounds(202, 330, 340, 29);
		contentPane.add(phoneNumText);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setForeground(new Color(0, 0, 128));
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirmBtn.setBounds(202, 389, 208, 62);
		confirmBtn.addActionListener(listener);
		contentPane.add(confirmBtn);
		
		warning = new JLabel("");
		warning.setForeground(new Color(255, 0, 0));
		warning.setFont(new Font("Tahoma", Font.BOLD, 14));
		warning.setBounds(70, 408, 127, 26);
		contentPane.add(warning);
		
		this.setVisible(true);
	}
}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controller.KidInputForm;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class KidInput extends JFrame {
	public MainView mainView;
	public JPanel contentPane;
	public JTextField idTextKid;
	public JTextField firstTextKid;
	public JTextField lastTextKid;
	public JTextField dOBTextKid;
	public JTextField genderTextKid;
	public JTextField parentNameTextKid;
	public JTextField addressTextKid;
	public JTextField emailTextKid;
	public JTextField phoneNumTextKid;
	public JLabel WarnKid;
	private JLabel lblNewLabel_1;
	
	public KidInput(MainView mainView) {
		this.mainView = mainView;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 588);
		setTitle("Input Information");
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ActionListener listener = new KidInputForm(this, mainView);
		
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
		lblAddress.setBounds(70, 274, 114, 29);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(70, 324, 94, 29);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPhoneNumber.setBounds(70, 374, 127, 29);
		contentPane.add(lblPhoneNumber);
		
		idTextKid = new JTextField();
		idTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idTextKid.setBounds(202, 30, 340, 29);
		contentPane.add(idTextKid);
		idTextKid.setColumns(10);
		
		firstTextKid = new JTextField();
		firstTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstTextKid.setColumns(10);
		firstTextKid.setBounds(202, 80, 340, 29);
		contentPane.add(firstTextKid);
		
		lastTextKid = new JTextField();
		lastTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastTextKid.setColumns(10);
		lastTextKid.setBounds(202, 130, 340, 29);
		contentPane.add(lastTextKid);
		
		dOBTextKid = new JTextField();
		dOBTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dOBTextKid.setColumns(10);
		dOBTextKid.setBounds(202, 180, 340, 29);
		contentPane.add(dOBTextKid);
		
		addressTextKid = new JTextField();
		addressTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addressTextKid.setColumns(10);
		addressTextKid.setBounds(202, 274, 340, 29);
		contentPane.add(addressTextKid);
		
		emailTextKid = new JTextField();
		emailTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTextKid.setColumns(10);
		emailTextKid.setBounds(202, 324, 340, 29);
		contentPane.add(emailTextKid);
		
		phoneNumTextKid = new JTextField();
		phoneNumTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumTextKid.setColumns(10);
		phoneNumTextKid.setBounds(202, 374, 340, 29);
		contentPane.add(phoneNumTextKid);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setBackground(new Color(127, 255, 212));
		confirmBtn.setForeground(new Color(0, 0, 0));
		confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirmBtn.setBounds(220, 479, 208, 62);
		confirmBtn.addActionListener(listener);
		contentPane.add(confirmBtn);
		
		WarnKid = new JLabel("");
		WarnKid.setForeground(new Color(255, 0, 0));
		WarnKid.setFont(new Font("Tahoma", Font.BOLD, 14));
		WarnKid.setBounds(33, 494, 159, 26);
		contentPane.add(WarnKid);
		
		JLabel lblParentname = new JLabel("Parent Name");
		lblParentname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblParentname.setBounds(70, 426, 127, 29);
		contentPane.add(lblParentname);
		
		parentNameTextKid = new JTextField();
		parentNameTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		parentNameTextKid.setColumns(10);
		parentNameTextKid.setBounds(202, 426, 340, 29);
		contentPane.add(parentNameTextKid);
			
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(70, 224, 127, 29);
		contentPane.add(lblGender);
		
		genderTextKid = new JTextField();
		genderTextKid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderTextKid.setColumns(10);
		genderTextKid.setBounds(202, 224, 340, 29);
		contentPane.add(genderTextKid);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 600, 551);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("medical.jpg")).getScaledInstance(600, 551, Image.SCALE_DEFAULT)));
		contentPane.add(lblNewLabel_1);
		
		
		this.setVisible(true);
	}
}

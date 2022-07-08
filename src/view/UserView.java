package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UserController;
import dao.MomDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.core.Mom;

public class UserView extends JFrame {
	private JPanel contentPane;
	public String id;
	public JTable table; 
	public JTextField addressText;
	public JTextField phoneText;
	public JTextField mailText;
	public JTextField appointText;
	public Mom mom;

	/**
	 * Create the frame.
	 */
	public UserView(String id) {
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Medical Care");
		setBounds(100, 100, 1000, 600);
		this.setLocationRelativeTo(null);
		
		this.mom = MomDAO.getInstance().select(new Mom(id));
		ActionListener listener = new UserController(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setText("Welcome back " + this.mom.getFirstName() + " " + this.mom.getLastName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(304, 7, 460, 70);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "DOB", "Address", "Phone", "Mail", "Appointment", "Status", "EDD"
			}
		));
		table.setRowHeight(table.getRowHeight() + 40);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				mom.getID(),
				mom.getFirstName() + " " + mom.getLastName(),
				mom.getDateOfBirth(),
				mom.getAddress(),
				mom.getPhoneNum(),
				mom.getEmail(),
				mom.getAppointment(),
				mom.getHealthStatus(),
				mom.getEDD()
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(23,107,939,167);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Address\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 350, 86, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone Num\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(23, 400, 86, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(23, 450, 86, 39);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Make an appointment\r\n");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(679, 300, 199, 39);
		contentPane.add(lblNewLabel_1_3);
		
		JButton updateButton = new JButton("Update");
		updateButton.setBackground(new Color(127, 255, 212));
		updateButton.setForeground(new Color(0, 0, 0));
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateButton.setBounds(119, 500, 112, 39);
		updateButton.addActionListener(listener);
		contentPane.add(updateButton);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setForeground(new Color(0, 0, 0));
		confirmButton.setBackground(new Color(127, 255, 212));
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirmButton.setBounds(850, 350, 112, 39);
		confirmButton.addActionListener(listener);
		contentPane.add(confirmButton);
		
		addressText = new JTextField();
		addressText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressText.setBounds(119, 350, 207, 39);
		contentPane.add(addressText);
		addressText.setColumns(10);
		
		phoneText = new JTextField();
		phoneText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneText.setColumns(10);
		phoneText.setBounds(119, 400, 207, 39);
		contentPane.add(phoneText);
		
		mailText = new JTextField();
		mailText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mailText.setColumns(10);
		mailText.setBounds(119, 450, 207, 39);
		contentPane.add(mailText);
		
		appointText = new JTextField();
		appointText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		appointText.setColumns(10);
		appointText.setBounds(649, 350, 184, 39);
		contentPane.add(appointText);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Update information");
		lblNewLabel_1_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(119, 300, 171, 39);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(597, 350, 42, 39);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnEvent = new JButton("Event");
		btnEvent.setBackground(new Color(127, 255, 212));
		btnEvent.setForeground(new Color(0, 0, 0));
		btnEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEvent.setBounds(679, 422, 178, 62);
		btnEvent.addActionListener(listener);
		contentPane.add(btnEvent);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 986, 83);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 83, 986, 480);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("medical.jpg")).getScaledInstance(986, 480, Image.SCALE_DEFAULT)));

		contentPane.add(lblNewLabel_2);
		
		this.setVisible(true);
	}
}

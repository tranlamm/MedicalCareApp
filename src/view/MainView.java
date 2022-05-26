package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.NavBarController;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MainView extends JFrame {
	public JPanel contentPane;
	public JPanel mom;
	public JPanel kid;
	public JPanel clinic;
	public JPanel event;
	public JTable table;
	public JTextField idText;
	public JTextField nameText;
	public JTextField addressText;
	public JTextField emailText;
	public JTextField dOBText;
	public JTextField phoneNumText;
	public JTextField idSearchText;
	public JTextField nameSearchText;
	public JTextField phoneSearchText;

	/**
	 * Create the frame.
	 */
	public MainView() {
		this.setTitle("Medical_Care");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener navBarListener = new NavBarController(this);
		
		JPanel navBar = new JPanel();
		navBar.setBackground(Color.LIGHT_GRAY);
		navBar.setBounds(0, 0, 280, 730);
		navBar.setLayout(null);
		contentPane.add(navBar);
		
		JButton btnMom = new JButton("Mom");
		btnMom.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMom.setBounds(0, 160, 280, 100);
		btnMom.addActionListener(navBarListener);
		navBar.add(btnMom);
		
		JButton btnKid = new JButton("Kid");
		btnKid.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKid.setBounds(0, 260, 280, 100);
		btnKid.addActionListener(navBarListener);
		navBar.add(btnKid);
		
		JButton btnClinic = new JButton("Clinic");
		btnClinic.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClinic.setBounds(0, 360, 280, 100);
		btnClinic.addActionListener(navBarListener);
		navBar.add(btnClinic);
		
		JButton btnEvent = new JButton("Event");
		btnEvent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEvent.setBounds(0, 460, 280, 100);
		btnEvent.addActionListener(navBarListener);
		navBar.add(btnEvent);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\navBar.jpg"));
		background.setVerticalAlignment(SwingConstants.TOP);
		background.setBounds(0, 0, 280, 734);
		navBar.add(background);
		
		jPanelMom();
		jPanelKid();
		jPanelClinic();
		jPanelEvent();
	
		contentPane.add(mom);
		contentPane.add(kid);
		contentPane.add(clinic);
		contentPane.add(event);
	
		
		this.setVisible(true);
	}
	
	public void jPanelMom()
	{
		mom = new JPanel();
		mom.setBackground(Color.WHITE);
		mom.setBounds(280, 0, 1125, 730);
		mom.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin thai ph\u1EE5");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(417, 10, 535, 48);
		mom.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Name", "Date Of Birth", "Address", "Phone Number", "Email", "Weight", "Appointment"
				, "Health Status", "EDD"
			}
		));
		table.setRowHeight(table.getRowHeight() + 20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10,65,1051,385);
		
		mom.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("ID\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(525, 461, 58, 35);
		mom.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(680, 461, 47, 35);
		mom.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(525, 549, 79, 35);
		mom.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date Of Birth\r\n");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(525, 507, 113, 35);
		mom.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Phone Number\r\n");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(525, 641, 134, 35);
		mom.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Email");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2.setBounds(523, 595, 72, 35);
		mom.add(lblNewLabel_1_3_2);
		
		idText = new JTextField();
		idText.setBounds(561, 463, 109, 35);
		mom.add(idText);
		idText.setColumns(10);
		
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(737, 463, 166, 35);
		mom.add(nameText);
		
		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(613, 551, 290, 35);
		mom.add(addressText);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(613, 597, 290, 35);
		mom.add(emailText);
		
		dOBText = new JTextField();
		dOBText.setColumns(10);
		dOBText.setBounds(662, 505, 241, 35);
		mom.add(dOBText);
		
		phoneNumText = new JTextField();
		phoneNumText.setColumns(10);
		phoneNumText.setBounds(662, 643, 241, 35);
		mom.add(phoneNumText);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.setBounds(948, 461, 113, 35);
		mom.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(948, 503, 113, 35);
		mom.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(948, 549, 113, 35);
		mom.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(948, 595, 113, 35);
		mom.add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("Search\r\n");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(137, 450, 100, 48);
		mom.add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("ID\r\n");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(10, 507, 58, 35);
		mom.add(lblNewLabel_11);
		
		JLabel lblNewLabel_1_11 = new JLabel("Name\r\n");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_11.setBounds(10, 552, 47, 35);
		mom.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_1_3_11 = new JLabel("Phone Number\r\n");
		lblNewLabel_1_3_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_11.setBounds(10, 595, 134, 35);
		mom.add(lblNewLabel_1_3_11);
		
		idSearchText = new JTextField();
		idSearchText.setColumns(10);
		idSearchText.setBounds(75, 509, 267, 35);
		mom.add(idSearchText);
		
		nameSearchText = new JTextField();
		nameSearchText.setColumns(10);
		nameSearchText.setBounds(75, 552, 267, 35);
		mom.add(nameSearchText);
		
		phoneSearchText = new JTextField();
		phoneSearchText.setColumns(10);
		phoneSearchText.setBounds(137, 595, 205, 35);
		mom.add(phoneSearchText);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(0, 0, 128));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(124, 649, 113, 35);
		mom.add(btnSearch);
		
		JLabel backgroundMom = new JLabel("");
		backgroundMom.setVerticalAlignment(SwingConstants.TOP);
		backgroundMom.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\medical.jpg"));
		backgroundMom.setBounds(0, 0, 1100, 800);
		mom.add(backgroundMom);
		mom.setVisible(true);
	}
	
	public void jPanelKid()
	{
		kid = new JPanel();
		kid.setBackground(Color.BLACK);
		kid.setBounds(280, 0, 1125, 730);
		kid.setVisible(false);
	}
	
	public void jPanelClinic()
	{
		clinic = new JPanel();
		clinic.setBackground(Color.YELLOW);
		clinic.setBounds(280, 0, 1125, 730);
		clinic.setVisible(false);
	}
	
	public void jPanelEvent()
	{
		event = new JPanel();
		event.setBackground(Color.CYAN);
		event.setBounds(280, 0, 1125, 730);
		event.setVisible(false);
	}
	
}

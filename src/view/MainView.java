package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.EventController;
import controller.MomController;
import controller.NavBarController;
import model.manager.ManagerClinic;
import model.manager.ManagerEvent;
import model.manager.ManagerKid;
import model.manager.ManagerMom;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class MainView extends JFrame {
	public ManagerMom managerMom;
	public ManagerEvent managerEvent;
	public ManagerClinic managerClinic;
	public ManagerKid managerKid;
	
	public JPanel contentPane;
	public JPanel mom;
	public JPanel kid;
	public JPanel clinic;
	public JPanel event;
	
	// for mom panel
	public JTable tableMom;
	public JTextField idTextMom;
	public JTextField firstTextMom;
	public JTextField addressTextMom;
	public JTextField emailTextMom;
	public JTextField dOBTextMom;
	public JTextField phoneNumTextMom;
	public JTextField idSearchTextMom;
	public JTextField weightTextMom;
	public JTextField eddTextMom;
	public JTextField healthTextMom;
	public JTextField apptTextMom;
	public JTextField lastTextMom;
	public JLabel labelWarnMom;

	// for event panel
	public JTable tableEvent;
	public JTextField dateEvent;
	public JTextField nameEvent;
	public JTextField searchTextEvent;
	public JTextArea desEvent;

	/**
	 * Create the frame.
	 */
	public MainView() {
		//initialize
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Medical_Care");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		this.setLocationRelativeTo(null);
		managerMom = new ManagerMom();
		managerEvent = new ManagerEvent();
		managerKid = new ManagerKid();
		managerClinic = new ManagerClinic();
		
		//content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//nav bar
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
		//end nav bar
		
		//main panel
//		jPanelMom();
//		jPanelKid();
//		jPanelClinic();
		jPanelEvent();
		
//		contentPane.add(mom);
//		contentPane.add(kid);
//		contentPane.add(clinic);
		contentPane.add(event);
		//end main panel
		
		this.setVisible(true);
	}
	
	public void jPanelMom()
	{
		mom = new JPanel();
		mom.setBackground(Color.WHITE);
		mom.setBounds(280, 0, 1125, 730);
		mom.setLayout(null);
		
		ActionListener momListener = new MomController(this);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin thai ph\u1EE5");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(417, 10, 535, 48);
		mom.add(lblNewLabel);
		
		tableMom = new JTable();
		tableMom.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Date Of Birth", "Address", "Phone Number", "Email", "Weight", "Appointment", "Health Status", "EDD"
			}
		));
		tableMom.setRowHeight(tableMom.getRowHeight() + 20);
		
		JScrollPane scrollPaneMom = new JScrollPane(tableMom);
		scrollPaneMom.setBounds(10,65,1051,385);
		
		mom.add(scrollPaneMom);
		
		JLabel lblNewLabel_1 = new JLabel("ID\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(296, 450, 58, 35);
		mom.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(412, 450, 94, 35);
		mom.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address\r\n");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(296, 542, 79, 35);
		mom.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date Of Birth\r\n");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(296, 496, 113, 35);
		mom.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Phone Number\r\n");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBounds(296, 634, 134, 35);
		mom.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Email");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3_2.setBounds(296, 588, 72, 35);
		mom.add(lblNewLabel_1_3_2);
		
		idTextMom = new JTextField();
		idTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTextMom.setBounds(327, 452, 72, 35);
		mom.add(idTextMom);
		idTextMom.setColumns(10);
		
		firstTextMom = new JTextField();
		firstTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstTextMom.setColumns(10);
		firstTextMom.setBounds(512, 452, 113, 35);
		mom.add(firstTextMom);
		
		addressTextMom = new JTextField();
		addressTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressTextMom.setColumns(10);
		addressTextMom.setBounds(370, 544, 253, 35);
		mom.add(addressTextMom);
		
		emailTextMom = new JTextField();
		emailTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailTextMom.setColumns(10);
		emailTextMom.setBounds(353, 588, 270, 35);
		mom.add(emailTextMom);
		
		dOBTextMom = new JTextField();
		dOBTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dOBTextMom.setColumns(10);
		dOBTextMom.setBounds(407, 496, 216, 35);
		mom.add(dOBTextMom);
		
		phoneNumTextMom = new JTextField();
		phoneNumTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneNumTextMom.setColumns(10);
		phoneNumTextMom.setBounds(425, 636, 198, 35);
		mom.add(phoneNumTextMom);
		
		JButton btnInsertMom = new JButton("Insert");
		btnInsertMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertMom.setBounds(948, 461, 113, 35);
		btnInsertMom.addActionListener(momListener);
		mom.add(btnInsertMom);
		
		JButton btnDeleteMom = new JButton("Delete");
		btnDeleteMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteMom.setBounds(948, 503, 113, 35);
		btnDeleteMom.addActionListener(momListener);
		mom.add(btnDeleteMom);
		
		JButton btnUpdateMom = new JButton("Update");
		btnUpdateMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateMom.setBounds(948, 549, 113, 35);
		btnUpdateMom.addActionListener(momListener);
		mom.add(btnUpdateMom);
		
		JButton btnResetMom = new JButton("Reset");
		btnResetMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnResetMom.setBounds(948, 595, 113, 35);
		btnResetMom.addActionListener(momListener);
		mom.add(btnResetMom);
		
		JLabel lblNewLabel_2 = new JLabel("Search\r\n");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(33, 450, 100, 48);
		mom.add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("ID\r\n");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(10, 507, 58, 35);
		mom.add(lblNewLabel_11);
		
		idSearchTextMom = new JTextField();
		idSearchTextMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		idSearchTextMom.setColumns(10);
		idSearchTextMom.setBounds(75, 509, 121, 35);
		mom.add(idSearchTextMom);
		
		JButton btnSearchMom = new JButton("Search");
		btnSearchMom.setForeground(new Color(0, 0, 128));
		btnSearchMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchMom.setBounds(20, 555, 113, 35);
		btnSearchMom.addActionListener(momListener);
		mom.add(btnSearchMom);
		
		JLabel lblNewLabel_1_111 = new JLabel("Weight\r\n");
		lblNewLabel_1_111.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_111.setBounds(654, 542, 72, 35);
		mom.add(lblNewLabel_1_111);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Appointment\r\n");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(654, 634, 121, 35);
		mom.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Health Status\r\n");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(654, 588, 132, 35);
		mom.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("EDD\r\n");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_3.setBounds(654, 496, 47, 35);
		mom.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_11 = new JLabel("Last Name\r\n");
		lblNewLabel_1_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_11.setBounds(652, 450, 94, 35);
		mom.add(lblNewLabel_1_11);
		
		lastTextMom = new JTextField();
		lastTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastTextMom.setColumns(10);
		lastTextMom.setBounds(745, 452, 156, 35);
		mom.add(lastTextMom);
		
		weightTextMom = new JTextField();
		weightTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		weightTextMom.setColumns(10);
		weightTextMom.setBounds(731, 544, 170, 35);
		mom.add(weightTextMom);
		
		eddTextMom = new JTextField();
		eddTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eddTextMom.setColumns(10);
		eddTextMom.setBounds(731, 498, 170, 35);
		mom.add(eddTextMom);
		
		healthTextMom = new JTextField();
		healthTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		healthTextMom.setColumns(10);
		healthTextMom.setBounds(775, 590, 126, 35);
		mom.add(healthTextMom);
		
		apptTextMom = new JTextField();
		apptTextMom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		apptTextMom.setColumns(10);
		apptTextMom.setBounds(776, 636, 125, 35);
		mom.add(apptTextMom);
		
		labelWarnMom = new JLabel("");
		labelWarnMom.setForeground(Color.RED);
		labelWarnMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelWarnMom.setBounds(930, 646, 150, 23);
		mom.add(labelWarnMom);
		
		JLabel backgroundMom = new JLabel("");
		backgroundMom.setVerticalAlignment(SwingConstants.TOP);
		backgroundMom.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\medical.jpg"));
		backgroundMom.setBounds(0, 0, 1100, 730);
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
		event.setBackground(Color.WHITE);
		event.setBounds(280, 0, 1125, 730);
		event.setLayout(null);
		
		ActionListener eventListener = new EventController(this);
		
		tableEvent = new JTable();
		tableEvent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Date", "Description"
			}
		));
		tableEvent.setRowHeight(tableEvent.getRowHeight() + 30);
		
		JScrollPane scrollPaneEvent = new JScrollPane(tableEvent);
		scrollPaneEvent.setBounds(39,100,505,585);
		event.add(scrollPaneEvent);
		
		dateEvent = new JTextField();
		dateEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateEvent.setBounds(628, 150, 236, 31);
		event.add(dateEvent);
		dateEvent.setColumns(10);
		
		nameEvent = new JTextField();
		nameEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameEvent.setColumns(10);
		nameEvent.setBounds(628, 100, 236, 31);
		event.add(nameEvent);
		
		desEvent = new JTextArea();
		desEvent.setBackground(Color.WHITE);
		desEvent.setFont(new Font("Arial", Font.PLAIN, 14));
	
		JScrollPane jScrollArea = new JScrollPane(desEvent); 
		jScrollArea.setBounds(570, 230, 294, 140);
		event.add(jScrollArea);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name\r\n");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(570, 100, 48, 23);
		event.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Date\r\n");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(570, 150, 38, 23);
		event.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Description\r\n");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(670, 200, 87, 23);
		event.add(lblNewLabel_3_1_1_1);
		
		JButton insertEvent = new JButton("Insert");
		insertEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertEvent.setBounds(912, 100, 100, 27);
		insertEvent.addActionListener(eventListener);
		event.add(insertEvent);
		
		JButton deleteEvent = new JButton("Delete");
		deleteEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteEvent.setBounds(912, 150, 100, 27);
		deleteEvent.addActionListener(eventListener);
		event.add(deleteEvent);
		
		JButton resetEvent = new JButton("Reset");
		resetEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetEvent.setBounds(912, 200, 100, 27);
		resetEvent.addActionListener(eventListener);
		event.add(resetEvent);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Name\r\n");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_2.setBounds(942, 275, 48, 23);
		event.add(lblNewLabel_3_1_2);
		
		searchTextEvent = new JTextField();
		searchTextEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchTextEvent.setColumns(10);
		searchTextEvent.setBounds(874, 300, 178, 31);
		event.add(searchTextEvent);
		
		JButton searchEvent = new JButton("Search");
		searchEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchEvent.setBounds(912, 340, 100, 27);
		searchEvent.addActionListener(eventListener);
		event.add(searchEvent);
		
		event.setVisible(false);
	}
}

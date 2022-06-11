package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

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
	public JTextField idSearchTextMom;
	public JTextField nameSearchMom;
	public ButtonGroup buttonGroupGender;

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
		this.setTitle("Medical Care");
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
		jPanelMom();
		jPanelKid();
		jPanelClinic();
		jPanelEvent();
		
		contentPane.add(mom);
		contentPane.add(kid);
		contentPane.add(clinic);
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
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(419, 32, 245, 48);
		mom.add(lblNewLabel);
		
		// table
		tableMom = new JTable();
		tableMom.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Date Of Birth", "Address", "Phone Number", "Email"
			}
		));
		tableMom.setRowHeight(tableMom.getRowHeight() + 20);
		JScrollPane scrollPaneMom = new JScrollPane(tableMom);
		scrollPaneMom.setBounds(90,175,905,320);
		mom.add(scrollPaneMom);
		
		// button
		JButton btnInsertMom = new JButton("Insert");
		btnInsertMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertMom.setBounds(570, 121, 94, 35);
		btnInsertMom.addActionListener(momListener);
		mom.add(btnInsertMom);
		
		JButton btnDeleteMom = new JButton("Delete");
		btnDeleteMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteMom.setBounds(790, 121, 94, 35);
		btnDeleteMom.addActionListener(momListener);
		mom.add(btnDeleteMom);
		
		JButton btnUpdateMom = new JButton("Update");
		btnUpdateMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateMom.setBounds(680, 121, 94, 35);
		btnUpdateMom.addActionListener(momListener);
		mom.add(btnUpdateMom);
		
		JButton btnResetMom = new JButton("Reset");
		btnResetMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnResetMom.setBounds(900, 121, 94, 35);
		btnResetMom.addActionListener(momListener);
		mom.add(btnResetMom);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(90, 520, 100, 48);
		mom.add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(90, 575, 36, 35);
		mom.add(lblNewLabel_11);
		
		idSearchTextMom = new JTextField();
		idSearchTextMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		idSearchTextMom.setColumns(10);
		idSearchTextMom.setBounds(174, 575, 241, 35);
		mom.add(idSearchTextMom);
		
		JLabel lblNewLabel_123 = new JLabel("Name");
		lblNewLabel_123.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_123.setBounds(90, 620, 58, 35);
		mom.add(lblNewLabel_123);
		
		nameSearchMom = new JTextField();
		nameSearchMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameSearchMom.setColumns(10);
		nameSearchMom.setBounds(174, 620, 241, 35);
		mom.add(nameSearchMom);
		
		JRadioButton idRadioMom = new JRadioButton("ID");
		idRadioMom.setBackground(Color.WHITE);
		idRadioMom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idRadioMom.setBounds(460, 575, 58, 23);
		mom.add(idRadioMom);
		
		JRadioButton nameRadioMom = new JRadioButton("Name");
		nameRadioMom.setBackground(Color.WHITE);
		nameRadioMom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameRadioMom.setBounds(520, 575, 72, 23);
		mom.add(nameRadioMom);
		
		buttonGroupGender = new ButtonGroup();
		buttonGroupGender.add(idRadioMom);
		buttonGroupGender.add(nameRadioMom);
		
		JButton btnSearchMom = new JButton("Search");
		btnSearchMom.setForeground(new Color(0, 0, 128));
		btnSearchMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchMom.setBounds(461, 620, 113, 35);
		btnSearchMom.addActionListener(momListener);
		mom.add(btnSearchMom);
		
		JButton detailBtn = new JButton("Details");
		detailBtn.setForeground(new Color(0, 0, 128));
		detailBtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		detailBtn.setBounds(841, 527, 154, 53);
		detailBtn.addActionListener(momListener);
		mom.add(detailBtn);
		
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
		scrollPaneEvent.setBounds(50,60,500,611);
		event.add(scrollPaneEvent);
		
		dateEvent = new JTextField();
		dateEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateEvent.setBounds(669, 110, 195, 31);
		event.add(dateEvent);
		dateEvent.setColumns(10);
		
		nameEvent = new JTextField();
		nameEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameEvent.setColumns(10);
		nameEvent.setBounds(669, 60, 195, 31);
		event.add(nameEvent);
		
		desEvent = new JTextArea();
		desEvent.setBackground(Color.WHITE);
		desEvent.setFont(new Font("Arial", Font.PLAIN, 14));
	
		JScrollPane jScrollArea = new JScrollPane(desEvent); 
		jScrollArea.setBounds(611, 194, 253, 136);
		event.add(jScrollArea);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name\r\n");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(611, 60, 48, 23);
		event.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Date\r\n");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(611, 110, 38, 23);
		event.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Description\r\n");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(611, 160, 87, 23);
		event.add(lblNewLabel_3_1_1_1);
		
		JButton insertEvent = new JButton("Insert");
		insertEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertEvent.setBounds(912, 60, 100, 27);
		insertEvent.addActionListener(eventListener);
		event.add(insertEvent);
		
		JButton deleteEvent = new JButton("Delete");
		deleteEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteEvent.setBounds(912, 110, 100, 27);
		deleteEvent.addActionListener(eventListener);
		event.add(deleteEvent);
		
		JButton resetEvent = new JButton("Reset");
		resetEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetEvent.setBounds(912, 160, 100, 27);
		resetEvent.addActionListener(eventListener);
		event.add(resetEvent);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Name\r\n");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_2.setBounds(912, 225, 48, 23);
		event.add(lblNewLabel_3_1_2);
		
		searchTextEvent = new JTextField();
		searchTextEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchTextEvent.setColumns(10);
		searchTextEvent.setBounds(912, 250, 140, 31);
		event.add(searchTextEvent);
		
		JButton searchEvent = new JButton("Search");
		searchEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchEvent.setBounds(912, 303, 100, 27);
		searchEvent.addActionListener(eventListener);
		event.add(searchEvent);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Send Mail");
		lblNewLabel_3_1_1_2.setForeground(Color.RED);
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_1_2.setBounds(611, 370, 87, 23);
		event.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("From");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_1.setBounds(611, 408, 48, 23);
		event.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("To");
		lblNewLabel_3_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_2.setBounds(611, 452, 38, 23);
		event.add(lblNewLabel_3_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_3 = new JLabel("Subject");
		lblNewLabel_3_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_3.setBounds(611, 494, 59, 23);
		event.add(lblNewLabel_3_1_1_1_3);
		
		JLabel lblNewLabel_3_1_1_1_4 = new JLabel("Content");
		lblNewLabel_3_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_4.setBounds(611, 547, 72, 23);
		event.add(lblNewLabel_3_1_1_1_4);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(680, 404, 140, 31);
		event.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(679, 448, 140, 31);
		event.add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(679, 490, 140, 31);
		event.add(textField_2);
		
		JTextArea tmp = new JTextArea();
		tmp.setBackground(Color.WHITE);
		tmp.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane jScrollArea2 = new JScrollPane(tmp); 
		jScrollArea2.setBounds(611, 581, 273, 90);
		event.add(jScrollArea2);
		
		JButton btnSend = new JButton("Send");
		btnSend.setForeground(Color.BLUE);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.setBounds(912, 611, 140, 60);
		btnSend.addActionListener(eventListener);
		event.add(btnSend);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(835, 408, 72, 23);
		event.add(lblNewLabel_3);
		
		JPasswordField textField_3 = new JPasswordField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(912, 404, 140, 31);
		event.add(textField_3);
		
		event.setVisible(false);
	}
}

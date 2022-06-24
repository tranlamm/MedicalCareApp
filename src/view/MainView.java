package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import controller.ClinicController;
import controller.EventController;
import controller.MomController;
import controller.NavBarController;
import model.manager.ManagerClinic;
import model.manager.ManagerEvent;
import model.manager.ManagerKid;
import model.manager.ManagerMom;
import controller.KidController;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
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
	
	// for clinic panel
	public JTable tableClinic;
	public JTextField idClinic;
	public JTextField nameClinic;
	public JTextField emailClinic;
	public JTextField phoneNumberClinic;
	public JTextField address;
	public JTextField type;
	public JTextField searchClinic;
	
	// for kid panel
	public JTable tableKid;
	public JTextField KidSearchById;
	public JTextField KidSearchByName;
	public ButtonGroup buttonGroupKid;
	
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
		
//		JLabel background = new JLabel("");
//		background.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\navBar.jpg"));
//		background.setVerticalAlignment(SwingConstants.TOP);
//		background.setBounds(0, 0, 280, 734);
//		navBar.add(background);
		//end nav bar
		
		//main panel
		jPanelMom();
		jPanelKid();
		jPanelEvent();
		jPanelClinic();
		
		contentPane.add(mom);
		contentPane.add(kid);
		contentPane.add(event);
		contentPane.add(clinic);
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
		kid.setBackground(Color.WHITE);
		kid.setBounds(279, 0, 1125, 730);
		kid.setLayout(null);
		
		ActionListener kidListener = new KidController(this);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin tr\u1EBB em");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(456, 11, 239, 48);
		kid.add(lblNewLabel);

		
		tableKid = new JTable();
		tableKid.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name","Last Name", "Date Of Birth", "Gender", "Address", "Phone Num", "Email", "Parent Name"
			}
		));
		tableKid.setRowHeight(tableKid.getRowHeight() + 20);
		JScrollPane scrollPaneKid = new JScrollPane(tableKid);
		scrollPaneKid.setBounds(54,206,885,348);
		kid.add(scrollPaneKid);
		
		
		JButton btnAdd = new JButton("Insert");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdd.setBackground(Color.BLUE);
		btnAdd.setBounds(962, 206, 103, 48);
		btnAdd.addActionListener(kidListener);
		kid.add(btnAdd);
		
		JButton btnEdit = new JButton("Update");
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.setBounds(962, 306, 103, 48);
		btnEdit.addActionListener(kidListener);
		kid.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(962, 406, 103, 48);
		btnDelete.addActionListener(kidListener);
		kid.add(btnDelete);
		
		JButton btnClear = new JButton("Reset");
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClear.setBackground(Color.GREEN);
		btnClear.setBounds(962, 506, 103, 48);
		btnClear.addActionListener(kidListener);
		kid.add(btnClear);
		
		JButton btnSearchKid = new JButton("Search");
		btnSearchKid.setForeground(Color.BLACK);
		btnSearchKid.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSearchKid.setBackground(Color.BLUE);
		btnSearchKid.setBounds(746, 134, 119, 43);
		btnSearchKid.addActionListener(kidListener);
		kid.add(btnSearchKid);
		
		KidSearchById = new JTextField();
		KidSearchById.setText("ID...");
		KidSearchById.setFont(new Font("Tahoma", Font.PLAIN, 15));
		KidSearchById.setColumns(10);
		KidSearchById.setBounds(248, 81, 467, 35);
		kid.add(KidSearchById);

		KidSearchByName = new JTextField();
		KidSearchByName.setText("Name...");
		KidSearchByName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		KidSearchByName.setColumns(10);
		KidSearchByName.setBounds(248, 139, 467, 35);
		kid.add(KidSearchByName);
		
		JRadioButton idRadioKid = new JRadioButton("ID");
		idRadioKid.setBackground(Color.WHITE);
		idRadioKid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idRadioKid.setBounds(746, 87, 58, 23);
		kid.add(idRadioKid);
		
		JRadioButton nameRadioKid = new JRadioButton("Name");
		nameRadioKid.setBackground(Color.WHITE);
		nameRadioKid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameRadioKid.setBounds(806, 87, 72, 23);
		kid.add(nameRadioKid);
		
		buttonGroupKid = new ButtonGroup();
		buttonGroupKid.add(idRadioKid);
		buttonGroupKid.add(nameRadioKid);
		
		JButton btnWH = new JButton("Weight Height");
		btnWH.setForeground(new Color(0, 0, 128));
		btnWH.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnWH.setBounds(54, 604, 407, 86);
		btnWH.addActionListener(kidListener);
		kid.add(btnWH);
		
		JButton btnHM = new JButton("History Medical");
		btnHM.setForeground(new Color(0, 0, 128));
		btnHM.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHM.setBounds(532, 604, 407, 86);
		btnHM.addActionListener(kidListener);
		kid.add(btnHM);
		
//		JLabel backgroundKid = new JLabel("");
//		backgroundKid.setVerticalAlignment(SwingConstants.TOP);
//		backgroundKid.setIcon(new ImageIcon("https://media.istockphoto.com/photos/blue-medical-background-with-clipboard-and-stethoscope-picture-id1133637775?k=6&m=1133637775&s=170667a&w=0&h=6d-niRIqkUU40zOogpL71nlF9ItDCtSQMppn9MxtM3o="));
//		backgroundKid.setBounds(0, 0, 1125, 730);
//		kid.add(backgroundKid);
		
		kid.setVisible(false);
	}
	
	public void jPanelClinic()
	{
		clinic = new JPanel();
		clinic.setBackground(Color.WHITE);
		clinic.setBounds(280, 0, 1125, 730);
		clinic.setLayout(null);
		
		ActionListener listener = new ClinicController(this);
		
		tableClinic = new JTable();
		tableClinic.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email","Phone Number","Address","Type"
			}
		));
		tableClinic.setRowHeight(tableClinic.getRowHeight() + 30);
		
		JScrollPane scrollPaneClinic = new JScrollPane(tableClinic);
		scrollPaneClinic.setBounds(125,106,452,426);
		clinic.add(scrollPaneClinic);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(718, 86, 81, 42);
		clinic.add(lblNewLabel_1);
		
		idClinic = new JTextField();
		idClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idClinic.setBounds(809, 82, 166, 51);
		clinic.add(idClinic);
		idClinic.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(718, 168, 81, 42);
		clinic.add(lblNewLabel_1_1);
		
		nameClinic = new JTextField();
		nameClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameClinic.setColumns(10);
		nameClinic.setBounds(809, 164, 166, 51);
		clinic.add(nameClinic);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(663, 265, 81, 42);
		clinic.add(lblNewLabel_1_2);
		
		emailClinic = new JTextField();
		emailClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailClinic.setColumns(10);
		emailClinic.setBounds(809, 261, 166, 51);
		clinic.add(emailClinic);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone Number");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(660, 350, 139, 42);
		clinic.add(lblNewLabel_1_3);
		
		phoneNumberClinic = new JTextField();
		phoneNumberClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneNumberClinic.setColumns(10);
		phoneNumberClinic.setBounds(809, 346, 166, 51);
		clinic.add(phoneNumberClinic);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(718, 431, 81, 42);
		clinic.add(lblNewLabel_1_4);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		address.setColumns(10);
		address.setBounds(809, 427, 166, 51);
		clinic.add(address);
		
		JLabel lblNewLabel_1_5 = new JLabel("Type");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(699, 526, 81, 42);
		clinic.add(lblNewLabel_1_5);
		
		type = new JTextField();
		type.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type.setColumns(10);
		type.setBounds(790, 522, 166, 51);
		clinic.add(type);
		
		JButton insertBtn = new JButton("Insert");
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.setBounds(77, 625, 139, 51);
		insertBtn.addActionListener(listener);
		clinic.add(insertBtn);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateBtn.setBounds(244, 625, 139, 51);
		updateBtn.addActionListener(listener);
		clinic.add(updateBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteBtn.setBounds(413, 625, 139, 51);
		deleteBtn.addActionListener(listener);
		clinic.add(deleteBtn);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetBtn.setBounds(582, 625, 139, 51);
		resetBtn.addActionListener(listener);
		clinic.add(resetBtn);
		
		searchClinic = new JTextField();
		searchClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchClinic.setColumns(10);
		searchClinic.setBounds(458, 534, 166, 51);
		clinic.add(searchClinic);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchBtn.setBounds(309, 534, 139, 51);
		searchBtn.addActionListener(listener);
		clinic.add(searchBtn);
		
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
		textField.setBounds(689, 404, 195, 31);
		event.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(689, 448, 195, 31);
		event.add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(689, 490, 195, 31);
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
		
		event.setVisible(false);
	}
}

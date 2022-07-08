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
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;

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
	public ButtonGroup buttonGroupClinic;
	
	// for kid panel
	public JTable tableKid;
	public JTextField KidSearchById;
	public JTextField KidSearchByName;
	public ButtonGroup buttonGroupKid;
	private JPanel bgrTable;
	/**
	 * Create the frame.
	 */
	public MainView() {
		//initialize
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Medical Care");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
//		this.setSize(1650,1080);
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
		navBar.setForeground(Color.WHITE);
		navBar.setBackground(new Color(238, 232, 170));
		navBar.setBounds(0, 161, 280, 668);
		navBar.setLayout(null);
		contentPane.add(navBar);
		
		JButton btnMom = new JButton("Mom");
		btnMom.setForeground(new Color(0, 0, 0));
		btnMom.setBackground(new Color(255, 165, 0));
		btnMom.setFocusPainted(false);
		btnMom.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMom.setBorder(new LineBorder(new Color(224, 255, 255), 2));
		btnMom.setBounds(0, 0, 280, 167);
		btnMom.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("iconMom.png"))));
		btnMom.addActionListener(navBarListener);
		navBar.add(btnMom);
		
		JButton btnKid = new JButton("Kid");
		btnKid.setForeground(Color.BLACK);
		btnKid.setBackground(new Color(255, 165, 0));
		btnKid.setFocusPainted(false);
		btnKid.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKid.setBorder(new LineBorder(new Color(224, 255, 255), 2));
		btnKid.setBounds(0, 167, 280, 167);
		btnKid.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("iconKid.png"))));
		btnKid.addActionListener(navBarListener);
		navBar.add(btnKid);
		
		JButton btnClinic = new JButton("Clinic");
		btnClinic.setForeground(Color.BLACK);
		btnClinic.setBackground(new Color(255, 165, 0));
		btnClinic.setFocusPainted(false);
		btnClinic.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClinic.setBounds(0, 334, 280, 167);
		btnClinic.setBorder(new LineBorder(new Color(224, 255, 255), 2));
		btnClinic.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("iconHospital.png"))));
		btnClinic.addActionListener(navBarListener);
		navBar.add(btnClinic);
		
		JButton btnEvent = new JButton("Event");
		btnEvent.setForeground(new Color(0, 0, 0));
		btnEvent.setBackground(new Color(255, 165, 0));
		btnEvent.setFocusPainted(false);
		btnEvent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEvent.setBounds(0, 501, 280, 167);
		btnEvent.setBorder(new LineBorder(new Color(224, 255, 255), 2));
		btnEvent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("iconEvent.png"))));
		btnEvent.addActionListener(navBarListener);
		navBar.add(btnEvent);
		
		//icon WHO
		JLabel lblNewLabel_3 = new JLabel("HUST HOSPITAL");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
    	lblNewLabel_3.setBackground(new Color(224, 255, 255));
    	lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("iconWHOother.png"))));
		lblNewLabel_3.setBounds(0, 0, 280, 161);
		contentPane.add(lblNewLabel_3);
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
		
		
		

		
		
		
//		JLabel backgroundMom = new JLabel("");
//		backgroundMom.setBackground(new Color(224, 255, 255));
//		backgroundMom.setVerticalAlignment(SwingConstants.TOP);
//		backgroundMom.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//		backgroundMom.setBounds(0, 161, 1242, 666);
//		mom.add(backgroundMom);
	
		
		
		//end main panel
		
		this.setVisible(true);
	}
	
	public void jPanelMom()
	{
		mom = new JPanel();
		mom.setBackground(new Color(224, 255, 255));
		mom.setBounds(280, 0, 1238, 823);
		
		ActionListener momListener = new MomController(this);
		mom.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1251, 161);
		panel.setBackground(new Color(255, 255, 255));
		mom.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin thai ph\u1EE5");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(548, 46, 308, 48);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(224, 255, 255));
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242,161, Image.SCALE_DEFAULT)));
		lblNewLabel_6.setBounds(0, 0, 1242, 161);
		panel.add(lblNewLabel_6);
		
		
		
//		JLabel backgroundMom = new JLabel("");
//		backgroundMom.setBackground(new Color(224, 255, 255));
//		backgroundMom.setVerticalAlignment(SwingConstants.TOP);
//		backgroundMom.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//		backgroundMom.setBounds(0, 161, 1242, 666);
//		mom.add(backgroundMom);
		
		
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
		scrollPaneMom.setBounds(23, 207, 1048, 418);
		mom.add(scrollPaneMom);
		
		// button
		JButton btnInsertMom = new JButton("Insert");
		btnInsertMom.setBounds(1105, 223, 94, 35);
		btnInsertMom.setForeground(new Color(0, 0, 0));
		btnInsertMom.setBackground(new Color(127, 255, 212));
		btnInsertMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertMom.addActionListener(momListener);
		mom.add(btnInsertMom);
		
		JButton btnDeleteMom = new JButton("Delete");
		btnDeleteMom.setBounds(1105, 438, 94, 35);
		btnDeleteMom.setBackground(new Color(127, 255, 212));
		btnDeleteMom.setForeground(new Color(0, 0, 0));
		btnDeleteMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteMom.addActionListener(momListener);
		mom.add(btnDeleteMom);
		
		JButton btnUpdateMom = new JButton("Update");
		btnUpdateMom.setBounds(1105, 335, 94, 35);
		btnUpdateMom.setBackground(new Color(127, 255, 212));
		btnUpdateMom.setForeground(new Color(0, 0, 0));
		btnUpdateMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateMom.addActionListener(momListener);
		mom.add(btnUpdateMom);
		
		JButton btnResetMom = new JButton("Reset");
		btnResetMom.setBounds(1105, 553, 94, 35);
		btnResetMom.setForeground(new Color(0, 0, 0));
		btnResetMom.setBackground(new Color(127, 255, 212));
		btnResetMom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnResetMom.addActionListener(momListener);
		mom.add(btnResetMom);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setBounds(180, 635, 100, 48);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		mom.add(lblNewLabel_2);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setBounds(359, 658, 36, 35);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		mom.add(lblNewLabel_11);
		
		idSearchTextMom = new JTextField();
		idSearchTextMom.setBounds(468, 658, 472, 35);
		idSearchTextMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		idSearchTextMom.setColumns(10);
		mom.add(idSearchTextMom);
		
		JLabel lblNewLabel_123 = new JLabel("Name");
		lblNewLabel_123.setBounds(359, 726, 58, 35);
		lblNewLabel_123.setFont(new Font("Tahoma", Font.BOLD, 16));
		mom.add(lblNewLabel_123);
		
		nameSearchMom = new JTextField();
		nameSearchMom.setBounds(468, 726, 472, 35);
		nameSearchMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameSearchMom.setColumns(10);
		mom.add(nameSearchMom);
		
		JRadioButton idRadioMom = new JRadioButton("ID");
		idRadioMom.setBounds(148, 689, 58, 23);
		idRadioMom.setBackground(new Color(224, 255, 255));
		idRadioMom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mom.add(idRadioMom);
		
		JRadioButton nameRadioMom = new JRadioButton("Name");
		nameRadioMom.setBounds(225, 689, 72, 23);
		nameRadioMom.setBackground(new Color(224, 255, 255));
		nameRadioMom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mom.add(nameRadioMom);
		
		buttonGroupGender = new ButtonGroup();
		buttonGroupGender.add(idRadioMom);
		buttonGroupGender.add(nameRadioMom);
		
		JButton btnSearchMom = new JButton("Search");
		btnSearchMom.setBounds(144, 719, 153, 61);
		btnSearchMom.setBackground(new Color(127, 255, 212));
		btnSearchMom.setForeground(Color.BLACK);
		btnSearchMom.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearchMom.addActionListener(momListener);
		mom.add(btnSearchMom);
		
		JButton detailBtn = new JButton("Details");
		detailBtn.setBounds(1005, 658, 194, 103);
		detailBtn.setBackground(new Color(127, 255, 212));
		detailBtn.setForeground(new Color(0, 0, 0));
		detailBtn.setFont(new Font("Tahoma", Font.BOLD, 21));
		detailBtn.addActionListener(momListener);
		mom.add(detailBtn);
			
//		JLabel backgroundMom = new JLabel("");
//		backgroundMom.setBackground(new Color(224, 255, 255));
//		backgroundMom.setVerticalAlignment(SwingConstants.TOP);
//		backgroundMom.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//		backgroundMom.setBounds(0, 161, 1242, 666);
//		mom.add(backgroundMom);
	
		mom.setVisible(true);
	}
	
	public void jPanelKid()
	{
		kid = new JPanel();
		kid.setBackground(new Color(224, 255, 255));
		kid.setBounds(279, 0,  1251, 829);
		kid.setLayout(null);
		
		
		
		ActionListener kidListener = new KidController(this);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1261, 161);
		kid.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Th\u00F4ng tin tr\u1EBB");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(529, 48, 308, 48);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBackground(new Color(224, 255, 255));
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_8.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1251, 161, Image.SCALE_DEFAULT)));
		lblNewLabel_8.setBounds(0, 0, 1251, 161);
		panel.add(lblNewLabel_8);
		
		
//		JLabel backgroundMom = new JLabel("");
//		backgroundMom.setBackground(new Color(224, 255, 255));
//		backgroundMom.setVerticalAlignment(SwingConstants.TOP);
//		backgroundMom.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//		backgroundMom.setBounds(0, 161, 1242, 666);
//		mom.add(backgroundMom);
		
		//table
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
		scrollPaneKid.setBounds(34,345,1001,348);
		kid.add(scrollPaneKid);
		
		
		JButton btnAdd = new JButton("Insert");
		btnAdd.setBackground(new Color(127, 255, 212));
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAdd.setBounds(1098, 290, 103, 48);
		btnAdd.addActionListener(kidListener);
		kid.add(btnAdd);
		
		JButton btnEdit = new JButton("Update");
		btnEdit.setBackground(new Color(127, 255, 212));
		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEdit.setBounds(1098, 412, 103, 48);
		btnEdit.addActionListener(kidListener);
		kid.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDelete.setBackground(new Color(127, 255, 212));
		btnDelete.setBounds(1098, 536, 103, 48);
		btnDelete.addActionListener(kidListener);
		kid.add(btnDelete);
		
		JButton btnClear = new JButton("Reset");
		btnClear.setForeground(Color.BLACK);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnClear.setBackground(new Color(127, 255, 212));
		btnClear.setBounds(1098, 655, 103, 48);
		btnClear.addActionListener(kidListener);
		kid.add(btnClear);
		
		JButton btnSearchKid = new JButton("Search");
		btnSearchKid.setForeground(Color.BLACK);
		btnSearchKid.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSearchKid.setBackground(new Color(127, 255, 212));
		btnSearchKid.setBounds(202, 171, 119, 43);
		btnSearchKid.addActionListener(kidListener);
		kid.add(btnSearchKid);
		
		KidSearchById = new JTextField();
		KidSearchById.setText("ID...");
		KidSearchById.setFont(new Font("Tahoma", Font.PLAIN, 15));
		KidSearchById.setColumns(10);
		KidSearchById.setBounds(440, 214, 467, 35);
		kid.add(KidSearchById);

		KidSearchByName = new JTextField();
		KidSearchByName.setText("Name...");
		KidSearchByName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		KidSearchByName.setColumns(10);
		KidSearchByName.setBounds(440, 281, 467, 35);
		kid.add(KidSearchByName);
		
		JRadioButton idRadioKid = new JRadioButton("ID");
		idRadioKid.setBackground(new Color(224, 255, 255));
		idRadioKid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idRadioKid.setBounds(328, 220, 58, 23);
		kid.add(idRadioKid);
		
		JRadioButton nameRadioKid = new JRadioButton("Name");
		nameRadioKid.setBackground(new Color(224, 255, 255));
		nameRadioKid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameRadioKid.setBounds(328, 287, 72, 23);
		kid.add(nameRadioKid);
		
		buttonGroupKid = new ButtonGroup();
		buttonGroupKid.add(idRadioKid);
		buttonGroupKid.add(nameRadioKid);
		
		JButton btnWH = new JButton("Weight Height");
		btnWH.setBackground(new Color(127, 255, 212));
		btnWH.setForeground(new Color(0, 0, 0));
		btnWH.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnWH.setBounds(54, 703, 407, 86);
		btnWH.addActionListener(kidListener);
		kid.add(btnWH);
		
		JButton btnHM = new JButton("History Medical");
		btnHM.setBackground(new Color(127, 255, 212));
		btnHM.setForeground(new Color(0, 0, 0));
		btnHM.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHM.setBounds(532, 703, 407, 86);
		btnHM.addActionListener(kidListener);
		kid.add(btnHM);
		
//		JLabel backgroundKid = new JLabel("");
//		backgroundKid.setVerticalAlignment(SwingConstants.TOP);
//		backgroundKid.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("bgrKid.jpg")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//		backgroundKid.setBounds(0, 161, 1242, 666);
//		kid.add(backgroundKid);
		
		kid.setVisible(false);
	}
	
	public void jPanelClinic()
	{
		clinic = new JPanel();
		clinic.setBackground(new Color(224, 255, 255));
		clinic.setBounds(280, 0,  1261, 827);
		clinic.setLayout(null);
		
		ActionListener listener = new ClinicController(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1251, 161);
		clinic.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel_5 = new JLabel("Th\u00F4ng tin ph\u00F2ng kh\u00E1m");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(499, 48, 380, 48);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_9.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1251, 161, Image.SCALE_DEFAULT)));
		lblNewLabel_9.setBounds(0, 0, 1251, 161);
		panel.add(lblNewLabel_9);
		
	
		
		//table
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
		scrollPaneClinic.setBounds(37,186,787,426);
		clinic.add(scrollPaneClinic);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(866, 214, 81, 42);
		clinic.add(lblNewLabel_1);
		
		idClinic = new JTextField();
		idClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idClinic.setBounds(1015, 210, 166, 51);
		clinic.add(idClinic);
		idClinic.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(866, 322, 81, 42);
		clinic.add(lblNewLabel_1_1);
		
		nameClinic = new JTextField();
		nameClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameClinic.setColumns(10);
		nameClinic.setBounds(1015, 318, 166, 51);
		clinic.add(nameClinic);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(866, 430, 81, 42);
		clinic.add(lblNewLabel_1_2);
		
		emailClinic = new JTextField();
		emailClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailClinic.setColumns(10);
		emailClinic.setBounds(1015, 426, 166, 51);
		clinic.add(emailClinic);
		
		JLabel lblNewLabel_1_3 = new JLabel("Phone Number");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(866, 536, 139, 42);
		clinic.add(lblNewLabel_1_3);
		
		phoneNumberClinic = new JTextField();
		phoneNumberClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneNumberClinic.setColumns(10);
		phoneNumberClinic.setBounds(1015, 532, 166, 51);
		clinic.add(phoneNumberClinic);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(866, 629, 81, 42);
		clinic.add(lblNewLabel_1_4);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 14));
		address.setColumns(10);
		address.setBounds(1015, 625, 166, 51);
		clinic.add(address);
		
		JLabel lblNewLabel_1_5 = new JLabel("Type");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(866, 738, 81, 42);
		clinic.add(lblNewLabel_1_5);
		
		type = new JTextField();
		type.setFont(new Font("Tahoma", Font.PLAIN, 14));
		type.setColumns(10);
		type.setBounds(1015, 734, 166, 51);
		clinic.add(type);
		
		JButton insertBtn = new JButton("Insert");
		insertBtn.setBackground(new Color(127, 255, 212));
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.setBounds(37, 734, 139, 51);
		insertBtn.addActionListener(listener);
		clinic.add(insertBtn);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBackground(new Color(127, 255, 212));
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateBtn.setBounds(242, 734, 139, 51);
		updateBtn.addActionListener(listener);
		clinic.add(updateBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBackground(new Color(127, 255, 212));
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteBtn.setBounds(449, 734, 139, 51);
		deleteBtn.addActionListener(listener);
		clinic.add(deleteBtn);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setBackground(new Color(127, 255, 212));
		resetBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetBtn.setBounds(655, 734, 139, 51);
		resetBtn.addActionListener(listener);
		clinic.add(resetBtn);
		
		searchClinic = new JTextField();
		searchClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchClinic.setColumns(10);
		searchClinic.setBounds(354, 636, 355, 51);
		clinic.add(searchClinic);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setBackground(new Color(127, 255, 212));
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchBtn.setBounds(97, 636, 139, 51);
		searchBtn.addActionListener(listener);
		clinic.add(searchBtn);
		
		JRadioButton idRadioClinic = new JRadioButton("ID");
		idRadioClinic.setBackground(new Color(224, 255, 255));
		idRadioClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idRadioClinic.setBounds(242, 639, 52, 23);
		clinic.add(idRadioClinic);
		
		JRadioButton nameRadioClinic = new JRadioButton("Address");
		nameRadioClinic.setBackground(new Color(224, 255, 255));
		nameRadioClinic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameRadioClinic.setBounds(242, 664, 104, 23);
		clinic.add(nameRadioClinic);
		
		buttonGroupClinic = new ButtonGroup();
		buttonGroupClinic.add(idRadioClinic);
		buttonGroupClinic.add(nameRadioClinic);
		
		
//		JLabel background_clinic = new JLabel("New label");
//		background_clinic.setVerticalAlignment(SwingConstants.TOP);
//		background_clinic.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("bgrKid.jpg")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//		background_clinic.setBounds(0, 161, 1242, 666);
//		clinic.add(background_clinic);
		
		
		
		clinic.setVisible(false);
	}
	
	public void jPanelEvent()
	{
		
		
		event = new JPanel();
		event.setBackground(new Color(224, 255, 255));
		event.setBounds(280, 0, 1242, 827);
		event.setLayout(null);
		
		ActionListener eventListener = new EventController(this);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1242, 161);
		event.add(panel);
		panel.setLayout(null);
	
		
		JLabel lblNewLabel_7 = new JLabel("Th\u00F4ng tin l\u1ECBch kh\u00E1m");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(529, 48, 308, 48);
		lblNewLabel_7.setBackground(Color.WHITE);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 30));

		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBackground(new Color(224, 255, 255));
		lblNewLabel_10.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_10.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242,161, Image.SCALE_DEFAULT)));
		lblNewLabel_10.setBounds(0, 0, 1232, 161);
		panel.add(lblNewLabel_10);
		
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
		scrollPaneEvent.setBounds(30,207,571,584);
		event.add(scrollPaneEvent);
		
		dateEvent = new JTextField();
		dateEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateEvent.setBounds(771, 265, 195, 31);
		event.add(dateEvent);
		dateEvent.setColumns(10);
		
		nameEvent = new JTextField();
		nameEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameEvent.setColumns(10);
		nameEvent.setBounds(771, 197, 195, 31);
		event.add(nameEvent);
		
		desEvent = new JTextArea();
		desEvent.setBackground(Color.WHITE);
		desEvent.setFont(new Font("Arial", Font.PLAIN, 14));
	
		JScrollPane jScrollArea = new JScrollPane(desEvent); 
		jScrollArea.setBounds(771, 337, 253, 136);
		event.add(jScrollArea);
		
		JLabel lblNewLabel_3_1 = new JLabel("Name\r\n");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(661, 201, 48, 23);
		event.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Date\r\n");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(661, 269, 38, 23);
		event.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Description\r\n");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1.setBounds(661, 336, 87, 23);
		event.add(lblNewLabel_3_1_1_1);
		
		JButton insertEvent = new JButton("Insert");
		insertEvent.setBackground(new Color(127, 255, 212));
		insertEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertEvent.setBounds(1052, 212, 100, 27);
		insertEvent.addActionListener(eventListener);
		event.add(insertEvent);
		
		JButton deleteEvent = new JButton("Delete");
		deleteEvent.setBackground(new Color(127, 255, 212));
		deleteEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteEvent.setBounds(1052, 291, 100, 27);
		deleteEvent.addActionListener(eventListener);
		event.add(deleteEvent);
		
		JButton resetEvent = new JButton("Reset");
		resetEvent.setBackground(new Color(127, 255, 212));
		resetEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetEvent.setBounds(1052, 372, 100, 27);
		resetEvent.addActionListener(eventListener);
		event.add(resetEvent);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Name\r\n");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_2.setBounds(1008, 520, 48, 23);
		event.add(lblNewLabel_3_1_2);
		
		searchTextEvent = new JTextField();
		searchTextEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		searchTextEvent.setColumns(10);
		searchTextEvent.setBounds(1076, 516, 140, 31);
		event.add(searchTextEvent);
		
		JButton searchEvent = new JButton("Search");
		searchEvent.setBackground(new Color(127, 255, 212));
		searchEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchEvent.setBounds(1052, 457, 100, 27);
		searchEvent.addActionListener(eventListener);
		event.add(searchEvent);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Send Mail");
		lblNewLabel_3_1_1_2.setForeground(Color.RED);
		lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_1_1_2.setBounds(635, 483, 87, 23);
		event.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("From");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_1.setBounds(611, 516, 48, 23);
		event.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_2 = new JLabel("To");
		lblNewLabel_3_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_2.setBounds(611, 564, 38, 23);
		event.add(lblNewLabel_3_1_1_1_2);
		
		JLabel lblNewLabel_3_1_1_1_3 = new JLabel("Subject");
		lblNewLabel_3_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_3.setBounds(611, 618, 59, 23);
		event.add(lblNewLabel_3_1_1_1_3);
		
		JLabel lblNewLabel_3_1_1_1_4 = new JLabel("Content");
		lblNewLabel_3_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1_1_4.setBounds(611, 668, 72, 23);
		event.add(lblNewLabel_3_1_1_1_4);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(771, 516, 195, 31);
		event.add(textField);
		
		JTextField textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(771, 560, 195, 31);
		event.add(textField_1);
		
		JTextField textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(771, 614, 195, 31);
		event.add(textField_2);
		JScrollPane jScrollArea2 = new JScrollPane(); 
		jScrollArea2.setBounds(751, 668, 273, 90);
		event.add(jScrollArea2);
		
		JTextArea textArea = new JTextArea();
		jScrollArea2.setViewportView(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBackground(new Color(127, 255, 212));
		btnSend.setForeground(new Color(0, 0, 0));
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSend.setBounds(1029, 698, 140, 60);
		btnSend.addActionListener(eventListener);
		event.add(btnSend);
		
		event.setVisible(false);
	}
}

/*event = new JPanel();
event.setBackground(new Color(224, 255, 255));
event.setBounds(280, 0, 1232, 827);



ActionListener eventListener = new EventController(this);

JPanel panel = new JPanel();
panel.setBounds(0, 0, 1232, 161);
event.add(panel);
panel.setLayout(null);

JLabel lblNewLabel_7 = new JLabel("Th\u00F4ng tin l\u1ECBch kh\u00E1m");
lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_7.setBounds(341, 33, 500, 100);
lblNewLabel_7.setBackground(Color.WHITE);
panel.add(lblNewLabel_7);
lblNewLabel_7.setForeground(new Color(0, 0, 0));
lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 30));

JLabel lblNewLabel_10 = new JLabel("New label");
lblNewLabel_10.setBackground(new Color(224, 255, 255));
lblNewLabel_10.setVerticalAlignment(SwingConstants.TOP);
lblNewLabel_10.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("momBgr2.png")).getScaledInstance(1242,161, Image.SCALE_DEFAULT)));
lblNewLabel_10.setBounds(0, 0, 1232, 161);
panel.add(lblNewLabel_10);

event.setLayout(null);

//table
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
scrollPaneEvent.setBounds(10, 354, 500, 417);
event.add(scrollPaneEvent);

dateEvent = new JTextField();
dateEvent.setBounds(640, 334, 195, 31);
dateEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
event.add(dateEvent);
dateEvent.setColumns(10);

nameEvent = new JTextField();
nameEvent.setBounds(640, 282, 195, 31);
nameEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
nameEvent.setColumns(10);
event.add(nameEvent);

desEvent = new JTextArea();
desEvent.setBackground(Color.WHITE);
desEvent.setFont(new Font("Arial", Font.PLAIN, 14));


JScrollPane jScrollArea = new JScrollPane();
jScrollArea.setBounds(957, 580, 253, 136);
event.add(jScrollArea);

JLabel lblNewLabel_3_1 = new JLabel("Name\r\n");
lblNewLabel_3_1.setBounds(582, 290, 48, 23);
lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1);

JLabel lblNewLabel_3_1_1 = new JLabel("Date\r\n");
lblNewLabel_3_1_1.setBounds(582, 338, 38, 23);
lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_1);

JLabel lblNewLabel_3_1_1_1 = new JLabel("Description\r\n");
lblNewLabel_3_1_1_1.setBounds(935, 525, 87, 23);
lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_1_1);

JButton insertEvent = new JButton("Insert");
insertEvent.setBackground(new Color(127, 255, 212));
insertEvent.setBounds(957, 245, 100, 27);
insertEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
insertEvent.addActionListener(eventListener);
event.add(insertEvent);

JButton deleteEvent = new JButton("Delete");
deleteEvent.setBackground(new Color(127, 255, 212));
deleteEvent.setBounds(957, 315, 100, 27);
deleteEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
deleteEvent.addActionListener(eventListener);
event.add(deleteEvent);

JButton resetEvent = new JButton("Reset");
resetEvent.setBackground(new Color(127, 255, 212));
resetEvent.setBounds(957, 390, 100, 27);
resetEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
resetEvent.addActionListener(eventListener);
event.add(resetEvent);

JLabel lblNewLabel_3_1_2 = new JLabel("Name\r\n");
lblNewLabel_3_1_2.setBounds(296, 185, 48, 23);
lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_2);

searchTextEvent = new JTextField();
searchTextEvent.setBounds(669, 243, 140, 31);
searchTextEvent.setFont(new Font("Tahoma", Font.PLAIN, 14));
searchTextEvent.setColumns(10);
event.add(searchTextEvent);

JButton searchEvent = new JButton("Search");
searchEvent.setBackground(new Color(127, 255, 212));
searchEvent.setBounds(558, 245, 100, 27);
searchEvent.setFont(new Font("Tahoma", Font.BOLD, 14));
searchEvent.addActionListener(eventListener);
event.add(searchEvent);

JLabel lblNewLabel_3_1_1_2 = new JLabel("Send Mail");
lblNewLabel_3_1_1_2.setBounds(558, 477, 87, 23);
lblNewLabel_3_1_1_2.setForeground(Color.RED);
lblNewLabel_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
event.add(lblNewLabel_3_1_1_2);

JLabel lblNewLabel_3_1_1_1_1 = new JLabel("From");
lblNewLabel_3_1_1_1_1.setBounds(558, 531, 48, 23);
lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_1_1_1);

JLabel lblNewLabel_3_1_1_1_2 = new JLabel("To");
lblNewLabel_3_1_1_1_2.setBounds(558, 591, 38, 23);
lblNewLabel_3_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_1_1_2);

JLabel lblNewLabel_3_1_1_1_3 = new JLabel("Subject");
lblNewLabel_3_1_1_1_3.setBounds(558, 638, 59, 23);
lblNewLabel_3_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_1_1_3);

JLabel lblNewLabel_3_1_1_1_4 = new JLabel("Content");
lblNewLabel_3_1_1_1_4.setBounds(558, 671, 72, 23);
lblNewLabel_3_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
event.add(lblNewLabel_3_1_1_1_4);

JTextField textField = new JTextField();
textField.setBounds(648, 527, 195, 31);
textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
textField.setColumns(10);
event.add(textField);

JTextField textField_1 = new JTextField();
textField_1.setBounds(648, 587, 195, 31);
textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
textField_1.setColumns(10);
event.add(textField_1);

JTextField textField_2 = new JTextField();
textField_2.setBounds(648, 634, 195, 31);
textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
textField_2.setColumns(10);
event.add(textField_2);
JScrollPane jScrollArea2 = new JScrollPane();
jScrollArea2.setBounds(566, 714, 273, 90);
event.add(jScrollArea2);

JButton btnSend = new JButton("Send");
btnSend.setBackground(new Color(127, 255, 212));
btnSend.setBounds(1092, 477, 140, 60);
btnSend.setForeground(new Color(0, 0, 0));
btnSend.setFont(new Font("Tahoma", Font.BOLD, 18));
btnSend.addActionListener(eventListener);
event.add(btnSend);

//JLabel lblNewLabel_7 = new JLabel("New label");
//lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
//lblNewLabel_7.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("event.png")).getScaledInstance(1242, 666, Image.SCALE_DEFAULT)));
//lblNewLabel_7.setBounds(0, 0, 1242, 666);
//event.add(lblNewLabel_7);*/

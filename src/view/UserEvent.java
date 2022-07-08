package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UserEventController;
import dao.EventDAO;
import model.core.Event;

import javax.swing.JLabel;
import java.awt.Color;

public class UserEvent extends JFrame {
	public UserView userView;
	public ArrayList<Event> list;
	private JPanel contentPane;
	public JTable tableEvent;
	public JTextField searchTextEvent;
	
	public UserEvent(UserView userView) { 
		this.userView = userView;
		list = EventDAO.getInstance().select();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setTitle("Event");
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ActionListener listener = new UserEventController(this);
		
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
		scrollPaneEvent.setBounds(105,139,792,326);
		contentPane.add(scrollPaneEvent);
		
		searchTextEvent = new JTextField();
		searchTextEvent.setText("Describe...");
		searchTextEvent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchTextEvent.setColumns(10);
		searchTextEvent.setBounds(268, 68, 466, 37);
		contentPane.add(searchTextEvent);
		
		JLabel lblNewLabel = new JLabel("Event");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(458, 11, 83, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(127, 255, 212));
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(758, 68, 139, 37);
		btnSearch.addActionListener(listener);
		contentPane.add(btnSearch);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBackground(new Color(127, 255, 212));
		btnBook.setForeground(new Color(0, 0, 0));
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBook.setBounds(758, 496, 139, 37);
		btnBook.addActionListener(listener);
		contentPane.add(btnBook);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(127, 255, 212));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(588, 496, 139, 37);
		btnReset.addActionListener(listener);
		contentPane.add(btnReset);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 976, 58);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 58, 976, 495);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("medical.jpg")).getScaledInstance(976, 495, Image.SCALE_DEFAULT)));
		
		contentPane.add(lblNewLabel_1);
		
		this.setVisible(true);
	}
}

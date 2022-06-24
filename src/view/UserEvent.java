package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(458, 11, 83, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(758, 68, 139, 37);
		btnSearch.addActionListener(listener);
		contentPane.add(btnSearch);
		
		JButton btnBook = new JButton("Book");
		btnBook.setForeground(new Color(0, 0, 128));
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBook.setBounds(758, 496, 139, 37);
		btnBook.addActionListener(listener);
		contentPane.add(btnBook);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 0, 128));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(588, 496, 139, 37);
		btnReset.addActionListener(listener);
		contentPane.add(btnReset);
		
		this.setVisible(true);
	}
}

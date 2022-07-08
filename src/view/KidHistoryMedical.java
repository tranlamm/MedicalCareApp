package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.KidHistoryController;
import dao.HistoryMedicalDAO;
import model.core.HistoryMedical;
import model.core.Kid;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class KidHistoryMedical extends JFrame {
	public Kid kid;
	public JPanel contentPane;
	public JTextField typeText;
	public JTextField dateText;
	public JTextField idText;
	public JTextField interactionText;
	public JTextField searchText;
	public JTable table;
	public ArrayList<HistoryMedical> list;
	/**
	 * @wbp.nonvisual location=-27,54
	 */
	private final JPanel panel = new JPanel();
	
	/**
	 * Create the frame.
	 */
	public KidHistoryMedical(Kid kid) {
		this.kid = kid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("History Medical");
		this.setLocationRelativeTo(null);
		this.list = HistoryMedicalDAO.getInstance().select(this.kid.getID());
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ActionListener listener = new KidHistoryController(this);
		
		JLabel lblNewLabel = new JLabel("History Medical");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(295, 11, 194, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(368, 411, 102, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Interaction");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(34, 472, 102, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID vaccine");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(34, 411, 102, 35);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(368, 472, 77, 35);
		contentPane.add(lblNewLabel_1_3);
		
		typeText = new JTextField();
		typeText.setBounds(423, 413, 164, 35);
		contentPane.add(typeText);
		typeText.setColumns(10);
		
		dateText = new JTextField();
		dateText.setColumns(10);
		dateText.setBounds(423, 474, 164, 35);
		contentPane.add(dateText);
		
		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(133, 413, 164, 35);
		contentPane.add(idText);
		
		interactionText = new JTextField();
		interactionText.setColumns(10);
		interactionText.setBounds(133, 474, 164, 35);
		contentPane.add(interactionText);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(127, 255, 212));
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(634, 74, 102, 35);
		btnSearch.addActionListener(listener);
		contentPane.add(btnSearch);
		
		searchText = new JTextField();
		searchText.setColumns(10);
		searchText.setBounds(176, 74, 442, 35);
		contentPane.add(searchText);
		
		JLabel lblNewLabel_1_4 = new JLabel("Type of vaccine");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(35, 73, 148, 35);
		contentPane.add(lblNewLabel_1_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID vaccine", "Date of Injection", "Type of vaccine", "Interaction"
			}
		));
		table.setRowHeight(table.getRowHeight() + 20);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35,138,701,243);
		contentPane.add(scrollPane);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBackground(new Color(127, 255, 212));
		btnInsert.setForeground(new Color(0, 0, 0));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.setBounds(634, 411, 102, 35);
		btnInsert.addActionListener(listener);
		contentPane.add(btnInsert);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(127, 255, 212));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(634, 472, 102, 35);
		btnReset.addActionListener(listener);
		contentPane.add(btnReset);	
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("medical.jpg")).getScaledInstance(782, 435, Image.SCALE_DEFAULT)));
		
		lblNewLabel_2.setBounds(0, 128, 782, 435);
		contentPane.add(lblNewLabel_2);
		
//		JLabel backgroundEvent = new JLabel("New label");
//		backgroundEvent.setBounds(0, 161, 1261, 703);
//		backgroundEvent.setVerticalAlignment(SwingConstants.TOP);
//		backgroundEvent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MainView.class.getResource("medical.jpg")).getScaledInstance(1541, 702, Image.SCALE_DEFAULT)));
//		backgroundEvent.setBounds(0, 161, 1251, 673);
//		event.add(backgroundEvent);
//		
		
		this.setVisible(true);
	}
}

package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.MomDetailController;
import model.core.Mom;
import model.core.WeightHeight;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class MomDetail extends JFrame {
	public Mom mom;
	
	private JPanel contentPane;
	public DefaultCategoryDataset dataset;
	public JTextField appoint;
	public JTextField status;
	public JTextField edd;
	public JTextField dateText;
	public JTextField weightText;
	public JTable table;

	public MomDetail(Mom mom) {
		this.mom = mom;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setTitle("Details");
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ActionListener listener = new MomDetailController(this);
		
		ChartPanel chartPanel = new ChartPanel(createLineChart());
		chartPanel.setBounds(40, 45, 634, 325);
		contentPane.add(chartPanel);
		
		JLabel lblNewLabel = new JLabel("Appointment");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(707, 435, 110, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblHealthStatus = new JLabel("Health Status");
		lblHealthStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHealthStatus.setBounds(707, 498, 110, 25);
		contentPane.add(lblHealthStatus);
		
		JLabel lblEdd = new JLabel("EDD");
		lblEdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdd.setBounds(707, 566, 65, 25);
		contentPane.add(lblEdd);
		
		appoint = new JTextField();
		appoint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		appoint.setBounds(827, 431, 147, 33);
		contentPane.add(appoint);
		appoint.setColumns(10);
		
		status = new JTextField();
		status.setFont(new Font("Tahoma", Font.PLAIN, 14));
		status.setColumns(10);
		status.setBounds(827, 494, 147, 33);
		contentPane.add(status);
		
		edd = new JTextField();
		edd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		edd.setColumns(10);
		edd.setBounds(827, 562, 147, 33);
		contentPane.add(edd);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(707, 101, 52, 25);
		contentPane.add(lblDate);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWeight.setBounds(707, 157, 52, 25);
		contentPane.add(lblWeight);
		
		dateText = new JTextField();
		dateText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateText.setColumns(10);
		dateText.setBounds(827, 97, 147, 33);
		contentPane.add(dateText);
		
		weightText = new JTextField();
		weightText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		weightText.setColumns(10);
		weightText.setBounds(827, 153, 147, 33);
		contentPane.add(weightText);
		
		JButton insertBtn = new JButton("Insert");
		insertBtn.setForeground(new Color(0, 0, 128));
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.setBounds(781, 220, 121, 33);
		insertBtn.addActionListener(listener);
		contentPane.add(insertBtn);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(new Color(0, 0, 128));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirm.setBounds(781, 618, 121, 33);
		btnConfirm.addActionListener(listener);
		contentPane.add(btnConfirm);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Appointment", "Health Status", "EDD"
			}
		));
		table.setRowHeight(52);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40,435,635,79);
		contentPane.add(scrollPane);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setValueAt(mom.getAppointment(), 0, 0);
		model_table.setValueAt(mom.getHealthStatus(), 0, 1);
		model_table.setValueAt(mom.getEDD(), 0, 2);
		
		this.setVisible(true);
	}
	
    private DefaultCategoryDataset createDataset() {
        dataset = new DefaultCategoryDataset();
        
        ArrayList<WeightHeight> list = mom.getWeight();
        
        for (WeightHeight x:list)
        {
        	double tmp = x.getWeight();
        	String date = x.getDate();
        	dataset.addValue(tmp, "Weight", date);
        }
        
        return dataset;
    }

    public JFreeChart createLineChart() {
    	JFreeChart lineChart = ChartFactory.createLineChart(
                "",

                "Date", "Weight", createDataset(),

                PlotOrientation.VERTICAL, false, false, false);

        return lineChart;
    }
    
}

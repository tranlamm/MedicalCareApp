package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import controller.KidWHController;
import dao.KidDAO;
import model.core.Kid;
import model.core.WeightHeight;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class KidWeightHeight extends JFrame {
	public Kid kid;
	
	private JPanel contentPane;
	public XYSeriesCollection datasetWeight;
	public XYSeries series1;
	public double count;
	public XYSeriesCollection datasetHeight;
	public XYSeries series1H;
	public double countH;
	
	public JTextField ageWeight;
	public JTextField weightText;
	public JTextField ageHeight;
	public JTextField heightText;

	public KidWeightHeight(Kid kid) {
		this.kid = kid;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setTitle("Weight Height");
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ActionListener listener = new KidWHController(this);
		
		ChartPanel chartPanelWeight = new ChartPanel(createLineChartWeight());
		chartPanelWeight.setBounds(50, 100, 500, 320);
		contentPane.add(chartPanelWeight);
		
		ChartPanel chartPanelHeight = new ChartPanel(createLineChartHeight());
		chartPanelHeight.setBounds(630, 100, 500, 320);
		contentPane.add(chartPanelHeight);
		
		JLabel lblNewLabel = new JLabel("Weight & Height");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(482, 25, 222, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(50, 463, 69, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Weight");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(50, 523, 69, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(630, 463, 69, 38);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Height");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(630, 523, 69, 38);
		contentPane.add(lblNewLabel_1_3);
		
		ageWeight = new JTextField();
		ageWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ageWeight.setBounds(129, 464, 174, 38);
		contentPane.add(ageWeight);
		ageWeight.setColumns(10);
		
		weightText = new JTextField();
		weightText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		weightText.setColumns(10);
		weightText.setBounds(129, 524, 174, 38);
		contentPane.add(weightText);
		
		ageHeight = new JTextField();
		ageHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ageHeight.setColumns(10);
		ageHeight.setBounds(709, 464, 174, 38);
		contentPane.add(ageHeight);
		
		heightText = new JTextField();
		heightText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heightText.setColumns(10);
		heightText.setBounds(709, 524, 174, 38);
		contentPane.add(heightText);
		
		JButton weightBtn = new JButton("Add Weight");
		weightBtn.setForeground(new Color(0, 0, 128));
		weightBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		weightBtn.setBounds(330, 520, 141, 44);
		weightBtn.addActionListener(listener);
		contentPane.add(weightBtn);
		
		JButton heightBtn = new JButton("Add Height");
		heightBtn.setForeground(new Color(0, 0, 128));
		heightBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		heightBtn.setBounds(913, 520, 141, 44);
		heightBtn.addActionListener(listener);
		contentPane.add(heightBtn);
		
		this.setVisible(true);
	}
	
	private XYDataset createDatasetWeight() {
        datasetWeight = new XYSeriesCollection();
        
        series1 = new XYSeries("Weight");
        XYSeries series2 = new XYSeries("Upper Bound");
        XYSeries series3 = new XYSeries("Lower Bound"); 
        
        ArrayList<WeightHeight> list = kid.getWeight();
        count = 3;
        for (WeightHeight x:list)
        {
        	double tmp = x.getWeight();
        	series1.add(count, tmp);
        	count += 0.5;
        }
  
        series2.add(3, 10.8);
		series2.add(3.5, 11.6);
		series2.add(4, 12.3);
		series2.add(4.5, 13);
    	series2.add(5, 13.7);
		series2.add(5.5, 14.6);
		series2.add(6, 15.3);
		series2.add(6.5, 16);
		series2.add(7, 16.8);
		series2.add(7.5, 17.6);
		series2.add(8, 18.6);
		series2.add(8.5, 19.6);
		series2.add(9, 20.8);
		series2.add(9.5, 22);
		series2.add(10, 23.3);
		
		series3.add(3, 18.1);
		series3.add(3.5, 19.8);
		series3.add(4, 21.5);
		series3.add(4.5, 23.2);
    	series3.add(5, 24.9);
		series3.add(5.5, 26.2);
		series3.add(6, 27.8);
		series3.add(6.5, 29.6);
		series3.add(7, 31.4);
		series3.add(7.5, 33.5);
		series3.add(8, 35.8);
		series3.add(8.5, 38.3);
		series3.add(9, 41);
		series3.add(9.5, 43.8);
		series3.add(10, 46.9);
       
        datasetWeight.addSeries(series1);
        datasetWeight.addSeries(series2);
        datasetWeight.addSeries(series3);
        return datasetWeight;
    }

    public void customize(JFreeChart chart)
    {
    	XYPlot plot = chart.getXYPlot();
    	XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    	
    	renderer.setSeriesPaint(0, Color.GREEN);
    	renderer.setSeriesPaint(1, Color.ORANGE);
    	renderer.setSeriesPaint(2, Color.RED);
    	
    	renderer.setSeriesStroke(0, new BasicStroke(2.0f));
    	renderer.setSeriesStroke(1, new BasicStroke(1.0f));
    	renderer.setSeriesStroke(2, new BasicStroke(1.0f));
    	
    	plot.setOutlinePaint(Color.BLUE);
    	plot.setOutlineStroke(new BasicStroke(2.0f));
    	
    	plot.setRenderer(renderer);
    }
    
    public JFreeChart createLineChartWeight() {
    	JFreeChart chart = ChartFactory.createXYLineChart("Weight", "Age", "Weight", createDatasetWeight());
    	customize(chart);
    	return chart;
    }
    
    private XYDataset createDatasetHeight() {
        datasetHeight = new XYSeriesCollection();
        
        series1H = new XYSeries("Height");
        XYSeries series2 = new XYSeries("Upper Bound");
        XYSeries series3 = new XYSeries("Lower Bound"); 
        
        ArrayList<WeightHeight> list = kid.getHeight();
        countH = 3;
        for (WeightHeight x:list)
        {
        	int tmp = x.getHeight();
        	series1H.add(countH, tmp);
        	countH += 0.5;
        }
  
        series2.add(3, 77);
		series2.add(3.5, 81);
		series2.add(4, 84);
		series2.add(4.5, 87);
    	series2.add(5, 90);
		series2.add(5.5, 92);
		series2.add(6, 95);
		series2.add(6.5, 97);
		series2.add(7, 100);
		series2.add(7.5, 102);
		series2.add(8, 105);
		series2.add(8.5, 107);
		series2.add(9, 110);
		series2.add(9.5, 113);
		series2.add(10, 116);
		
		series3.add(3, 103);
		series3.add(3.5, 106);
		series3.add(4, 109);
		series3.add(4.5, 112);
    	series3.add(5, 115);
		series3.add(5.5, 119);
		series3.add(6, 123);
		series3.add(6.5, 127);
		series3.add(7, 132);
		series3.add(7.5, 137);
		series3.add(8, 142);
		series3.add(8.5, 147);
		series3.add(9, 152);
		series3.add(9.5, 158);
		series3.add(10, 164);
       
        datasetHeight.addSeries(series1H);
        datasetHeight.addSeries(series2);
        datasetHeight.addSeries(series3);
        return datasetHeight;
    }
    
    public JFreeChart createLineChartHeight() {
    	JFreeChart chart = ChartFactory.createXYLineChart("Height", "Age", "Height", createDatasetHeight());
    	customize(chart);
    	return chart;
    }
}

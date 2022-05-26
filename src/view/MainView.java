package view;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.NavBarController;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTable;

public class MainView extends JFrame {
	private JPanel contentPane;
	public JPanel mom;
	public JPanel kid;
	public JPanel clinic;
	public JPanel event;

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
		navBar.setBackground(new Color(0, 255, 255));
		navBar.setBounds(0, 0, 280, 730);
		navBar.setLayout(null);
		contentPane.add(navBar);
		
		JButton btnMom = new JButton("Mom");
		btnMom.setBackground(UIManager.getColor("Button.darkShadow"));
		btnMom.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMom.setBounds(0, 165, 278, 70);
		btnMom.addActionListener(navBarListener);
		navBar.add(btnMom);
		
		JButton btnKid = new JButton("Kid");
		btnKid.setBackground(UIManager.getColor("Button.darkShadow"));
		btnKid.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnKid.setBounds(0, 245, 278, 70);
		btnKid.addActionListener(navBarListener);
		navBar.add(btnKid);
		
		JButton btnClinic = new JButton("Clinic");
		btnClinic.setBackground(UIManager.getColor("Button.darkShadow"));
		btnClinic.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClinic.setBounds(0, 325, 278, 70);
		btnClinic.addActionListener(navBarListener);
		navBar.add(btnClinic);
		
		JButton btnEvent = new JButton("Event");
		btnEvent.setBackground(UIManager.getColor("Button.darkShadow"));
		btnEvent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEvent.setBounds(0, 405, 278, 70);
		btnEvent.addActionListener(navBarListener);
		navBar.add(btnEvent);
		
		jPanelMom();
		jPanelKid();
		jPanelClinic();
		jPanelEvent();
	
		contentPane.add(mom);
		mom.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin thai ph\u1EE5");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(417, 111, 535, 144);
		mom.add(lblNewLabel);
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
		mom.setVisible(false);
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

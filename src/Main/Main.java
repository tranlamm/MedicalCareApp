package main;

import javax.swing.UIManager;

import view.SignInView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SignInView signInView = new SignInView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

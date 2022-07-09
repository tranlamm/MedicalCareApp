package main;

import view.SignInView;

public class Main  {
	public static void main(String[] args) {
		try {
			new SignInView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

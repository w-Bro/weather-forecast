package com.ui.main;

import javax.swing.UnsupportedLookAndFeelException;

import com.ui.frame.MainFrame;

public class Main {

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
			new MainFrame().setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

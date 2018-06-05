package jinhyuk;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class SelectLevel {
	JDialog dialogSelctLevel;
	JButton buttonEasy;
	JButton buttonNormal;
	JButton buttonHard;

	public SelectLevel(MainScreen mainScreen) {

		buttonEasy = new JButton("Easy");
		buttonEasy.setFont(new Font("GOTHIC", Font.BOLD, 15));
		buttonEasy.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new CardPuzzle(8);
				dialogSelctLevel.dispose();
				mainScreen.dispose();
			}
		});
		
		buttonNormal = new JButton("Normal");
		buttonNormal.setFont(new Font("GOTHIC", Font.BOLD, 15));
		buttonNormal.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new CardPuzzle(16);
				dialogSelctLevel.dispose();
				mainScreen.dispose();
			}
		});
		
		buttonHard = new JButton("Hard");
		buttonHard.setFont(new Font("GOTHIC", Font.BOLD, 15));
		buttonHard.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new CardPuzzle(20);
				dialogSelctLevel.dispose();
				mainScreen.dispose();
			}
		});
		
		dialogSelctLevel = new JDialog();
		dialogSelctLevel.setLayout(new GridLayout(3, 1));
		dialogSelctLevel.setBounds(400, 300, 250, 150);
		dialogSelctLevel.add(buttonEasy);
		dialogSelctLevel.add(buttonNormal);
		dialogSelctLevel.add(buttonHard);
        dialogSelctLevel.setLocation(850,450);
        dialogSelctLevel.setVisible(true);
	}

}

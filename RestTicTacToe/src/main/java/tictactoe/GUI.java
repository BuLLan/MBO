package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

	JFrame jf;
	Draw draw;
	JButton btnReset;
	JButton btnHelp;
	JButton btnHelpC;
	
	
	static JButton btn[] = new JButton[9];
	
	static int state[] = new int[9];
	static int player = 1;
	static int winner = 0;
	static int winnerLine = 0;
	static int help = 0;
	
	public GUI() {
		jf = new JFrame();
		jf.setSize(800,600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setTitle("Tic Tac Toe");
		
		for(int i = 0; i<btn.length; i++) {
			btn[i] = new JButton();
			btn[i].setVisible(true);
			btn[i].addActionListener(new ActionHandler());
			btn[i].setFocusPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].setBorder(null);
			jf.add(btn[i]);
		}
		
		ButtonPlacement.place();
		
		btnReset = new JButton("Neustart");
		btnReset.setBounds(675, 510, 100, 40);
		btnReset.setVisible(true);
		btnReset.setFocusPainted(false);
		btnReset.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Game.reset();
				
			}
		});
		
		jf.add(btnReset);
		
		
		btnHelp = new JButton("Hilfe");
		btnHelp.setBounds(100, 510, 100, 40);
		btnHelp.setVisible(true);
		btnHelp.setFocusPainted(false);
		btnHelp.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				help = 1;	
				btnHelpC.setVisible(true);
			}
			
				
		});
		jf.add(btnHelp);
		
		btnHelpC = new JButton();
		btnHelpC.setBounds(650, 100, 50, 50);
		btnHelpC.setVisible(false);
		btnHelpC.setFocusPainted(false);
		btnHelpC.setContentAreaFilled(false);
		btnHelpC.setBorder(null);
		btnHelpC.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				help = 0;
				btnHelpC.setVisible(false);
			}
			
				
		});
		jf.add(btnHelpC);
		
		draw = new Draw();
		draw.setBounds(0,0,800,600);
		draw.setVisible(true);
		jf.add(draw);
		
		jf.setVisible(true);
	}

}

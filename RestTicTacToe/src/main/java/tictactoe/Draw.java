package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {
	
	private static final long serialVersionUID = 1L;

	protected void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//draw
		g.setColor(Color.BLACK);
		
		//Vertikal
		g.drawLine(325, 75, 325, 525);
		g.drawLine(475, 75, 475, 525);
		
		//Horizontal
		g.drawLine(175, 225, 625, 225);
		g.drawLine(175, 375, 625, 375);
		
		//Beschriftungen
		g.drawString("A1", 305, 90);
		g.drawString("B1", 455, 90);
		g.drawString("C1", 605, 90);
		
		g.drawString("A2", 305, 240);
		g.drawString("B2", 455, 240);
		g.drawString("C2", 605, 240);
		
		g.drawString("A3", 305, 390);
		g.drawString("B3", 455, 390);
		g.drawString("C3", 605, 390);
		
		// Player-Anzeige
		if(GUI.player == 1) {
			g.drawString("Es ist dran: Spieler 1", 25, 50);
		} else if(GUI.player == 2) {
			g.drawString("Es ist dran: Spieler 2", 25, 50);
		}
		
		for(int i = 0; i < GUI.state.length; i++) {
			Rectangle bounds = GUI.btn[i].getBounds();
			
			if(GUI.state[i] == 1) {
				g.drawImage(ImageLoader.imgX, bounds.x, bounds.y, bounds.width, bounds.height, null);
			} else if(GUI.state[i] == 2) {
				g.drawImage(ImageLoader.imgO, bounds.x, bounds.y, bounds.width, bounds.height, null);
			}
		}
		
		//GewinnerLinie
		if (GUI.winnerLine == 1) {
			g.setColor(Color.RED);
			g.drawLine(175, 150, 625, 150);
		}
		if (GUI.winnerLine == 2) {
			g.setColor(Color.RED);
			g.drawLine(175, 300, 625, 300);
		}
		if (GUI.winnerLine == 3) {
			g.setColor(Color.RED);
			g.drawLine(175, 450, 625, 450);
		}
		if (GUI.winnerLine == 4) {
			g.setColor(Color.RED);
			g.drawLine(250, 75, 250, 525);
		}
		if (GUI.winnerLine == 5) {
			g.setColor(Color.RED);
			g.drawLine(400, 75, 400, 525);
		}
		if (GUI.winnerLine == 6) {
			g.setColor(Color.RED);
			g.drawLine(550, 75, 550, 525);
		}
		if (GUI.winnerLine == 7) {
			g.setColor(Color.RED);
			g.drawLine(175, 75, 625, 525);
		}
		if (GUI.winnerLine == 8) {
			g.setColor(Color.RED);
			g.drawLine(625, 75, 175, 525);
		}
		
		//Gewinneranzeige
		if(GUI.winner != 0) {
			g.setColor(Color.WHITE);
			g.fillRect(100, 200, 600, 200);
			g.setColor(Color.BLACK);
			g.drawRect(100, 200, 600, 200);
			g.setFont(new Font(null, Font.PLAIN, 20)); 
			g.drawString("Spieler "+GUI.winner+" hat gewonnen!" , 280, 300);
			g.setFont(new Font(null, Font.PLAIN, 10));
			g.drawString("Für Neustart bitte auf Neustart klicken" , 300, 320);
		}
		
		//Hilfsfeld
		if(GUI.help == 1) {
			g.setColor(Color.WHITE);
			g.fillRect(100, 100, 600, 400);
			g.setColor(Color.BLACK);
			g.drawRect(100, 100, 600, 400);
			g.setFont(new Font(null, Font.PLAIN, 12)); 
			g.drawString("Das Spiel TicTacToe ist sowohl über Maus als auch per Sprachsteuerung zu bedienen", 120, 130);
			g.drawString("Der Spieler, der dran ist, kann entweder per Klick in das entsprechende Feld", 120, 170);
			g.drawString("oder per Sprachbefehl für Spieler 1: Kreuz in Feld A1 (für das Feld oben links)", 120, 190);
			g.drawString("sein Zeichen eintragen", 120, 210);
			
			g.drawString("Zusätzlich sind folgende Sprachbefehle integriert:", 120, 250);
			g.drawString("Reihe A: Für das Ansagen der Zeichen in Reihe A", 140, 270);
			g.drawString("Spalte 1: Für das Ansagen der Zeichen in Spalte 1", 140, 290);
			g.drawString("Neustart: Für das Starten eines neuen Spiels", 140, 310);
			g.setFont(new Font(null, Font.PLAIN, 20)); 
			g.drawString("[x]", 665, 130);
		}
		
		repaint();
		
		
	}
}

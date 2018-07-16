package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("test");
		for(int i = 0; i < GUI.btn.length; i++) {
			if(GUI.winner == 0) {
				if (e.getSource() == GUI.btn[i]) {
					
					if(GUI.state[i] == 0 && GUI.player == 1) {
						GUI.state[i] = 1;
						Game.check(GUI.player);
						GUI.player = 2;
					} else if (GUI.state[i] == 0 && GUI.player == 2) {
						GUI.state[i] = 2;
						Game.check(GUI.player);
						GUI.player = 1;
					}
					
				}
				
			}
		}
	}

}

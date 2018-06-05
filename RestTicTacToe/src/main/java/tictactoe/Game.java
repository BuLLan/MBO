package tictactoe;

public class Game {
	public static void reset() {
		
		for(int i = 0; i<GUI.state.length; i++ ) {
			GUI.state[i] = 0;
		}
		
		GUI.player = 1;
		GUI.winner = 0;
		GUI.winnerLine = 0;
	}
	
	public static void check(int player) {
		if (GUI.winner == 0) {
			if (GUI.state[0] == player && GUI.state[1] == player && GUI.state[2] == player) {
				GUI.winner = player;
				GUI.winnerLine = 1;
			} else if (GUI.state[3] == player && GUI.state[4] == player && GUI.state[5] == player) {
				GUI.winner = player;
				GUI.winnerLine = 2;
			} else if (GUI.state[6] == player && GUI.state[7] == player && GUI.state[8] == player) {
				GUI.winner = player;
				GUI.winnerLine = 3;
			} else if (GUI.state[0] == player && GUI.state[3] == player && GUI.state[6] == player) {
				GUI.winner = player;
				GUI.winnerLine = 4;
			} else if (GUI.state[1] == player && GUI.state[4] == player && GUI.state[7] == player) {
				GUI.winner = player;
				GUI.winnerLine = 5;
			} else if (GUI.state[2] == player && GUI.state[5] == player && GUI.state[8] == player) {
				GUI.winner = player;
				GUI.winnerLine = 6;
			} else if (GUI.state[0] == player && GUI.state[4] == player && GUI.state[8] == player) {
				GUI.winner = player;
				GUI.winnerLine = 7;
			} else if (GUI.state[2] == player && GUI.state[4] == player && GUI.state[6] == player) {
				GUI.winner = player;
				GUI.winnerLine = 8;
			}			
		}
	}
}

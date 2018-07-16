package tictactoe;

import java.util.ArrayList;

public class Template {
	
	ArrayList<Integer> xL = new ArrayList<Integer>();
	ArrayList<Integer> yL = new ArrayList<Integer>();

	public Template(ArrayList<Integer> xL, ArrayList<Integer> yL) {
		this.xL = xL;
		this.yL = yL;
	}

	public ArrayList<Integer> getxL() {
		return xL;
	}

	public void setxL(ArrayList<Integer> xL) {
		this.xL = xL;
	}

	public ArrayList<Integer> getyL() {
		return yL;
	}

	public void setyL(ArrayList<Integer> yL) {
		this.yL = yL;
	}
	
	
}

package tictactoe;

import tictactoe.Template;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {
	private JPanel mousepanel;
	private ArrayList<Integer> xList = new ArrayList<Integer>();
	private ArrayList<Integer> yList = new ArrayList<Integer>();
	private double distance;
	private double winkel;
	private double distanceX;
	private double distanceO;
	private double distanceR;
	private double distanceH;
	private double minDist;
	Template created;
	Template X;
	Template O;
	Template R;
	Template H;

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
            btn[i].addMouseMotionListener(new MouseMotionListener() {
                public void mouseMoved(MouseEvent e) {

                }

                public void mouseDragged(MouseEvent e) {
                    if(SwingUtilities.isRightMouseButton(e)) {
                        xList.add(e.getX()); // Mausbewegung X-Koord aufzeichen
                        yList.add(e.getY()); // Mausbewegung Y-Koord aufzeichen
//
                    }
                }
            });
            btn[i].addMouseListener(new MouseListener() {
                public void mouseEntered(MouseEvent e ) {

                }
                public void mouseExited(MouseEvent e) {

                }
                public void mouseClicked(MouseEvent e) {

                }
                public void mousePressed(MouseEvent e ) {

                }
                public void mouseReleased(MouseEvent e) {
                    if(SwingUtilities.isRightMouseButton(e)) {
                       // System.out.println(xList);
                       // System.out.println(yList);

                        H = generateH();
                        R = generateR();
                        X = generateX();
                        O = generateO();
                        created = new Template(xList, yList);
                        distanceX = dtw(X, created);
                        distanceO = dtw(O, created);
                        distanceR = dtw(R, created);
                        distanceH = dtw(H, created);
                        minDist = Math.min(Math.min(Math.min(distanceO, distanceX), distanceR), distanceH);
                        if (minDist == distanceO) {
                            System.out.println("O");
                        }
                        else if (minDist == distanceX) {
                            System.out.println("X");
                        }
                        else if (minDist == distanceR) {
                            System.out.println("RESTART");
                        }
                        else if (minDist == distanceH){
                            System.out.println("HELP");
                        }
                        //TODO: Alert werfen
                        else{
                            System.out.println("WAS SOLL DAS SEIN?!");
                        }
                    }
                    xList.clear();
                    yList.clear();
                }
            });
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
    public Double distance(int a0, int a1, int b0, int b1) {
        distance = 0d;
        distance = Math.sqrt(Math.pow(b0-a0, 2) + Math.pow(b1-a1, 2));
        return distance;
    }

    public Double winkel(int a0, int a1, int b0, int b1, int c0, int c1) {
        winkel = 0d;
        winkel = Math.acos((-Math.pow(distance(a0,a1,c0,c1), 2) + Math.pow(distance(a0,a1,b0,b1), 2) +
                Math.pow(distance(b0,b1,c0,c1), 2)) / (2 * distance(a0,a1,b0,b1) * distance(b0,b1,c0,c1)));
        return winkel;
    }

    public ArrayList<Double> createWinkelList(Template t) {
        ArrayList<Double> list = new ArrayList<Double>();
        list.add(Math.PI);
        list.add(Math.PI);
        double d = 0d;
        for (int i=2; i<t.getxL().size(); i++) {
            d = winkel(t.getxL().get(0), t.getyL().get(0),t.getxL().get(i-1), t.getyL().get(i -1), t.getxL().get(i), t.getyL().get(i));
            if (!Double.isNaN(d) || d==Double.NaN) {
                list.add(d);
            }
        }
        return list;
    }

    public double winkelDist(double d1, double d2) {
        double d = Math.abs(d1-d2);
        if (d < Math.PI) {
            return (d/Math.PI);
        } else {
            return (2- (d/Math.PI));
        }
    }

    public double[][] distanceMatrix(Template t1, Template t2) {
        ArrayList<Double> list1 = new ArrayList<Double>();
        ArrayList<Double> list2 = new ArrayList<Double>();
        list1 = createWinkelList(t1);
        list2 = createWinkelList(t2);
        double[][] d = new double[list1.size()][list2.size()];

        double windist;
        for (int i=0; i < list1.size(); i++) {

            for (int j=0; j < list2.size(); j++) {
                windist=winkelDist(list1.get(i), list2.get(j));
                if (i==0 && j==0) {
                    d[i][j] = windist;
                }
                else if (i>0 && j==0) {
                    d[i][j] = windist + d[i-1][j];
                }
                else if (i==0 && j>0) {
                    d[i][j] = windist + d[i][j-1];
                }
                else {
                    d[i][j] = windist + Math.min(Math.min(d[i-1][j-1], d[i][j-1]), d[i-1][j]);
                }
            }
        }
        return d;
    }

    public double dtw(Template t1, Template t2) {
        double[][] d = distanceMatrix(t1,t2);
        double dist = 0;
        int m = d.length -1;
        int n = d[0].length -1;
        // System.out.print("("+m +"," + n + ") ");
        while (true) {
            // System.out.print("("+m +"," + n + ") ");
            if (m > 0 && n > 0) {
                if (m != (d.length - 1) && n != (d[0].length - 1)) {
                    dist = dist + d[m][n];
                } else {
                    dist = d[d.length-1][d[0].length-1];
                }

                if (d[m-1][n] < d[m-1][n-1] && d[m-1][n] < d[m][n-1]) {
                    m--;
                } else if (d[m][n-1] < d[m-1][n-1] && d[m-1][n-1] < d[m-1][n]) {
                    n--;
                } else {
                    m--;
                    n--;
                }

            } else if (m == 0 && n > 0) {
                dist = dist + d[m][n];
                n--;

            } else if (m > 0 && n == 0) {
                dist = dist + d[m][n];
                m--;
            } else if (m == 0 && n == 0) {
                dist = dist + d[m][n];
                break;
            }
        }
        dist = dist / (d.length + d[0].length);
        return dist;
    }
    public ArrayList<Double> generateT() {
        ArrayList<Double> t = new ArrayList<Double>();
        for (int i=0; i<60; i++) {
            t.add((0 + (1.0*i/60)));
        }
        return t;
    }

    public Template generateO() {
        ArrayList<Integer> xL = new ArrayList<Integer>();
        ArrayList<Integer> yL = new ArrayList<Integer>();
        ArrayList<Double> x = generateT();
        for (int i=0; i<x.size(); i++) {
            xL.add((int)Math.round(75 + (50*(Math.cos(2*Math.PI*x.get(i))))));
            yL.add((int)Math.round(75 + (50*(Math.sin(2*Math.PI*x.get(i))))));
//			System.out.print("(" + xL.get(i) + "," + yL.get(i) + ") ");
        }
        Template t = new Template(xL, yL);
        return t;
    }

    public Template generateX() {
        ArrayList<Integer> xL = new ArrayList<Integer>();
        ArrayList<Integer> yL = new ArrayList<Integer>();
        ArrayList<Double> x = generateT();
        for (int i=0; i<x.size(); i++) {
            if (i< (x.size()/3)) {
                xL.add((int)Math.round(25 +(100 * i/(x.size()/3))));
                yL.add(xL.get(i));
//				System.out.print("(" + xL.get(i) + "," + yL.get(i) + ") ");
            }
            else if (i >= (x.size()*2/3)) {

                xL.add((int)Math.round(25 +(100 * (i-40)/(x.size()/3))));
                yL.add(150-xL.get(i));
//				System.out.print("(" + xL.get(i) + "," + yL.get(i) + ") ");
            }
            else {
                xL.add((int)Math.round(125 -(100 * (i-20)/(x.size()/3))));
                yL.add(125);
//				System.out.print("(" + xL.get(i) + "," + yL.get(i) + ") ");
            }
        }
        Template t = new Template(xL, yL);
        return t;
    }

    public Template generateR() {
        ArrayList<Integer> xL = new ArrayList<Integer>();
        ArrayList<Integer> yL = new ArrayList<Integer>();
        ArrayList<Double> x = generateT();
        for (int i=0; i<x.size(); i++) {
            if (i < (x.size()/2)) {
                xL.add((int)Math.round(25 +(50 * i/(x.size()/2))));
                yL.add((int)Math.round(125 -(100 * i/(x.size()/2))));
            }
            else {
                xL.add((int)Math.round(75 +(50 * i/(x.size()/2))));
                yL.add((int)Math.round(25 +(100 * i/(x.size()/2))));
            }
        }
        Template t = new Template(xL, yL);
        return t;
    }

    public Template generateH() {
        ArrayList<Integer> xL = new ArrayList<Integer>();
        ArrayList<Integer> yL = new ArrayList<Integer>();
        ArrayList<Double> x = generateT();
        for (int i=0; i < x.size(); i++) {
            if(i < (x.size()/4)) {
                xL.add(25);
                yL.add((int)Math.round(25 + (100 * i/(x.size()/4))));
            }
            else if (i >= (x.size()/4) && i < (x.size()/4)) {
                xL.add((int)Math.round(25 + (100 * i/(x.size()/4))));
                yL.add(125);
            }
            else if ( i >= (x.size()/2) && i < (x.size()*3/4)) {
                xL.add(125);
                yL.add((int)Math.round(125 - (100 * i/(x.size()/4))));
            }
            else {
                xL.add((int)Math.round(125 - (100 * i/(x.size()/4))));
                yL.add(25);
            }
        }
        Template t = new Template(xL, yL);
        return t;
    }

}

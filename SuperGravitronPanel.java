import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class SuperGravitronPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME = 1000;
	private static final Color BACKGROUND = new Color(0, 0, 0);
	private static final Color Player_COLOR = new Color(96, 130, 182);
	private static int R1 = (int) (Math.random() * 256);
	private static int G = (int) (Math.random() * 256);
	private static int B = (int) (Math.random() * 256);
	private static final Color Enemy_COLOR = new Color(R1, G, B);
	private static final double Enemy_Length = 20;
	private static final int BUMPER_X_WIDTH = 20;
	private static final double Player_DIAM = 20;
	private BufferedImage myImage;
	// private Graphics myBuffer;
	private Graphics2D myBuffer;
	private Player ike;
	private Bumper[] bumper;
	private Timer timer;
	private Timer gtimer;
	private int L;
	private int R;
	private boolean left = false;
	private boolean right = false;
	private int score = 0;

	public SuperGravitronPanel() {
		myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.createGraphics();
		myBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ike = new Player(500, 500, Player_DIAM, Player_COLOR);
		bumper = new Bumper[10];
		ike.setdy(13);
		for (int x = 0; x < bumper.length; x++) {
			bumper[x] = new Bumper((int) (Math.random() * 200),
					(int) (Math.random() * 500 + 200), BUMPER_X_WIDTH,
					BUMPER_X_WIDTH, Enemy_COLOR);
			bumper[x].setdx(5);
		}
		timer = new Timer(5, new Listener());
		timer.start();
		addKeyListener(new Key());
		setFocusable(true);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);

	}

	private class Key extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				left = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = true;
			}
		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				left = false;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				right = false;
		}
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (left) {
				L = 1;
			}
			if (right) {
				R = 1;
			}
			if (!left) {
				L = 0;
			}
			if (!right) {
				R = 0;
			}
			if (L == 1)
				ike.setX(ike.getX() - 5);
			if (R == 1)
				ike.setX(ike.getX() + 5);
			myBuffer.setColor(BACKGROUND);
			myBuffer.fillRect(0, 0, FRAME, FRAME);
			for (int x = 0; x < bumper.length; x++) {
				bumper[x].draw(myBuffer);
				bumper[x].move(FRAME, FRAME);
			}
			BumperCollision.collide(bumper, ike);
			// BumperCollision.collide(FRAME, ike);
			if (ike.getX() <= 100 + ike.getRadius()) {
				score++;
				score= score-(score+1);
				
				
			}
			else if (ike.getX() >= 800 - ike.getRadius()){
				score++;
				score= (score+1);
				
			}
			ike.draw(myBuffer);
			ike.move(FRAME, FRAME);
			myBuffer.setFont(new Font("Times New Roman", Font.BOLD, 50));
			myBuffer.drawLine(0, 200, 1000, 200);
			myBuffer.drawLine(0, 800, 1000, 800);
			myBuffer.drawString("  Super Gravitron   ", FRAME - 700, 100);
			myBuffer.drawString("  Score: "+ score, FRAME - 250, 100);
			repaint();
		}
	}

	public void collide(Bumper[] b, Player p) {
		if (ike.getX() <= -100 + ike.getRadius()) {
			score++;
			
		}
		else if (ike.getX() >= 800 - ike.getRadius()){
			score++;
		}

	}

	private double distance(double x1, double y1, double x2, double y2) {
		double dist = 0;

		dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		return dist;
	}

}

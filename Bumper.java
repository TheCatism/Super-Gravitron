// Name: 				Date:

import java.awt.*;

public class Bumper {
	// private fields, all ints, for a Bumper
	// hint: the "location" of the bumper begins at its top left corner.
	private double dx;
	private double dy;
	private double myX;
	private double myY;
	private Color myColor;
	private double xWidth;
	private double yWidth;

	/**
	 * Creates a red Bumper at (200, 200) with a width of 75 and 125.
	 */
	public Bumper() {
		myX = 200;
		myY = 200;
		xWidth = 75;
		yWidth = 125;
		myColor = Color.RED;

	}

	/**
	 * Creates a polkadot of color c at (x, y) with a diameter of d.
	 * 
	 * @param x
	 *            the x-coordinate of the center of the bumper
	 * @param y
	 *            the y-coordinate of the center of the bumper
	 * @param xw
	 *            the width of the bumper
	 * @param yw
	 *            the length of the bumper
	 * @param c
	 *            the color of the bumper
	 */

	public Bumper(int x, int y, int xw, int yw, Color c) {

		myX = x;
		myY = y;
		xWidth = xw;
		yWidth = yw;
		myColor = c;

	}

	// ***********************************************
	//
	// Accessor methods (one for each field)
	// Comment each method with proper Javadoc
	//
	// ***********************************************
	/**
	 * Gets the x-coordinate
	 * 
	 * @return the x-coordinate
	 */

	public double getX() {
		return myX;
	}

	/**
	 * gets the y-coordinate
	 * 
	 * @return the y-coordinate
	 */

	public double getY() {
		return myY;
	}

	/**
	 * gets the x-Width
	 * 
	 * @return the x width
	 */
	public double xw() {
		return xWidth;
	}

	/**
	 * gets the y-Width
	 * 
	 * @return the y width
	 */

	public double yw() {
		return yWidth;
	}

	/**
	 * gets myColor
	 * 
	 * @returns myColor
	 */

	public Color getColor() {
		return myColor;
	}

	public double getdx() {
		return dx;
	}

	public double getdy() {
		return dy;
	}

	// ***********************************************
	//
	// Modifier methods (one for each field)
	// Comment each method with proper Javadoc
	//
	// ***********************************************
	/**
	 * Sets the x-coordinate to be x
	 * 
	 * @param d
	 *            the x-coordinate
	 */

	public void setX(double x) {
		myX = x;
	}

	/**
	 * sets the y coordinate
	 * 
	 * @param y
	 *            the y-coordinate
	 */
	public void setY(double y) {
		myY = y;
	}

	/**
	 * sets the xWidth
	 *
	 * @param xw
	 *            the xWidth
	 */
	public void setXWidth(int xw) {
		xWidth = xw;
	}

	/**
	 * sets the YWidth
	 *
	 * @param yw
	 *            the yWidth
	 */

	public void setYWidth(int yw) {
		yWidth = yw;
	}

	/**
	 * sets the color
	 * 
	 * @param c
	 *            = myColor
	 */

	public void setColor(Color c) {
		myColor = c;
	}

	public void setdx(double x) {
		dx = x;
	}

	public void setdy(double y) {
		dy = y;
	}

	// ************************
	//
	// Instance methods
	//
	// ************************

	/**
	 * Chooses a random (x,y) location for the Bumper. Bumper stays entirely in
	 * the window.
	 * 
	 * @param rightEdge
	 *            the right side of the window
	 * @param bottomEdge
	 *            the bottom side of the window
	 */
//	public void jump(int rightEdge, int bottomEdge) {
//		// moves location to random (x, y) within the edges
//		myX = (int) (Math.random() * (rightEdge - xWidth));
//		myY = (int) (Math.random() * (bottomEdge - yWidth));
//
//	}

	/**
	 * Draws a rectangular bumper on the buffer
	 * 
	 * @param myBuffer
	 *            the picture drawn on the screen
	 */
	public void draw(Graphics myBuffer) {
		myBuffer.setColor(getColor());
		myBuffer.drawRect((int)getX(),(int) getY(),(int) xw(),(int) yw());
	}

	public void move(double rightEdge, double bottomEdge) {
		// change the x-coordinate of the ball so it moves
		// Translation: x = x + dx
		setX(getX() + dx);

		setY(getY() + dy);

		// If the ball hits the right edge, change dx (the direction the ball
		// travels)
		// Translation: The x-coord of the ball (center) is past the right edge
		// - Length of the ball
//		if (getX() >= rightEdge - xw()) {
//			// place the ball on the right edge of screen
//			setX(rightEdge - xw());
//
//			// change directions (now move left)
//			dx = dx * -1;
//		}
//		// If the ball hits the left edge, change dx (the direction the ball
//		// travels)
//		else if (getX() <= 0 + xw()) {
//			setX(0 + xw());
//
//			dx = dx * -1;
//
//		}
		if(getX() >= rightEdge - xw())     
	      {
	         // place the ball on the right edge of screen
	         setX(100);
	         setY((int) (Math.random()* 500+200));
	         // change directions (now move left)
	         dx = dx * 1; 
	      }
	      // If the ball hits the left edge, change dx (the direction the ball travels)
//	      else if (getX() <= 0 + xw())
//	      {
//	         setX(1100);
//	         
//	         dx= dx * -1;
//	      } 
		// If the ball hits the bottom edge, change dy (the direction the ball
		// travels)

		if (getY() >= bottomEdge - yw()) {
			setY(bottomEdge - yw());

			dy = dy * -1;
		}
		// If the ball hits the top edge, change dy (the direction the ball
		// travels)

		else if (getY() <= 0 + yw()) {
			setY(0 + yw());

			dy = dy * -1;

		}
	}


	/**
	 * Returns true if any part of the Polkadot is inside the bumper
	 * 
	 * @return true if any part of the polkadot is inside the bumper
	 */
	public boolean inBumper(Player p) {
		for (int x = (int) getX(); x <= getX() + xw(); x++)
			// starts at upper left corner(x,y)
			for (int y = (int) getY(); y <= getY() + yw(); y++)
				if (distance(x, y, p.getX(), p.getY()) <= p.getRadius()) // checks
																				// every
																				// point
																				// on
																				// the
																				// bumper
					return true;
		return false;
	}

	/**
	 * Finds the distance between two points using the distance formula
	 * 
	 * @param x1
	 *            the x-coordinate of the first object
	 * @param y1
	 *            the y-coordinate of the first object
	 * @param x2
	 *            the x-coordinate of the 2nd object
	 * @param y2
	 *            the y-coordinate of the 2nd object
	 * @return the distance between the two points
	 */
	private double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}

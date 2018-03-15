// Phil Ero 15JUL08

public class BumperCollision {
	private static double nearestX; // used to approximate what point of the
									// bumper
	private static double nearestY; // a player collided with

	/**
	 * If the player collides with the Bumper, the player will bounce off the
	 * bumper at the same angle
	 * 
	 * @param bumper
	 *            the Bumper
	 * @param player
	 *            the player
	 */
	public static void collide(Bumper[] bumper, Player player) {
		for (int x = 0; x < bumper.length; x++) {
			// see if the player hit the bumper!
			if (bumper[x].inBumper(player)) {
				// back the player up until it is just outside the bumper
				while (bumper[x].inBumper(player)) {
					player.setX(player.getX() - player.getdx() / 10.0);
					player.setY(player.getY() - player.getdy() / 10.0);
				}

				// find the point on the edge of the bumper closest to the
				// player
				findImpactPoint(bumper, player);

				double ux = nearestX - player.getX();
				double uy = nearestY - player.getY();
				double ur = Math.sqrt(ux * ux + uy * uy);
				ux /= ur;
				uy /= ur;
				int dx = (int) player.getdx();
				int dy = (int) player.getdy();
				double dot_1 = ux * dx + uy * dy;
				double dot_2 = -uy * dx + ux * dy;
				dot_1 *= -1; // this is the actual "bounce"
				double[] d = new double[2];
				d[0] = dot_1 * ux - dot_2 * uy; // vector math
				d[1] = dot_1 * uy + dot_2 * ux; // vector math
				dx = (int) Math.round(d[0]);
				dy = (int) Math.round(d[1]);
				// player.setdx(dx);
				// player.setdy(dy);

				player.setX(500);
				player.setY(500);
				for (int c = 0; c < bumper.length; c++) {
					bumper[c].setX((int) (Math.random() * 200));
				}
			}
		}
	}

	private static void findImpactPoint(Bumper[] bumper, Player player) {
		// TODO Auto-generated method stub

	}

	/**
	 * Finds the point of impact between the Bumper and the player and updates
	 * to that (x, y) coordinate
	 * 
	 * @param bumper
	 *            the Bumper
	 * @param player
	 *            the player
	 */
	// private static void findImpactPoint(Bumper[] bumper, Player player)
	// {
	// for(int x=0;x<bumper.length;x++){
	// // first assume the nw corner is closest
	// nearestX = bumper[x].getX();
	// nearestY = bumper[x].getY();
	//
	// // now work around the edge of the bumper looking for a closer point
	// for (int x = (int) bumper[x].getX(); x <= bumper.getX() + bumper.xw();
	// x++) // top & bottom edges
	// {
	// updateIfCloser(x, (int) bumper.getY(), player);
	// updateIfCloser(x, (int) (bumper.getY() + bumper.yw()), player);
	// }
	// for (int y = (int) bumper.getY(); y <= bumper.getY() + bumper.yw(); y++)
	// // right & left edges
	// {
	// updateIfCloser((int) bumper.getX(), y, player);
	// updateIfCloser((int) (bumper.getX() + bumper.xw()), y, player);
	// }
	// }
	// }
	//
	/**
	 * Makes (x,y) the nearest point if it is closer to the player
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param b
	 *            the player object
	 */
	private static void updateIfCloser(int x, int y, Player b) {
		if (distance(x, y, b.getX(), b.getY()) < distance(nearestX, nearestY,
				b.getX(), b.getY())) {
			nearestX = x;
			nearestY = y;
		}
	}

	/**
	 * Calculates the distance between (x1, y1) and (x2, y2).
	 * 
	 * @param x1
	 *            the x-coordinate of the first object
	 * @param y1
	 *            the y-coordinate of the first object
	 * @param x2
	 *            the x-coordinate of the second object
	 * @param y2
	 *            the y-coordinate of the second object
	 * @return the distance between (x1, y1) and (x2, y2).
	 */
	private static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

}

package meritis.bnp.rovers;

public class RoverCoordinates {

	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;

	private final int maxX;
	private final int maxY;

	private int x;
	private int y;
	private Heading heading;

	public RoverCoordinates(int x, int y, int maxX, int maxY, Heading heading) throws Exception {
		this.maxX = maxX;
		this.maxY = maxY;
		checkPositionInitialisation(x, y);
		this.x = x;
		this.y = y;
		this.heading = heading;
	}

	/**
	 * makes the rover spin 90 degrees left, the heading attribute will take the new
	 * heading value after rotation.
	 */

	public void left() {
		switch (heading) {
		case N:
			heading = Heading.O;
			break;
		case O:
			heading = Heading.S;
			break;
		case S:
			heading = Heading.E;
			break;
		case E:
			heading = Heading.N;
			break;
		}
	}

	/**
	 * makes the rover spin 90 degrees right, the heading attribute will take the
	 * new heading value after rotation.
	 */
	public void right() {
		switch (heading) {
		case N:
			heading = Heading.E;
			break;
		case E:
			heading = Heading.S;
			break;
		case S:
			heading = Heading.O;
			break;
		case O:
			heading = Heading.N;
			break;
		}
	}

	/**
	 * Move forward one grid point, and maintain the same heading.
	 * 
	 * @throws Exception
	 */
	public void move() throws Exception {
		switch (heading) {
		case N:
			incrementY();
			break;
		case E:
			incrementX();
			break;
		case S:
			decrementY();
			break;
		case O:
			decrementX();
			break;
		}
	}

	/**
	 * Increment x position with one point, if x is not on the limit of the plateau
	 * 
	 * @throws Exception
	 */
	public void incrementX() throws Exception {
		if (x == maxX) {
			throw new Exception("X will be out of the plateu from the right side");
		}
		x++;
	}

	/**
	 * Decrement x position with one point, if x is not on the limit of the plateau
	 * 
	 * @throws Exception
	 */
	public void decrementX() throws Exception {
		if (x == MIN_X) {
			throw new Exception("X will be out of the plateu from the left side");
		}
		x--;
	}

	/**
	 * Increment y position with one point, if y is not on the limit of the plateau
	 * 
	 * @throws Exception
	 */
	public void incrementY() throws Exception {
		if (y == maxY) {
			throw new Exception("Y will be out of the plateu from the North side");
		}
		y++;
	}

	/**
	 * Decrement y position with one point, if y is not on the limit of the plateau
	 * 
	 * @throws Exception
	 */
	public void decrementY() throws Exception {
		if (y == MIN_Y) {
			throw new Exception("Y will be out of the plateu from the South side");
		}
		y--;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) throws Exception {
		checkX(x);
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws Exception {
		checkY(y);
		this.y = y;
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading heading) throws Exception {
		this.heading = heading;
	}

	private void checkPositionInitialisation(int x, int y) throws Exception {
		checkX(x);
		checkY(y);
	}

	private void checkX(int x) throws Exception {
		if (x > maxX || x < MIN_X) {
			throw new Exception("Error when initialasing Rover's position : '" + x + "' position out of the plateau");
		}
	}

	private void checkY(int y) throws Exception {
		if (y > maxY || y < MIN_Y) {
			throw new Exception("Error when initialasing Rover's position : '" + y + "' position out of the plateau");
		}
	}

	@Override
	public String toString() {
		return x + " " + y + " " + heading;
	}
}

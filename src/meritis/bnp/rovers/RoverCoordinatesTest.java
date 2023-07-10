package meritis.bnp.rovers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverCoordinatesTest {

	private static final int maxX = 5;
	private static final int maxY = 5;

	@Test
	void testRoverPositionCreation() {
		assertThrows(Exception.class, () -> {
			new RoverCoordinates(6, 0, maxX, maxY, Heading.E);
		});
		assertThrows(Exception.class, () -> {
			new RoverCoordinates(0, 7, maxX, maxY, Heading.E);
		});
	}

	@Test
	void testIncrementX() throws Exception {
		RoverCoordinates rover = new RoverCoordinates(0, 0, maxX, maxY, Heading.E);
		rover.incrementX();
		assert (rover.getX() == 1);
		rover.setX(5);
		assertThrows(Exception.class, () -> {
			rover.incrementX();
		});
	}

	@Test
	void testIncrementY() throws Exception {
		RoverCoordinates rover = new RoverCoordinates(0, 0, maxX, maxY, Heading.E);
		rover.incrementY();
		assert (rover.getY() == 1);
		rover.setY(5);
		assertThrows(Exception.class, () -> {
			rover.incrementY();
		});
	}

	@Test
	void testDecrementX() throws Exception {
		RoverCoordinates rover = new RoverCoordinates(0, 0, maxX, maxY, Heading.E);
		assertThrows(Exception.class, () -> {
			rover.decrementX();
		});
		rover.setX(5);
		rover.decrementX();
		assert (rover.getX() == 4);
	}

	@Test
	void testDecrementY() throws Exception {
		RoverCoordinates rover = new RoverCoordinates(0, 0, maxX, maxY, Heading.E);
		assertThrows(Exception.class, () -> {
			rover.decrementY();
		});
		rover.setY(5);
		rover.decrementY();
		assert (rover.getY() == 4);
	}

	@Test
	void testLeft() throws Exception {
		RoverCoordinates rover = new RoverCoordinates(0, 0, maxX, maxY, Heading.N);
		rover.left();
		assert (rover.getHeading() == Heading.O);
		rover.left();
		assert (rover.getHeading() == Heading.S);
		rover.left();
		assert (rover.getHeading() == Heading.E);
	}

	@Test
	void testRight() throws Exception {
		RoverCoordinates rover = new RoverCoordinates(0, 0, maxX, maxY, Heading.N);
		rover.right();
		assert (rover.getHeading() == Heading.E);
		rover.right();
		assert (rover.getHeading() == Heading.S);
		rover.right();
		assert (rover.getHeading() == Heading.O);
	}

	@Test
	void testMove() throws Exception {
		RoverCoordinates positionNord = new RoverCoordinates(0, 0, maxX, maxY, Heading.N);
		positionNord.move();
		assert (positionNord.getX() == 0);
		assert (positionNord.getY() == 1);

		RoverCoordinates positionEast = new RoverCoordinates(0, 0, maxX, maxY, Heading.E);
		positionEast.move();
		assert (positionEast.getX() == 1);
		assert (positionEast.getY() == 0);

		RoverCoordinates positionOuest = new RoverCoordinates(1, 0, maxX, maxY, Heading.O);
		positionOuest.move();
		assert (positionOuest.getX() == 0);
		assert (positionOuest.getY() == 0);

		RoverCoordinates positionSouth = new RoverCoordinates(0, 1, maxX, maxY, Heading.S);
		positionSouth.move();
		assert (positionSouth.getX() == 0);
		assert (positionSouth.getY() == 0);
	}
}

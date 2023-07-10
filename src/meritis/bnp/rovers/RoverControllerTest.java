package meritis.bnp.rovers;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RoverControllerTest {

	@Test
	void should_return_rover_position_after_moving() throws Exception {

		// Given this RoverPosition and this commands
		String initialPosition = "1 2 N";
		String upperRightCoordinates = "5 5";
		RoverCoordinates position = RoverController.createRoverCoordinates(initialPosition, upperRightCoordinates);
		String cmnds = "LMLMLMLMM";

		// When Applying this commands
		RoverController.command(position, cmnds);

		// Then the rover's position will be (1,3,N)
		assert (position.getX() == 1);
		assert (position.getY() == 3);
		assert (position.getHeading() == Heading.N);
	}

	@Test
	void should_throw_exception_when_uknowing_cmd() throws Exception {
		// Given this RoverPosition and this commands
		String initialPosition = "3 3 E";
		String upperRightCoordinates = "5 5";
		RoverCoordinates position = RoverController.createRoverCoordinates(initialPosition, upperRightCoordinates);
		String cmnds1 = "AMLMLMLMM";
		String cmnds2 = "MMRMMRMRRM";

		// When Applying commands
		assertThrows(Exception.class, () -> {
			RoverController.command(position, cmnds1);
		});
		RoverController.command(position, cmnds2);

		// Then the rover's position will be (1,3,N)
		assert (position.getX() == 5);
		assert (position.getY() == 1);
		assert (position.getHeading() == Heading.E);

	}

}

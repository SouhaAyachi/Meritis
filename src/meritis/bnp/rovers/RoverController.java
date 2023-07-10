package meritis.bnp.rovers;

public class RoverController {

	/**
	 * Transform input initialPosition and upperRightCoordinates to creates an
	 * instance of RoverCoordinates.
	 * 
	 * @param initialPosition
	 * @param upperRightCoordinates
	 * @return Rover
	 * @throws Exception
	 */
	public static RoverCoordinates createRoverCoordinates(String initialPosition, String upperRightCoordinates)
			throws Exception {
		String[] cmds = initialPosition.split(" ");
		String[] maxCoordinates = upperRightCoordinates.split(" ");
		int maxX = Integer.parseInt(maxCoordinates[0]);
		int maxY = Integer.parseInt(maxCoordinates[1]);
		int x = Integer.parseInt(cmds[0]);
		int y = Integer.parseInt(cmds[1]);
		Heading heading = checkHeading(cmds[2]);
		return new RoverCoordinates(x, y, maxX, maxY, heading);

	}

	/**
	 * Executes a list of commands on the Rover.
	 * 
	 * @param rover
	 * @param cmnds
	 * @throws Exception
	 */
	public static void command(RoverCoordinates rover, String cmnds) throws Exception {
		for (int i = 0; i < cmnds.length(); i++) {
			Command cmd = checkCmd(cmnds.charAt(i));
			switch (cmd) {
			case L:
				rover.left();
				break;
			case R:
				rover.right();
				break;
			case M:
				rover.move();
				break;
			}
		}
	}

	/**
	 * Transform char cmd to Command Enum.
	 * 
	 * @param char cmd
	 * @return Command
	 * @throws Exception
	 */
	private static Command checkCmd(char cmd) throws Exception {
		try {
			return Command.valueOf(Character.toString(cmd));
		} catch (IllegalArgumentException e) {
			throw new Exception(
					"Error when excuting commands : Unknow command '" + cmd + "' , possible values (L, R, M)");
		}
	}

	/**
	 * Transform String heading to Heading Enum
	 * 
	 * @param String heading
	 * @return Heading
	 * @throws Exception
	 */
	private static Heading checkHeading(String heading) throws Exception {
		try {
			return Heading.valueOf(heading);
		} catch (IllegalArgumentException e) {
			throw new Exception("Error when initialasing Rover's Heading :'" + heading
					+ "' Heading is not valid, valid values (N, S, E, O)");
		}
	}
}

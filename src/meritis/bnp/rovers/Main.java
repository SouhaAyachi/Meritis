package meritis.bnp.rovers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {

		String fileName = args[0];
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String upperRightCoordinates = reader.readLine();

			String initialPosition = reader.readLine();
			String cmnds;
			while (initialPosition != null) {
				RoverCoordinates rover = RoverController.createRoverCoordinates(initialPosition, upperRightCoordinates);
				cmnds = reader.readLine();

				RoverController.command(rover, cmnds);
				System.out.println(rover);

				initialPosition = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

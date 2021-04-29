package engine;

import java.io.*;
import java.util.*;
import units.*;

public class ReadCSV {

	// Reads into ArrayList<City> availableCities & ArrayList<Distance> distances
	public static void readFile(String path, ArrayList<City> availableCities, ArrayList<Distance> distances)
			throws IOException {
		String currentLine = "";
		FileReader fileReader = new FileReader(path); // open file "path"
		BufferedReader br = new BufferedReader(fileReader); // read from it

		while ((currentLine = br.readLine()) != null) {

			String[] result = currentLine.split(","); // save to result

			distances.add(new Distance(result[0], result[1], Integer.parseInt(result[2]))); // fill distances

			// check if city already added if not then add it
			if (availableCities.isEmpty()) {
				availableCities.add(new City(result[0]));
				availableCities.add(new City(result[1]));
			} else {
				// iterate to check if city is already in the list
				boolean flag0 = true;
				boolean flag1 = true;
				for (int i = 0; i < availableCities.size(); i++) {
					// set flag to false if list already has the cities
					if (availableCities.get(i).getName().equals(result[0])) {
						flag0 = false;
					}
					if (availableCities.get(i).getName().equals(result[1])) {
						flag1 = false;
					}
				}
				if (flag0) {
					availableCities.add(new City(result[0]));
				}
				if (flag1) {
					availableCities.add(new City(result[1]));
				}
			}
		}
	}

	public static void readFile(City city) throws IOException {
		String currentLine = "";
		String path = city.getName() + "_army"; // set path to the naming scheme of the file
		FileReader fileReader = new FileReader(path); // open file "path"
		BufferedReader br = new BufferedReader(fileReader); // read from it

		ArrayList<Unit> units = city.getDefendingArmy().getUnits(); // units of the army of the city
		while ((currentLine = br.readLine()) != null) 
		{

			String[] result = currentLine.split(","); // save to result

			// adding units
			switch (result[0]) 
			{
			// initialize units with corresponding level
			case "Archer":
				int x = units.get(-1 + Integer.parseInt(result[1])).getCurrentSoldierCount();
				units.get(-1 + Integer.parseInt(result[1])).setCurrentSoldierCount(x++);
				break;
			case "Infantry":
				int y = units.get(2 + Integer.parseInt(result[1])).getCurrentSoldierCount();
				units.get(-1 + Integer.parseInt(result[1])).setCurrentSoldierCount(y++);
				break;
			case "Cavalry":
				int z = units.get(5 + Integer.parseInt(result[1])).getCurrentSoldierCount();
				units.get(-1 + Integer.parseInt(result[1])).setCurrentSoldierCount(z++);
				break;
			}

		}
	}
}
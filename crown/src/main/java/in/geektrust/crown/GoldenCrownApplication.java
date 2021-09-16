package in.geektrust.crown;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import in.geektrust.crown.config.ApplicationConfig;
import in.geektrust.crown.exceptions.InvalidInputException;
import in.geektrust.crown.exceptions.InvalidKingdomException;
import in.geektrust.crown.globals.Constants;
import in.geektrust.crown.model.Kingdom;
import in.geektrust.crown.repositories.data.Data;
import in.geektrust.crown.services.MessageService;

/**
 * GoldenCrownApplication Class to run the Application
 * 
 * @author - Aman Singh
 * @version 1.0
 */
public class GoldenCrownApplication {

	/**
	 * 
	 * @param commandLineArgs - to store input file name
	 * @throws InvalidKingdomException if the Kingdom Name is invalid
	 * @throws InvalidInputException   if the input is invalid
	 */
	private void run(List<String> commandLineArgs) throws InvalidKingdomException, InvalidInputException {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		String inputFile = commandLineArgs.get(0);
		Data loadKingdomData = applicationConfig.getKingdomDataLoader();
		loadKingdomData.loadData();
		MessageService messageService = applicationConfig.getMessageService();
		Set<Kingdom> allySet = new LinkedHashSet<>();
		initializeAllySet(allySet);
		messageService.processMessage(inputFile, allySet);
		displayAllies(allySet);
	}

	/**
	 * 
	 * @param allySet to Store the allies of Kingdom SPACE
	 */
	private void initializeAllySet(Set<Kingdom> allySet) {
		allySet.add(new Kingdom(Constants.SHAN_KINGDOM, Constants.SPACE_KINGDOM_EMBLEM));
	}

	/**
	 * method to display allies of SPACE Kingdom
	 * 
	 * @param allySet store the allies of SPACE Kingdom
	 */
	private void displayAllies(Set<Kingdom> allySet) {
		if (allySet.size() < (Constants.MIN_ALLIES_REQUIRE_INCLUDING_SPACE)) {
			System.out.println(Constants.SHAN_CANNOT_RULE);
		} else {
			for (Kingdom kingdoms : allySet) {
				System.out.println(kingdoms.getName());
			}
		}

	}

	public static void main(String[] args) throws InvalidKingdomException {
		try {
			if (args.length == 0) {
				throw new InvalidInputException("Invalid Input Please Provide Correct Input.");
			}
			List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
			GoldenCrownApplication applcation = new GoldenCrownApplication();
			applcation.run(commandLineArgs);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}

	}
}

package bballSim;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	//Global Variables
	static Scanner s = new Scanner(System.in);
	static RNG rng = new RNG();
	static Awards award = new Awards();
	
	static int currentYear = 1;
	static boolean retired = false;
	static boolean game = true;
	static boolean posVerified = false;
	static boolean buffVerified = false;
	static boolean contractLoopFlag = true;

	//Main method
	public static void main(String[] args) throws IOException{

		System.out.print("*Please enter player name: ");
		String playerName = s.nextLine();
		String playerPosition = "";
		String statToBuff = "";
		
		//Player Position Verification
		while (!posVerified) {
			blank();
			System.out.print("*Please enter desired position (PG, SG, SF, PF, C): ");
			playerPosition = s.nextLine();
			playerPosition = playerPosVerification(playerPosition);
		}
		
		//Player Stat Buff Verification
		while (!buffVerified) {
			blank();
			System.out.println("*Please enter desired stat to buff");
			System.out.print("(Points, Assists, Steals, Rebounds, Blocks): ");
			statToBuff = s.nextLine();
			statToBuff = buffVerification(statToBuff);
			
		}
		
		blank();
		System.out.println("Generating random stats..");
		CreatePlayer player = new CreatePlayer(playerName, playerPosition, statToBuff);
		PositionScoring stats = new PositionScoring(player.position);
		stats.statBuff(player, rng);
		
		pause(2500);
		blank();
		
		//Main game loop
		while(game) {
			contractSim(player, stats);
			newContractSigning(player);
		}

		pause(1500);
		award.hallOfFame(player, currentYear);
		System.out.println("=================================");
		System.out.println("You've Retired..");
		System.out.println("Here's your final stats:");
		blank();
		player.retiredPlayer(currentYear, player);
		blank();
		stats.displayFinalStats(currentYear);
		
		waitBeforeExit();
		s.close();

	}
	
	//Blank Line Method
	static void blank() {
		System.out.println();
	}
	
	//Thread Pause Method
	static void pause(int n) {
		try {
			Thread.sleep(n);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Wait keyboard press before exit method
	static void waitBeforeExit() throws IOException{
		System.out.print("Press Enter to exit...");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        System.out.print("Exiting...");
        pause(1500);
	}
	
	//Contract Simulation Method
	private static void contractSim(CreatePlayer player, PositionScoring stats) {		
		while (contractLoopFlag) {
			int contract = player.contract;
			
			// Contract loop
			for (int i = 1; i <= contract; i++) {
				boolean forceRetirement = player.forceRetirment;
				
				System.out.println("=================================");
				System.out.println("Year " + currentYear);
				player.introducePlayer();
				blank();
				pause(500);
				
				//Checking if player is injured or not
				if (player.injured) {
					System.out.println("You're injured and can't play for this season..");
					player.retireAfterInjury(player);
					if (forceRetirement) {
						retired = true;
						contractLoopFlag = false;
						break;
					}
				}
				
				//Checking if injuries is enough for force retirement
				else if (forceRetirement) {
					retired = true;
					contractLoopFlag = false;
					break;
				}
				
				// If player is not injured or forced to retire
				else {
					int conferenceSeed = conferenceSeeding();
					if (conferenceSeed <= 8) careerGames(player);
					else {
						System.out.println("You're Eliminated");
						blank();
						pause(1000);
					}
					
					stats.playerStats(player);
					pause(750);
					
					if (currentYear == 1) award.rookieOfTheYear(player, stats);
					award.allStarPlayer(player, stats);
				}
				
				//Checking if injuries is enough for force retirement
				if (forceRetirement) {
					retired = true;
					contractLoopFlag = false;
					break;
				}
				
				//Continue current contract
				else {
					if (i != contract) {
						if (!continueContract(s, player)) {
							contractLoopFlag = false;
							break;
						}
					}
					else if (!contractExtension(s, player)) {
						contractLoopFlag = false;
						break;
					}
				}
			}
		}
	}
	
	//Continue Contract Prompt
	private static boolean continueContract (Scanner s, CreatePlayer player) {
		System.out.print("Continue?[Y/N]: ");
		String cont = s.nextLine();
		boolean continueContract = true;
		
		if (!cont.equalsIgnoreCase("Y")) continueContract = false;
		else {
			blank();
			player.addAge();
			player.minusContractTime();
			player.isInjured(player);
			player.retireAfterInjury(player);
			currentYear++;
		}
		
		return continueContract;
	}
	
	private static boolean contractExtension (Scanner s, CreatePlayer player) {
		boolean extendContract = rng.extendContract();
		
		if (extendContract) {
			System.out.print("Do you want to extend your contract? [Y/N]: ");
			String cont = s.nextLine();
			
			if (!cont.equalsIgnoreCase("Y")) extendContract = false;
			else {
				blank();
				player.addAge();
				player.extendContract(player);
				player.isInjured(player);
				player.retireAfterInjury(player);
				currentYear++;
			}
		}
		
		return extendContract;
	}
	
	//New Contract Signing Method
	private static void newContractSigning (CreatePlayer player) {
		// Checks if contract is terminated by retirement
		if (retired) game = false;
		else {
			System.out.print("Sign another contract?[Y/N]: ");
			String answer = s.nextLine();
			
			if (answer.equalsIgnoreCase("Y")) {
				blank();
				player.addAge();
				player.isInjured(player);
				player.newContract(player);
				contractLoopFlag = true;
				currentYear++;
			}
			else {
				blank();
				game = false;
			}
		}			
	}
	
	//Generate Random Conference Rank / Seed
	static int conferenceSeeding() {
		pause(1000);
		System.out.println("Initializing Conference Seed..");
		pause(1000);
		int conferenceSeed = rng.randConferenceSeed();
		int n = conferenceSeed % 10;
		
		if (conferenceSeed == 11 || conferenceSeed == 12 || conferenceSeed == 13) {
			System.out.println(conferenceSeed + "th seed");
		}
		
		else {
			switch (n) {
				case 1:
					System.out.println(conferenceSeed + "st seed");
					break;
				case 2:
					System.out.println(conferenceSeed + "nd seed");
					break;
				case 3:
					System.out.println(conferenceSeed + "rd seed");
					break;
				default:
					System.out.println(conferenceSeed + "th seed");
					break;
			}
		}
		
		pause(500);
		blank();
		
		return conferenceSeed;
	}
	
	//Game Simulation Method
	static void careerGames(CreatePlayer player) {
		
		GamesSim sim = new GamesSim(player);
		boolean semis = false, cfFinals = false, finals = false;
		boolean elims = sim.elims();
		
		if (!elims) return;
		else semis = sim.semis();
		
		if (!semis) return;
		else cfFinals = sim.cfFinals();
		
		if (!cfFinals)return;
		else finals = sim.finals();
		
		if (!finals) return;
		else player.rings++;		
	}
	
	//Player Position Verification Method
	static String playerPosVerification(String playerPosition) {
		String positions[] = {"PG", "SG", "SF", "PF", "C"};
		
		for(String x : positions) {
			if (x.equalsIgnoreCase(playerPosition)) {
				playerPosition = x;
				posVerified = true;
			}
		}
		
		return playerPosition;
	}
	
	//Player Stat Buff Verification Method
	static String buffVerification(String statToBuff) {
		String stats[] = {"Points", "Assists", "Steals", "Rebounds", "Blocks"};
		
		for(String x : stats) {
			if (x.equalsIgnoreCase(statToBuff)) {
				statToBuff = x;
				buffVerified = true;
			}
		}
		
		return statToBuff;
	}
}

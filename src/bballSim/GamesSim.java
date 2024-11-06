package bballSim;

public class GamesSim {
	
	RNG rng = new RNG();
	RandTeam randTeam = new RandTeam();
	CreatePlayer player;
	
	GamesSim(CreatePlayer player){
		this.player = player;
	}
	
	static void pause(int n) {
		try {
			Thread.sleep(n);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	boolean elims() {
		boolean game = true;
		int win = 0;
		int score = 0, enemyScore = 0;
		String enemyTeam = randTeam.randEnemyTeam(player);
		
		while (game) {
			
			System.out.println("Welcome to the Eliminations (Game of 5)");
			for(int games = 1; games <= 5; games++) {
				System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
				
				pause(1000);
				
				int winningTeam = rng.winningTeam();
				if (winningTeam == 1) {
					System.out.println("You Win!");
					score++;
				}
				else {
					System.out.println("You Lose..");
					enemyScore++;
				}
				
				pause(1000);
				
				if (score == 3) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You move to the Semis!");
					randTeam.losingTeams(enemyTeam);
					pause(1250);
					win = 1;
					break;
				}
				else if (enemyScore == 3) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You're eliminated..");
					pause(1250);
					break;
				}
			}
			game = false;
		}
		System.out.println();
		
		if (win == 1) return true;
		else return false;
	}
	
	boolean semis() {
		boolean game = true;
		int win = 0;
		int score = 0, enemyScore = 0;
		String enemyTeam = randTeam.randEnemyTeam(player);
		
		while (game) {
			
			System.out.println("Welcome to the Semi-Finals (Game of 5)");
			for(int games = 1; games <= 5; games++) {
				System.out.println(player.team + " vs " + enemyTeam 
						+ "(" + score + "-" + enemyScore + ")");
				
				pause(1000);
				
				int winningTeam = rng.winningTeam();
				if (winningTeam == 1) {
					System.out.println("You Win!");
					score++;
				}
				else {
					System.out.println("You Lose..");
					enemyScore++;
				}
				
				pause(1000);
				
				if (score == 3) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You move to the Conference Finals!");
					pause(1250);
					win = 1;
					break;
				}
				else if (enemyScore == 3) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You're eliminated..");
					pause(1250);
					break;
				}
			}
			game = false;
		}
		System.out.println();
		
		if (win == 1) return true;
		else return false;
	}
	
	boolean cfFinals() {
		boolean game = true;
		int win = 0;
		int score = 0, enemyScore = 0;
		String enemyTeam = randTeam.randEnemyTeam(player);
		
		while (game) {
			
			System.out.println("Welcome to the Conference Finals (Game of 7)");
			for(int games = 1; games <= 7; games++) {
				System.out.println(player.team + " vs " + enemyTeam 
						+ "(" + score + "-" + enemyScore + ")");
				
				pause(1000);
				
				int winningTeam = rng.winningTeam();
				if (winningTeam == 1) {
					System.out.println("You Win!");
					score++;
				}
				else {
					System.out.println("You Lose..");
					enemyScore++;
				}
				
				pause(1000);
				
				if (score == 4) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You move to the Finals!");
					pause(1250);
					win = 1;
					break;
				}
				else if (enemyScore == 4) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You're eliminated..");
					pause(1250);
					break;
				}
			}
			game = false;
		}
		System.out.println();
		
		if (win == 1) return true;
		else return false;
	}
	
	boolean finals() {
		boolean game = true;
		int win = 0;
		int score = 0, enemyScore = 0;
		String enemyTeam = randTeam.randFinalsEnemyTeam();
		
		while (game) {
			
			System.out.println("Welcome to the Finals (Game of 7)");
			for(int games = 1; games <= 7; games++) {
				System.out.println(player.team + " vs " + enemyTeam 
						+ "(" + score + "-" + enemyScore + ")");
				
				pause(1000);
				
				int winningTeam = rng.winningTeam();
				if (winningTeam == 1) {
					System.out.println("You Win!");
					score++;
				}
				else {
					System.out.println("You Lose..");
					enemyScore++;
				}
				
				pause(1000);
				
				if (score == 4) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You're this year's CHAMPIONS!");
					pause(1250);
					win = 1;
					break;
				}
				else if (enemyScore == 4) {
					System.out.println(player.team + " vs " + enemyTeam 
							+ "(" + score + "-" + enemyScore + ")");
					System.out.println("You're eliminated..");
					pause(1250);
					break;
				}
			}
			game = false;
		}
		System.out.println();
		
		if (win == 1) return true;
		else return false;
	}

}

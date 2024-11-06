package bballSim;

public class PositionScoring {
	
	String pos;
	int totalYears;
	int points, assists, steals, rebounds, blocks;
	int fP, fA, fS, fR, fB;
	int p = 0, a = 0, s = 0, r = 0, b = 0;
	
	PositionScoring(String pos) {
		this.pos = pos;
	}
	
	void playerStats(CreatePlayer player) {
		
		switch (pos) {
			case "PG": //60
				points = (int)(Math.random() * 41) + player.pointBuff;
				assists = (int)(Math.random() * 15) + player.assistBuff;
				steals = (int)(Math.random() * 7) + player.stealBuff;
				rebounds = (int)(Math.random() * 4) + player.reboundBuff;
				blocks = (int)(Math.random() * 3) + player.blockBuff;
				break;
			case "SG": //60
				points = (int)(Math.random() * 36) + player.pointBuff;
				assists = (int)(Math.random() * 12) + player.assistBuff;
				steals = (int)(Math.random() * 7) + player.stealBuff;
				rebounds = (int)(Math.random() * 6) + player.reboundBuff;
				blocks = (int)(Math.random() * 4) + player.blockBuff;
				break;
			case "SF": //50
				points = (int)(Math.random() * 22) + player.pointBuff;
				assists = (int)(Math.random() * 8) + player.assistBuff;
				steals = (int)(Math.random() * 3) + player.stealBuff;
				rebounds = (int)(Math.random() * 15) + player.reboundBuff;
				blocks = (int)(Math.random() * 7) + player.blockBuff;
				break;
			case "PF": //50
				points = (int)(Math.random() * 16) + player.pointBuff;
				assists = (int)(Math.random() * 6) + player.assistBuff;
				steals = (int)(Math.random() * 3) + player.stealBuff;
				rebounds = (int)(Math.random() * 18) + player.reboundBuff;
				blocks = (int)(Math.random() * 13) + player.blockBuff;
				break;
			case "C": //55
				points = (int)(Math.random() * 15) + player.pointBuff;
				assists = (int)(Math.random() * 11) + player.assistBuff;
				steals = (int)(Math.random() * 2) + player.stealBuff;
				rebounds = (int)(Math.random() * 17) + player.reboundBuff;
				blocks = (int)(Math.random() * 15) + player.blockBuff;
				break;
		}

		System.out.println("Average Stats per Game this Season:");
		System.out.println("Points   : " + points);
		System.out.println("Assists  : " + assists);
		System.out.println("Steals   : " + steals);
		System.out.println("Rebounds : " + rebounds);
		System.out.println("Blocks   : " + blocks);
		System.out.println();
		
		overallStats(player);
		
	}
	
	void statBuff(CreatePlayer player, RNG rng) {
		char buff = player.statToBuff;
		
		switch (buff) {
			case 'p':
				player.pointBuff = rng.randStatBuff(buff);
				break;
			case 'a':
				player.assistBuff = rng.randStatBuff(buff);
				break;
			case 's':
				player.stealBuff = rng.randStatBuff(buff);
				break;
			case 'r':
				player.reboundBuff = rng.randStatBuff(buff);
				break;
			case 'b':
				player.blockBuff = rng.randStatBuff(buff);
				break;
		}
	}
	
	void overallStats(CreatePlayer player) {
		p += points;
		a += assists;
		s += steals;
		r += rebounds;
		b += blocks;
		
		player.totalFinalStats = p + a + s + r + b;
	}
	
	void displayFinalStats(int totalYears) {
		
		fP = p / totalYears;
		fA = a / totalYears;
		fS = s / totalYears;
		fR = r / totalYears;
		fB = b / totalYears;
		
		System.out.println("Average Stats per Game for the Whole Career:");
		System.out.println("Points   : " + fP);
		System.out.println("Assists  : " + fA);
		System.out.println("Steals   : " + fS);
		System.out.println("Rebounds : " + fR);
		System.out.println("Blocks   : " + fB);
		System.out.println();
	}

}

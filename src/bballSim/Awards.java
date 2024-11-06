package bballSim;

public class Awards {

	Awards() {
		
	}
	
	void displayAwards(CreatePlayer player) {
		if (player.allStar != 0) System.out.println("All-Star           : " + player.allStar);
		
		System.out.println();
		
		if (player.rookieOfTheYear != 0) System.out.println("* Rookie of the Year");
		if (player.hallOfFame != 0) System.out.println("* Hall of Famer");
		
	}
	
	int totalStats (CreatePlayer player, PositionScoring stats) {
		int points = stats.points;
		int assists = stats.assists;
		int steals = stats.steals;
		int rebounds = stats.rebounds;
		int blocks = stats.blocks;
		return points + assists + + steals + rebounds + blocks;
	}
	
	void rookieOfTheYear (CreatePlayer player, PositionScoring stats) {
		int totalStats = totalStats(player, stats);
		
		if (totalStats >= 35) {
			player.rookieOfTheYear++;
		}
	}
	
	void allStarPlayer(CreatePlayer player, PositionScoring stats) {
		int totalStats = totalStats(player, stats);
		
		if (totalStats >= 30) {
			player.allStar++;
		}
	}
	
	void hallOfFame(CreatePlayer player, int totalYears) {
		int totalFinalStats = player.totalFinalStats;
		
		if (totalFinalStats >= 500 && totalYears >= 13) {
			player.hallOfFame++;
		}
	}
}

package bballSim;

public class RandTeam {
	
	RNG rng = new RNG();
	
	int enemyConference, conference, team;
	String[] losingTeams = new String[3];
	String teams[][] = {
		{"Hawks", "Celtics", "Nets", "Hornets", "Bulls",
		 "Caveliers", "Pistons", "Pacers", "Heat", "Bucks",
		 "Knicks", "Magic", "76ers", "Raptors", "Wizards"}, 
		
		{"Mavericks", "Nuggets", "Warriors", "Rockets", "Clippers",
		 "Lakers", "Grizzlies", "Timberwolves", "Pelicans", "Thunder",
		 "Suns", "Trail Blazers", "Kings", "Spurs", "Jazz"}};
	
	RandTeam() {
		
	}

	String randTeam(int conference) {
		team = rng.randTeam();

		if (conference == 0) enemyConference = 1;
		else enemyConference = 0;
		
		return teams[conference][team];
	}
	
	String randEnemyTeam(CreatePlayer player) {
		boolean rand = true;
		String enemyTeam = "";
		
		while (rand) {
			team = rng.randTeam();
			enemyTeam = teams[player.conference][team];
			int space = this.losingTeams.length;

			for (int i = 0; i <= space; i++) {
				if (!enemyTeam.equalsIgnoreCase(player.team) &&
				!enemyTeam.equalsIgnoreCase(this.losingTeams[i])) {
					rand = false;
					break;
				}
			}
		}
		
		return enemyTeam;
	}
	
	String randFinalsEnemyTeam() {
		team = rng.randTeam();
		return teams[enemyConference][team];
	}
	
	void losingTeams(String team) {
		int space = this.losingTeams.length - 1;
		for (int i = 0; i <= space; i++) {
			if (losingTeams[i] == null) {
				losingTeams[i] = team;
				break;
			}
		}
	}
}

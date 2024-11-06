package bballSim;

public class RNG {
	
	RNG (){
		
	}
	
	int randContract() {
		return (int)(Math.random() * 7) + 3;
	}
	
	int randInitialAge() {
		return (int)(Math.random() * 6) + 20;
	}
	
	int randConference() {
		return (int)(Math.random() * 2);
	}
	
	int randTeam() {
		return (int)(Math.random() * 15);
	}
	
	int randConferenceSeed() {
		return (int)(Math.random() * 15) + 1;
	}
	
	int winningTeam() {
		return (int)(Math.random() * 2) + 1;
	}
	
	int randStatBuff(char buff) {
		switch (buff) {
			case 'p': return (int)(Math.random() * 15) + 5;
			case 'a': return (int)(Math.random() * 10) + 5;
			case 's': return (int)(Math.random() * 4) + 3;
			case 'r': return (int)(Math.random() * 11) + 2;
			case 'b': return (int)(Math.random() * 3) + 3;
			default : return 0;
		}
	}
	
	boolean extendContract() {
		int rand = (int)(Math.random() * 2) + 1;
		if (rand == 1) return true;
		else return false;
	}
	
	boolean isInjured(CreatePlayer player) {
		boolean injury;
		int n = 0;
		
		if (player.age >= 20 && player.age <= 29) n = (int)(Math.random() * 20);
		else if (player.age >= 30 && player.age <= 39) n = (int)(Math.random() * 15);
		else if (player.age >= 40 && player.age <= 49) n = (int)(Math.random() * 10);
		else if (player.age >= 50) n = (int)(Math.random() * 5);
		
		
		if (n != 0) injury = false;
		else injury = true;
		
		return injury;
	}
	
	String randPosition(CreatePlayer player) {
		String randPos = player.position;
		int pos;
		
		if (player.position.equalsIgnoreCase("PG") || 
				player.position.equalsIgnoreCase("SG")) {
			pos = (int)(Math.random() * 2);
			if (pos == 0) randPos = "PG";
			else randPos = "SG";
		} else {
			pos = (int)(Math.random() * 3);
			if (pos == 0) randPos = "SF";
			else if (pos == 1) randPos = "PF";
			else randPos = "C";
		}
		
		return randPos;
	}
}

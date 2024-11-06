package bballSim;

public class CreatePlayer {
	
	RNG rng = new RNG();
	RandTeam randTeam = new RandTeam();
	Awards award = new Awards();
	
	String name, position, team;
	char statToBuff;
	boolean injured = false;
	boolean forceRetirment = false;
	int rings = 0;
	int contract, age, injuries;
	int remainingContract, conference;
	int rookieOfTheYear, allStar, totalFinalStats, hallOfFame;
	int pointBuff, assistBuff, stealBuff, blockBuff, reboundBuff;
	
	CreatePlayer(String name, String position, String statToBuff){
		this.name = name;
		this.position = position.toUpperCase();
		this.statToBuff = statToBuff.toLowerCase().charAt(0);
		this.contract = rng.randContract();
		this.age = rng.randInitialAge();
		this.conference = rng.randConference();
		this.team = randTeam.randTeam(this.conference);
		this.remainingContract = this.contract - 1;
	}
	
	void introducePlayer() {
		if (this.remainingContract == 0) {
			System.out.println("Name          : " + this.name);
			System.out.println("Age           : " + this.age);
			System.out.println("Position      : " + this.position);
			System.out.println("Contract      : Last Year");
			System.out.println("Team          : " + this.team);
			System.out.println("Championships : " + this.rings);
		}
		else if (this.remainingContract == 1) {
			System.out.println("Name          : " + this.name);
			System.out.println("Age           : " + this.age);
			System.out.println("Position      : " + this.position);
			System.out.println("Contract      : " + this.remainingContract + " year remaining");
			System.out.println("Team          : " + this.team);
			System.out.println("Championships : " + this.rings);
		}
		else {
			System.out.println("Name          : " + this.name);
			System.out.println("Age           : " + this.age);
			System.out.println("Position      : " + this.position);
			System.out.println("Contract      : " + this.remainingContract + " years remaining");
			System.out.println("Team          : " + this.team);
			System.out.println("Championships : " + this.rings);
		}
		
	}
	
	void retiredPlayer(int careerYears, CreatePlayer player) {
		System.out.println("Name               : " + this.name);
		System.out.println("Age                : " + this.age);
		System.out.println("Position           : " + this.position);
		System.out.println("Career Years       : " + careerYears + " years");
		System.out.println("Last Team          : " + this.team);
		System.out.println("Championships Held : " + this.rings);
		
		award.displayAwards(player);
	}
	
	void addAge() {
		this.age++;
	}
	
	void newContract(CreatePlayer player) {
		this.position = rng.randPosition(player);
		this.contract = rng.randContract();
		this.remainingContract = this.contract - 1;
		this.conference = rng.randConference();
		this.team = randTeam.randTeam(this.conference);
	}
	
	void extendContract(CreatePlayer player) {
		this.contract = rng.randContract();
		this.remainingContract = this.contract - 1;
	}
	
	void minusContractTime() {
		this.remainingContract--;
	}
	
	void isInjured(CreatePlayer player) {
		this.injured = rng.isInjured(player);
		if (this.injured) this.injuries++;
	}
	
	void retireAfterInjury(CreatePlayer player) {
		if (player.injuries == 3) this.forceRetirment = true;
		else this.forceRetirment = false;
	}

}

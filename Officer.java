package il.ac.tau.cs.sw1.ex9.starfleet;

public class Officer extends CrewWoman{
	private static int instanceNumbe=0;
	OfficerRank rank;
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age, yearsInService, name);
		this.rank=rank;
	}
	public OfficerRank getRank() {
		return this.rank;
	}
	
	public String toString() {
		return super.toString()+"\n"+"\t"+"Rank="+this.getRank().toString();
	}

	
}

package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends CrewWoman{
	int modelNumber;
	private static int instanceNumber=0;
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber=modelNumber;
	}
	
	public int getModelNumber() {
		return this.modelNumber;
	}
	public String toString() {
		return super.toString()+"\n"+"\t"+"ModelNumber="+this.getModelNumber();
	}

}

package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Fighter{
	
protected int numberOfTechnicians;
protected int sumOfAnnualMaintenanceCostAfterDiscount;
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		this.numberOfTechnicians=numberOfTechnicians;
		sumOfAnnualMaintenanceCostAfterDiscount= (int) Math.round(this.sumOfAnnualMaintenanceCost-(0.1*this.numberOfTechnicians*this.sumOfAnnualMaintenanceCost));
		this.sumOfAnnualMaintenanceCost=sumOfAnnualMaintenanceCostAfterDiscount;
		this.totalAnnualCost=this.sumOfAnnualMaintenanceCost+5000;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return this.totalAnnualCost;
	}
	public String toString() {
		return super.toString()+"\n\tNumberOfTechnicians="+this.numberOfTechnicians;
	}
	
	

}

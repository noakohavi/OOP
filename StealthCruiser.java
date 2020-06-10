package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	private static int numOfStealthCruisers=0;
	private static int instanceNumber=0;
	private static Collection<Weapon> laserArray= Arrays.asList(new Weapon("Laser Cannons",10,100));	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
	super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	this.numOfStealthCruisers+=1;
	
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers,new LinkedList<Weapon>(laserArray));
	
	}

	@Override
	public int getAnnualMaintenanceCost() {

		return this.totalAnnualCost+(this.numOfStealthCruisers*50);
	}
	
}

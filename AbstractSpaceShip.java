package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashMap;
import java.util.Set;
	
public abstract class AbstractSpaceShip implements Spaceship{
	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected int firePower=10;
	protected Set<? extends CrewMember> crewMembers;
	protected int annualMaintenanceCost;

	public AbstractSpaceShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
		this.name=name;
		this.commissionYear=commissionYear;
		this.maximalSpeed=maximalSpeed;
		this.crewMembers=crewMembers;
	}
	

	public String getName() {
		return this.name;
	}
	public int getCommissionYear() {
		return this.commissionYear;
	}
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}
	
	public Set<? extends CrewMember> getCrewMembers(){
		return this.crewMembers;
	}
	
	public int getFirePower() {
		return this.firePower;
	}
	public String toString() {
		return(this.getClass().getSimpleName()+"\n\tName="+this.name+"\n"+"\t"+"CommissionYear="+this.getCommissionYear()
		+"\n"+"\t"+"MaximalSpeed="+this.getMaximalSpeed()+"\n"+"\t"+"FirePower="+this.getFirePower()+"\n"+"\t"+
		"CrewMembers="+this.getCrewMembers().size()+"\n"+"\t"+"AnnualMaintenanceCost="+this.getAnnualMaintenanceCost());
	}
	public abstract int getAnnualMaintenanceCost();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSpaceShip other = (AbstractSpaceShip) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	


	
}

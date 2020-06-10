package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends AbstractSpaceShip{
	protected List<Weapon> weapons;
	protected int sumOfFirePower;
	protected int sumOfAnnualMaintenanceCost = 0;
	protected int totalAnnualCost;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear, maximalSpeed, crewMembers);
		this.weapons=weapons;
		for (Weapon weapon:weapons) {
			sumOfFirePower+=weapon.getFirePower();
		}
		this.firePower+=sumOfFirePower;
		for (Weapon weapon:weapons) {
			sumOfAnnualMaintenanceCost+=weapon.getAnnualMaintenanceCost();
		}
		this.totalAnnualCost=2500+this.sumOfAnnualMaintenanceCost+Math.round(1000*this.maximalSpeed);
	}
	@Override
	public int getFirePower() {
		return this.firePower;
		
	}
	

	@Override
	public int getAnnualMaintenanceCost() {

		return this.totalAnnualCost;
	}
	public List<Weapon> getWeapon(){
		return this.weapons;
	}
	public String toString() {
		return super.toString()+"\n"+"\t"+"WeaponArray="+this.getWeapon();
	}
	
	
	
}

package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends AbstractSpaceShip{
	private int cargoCapacity;
	private int passengerCapacity;
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, 
		int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.cargoCapacity=cargoCapacity;
		this.passengerCapacity=passengerCapacity;

	}
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}
	public int getAnnualMaintenanceCost() {
		return 3000+(5*this.cargoCapacity)+(3*this.passengerCapacity);
	}
	public String toString() {
		return super.toString()+"\n"+"\t"+"CargoCapacity="+this.getCargoCapacity()+"\n"+"\t"+"PassengerCapacity="+this.getPassengerCapacity();
	}

}

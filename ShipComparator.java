package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

class ShipComparator implements Comparator<Spaceship>{
	public ShipComparator(){
		
	}
	@Override
	public int compare(Spaceship spaceship1, Spaceship spaceship2) {
		if (Integer.compare(spaceship1.getFirePower(), spaceship2.getFirePower())>0){
			return -1;
		}
		else if(Integer.compare(spaceship1.getFirePower(), spaceship2.getFirePower())<0)
			return 1;
		else {//equal FirePower
			if(Integer.compare(spaceship1.getCommissionYear(),spaceship2.getCommissionYear())>0) {
				return -1;
			}
			else if(Integer.compare(spaceship1.getCommissionYear(),spaceship2.getCommissionYear())<0) {
				return 1;
			}
			
			else {//equal CommissionYear
				return spaceship1.getName().compareTo(spaceship2.getName());
			}
		}
	}
	
}

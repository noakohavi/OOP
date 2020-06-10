package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> listShip=new LinkedList<>(fleet);
		List<String> listString=new LinkedList<>();
		Collections.sort(listShip,new ShipComparator());
		for (Spaceship ship:listShip) {
			listString.add(ship.toString());
		}
		
		return listString;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> classesMap= new HashMap<>();
		for (Spaceship ship:fleet) {
			if (classesMap.containsKey(ship.getClass().getSimpleName())) {
				classesMap.replace(ship.getClass().getSimpleName(),classesMap.get(ship.getClass().getSimpleName())+1);
			}
			else {
				classesMap.put(ship.getClass().getSimpleName(),1);
			}
		}
		return classesMap;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum=0;
		for (Spaceship ship: fleet) {
			sum+=ship.getAnnualMaintenanceCost();
		}
		return sum;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponsSet= new HashSet<>();
		for (Spaceship ship:fleet) {
			if (ship instanceof Fighter) {
				for(Weapon weapon:((Fighter) ship).getWeapon()) {
					weaponsSet.add(weapon.getName());
				}
			}
		}
		return weaponsSet;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum=0;
		for (Spaceship ship:fleet) {
			sum+=ship.getCrewMembers().size();
		}
		return sum;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int numOfOfficers=0;
		int sumOfOfficersAges=0;
		for (Spaceship ship:fleet) {
			for (CrewMember crewMember:ship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					numOfOfficers+=1;
					sumOfOfficersAges+=crewMember.getAge();
				}
			}
		}
		return (float) sumOfOfficersAges/numOfOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer,Spaceship> highRankOfficers=new HashMap<>();
		for (Spaceship ship:fleet) {
			Officer highestRankOfficer = null;
			for (CrewMember crewMember:ship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					if (highestRankOfficer==null) {
						highestRankOfficer=(Officer)crewMember;
						highRankOfficers.put(highestRankOfficer,ship);	
					}
					else {
						if((highestRankOfficer.getRank().compareTo(((Officer)crewMember).getRank()))<0) {
							highRankOfficers.remove(highestRankOfficer);
							highestRankOfficer=(Officer)crewMember;
							highRankOfficers.put(highestRankOfficer,ship);
						}
					}
				}
			}
		}
		return highRankOfficers;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank,Integer> numOfRanks= new HashMap<>();
		/*numOfRanks.put(OfficerRank.Ensign,0);
		numOfRanks.put(OfficerRank.Lieutenant,0);
		numOfRanks.put(OfficerRank.LieutenantCommander,0);
		numOfRanks.put(OfficerRank.Commander,0);
		numOfRanks.put(OfficerRank.Captain,0);
		numOfRanks.put(OfficerRank.Admiral,0);
		*/
		for (Spaceship ship: fleet) {
			for (CrewMember crewMember: ship.getCrewMembers()) {
				if (crewMember instanceof Officer) {
					
					OfficerRank tempRank= ((Officer)crewMember).getRank();
					if (!numOfRanks.containsKey(tempRank)) {
						numOfRanks.put(tempRank,1);
					}
					else {
					numOfRanks.replace(tempRank,numOfRanks.get(tempRank)+1);
					}
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> couples= new LinkedList<>(numOfRanks.entrySet());
		Collections.sort(couples,(x,y)->Integer.compare(x.getValue(), y.getValue()));
		return couples;
	}

}

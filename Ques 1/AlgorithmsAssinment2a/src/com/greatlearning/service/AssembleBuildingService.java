package com.greatlearning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.greatlearning.model.SkyscraperAssembly;

public class AssembleBuildingService {

	private SkyscraperAssembly[] buildingArrayObj;
	private Queue<Integer> floorSize=null;
	private Queue<Integer> floorSizeSorted=null;
	private ArrayList<String> ar=null;
	private int[] sortFloorSize=null;

	private boolean nextIdentified =false;

	public AssembleBuildingService(SkyscraperAssembly[] buildingArrayObj) {
		this.buildingArrayObj=buildingArrayObj;
	}

	public SkyscraperAssembly[] assembleBuilding() {
		try {
			//Local variable Declarations
			int j , k = 0;
			int noOfFloors=buildingArrayObj.length;
			int nextmaxexpected=0;
			int q1Popped=0;
			String tempStr="";

			//Initialization
			floorSize=new LinkedList<Integer> ();
			floorSizeSorted=new LinkedList<Integer> ();
			ar=new ArrayList<String>();
			sortFloorSize=new int[buildingArrayObj.length];

			//Floor Size assignment, sorting and adding to Queue & Array DS
			for  (SkyscraperAssembly building : buildingArrayObj ) {
				floorSize.add(building.getFloorSizeDeivered());
				sortFloorSize[k]=building.getFloorSizeDeivered();
				k++;
			}
			Arrays.sort(sortFloorSize);
			for (int i=(noOfFloors-1);i>=0;i--) {
				floorSizeSorted.add(sortFloorSize[i]);
			}
			nextmaxexpected=floorSizeSorted.peek();

			for (int i=0;i<noOfFloors;i++) {
				//If expected floor size received for the day
				if (nextmaxexpected == floorSize.peek() ) {
					q1Popped=floorSize.poll();
					tempStr="";
					ar.add(String.valueOf(q1Popped));

					do {
						if(ar.contains(String.valueOf(nextmaxexpected))){
							ar.remove (ar.indexOf(String.valueOf(nextmaxexpected)));
							tempStr= tempStr + " " + String.valueOf(floorSizeSorted.poll());
							if (floorSizeSorted.size() == 0)
								break;
							nextmaxexpected=floorSizeSorted.peek();
							nextIdentified=true;
						}else {
							nextIdentified=false;
						}
					}while ((nextIdentified==true) && (floorSizeSorted.size()>0));

					buildingArrayObj[i].setFloorAssembled(tempStr);
				}
				else {//If expected floor size NOT received for the day
					q1Popped=floorSize.poll();
					ar.add(String.valueOf(q1Popped));
					buildingArrayObj[i].setFloorAssembled("");
				}
			}
			return buildingArrayObj;
		}catch(Exception ex){
			System.out.println("Exception" + ex.getMessage());
			return null;
		}		
	}

}

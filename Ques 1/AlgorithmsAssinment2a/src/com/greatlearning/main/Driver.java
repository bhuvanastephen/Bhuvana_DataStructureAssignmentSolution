package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.model.SkyscraperAssembly;
import com.greatlearning.service.AssembleBuildingService;

public class Driver {

	private static Scanner sc =new Scanner(System.in);
	private static SkyscraperAssembly[] building = null;
	private static AssembleBuildingService assembleService=null;

	public static void main(String[] args) {
		
		int operation = 0;
		int noOfFloors = 0;
		try {
			
			do {
				//Display Operations
				operation= displayOptions();
				switch(operation) {
				case 1:
					//Get number of Floors
					System.out.println("Enter the total no of floors in the building");
					noOfFloors= sc.nextInt();
					building= new SkyscraperAssembly[noOfFloors];
					
					//Add Floor Size delivered for each day
					for (int i=0;i<noOfFloors;i++) {
						building[i]=new SkyscraperAssembly();
						building[i].addFloorSizeDetails(i);
					}
					
					//Assemble the Building based on floor size delivered
					assembleService= new AssembleBuildingService(building);
					building=assembleService.assembleBuilding();
					
					//Print Building Assembled Daily
					SkyscraperAssembly.printFloorSizeDetails(building);
					break;
				
				case 0:
					//Exit
					System.out.println("Exited successfully");
					System.out.println("Happy Building !!!");
					break;
				default:
					//Invalid Option
					System.out.println("Invalid option-- Press 0 to exit");
					break;
				}
			}while (operation != 0);
		}catch(Exception ex ){
			System.out.println("Exception" + ex.getMessage());
		}
	}

	public static int displayOptions() {

		int choice = 0;

		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Construct New Building");
		System.out.println("0. Press 0 to exit");
		try {
			choice=sc.nextInt();
		}
		catch(Exception ex){
			System.out.println("Invalid choice " + ex.getMessage());
		}

		return choice;
	}

}

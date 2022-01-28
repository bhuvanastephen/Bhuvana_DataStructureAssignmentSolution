package com.greatlearning.model;

import java.util.Scanner;

public class SkyscraperAssembly {
	private String dayNo ="";
	private int floorSizeDeivered =0;
	private String floorAssembled ="";
	private static Scanner sc = new Scanner(System.in);

	

	public String getDayNo() {
		return dayNo;
	}

	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}

	public int getFloorSizeDeivered() {
		return floorSizeDeivered;
	}

	public void setFloorSizeDeivered(int floorSizeDeivered) {
		this.floorSizeDeivered = floorSizeDeivered;
	}

	public String getFloorAssembled() {
		return floorAssembled;
	}

	public void setFloorAssembled(String floorAssembled) {
		this.floorAssembled = floorAssembled;
	}

	public void addFloorSizeDetails(int dayNo ) {
		Boolean inputCorrectFormat = true;
		dayNo = dayNo + 1;
		do {
			try {
				this.dayNo  = String.valueOf(dayNo);
				System.out.println("Enter the floor size given on day : " + this.dayNo);
				this.floorSizeDeivered = sc.nextInt();
				inputCorrectFormat = true;
			}catch(Exception ex) {
				System.out.println("Invalid input format, please input again ");
				inputCorrectFormat = false;
				sc =new Scanner(System.in);
			}
		}while(inputCorrectFormat == false);
	}

	
	public static void printFloorSizeDetails(SkyscraperAssembly[] buildingArrayObj ) {

		System.out.println("--------------------Company Stock details-------------------");
		System.out.print("  Day-No\t");
		System.out.print(" Floor-Delivered  \t");
		System.out.print("Floor-Assembled\n");
		for  (SkyscraperAssembly building : buildingArrayObj ) {
			System.out.print(" " + building.getDayNo() + "\t\t");
			System.out.print(" " + building.getFloorSizeDeivered() + "\t\t");
			System.out.print("\t" + building.getFloorAssembled() + "\n");
		}
		System.out.println("------------------------------------------------------------");
	}

}

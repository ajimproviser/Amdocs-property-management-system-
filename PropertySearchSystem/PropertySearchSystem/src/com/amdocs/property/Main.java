package com.amdocs.property;
import java.util.*;
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			while (true) {
				System.out.println("\n 1. Add new property.");
				System.out.println("\n 2. Update property.");
				System.out.println("\n 3. Delete property ");
				System.out.println("\n 4. Find by city");
				System.out.println("\n 5. View all properties.");
				System.out.println("\n 6. Find by cost.");
				System.out.println("\n 7. Find by number of rooms and city.");
				System.out.println("\n 8. Exit");
				System.out.println("\n Enter your choice");
				//if(sc.hasNext())sc.next();
				int ch = sc.nextInt();//Integer.parseInt(sc.nextLine());
				switch (ch) {
				case 1:
					App.addProperty();
					break;
				case 2:
					App.updatePropertyCost();
					break;
				case 3:
					App.deleteProperty();
					break;
				case 4:
					App.searchByCity();
					break;
				case 5:
					App.showAllProperty();
					break;
				case 6:
					App.searchByCost(sc);
					break;
				case 7:
					App.searchByNoOfRoomsAndCity();
					break;
				case 8:
					System.exit(0);
					break;
				default:
					System.out.println("Try again");
					break;
				}
			}
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error : " + e.getMessage());
		}
	}
}
	

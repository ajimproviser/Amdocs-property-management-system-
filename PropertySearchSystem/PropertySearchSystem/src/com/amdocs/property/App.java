package com.amdocs.property;
import java.util.*;
import com.amdocs.property.model.*;
import com.amdocs.property.dao.*;

public class App{
	static List<Property> propertylist=new ArrayList<Property>();
	protected static Property createProperty() {
		Scanner sc=new Scanner(System.in);
		Property obj = new Property();
		try {
			System.out.println("Enter propertyId: ");
			int id = sc.nextInt();
			obj.setPropertyId(id);
			id=obj.getPropertyId();
		
			sc.nextLine();
			System.out.println("Enter no of Rooms: ");
			String noRooms = sc.nextLine();
			obj.setNoOfRooms(noRooms);
			noRooms=obj.getNoOfRooms();
			
			System.out.println("Enter no of Area in Sqft: ");
//			double areaSqft = Double.parseDouble(scanner.nextLine());
			double areaSqft = sc.nextDouble();
			obj.setAreaInSqft(areaSqft);
			areaSqft=obj.getAreaInSqft();
			
			System.out.println("Enter the floor number: ");
			int floorNo = sc.nextInt();
			obj.setFloorNo(floorNo);
			floorNo=obj.getFloorNo();
			
			System.out.println("Enter your city: ");
			sc.nextLine();
			String city = sc.nextLine();
			obj.setCity(city);
			city=obj.getCity();
			
			System.out.println("Enter your State: ");
			String state = sc.nextLine();
			obj.setState(state);
			state=obj.getState();
			
			System.out.println("Enter the price: ");
//			double areaSqft = Double.parseDouble(scanner.nextLine());
			double cost = sc.nextDouble();
			obj.setCost(cost);
			cost=obj.getCost();
			
			System.out.println("Enter your name: ");
			sc.nextLine();
			String oname = sc.nextLine();
			obj.setOwnerName(oname);
			oname=obj.getOwnerName();
			
			System.out.println("Enter your contact no: ");
			String ocontact = sc.nextLine();
			obj.setOwnerContactNo(ocontact);
			ocontact=obj.getOwnerContactNo();
			
		}
		catch (NumberFormatException e) {
			System.out.println("Please Provide a number value\n " + e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e);	
		}

		return obj;
	}

	protected static void displayProperty(Property property) {
		System.out.println(property);							// from - to string 
	}

	protected static PropertyDao dao = new PropertyDaoImp();
	

	protected static void addProperty() {
		Property createProperty;
//		try {
			createProperty = createProperty();
//			propertylist.add(createProperty);
			int id= dao.addProperty(createProperty);
//		} catch (SQLException e) {
//			System.out.println(e);
//		}	
//		}catch (SystemException e) {
//			System.out.println(e);
//		}
			System.out.println("The property details are updated ,your property ID is "+ id);
		
	}
	
	protected static void deleteProperty() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the property you wanna delete: ");
		int id=sc.nextInt();
		int del=dao.deleteProperty(id);	
		System.out.println("The property details with ID: "+ del + " is deleted");
	}
	
	protected static void updatePropertyCost() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id number you want to update: ");
		int id=sc.nextInt();
		System.out.println("Enter the new cost: ");
		Double cost=sc.nextDouble();
		dao.updatePropertyCost(id,cost);
	}
	
	protected static void searchByCity() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the city name you wanna search: ");
		String city=sc.nextLine();
		List<Property> list1=dao.ByCity(city);
		if(list1.isEmpty())
		{
			System.out.println("no property found");
		}
		System.out.println(list1);
	}
	protected static void showAllProperty() {
		PropertyDao dao=new PropertyDaoImp();
		List<Property> allProperty = dao.showAllProperties();
		for (Property property : allProperty) {
			if (property != null)
				System.out.println(property);
		}
	}
	protected static void searchByCost(Scanner sc) {
		PropertyDao dao=new PropertyDaoImp();
		System.out.println("Minimum price: ");
		//Scanner sc=new Scanner(System.in);
		Double min=sc.nextDouble();
		System.out.println("Maximum price: ");
		Double max=sc.nextDouble();
		List<Property> allProperty = dao.searchByCost(min, max);
		//sc.close();
		if(allProperty.isEmpty())
		{
			System.out.println("No property found");
		}
		for (Property property : allProperty) {
			if (property != null)
			{
				System.out.println(property);
			}
		}
	}
	protected static void searchByNoOfRoomsAndCity() {
		PropertyDao dao=new PropertyDaoImp();
		System.out.println("Enter the city name: ");
		Scanner sc=new Scanner(System.in);
		String room=sc.nextLine();
		System.out.println("Enter the no of rooms in terms of BHK: ");
		String city=sc.nextLine();
		List<Property> allProperty = dao.searchByNoOfRoomsAndCity(room,city);
		if(allProperty.isEmpty())
		{
			System.out.println("no property found");
		}
		for (Property property : allProperty) {
			if (property != null)
				System.out.println(property);
		}
	}
	
	
}


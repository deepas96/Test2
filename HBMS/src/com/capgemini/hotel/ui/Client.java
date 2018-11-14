package com.capgemini.hotel.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Scanner;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.exception.HotelException;
import com.capgemini.hotel.service.HotelService;
import com.capgemini.hotel.util.DBUtil;

public class Client {

	
	public static void main(String[] args) throws HotelException {
		
		Connection conn = DBUtil.getConnection();
		System.out.println("\tWelcome to Star Hotel\t");
		System.out.println("1. Book Room");
		System.out.println("2. Exit");
		
		Scanner scan = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		int choice;
		String ch = "";
		
		System.out.println("Enter your choice:");
		choice = scan.nextInt();
		HotelService service = new HotelService();
		
		do{
			if(choice == 1)
			{
			
				String name,email,address,mobile,roomType;
				int roomNo;
				
				while(true){
					
				boolean isValid;
				System.out.println("Enter Customer Name:");
				try {
					name = reader.readLine();
					isValid = service.validateName(name);
				} catch (IOException e) {
					//e.printStackTrace();
					throw new HotelException("Invalid input");
				}
				
				if(isValid)
					break;
				
				else 
					System.out.println("Please enter name in correct format");
				}
			
				
				while(true){
				System.out.println("Enter Email:");
				email = scan.next();
				boolean isValid = service.validateEmail(email);
				if(isValid)
					break;
				
				else 
					System.out.println("Please enter email in correct format");
				
				}
				
				while(true){
				boolean isValid;
				System.out.println("Enter Customer Address:");
				try {
					address = reader.readLine();
					isValid = service.validateAddress(address);
				} catch (IOException e) {
//					e.printStackTrace();
					throw new HotelException("Invalid input");
				}
				
				if(isValid)
					break;
				
				System.out.println("Please enter address in 25 characters");
				}
				
				
			
				while(true){
				System.out.println("Enter Mobile No:");
				mobile = scan.next();
				boolean isValid = service.validateMobile(mobile);
				if (isValid)
					break;
				else
					System.out.println("Please enter correct mobile number");
				}
				
				
				while(true){
				System.out.println("Room No:");
				roomNo = scan.nextInt();
				boolean isValid = service.validateRoomNo(roomNo);
				if (isValid)
					break;
				else
					System.out.println("Please enter correct room number");
				}
				
				while(true){
				System.out.println("Room Type:");
				roomType = scan.next();
				boolean isValid = service.validateRoomType(roomType);
				if (isValid)
					break;
				else
					System.out.println("Please enter correct room type");
				}
				
				
				CustomerBean customer = new CustomerBean();
				customer.setCustName(name);
				customer.setEmail(email);
				customer.setCustAddress(address);
				customer.setMobile(mobile);
				if ((roomNo >=101 && roomNo <=103)||(roomNo >=201 && roomNo <=203)){
					customer.setRoomNo(roomNo);
					customer.setStatus("Booked");
				}
				else {
					customer.setStatus("Not booked");
				}
//				else {
//					customer.setRoomNo()
//				}
				
				customer.setRoomType(roomType);
				
				int id = service.addCustomerDetails(customer);
				System.out.println("Your Room has been successfully booked, your Customer ID is : "+id);
				
			}
			else if(choice == 2)
			{
				System.out.println("Exiting ...");
				break;
			}
			else {
				System.out.println("Please enter correct choice");
			}
		
			System.out.println("Do you wish to continue ...");
			ch = scan.next();
		}while(ch.equalsIgnoreCase("yes"));
		
		
		
	}
}

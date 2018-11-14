package com.capgemini.hotel.service;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.dao.CustomerBookingDAO;
import com.capgemini.hotel.exception.HotelException;

public class HotelService implements IHotelService{

	CustomerBookingDAO dao = new CustomerBookingDAO();
	public boolean validateName(String name){
		
		if (name.matches("[a-zA-Z ]{1,25}"))
			return true;
		else 
			return false;
	}
	
	public boolean validateEmail(String email){
		
		//if (email.matches("/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,6}$/"))
			return true;
//		else 
//			return false;
	}
	
	public boolean validateAddress(String address){
		
		if (address.matches("[a-zA-Z0-9/,]{1,25}"))
			return true;
		else 
			return false;
	}

	
	public boolean validateMobile(String mobile){
		
		if (mobile.matches("[0-9]{10}") && (mobile.charAt(0) == '9' || mobile.charAt(0) == '7' || mobile.charAt(0) == '8'))
			return true;
		else 
			return false;
		
	}
	
	public boolean validateRoomNo(int roomNo){
		
		if ((roomNo >=101 && roomNo <=103)||(roomNo >=201 && roomNo <=203))
			return true;
		else 
			return false;
		
	}
	public boolean validateRoomType(String roomType){
	
		String arr[] = {"AC_SINGLE", "AC_DOUBLE", "NONAC_SINGLE", "NONAC_DOUBLE"};
		int valid = 0;
		for (String s: arr){
			if (roomType.equalsIgnoreCase(s))
				valid = 1;
		}
		
		if (valid == 1)
			return true;
		else 
			return false;

	
}
	@Override
	public int addCustomerDetails(CustomerBean bean) throws HotelException {
		return dao.addCustomerDetails(bean);
	}

	@Override
	public boolean validateCustomer(CustomerBean bean) {

		if (validateEmail(bean.getEmail()))
			return true;
		else if (validateAddress(bean.getCustAddress()))
			return true;
		else if (validateMobile(bean.getMobile()))
			return true;
		else if (validateName(bean.getCustName()))
			return true;
		else if (validateRoomNo(bean.getRoomNo()))
			return true;
		else if (validateRoomType(bean.getRoomType()))
			return true;
		else if (validateName(bean.getCustName()))
			return true;
		else 
			return false;
		
	}
	
	
	
}

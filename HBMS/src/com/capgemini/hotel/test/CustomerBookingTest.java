package com.capgemini.hotel.test;

import org.junit.Test;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.dao.CustomerBookingDAO;
import com.capgemini.hotel.exception.HotelException;



public class CustomerBookingTest {

	
	@Test (expected=HotelException.class) 
	public void testSearchForValidInput() throws HotelException{
		
		CustomerBookingDAO dao = new CustomerBookingDAO();
		CustomerBean bean = new CustomerBean();
		
		int i = dao.addCustomerDetails(bean);

		//Assert.assertNull(bean); //case fail if object 
		
	}
	
}

package com.capgemini.hotel.dao;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.exception.HotelException;

public interface ICustomerBookingDAO {

	int addCustomerDetails(CustomerBean bean)  throws HotelException;
	
}

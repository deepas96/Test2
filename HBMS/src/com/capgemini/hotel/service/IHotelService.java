package com.capgemini.hotel.service;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.exception.HotelException;

public interface IHotelService {

	int addCustomerDetails (CustomerBean bean) throws HotelException;
	
	boolean validateCustomer(CustomerBean bean);
	
}

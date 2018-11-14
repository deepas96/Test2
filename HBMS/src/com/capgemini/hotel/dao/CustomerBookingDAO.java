package com.capgemini.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.exception.HotelException;
import com.capgemini.hotel.util.DBUtil;

public class CustomerBookingDAO implements ICustomerBookingDAO{

	Connection connection;
	Logger logger = Logger.getLogger(CustomerBookingDAO.class.getName( ));
	

	
	public CustomerBookingDAO() {
		connection = DBUtil.getConnection();
      	PropertyConfigurator.configure("log4j.properties");

	}
	
	
	@Override
	public int addCustomerDetails(CustomerBean bean) throws HotelException {
		
		String sql = "INSERT INTO CustomerDetails_161082 VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			
			int custId = generateCustomerId();
			bean.setCustId(custId);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, custId);
			ps.setString(2, bean.getCustName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getCustAddress());
			ps.setString(5, bean.getMobile());
			ps.setString(6, bean.getRoomType());
			ps.setInt(7, bean.getRoomNo());
			ps.setString(8, bean.getStatus());
			
			int i = ps.executeUpdate();
			//System.out.println("Values updated"+i);
			logger.info("Customer booked a room "+ bean);
			return custId;
		} catch (SQLException e) {
			
			throw new HotelException(e.getMessage());
		}
	
	}

	private int generateCustomerId() {
		
		String sql="SELECT CustomerID_SEQ.nextval FROM DUAL";
		
		Statement stmt;
		int custId = 0;
		try {
			stmt = connection.createStatement();
			ResultSet rSet = stmt.executeQuery(sql);
			if(rSet.next())
			{
				 custId = rSet.getInt(1);
			
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//
		}
		return custId;
	}

	
	
}

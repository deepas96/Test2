package com.capgemini.hotel.bean;

public class CustomerBean {

	//class attributes
	private int custId;
	private String custName;
	private String email;
	private String custAddress;
	private String mobile;
	private int roomNo;
	private String roomType;
	private String status;
	
	
	//constructors
	public CustomerBean() {
		super();
	}


	public CustomerBean(int custId, String custName, String email, String custAddress,
			String mobile, int roomNo, String roomType, String status) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.email = email;
		this.custAddress = custAddress;
		this.mobile = mobile;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.status = status;
	}

	//get set methods
	
	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCustAddress() {
		return custAddress;
	}


	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public int getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
}

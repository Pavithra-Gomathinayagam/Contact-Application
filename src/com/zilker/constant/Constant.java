package com.zilker.constant;

public class Constant {

	public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/contactDB";
	public static final String USERNAME="root";
	public static final String PASSWORD="";
	public static final String INSERT_CONTACT = "INSERT INTO Contact(firstName,lastName,email) VALUES(?,?,?)";
	public static final String SELECT_QUERY= "select * from Contact where email = ?";
	public static final String INSERT_HOME = "INSERT INTO Home VALUES(?,?,?,?)";
	public static final String INSERT_OFFICE = "INSERT INTO Office VALUES(?,?,?)";
	public static final String INSERT_MOBILE = "INSERT INTO Mobile VALUES(?,?,?)";
	public static final String DELETE_CONTACT= "DELETE FROM Contact WHERE contId = ?";
	public static final String UPDATE_NAME= "UPDATE Contact SET firstName = ? , lastName = ? where contId = ?";
	public static final String UPDATE_HOME = "UPDATE Home SET areaCode = ? , countryCode = ? , homeNo = ? where contId = ? and homeNo = ?";
	public static final String UPDATE_OFFICE = "UPDATE Office SET ofcExtn = ? , ofcNo = ? where contId = ? and ofcNo = ?";
	public static final String UPDATE_MOBILE = "UPDATE Mobile SET mobExtn = ? , mobNo = ? where contId = ? and mobNo = ?";
	public static final String SELECT_CONTACT= "SELECT * FROM Contact where contId = ?";
	public static final String SELECT_HOME = "SELECT * FROM Home where contId = ?";
	public static final String SELECT_OFFICE = "SELECT * FROM Office where contId = ?";
	public static final String SELECT_MOBILE = "SELECT * FROM Mobile where contId = ?";
	public static final String EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
	public static final String AREA_CODE = "[1-9]{2,3}";
	public static final String COUNTRY_CODE = "^\\+[1-9]{1,3}";
	public static final String HOME_NO = "[1-9]{6,7}";
	public static final String OFFICE_EXTENSION = "[1-9]{3,5}";
	public static final String OFFICE_NO = "[0-9]{6,8}";
	public static final String MOBILE_EXTENSION = "^\\+[1-9]{1}[0-9]{1,3}$";
	public static final String MOBILE_NO = "^[789]\\d{9}$";
	
}

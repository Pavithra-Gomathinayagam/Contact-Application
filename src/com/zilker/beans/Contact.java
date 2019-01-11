package com.zilker.beans;

public class Contact {

	private String firstName, lastName, email;
	private int areaCode, countryCode, homeNo, ofcExtn, ofcNo, mobExtn, oldhomeNo, oldofcNo;
	private long mobNo, oldmobNo;
	
	public Contact()
	{
	
	}

	
	public int getOldhomeNo() {
		return oldhomeNo;
	}


	public void setOldhomeNo(int oldhomeNo) {
		this.oldhomeNo = oldhomeNo;
	}



	public long getOldmobNo() {
		return oldmobNo;
	}


	public void setOldmobNo(long oldmobNo) {
		this.oldmobNo = oldmobNo;
	}


	public int getOldofcNo() {
		return oldofcNo;
	}


	public void setOldofcNo(int oldofcNo) {
		this.oldofcNo = oldofcNo;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public int getHomeNo() {
		return homeNo;
	}

	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}

	public int getOfcExtn() {
		return ofcExtn;
	}

	public void setOfcExtn(int ofcExtn) {
		this.ofcExtn = ofcExtn;
	}

	public int getOfcNo() {
		return ofcNo;
	}

	public void setOfcNo(int ofcNo) {
		this.ofcNo = ofcNo;
	}

	public int getMobExtn() {
		return mobExtn;
	}

	public void setMobExtn(int mobExtn) {
		this.mobExtn = mobExtn;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	



}
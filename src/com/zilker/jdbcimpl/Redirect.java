package com.zilker.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zilker.beans.Contact;
import com.zilker.constant.Constant;
import com.zilker.dao.ContactDAO;

public class Redirect {

	private static final Logger logger = Logger.getLogger(Redirect.class.getName());
	Scanner sc = new Scanner(System.in);
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private static Pattern pattern;
	private static Matcher matcher;
	
	void insert()
	{
		try {
			Contact contact = new Contact();
			ContactDAO contactdao = new ContactDAO();
			
			logger.log(Level.INFO,"Enter FirstName");
			String firstName = sc.next();
			
			logger.log(Level.INFO,"Enter lastname");
			String lastName = sc.next();
			int counter=0;
			String email="";
			int areaCode = 0,countryCode = 0,homeNo = 0,ofcExtn = 0,ofcNo = 0,mobExtn = 0;
			long mobNo = 0;
			//logger.log(Level.INFO,"Enter email");
			//email = sc.next();
			
			do {
				
			logger.log(Level.INFO,"Enter email");
			String emailID = sc.next();
			pattern = Pattern.compile(Constant.EMAIL);
			matcher = pattern.matcher(emailID);
				if(matcher.matches()==true)
				{
					email = String.valueOf(emailID);
					counter = 1;
					break;
				}
				else
					logger.log(Level.INFO,"Invalid email");
			}while(counter!=1);
			
			
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setEmail(email);
			contactdao.insertContact(contact);
			
			counter = 0;
			logger.log(Level.INFO,"Do you want to add home number?(Y|N)");
			char choice;
			int count;
			choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				logger.log(Level.INFO,"Enter the total number of home number to be added");
				count=sc.nextInt();
				String area_Code,country_Code,home_No;
				for(int i=0;i<count;i++)
				{
					do {
						
					logger.log(Level.INFO,"Enter area code");
					area_Code = sc.next();
					pattern = Pattern.compile(Constant.AREA_CODE);
					matcher = pattern.matcher(area_Code);
						if(matcher.matches()==true)
						{
							areaCode = Integer.parseInt(area_Code);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid areacode");
					
					}while(counter!=1);
					counter = 0;
					
					do {
						
					logger.log(Level.INFO,"Enter country code");
					country_Code = sc.next();
					pattern = Pattern.compile(Constant.COUNTRY_CODE);
					matcher = pattern.matcher(country_Code);
						if(matcher.matches()==true)
						{
							countryCode = Integer.parseInt(country_Code);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid countrycode");
					
					}while(counter!=1);
					counter = 0;
					
					do {
					
					logger.log(Level.INFO,"Enter home number");
					home_No = sc.next();
					pattern = Pattern.compile(Constant.HOME_NO);
					matcher = pattern.matcher(home_No);
						if(matcher.matches()==true)
						{
							homeNo = Integer.parseInt(home_No);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid Home no");
					
					}while(counter!=1);
					
					contact.setAreaCode(areaCode);
					contact.setCountryCode(countryCode);
					contact.setHomeNo(homeNo);
					contactdao.insertHome(contact);
					counter = 0;
				}
			}
			
			logger.log(Level.INFO,"Do you want to add office number?(Y|N)");
			choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				logger.log(Level.INFO,"Enter the total number of office number to be added");
				count=sc.nextInt();
				String ofc_Extn,ofc_No;
				for(int i=0;i<count;i++)
				{
					do {
						
					logger.log(Level.INFO,"Enter office extension");
					ofc_Extn = sc.next();
					pattern = Pattern.compile(Constant.OFFICE_EXTENSION);
					matcher = pattern.matcher(ofc_Extn);
						if(matcher.matches()==true)
						{
							ofcExtn = Integer.parseInt(ofc_Extn);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid Office no");
					
					}while(counter!=1);
					
					counter = 0;
					
					do {
						
					logger.log(Level.INFO,"Enter office number");
					ofc_No = sc.next();
					pattern = Pattern.compile(Constant.OFFICE_NO);
					matcher = pattern.matcher(ofc_No);
						if(matcher.matches()==true)
						{
							ofcNo = Integer.parseInt(ofc_No);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid office no");
					}
					while(counter!=1);
					contact.setOfcExtn(ofcExtn);
					contact.setOfcNo(ofcNo);
					contactdao.insertOffice(contact);
				}
			}
			
			logger.log(Level.INFO,"Do you want to add mobile number?(Y|N)");
			choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				logger.log(Level.INFO,"Enter the total number of mobile number to be added");
				count=sc.nextInt();
				String mob_Extn,mob_No;
				for(int i=0;i<count;i++)
				{
					do {
						
					logger.log(Level.INFO,"Enter mobile extension");
					mob_Extn = sc.next();
					
					pattern = Pattern.compile(Constant.MOBILE_EXTENSION);
					matcher = pattern.matcher(mob_Extn);
						if(matcher.matches()==true)
						{
							mobExtn = Integer.parseInt(mob_Extn);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid Home no");
					}while(counter != 1);
					counter = 0;
					
					do {
						
					logger.log(Level.INFO,"Enter mobile number");
					mob_No = sc.next();
					
					pattern = Pattern.compile(Constant.MOBILE_NO);
					matcher = pattern.matcher(mob_No);
						if(matcher.matches()==true)
						{
							mobNo = Long.parseLong(mob_No);
							counter = 1;
							break;
						}
						else
							logger.log(Level.INFO,"Invalid Home no");
					}while(counter!=1);
					contact.setMobExtn(mobExtn);
					contact.setMobNo(mobNo);
					contactdao.insertMobile(contact);
				}
			}
			
		}
		catch(Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
		
	  }
	
	void delete()
	{
		logger.log(Level.INFO,"Enter the email");
		String email = sc.next();
		
		Contact contact = new Contact();
		ContactDAO contactdao = new ContactDAO();
		
		contact.setEmail(email);
		contactdao.deleteContact(contact);
		
	}
	
	void edit()
	{
		try {
			
			Contact contact = new Contact();
			ContactDAO contactdao = new ContactDAO();
			
			logger.log(Level.INFO,"Enter the email");
			String email = sc.next();
			
			logger.log(Level.INFO,"Enter the Firstname");
			String firstName = sc.next();
			
			logger.log(Level.INFO,"Enter the lastName");
			String lastName = sc.next();
			
			contact.setEmail(email);
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contactdao.editName(contact);
			
			logger.log(Level.INFO,"Do you want to edit home?(Y|N)");
			char choice;
			int count;
			choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				logger.log(Level.INFO,"how many numbers you want to edit?");
				count=sc.nextInt();
				for(int i=0;i<count;i++)
				{
					logger.log(Level.INFO,"Enter the old number");
					int oldhomeNo = sc.nextInt();
					
					logger.log(Level.INFO,"Enter area code");
					int areaCode = sc.nextInt();
					
					logger.log(Level.INFO,"Enter country code");
					int countryCode = sc.nextInt();
					
					logger.log(Level.INFO,"Enter home number");
					int homeNo = sc.nextInt();
					
					contact.setAreaCode(areaCode);
					contact.setCountryCode(countryCode);
					contact.setHomeNo(homeNo);
					contact.setOldhomeNo(oldhomeNo);
					contactdao.editHome(contact);
				}
			}
			
			logger.log(Level.INFO,"Do you want to edit Office?(Y|N)");
			choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				logger.log(Level.INFO,"how many numbers you want to edit?");
				count=sc.nextInt();
				for(int i=0;i<count;i++)
				{
					logger.log(Level.INFO,"Enter the old number");
					int oldofcNo = sc.nextInt();
					
					logger.log(Level.INFO,"Enter the office extension");
					int ofcExtn = sc.nextInt();
					
					logger.log(Level.INFO,"Enter the office number");
					int ofcNo = sc.nextInt();
					
					contact.setOfcExtn(ofcExtn);
					contact.setOfcNo(ofcNo);
					contactdao.editOfc(contact);
				}
			}
			
			logger.log(Level.INFO,"Do you want to edit Mobile?(Y|N)");
			choice=sc.next().charAt(0);
			if(choice=='Y'||choice=='y')
			{
				logger.log(Level.INFO,"how many numbers you want to edit?");
				count=sc.nextInt();
				for(int i=0;i<count;i++)
				{
					logger.log(Level.INFO,"Enter the old number");
					long oldmobNo = sc.nextLong();
					
					logger.log(Level.INFO,"Enter the mobile extension");
					int mobExtn = sc.nextInt();
					
					logger.log(Level.INFO,"Enter the mobile number");
					int mobNo = sc.nextInt();
					
					contact.setMobExtn(mobExtn);
					contact.setMobNo(mobNo);
					contact.setOldmobNo(oldmobNo);
					contactdao.editMob(contact);
				}
			}
			
			
		}
		catch(Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
		
	}
	void display()
	{
		try {
		
			logger.log(Level.INFO,"Enter the email");
			String email = sc.next();
			
			Contact contact = new Contact();
			ContactDAO contactdao = new ContactDAO();
			
			contact.setEmail(email);
			contactdao.displayContact(contact);
			
		}catch(Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
		
	}
	
}

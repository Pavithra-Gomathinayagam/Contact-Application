package com.zilker.jdbcimpl;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zilker.beans.Contact;
import com.zilker.dao.ContactDAO;

public class JDBC {
	
private static final Logger logger = Logger.getLogger(JDBC.class.getName());
	
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		try {
			
			do {
			logger.log(Level.INFO,"Enter the choice");
			logger.log(Level.INFO,"1.Create");
			logger.log(Level.INFO,"2.Edit");
			logger.log(Level.INFO,"3.Delete");
			logger.log(Level.INFO,"4.Display");
			logger.log(Level.INFO,"5.Exit");
			int ch=scn.nextInt();
			Redirect redirect = new Redirect(); 
			
				switch(ch)
				{
					case 1:
						redirect.insert();
						break;
				
					case 2:
						redirect.edit();
						break;
				
					case 3:
						redirect.delete();
						break;
				
					case 4:
						redirect.display();
						break;
			
					case 5:
						System.exit(0);
				}
			}while(true);
			}catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
			} finally {
			scn.close();
			}
	}

}

package com.zilker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zilker.beans.Contact;
import com.zilker.constant.Constant;
import com.zilker.utils.DBUtils;

public class ContactDAO {
	
	private static final Logger logger = Logger.getLogger(ContactDAO.class.getName());
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public void insertContact (Contact contact) {
		try {
			conn = DBUtils.getConnection();
			pst = conn.prepareStatement(Constant.INSERT_CONTACT);
			pst.setString(1, contact.getFirstName());
			pst.setString(2, contact.getLastName());
			pst.setString(3, contact.getEmail());
			
			int count = pst.executeUpdate();
			logger.log(Level.INFO, "Number of rows affected: " + count);
			} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error inserting contact details");
			} finally {
			DBUtils.closeConnection(conn, pst, rs);
			}
	}
	
	public void insertHome (Contact contact) {
		try {
			conn = DBUtils.getConnection();
			String sql = Constant.SELECT_QUERY;
			pst = conn.prepareStatement(sql);
			pst.setString(1,contact.getEmail());
			rs = pst.executeQuery();
			int contId = 0;
			if(rs.next())
				if(rs.getString(4).equals(contact.getEmail()))
				{
					String id = rs.getString(1);
					contId = Integer.parseInt(id);
				}
			pst = conn.prepareStatement(Constant.INSERT_HOME);
			pst.setInt(1,contId);
			pst.setInt(2,contact.getAreaCode());
			pst.setInt(3, contact.getCountryCode());
			pst.setInt(4, contact.getHomeNo());
			
			int count = pst.executeUpdate();
			logger.log(Level.INFO, "Number of rows affected: " + count);
			} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error inserting home details");
			} finally {
			DBUtils.closeConnection(conn, pst, rs);
			}
	}
		
	public void insertOffice (Contact contact) {
			try {
				conn = DBUtils.getConnection();
				String sql = Constant.SELECT_QUERY;
				pst = conn.prepareStatement(sql);
				pst.setString(1,contact.getEmail());
				rs=pst.executeQuery();
				int contId = 0;
				if(rs.next())
					if(rs.getString(4).equals(contact.getEmail()))
					{
						String id = rs.getString(1);
						contId = Integer.parseInt(id);
					}
				pst = conn.prepareStatement(Constant.INSERT_OFFICE);
				pst.setInt(1,contId);
				pst.setInt(2,contact.getOfcExtn());
				pst.setInt(3, contact.getOfcNo());
				
				int count = pst.executeUpdate();
				logger.log(Level.INFO, "Number of rows affected: " + count);
				} catch (SQLException e) {
				logger.log(Level.SEVERE, "Error inserting office details");
				} finally {
				DBUtils.closeConnection(conn, pst, rs);
				}

	}
	
	public void insertMobile (Contact contact) {
		try {
			conn = DBUtils.getConnection();
			String sql = Constant.SELECT_QUERY;
			pst = conn.prepareStatement(sql);
			pst.setString(1,contact.getEmail());
			rs=pst.executeQuery();
			int contId = 0;
			if(rs.next())
				if(rs.getString(4).equals(contact.getEmail()))
				{
					String id = rs.getString(1);
					contId = Integer.parseInt(id);
				}
			pst = conn.prepareStatement(Constant.INSERT_MOBILE);
			pst.setInt(1,contId);
			pst.setInt(2,contact.getMobExtn());
			pst.setLong(3, contact.getMobNo());
			
			int count = pst.executeUpdate();
			logger.log(Level.INFO, "Number of rows affected: " + count);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "Error inserting office details");
		} finally {
			DBUtils.closeConnection(conn, pst, rs);
		}

}
	
	public void deleteContact (Contact contact) {
		try {
			conn = DBUtils.getConnection();
			String sql = Constant.SELECT_QUERY;
			System.out.println("ex");
			pst = conn.prepareStatement(sql);
			pst.setString(1,contact.getEmail());
			System.out.println("ex");
			ResultSet rs=pst.executeQuery();
			int contId = 0;
			if(rs.next())
				if(rs.getString(4).equals(contact.getEmail()))
				{
					String id = rs.getString(1);
					contId = Integer.parseInt(id);
				}
			System.out.print(contId);
			pst = conn.prepareStatement(Constant.DELETE_CONTACT);
			pst.setInt(1, contId);
			
			pst.executeUpdate();
			logger.log(Level.INFO, "Deleted ");
			
			}catch (SQLException e) {
			logger.log(Level.SEVERE, "Error deleting details");
			} finally {
			DBUtils.closeConnection(conn, pst, rs);
			}
		
		
	}
	
	public void editName(Contact contact) {
		try {
			conn = DBUtils.getConnection();
			String sql = Constant.SELECT_QUERY;
			pst = conn.prepareStatement(sql);
			pst.setString(1,contact.getEmail());
			rs=pst.executeQuery();
			int contId = 0;
			if(rs.next())
				if(rs.getString(4).equals(contact.getEmail()))
				{
					String id = rs.getString(1);
					contId = Integer.parseInt(id);
				}
			pst = conn.prepareStatement(Constant.UPDATE_NAME);
			pst.setString(1,contact.getFirstName());
			pst.setString(2,contact.getLastName());
			pst.setInt(3, contId);
			
			pst.executeUpdate();
			logger.log(Level.INFO, "Updated Name ");		
			}catch (SQLException e) {
			logger.log(Level.SEVERE, "Error updating name details");
			} finally {
			DBUtils.closeConnection(conn, pst, rs);
			}
	}
	
	public void editHome(Contact contact) {
		try {
			conn = DBUtils.getConnection();
			String sql = Constant.SELECT_QUERY;
			pst = conn.prepareStatement(sql);
			pst.setString(1,contact.getEmail());
			rs=pst.executeQuery();
			int contId = 0;
			if(rs.next())
				if(rs.getString(4).equals(contact.getEmail()))
				{
					String id = rs.getString(1);
					contId = Integer.parseInt(id);
				}
			pst = conn.prepareStatement(Constant.UPDATE_HOME);
			pst.setInt(1,contact.getAreaCode());
			pst.setInt(2,contact.getCountryCode());
			pst.setInt(3, contact.getHomeNo());
			pst.setInt(4,contId);
			pst.setInt(5, contact.getOldhomeNo());
			System.out.print(contact.getOldhomeNo());
			System.out.print(contId);
			
			pst.executeUpdate();
			logger.log(Level.INFO, "Updated homeno ");	
			}catch (Exception e) {
			logger.log(Level.SEVERE, "Error updating home details");
			} finally {
			DBUtils.closeConnection(conn, pst, rs);
			}
	}
		
		public void editOfc(Contact contact) {
			try {
				conn = DBUtils.getConnection();
				String sql = Constant.SELECT_QUERY;
				pst = conn.prepareStatement(sql);
				pst.setString(1,contact.getEmail());
				rs=pst.executeQuery();
				int contId = 0;
				if(rs.next())
					if(rs.getString(4).equals(contact.getEmail()))
					{
						String id = rs.getString(1);
						contId = Integer.parseInt(id);
					}
				pst = conn.prepareStatement(Constant.UPDATE_OFFICE);
				pst.setInt(1,contact.getOfcExtn());
				pst.setInt(2,contact.getOfcNo());
				pst.setInt(3,contId);
				pst.setInt(4, contact.getOldofcNo());
				
				pst.executeUpdate();
				logger.log(Level.INFO, "Updated officeno ");	
				}catch (Exception e) {
				logger.log(Level.SEVERE, "Error updating office details");
				} finally {
				DBUtils.closeConnection(conn, pst, rs);
				}
		
	}
		
		public void editMob(Contact contact) {
			try {
				conn = DBUtils.getConnection();
				String sql = Constant.SELECT_QUERY;
				pst = conn.prepareStatement(sql);
				pst.setString(1,contact.getEmail());
				rs=pst.executeQuery();
				int contId = 0;
				if(rs.next())
					if(rs.getString(4).equals(contact.getEmail()))
					{
						String id = rs.getString(1);
						contId = Integer.parseInt(id);
					}
				pst = conn.prepareStatement(Constant.UPDATE_MOBILE);
				pst.setInt(1,contact.getMobExtn());
				pst.setLong(2,contact.getMobNo());
				pst.setInt(3,contId);
				pst.setLong(4,contact.getOldmobNo());
				
				pst.executeUpdate();
				logger.log(Level.INFO, "Updated mobno ");	
				}catch (Exception e) {
				logger.log(Level.SEVERE, "Error updating mobile details");
				} finally {
				DBUtils.closeConnection(conn, pst, rs);
				}
		
	}
		
		public void displayContact(Contact contact)
		{
			try {
				conn = DBUtils.getConnection();
				String sql = Constant.SELECT_QUERY;
				pst = conn.prepareStatement(sql);
				pst.setString(1,contact.getEmail());
				ResultSet rs1=pst.executeQuery();
				int contId = 0;
				if(rs1.next())
					if(rs1.getString(4).equals(contact.getEmail()))
					{
						String id = rs1.getString(1);
						contId = Integer.parseInt(id);
					}
				pst = conn.prepareStatement(Constant.SELECT_CONTACT);
				pst.setInt(1, contId);
				
				rs=pst.executeQuery();
				while(rs.next())
				{
					System.out.print(contId);
					logger.log(Level.INFO,"ContID"+rs.getString(1)+"First Name\n"+rs.getString(2)+"LastName\n"+rs.getString(3)+"Email\n"+rs.getString(4));
				}
				pst = conn.prepareStatement(Constant.SELECT_HOME);
				pst.setInt(1, contId);
				
				rs=pst.executeQuery();
				while(rs.next())
				{
					logger.log(Level.INFO,"\nArea code:"+rs.getString(2)+"\nCountry code:"+rs.getString(3)+"\nHome no:"+rs.getString(4));
				}
				pst = conn.prepareStatement(Constant.SELECT_OFFICE);
				pst.setInt(1, contId);
				
				rs=pst.executeQuery();
				while(rs.next())
				{
					logger.log(Level.INFO,"\noffice extension:"+rs.getString(2)+"\nOffice no:"+rs.getString(3));
				}
				pst = conn.prepareStatement(Constant.SELECT_MOBILE);
				pst.setInt(1, contId);
				
				rs=pst.executeQuery();
				while(rs.next())
				{
					logger.log(Level.INFO,"\nmobile extension:"+rs.getString(2)+"\nmobile no:"+rs.getString(3));
				}
				logger.log(Level.INFO, "Displayed ");
				
				}catch (SQLException e) {
				logger.log(Level.SEVERE, "Error displaying details");
				} finally {
				DBUtils.closeConnection(conn, pst, rs);
				}
			
		}

}

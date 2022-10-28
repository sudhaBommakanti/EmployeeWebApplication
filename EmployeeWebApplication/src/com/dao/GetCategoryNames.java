package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.LibraryList;

public class GetCategoryNames {
	
	private static final String SELECT_CATEGORY_NAMESQUERY = "SELECT CategoryName FROM CATEGORY";
	
	private static final String SELECT_LIBRARY_NAMESQUERY = "SELECT DISTINCT Title, Author FROM LIBRARYITEM";

	static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Library;integratedSecurity=true;TrustServerCertificate=true;";
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "";
	private static String password = "";
	
	//List<LibraryList> libraryItems = new ArrayList<LibraryList>();
	List<LibraryList> libraryItems;
	
	public boolean validate() {
		boolean status = false;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL, userName, password);

			PreparedStatement ps = con.prepareStatement(SELECT_CATEGORY_NAMESQUERY, java.sql.ResultSet.CONCUR_READ_ONLY);
						
			ResultSet rs = ps.executeQuery();
			
			final List<String> timeStr = new ArrayList<>();
		    while(rs.next()) {
		        // Just get the value of the column, and add it to the list
		        timeStr.add(rs.getString("CategoryName"));
		    }
			
		    System.out.println(".............." + timeStr.size());
			//rs.last();
			
			int counter = rs.getRow();
			System.out.println("counter: "+ counter);
			String[] sa = new String[counter];
		     counter = 0; // Reset counter to 0 so as to act as a Index incrementer
			 // Iterate through the ResultSet and fill Array
			 while (rs.next()) {
			     sa[counter] = rs.getString(1); 
			     counter++;
			 }
			 
			 // See what's in Array...
			 for (int i = 0; i < timeStr.size(); i++) {
			     System.out.println(timeStr.get(i));
			 }
	        

			status = true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public void check() {
		
		libraryItems = new ArrayList<LibraryList>();
		
		LibraryList list;

		PrintWriter pw = null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			//LibraryList list;
			Class.forName(driver);
			con = DriverManager.getConnection(URL, userName, password);

			ps = con.prepareStatement(SELECT_LIBRARY_NAMESQUERY);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				list = new LibraryList();
				// Just get the value of the column, and add it to the list
				list.setTitle(rs.getString("Title"));
				list.setAuthor(rs.getString("Author"));
				
				System.out.println("list: " + list.getAuthor() + " " + list.getTitle());
				
				libraryItems.add(list);
			}
			
			for(LibraryList item : libraryItems) {
				System.out.println(".........."+ item.getAuthor() + " " + item.getTitle());
			}

			System.out.println(".............." + libraryItems.size());
			// See what's in Array...
			for (int i = 0; i < libraryItems.size(); i++) {
				System.out.println("LibraryData: " + libraryItems.get(i).getAuthor());
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String [] args) {
		
		GetCategoryNames names = new GetCategoryNames();
		
		boolean check = names.validate();
		
		names.check();
		
		System.out.println(check);
	}

}

package com.model;

import java.sql.Date;

public class LibraryList {
	
	private int library_id; // LibraryID
	private int category_id; // CategoryId
	private String title; // Title
	private String author; // Author
	private int pages; // Pages
	private int runTimeMinutes; // RunTimeMinutes
	private boolean isBorrowable; // IsBorrowable
	private String borrower; // Borrower
	private Date borrowDate; // BorrowDate
	private String type; // Type
	
	public int getLibrary_id() {
		return library_id;
	}


	public void setLibrary_id(int library_id) {
		this.library_id = library_id;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	public int getRunTimeMinutes() {
		return runTimeMinutes;
	}


	public void setRunTimeMinutes(int runTimeMinutes) {
		this.runTimeMinutes = runTimeMinutes;
	}


	public boolean isBorrowable() {
		return isBorrowable;
	}


	public void setBorrowable(boolean isBorrowable) {
		this.isBorrowable = isBorrowable;
	}


	public String getBorrower() {
		return borrower;
	}


	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}


	public Date getBorrowDate() {
		return borrowDate;
	}


	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	/*
	 * @Override public String toString() { return "LibraryItem [library_id=" +
	 * library_id + ", category_id=" + category_id + ", title=" + title +
	 * ", author=" + author + ", pages=" + pages + ", runTimeMinutes=" +
	 * runTimeMinutes + ", isBorrowable=" + isBorrowable + ", borrower=" + borrower
	 * + ", borrowDate=" + borrowDate + ", type=" + type + "]"; }
	 */
	

}

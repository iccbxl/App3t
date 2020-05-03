package be.coello.poo.app3t.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Book {

	protected UUID id; 
	protected String title; 
	protected String author; 
	protected short totalpages; 
	protected byte loanPeriod; 
	protected double retalPrice; 
	protected LocalDate borrowingDate; 
	protected String langguage; 
	protected Person borrower;
	
	
	public Book(UUID id, String title, String author, short totalpages, String langguage) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.totalpages = totalpages;
		this.loanPeriod = 14;
		this.retalPrice = 1.25;
		this.langguage = langguage;		
		this.borrowingDate = null; 		
		this.borrower = null;
	}
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public short getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(short totalpages) {
		this.totalpages = totalpages;
	}
	public byte getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(byte loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public double getRetalPrice() {
		return retalPrice;
	}
	public void setRetalPrice(double retalPrice) {
		this.retalPrice = retalPrice;
	}
	public LocalDate getBorrowingDate() {
		return borrowingDate;
	}
	public void setBorrowingDate(LocalDate borrowingDate) {
		this.borrowingDate = borrowingDate;
	}
	public String getLangguage() {
		return langguage;
	}
	public void setLangguage(String langguage) {
		this.langguage = langguage;
	}
	public Person getBorrower() {
		return borrower;
	}
	public void setBorrower(Person borrower) {
		this.borrower = borrower;
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", totalpages=" + totalpages
				+ ", loanPeriod=" + loanPeriod + ", retalPrice=" + retalPrice + ", borrowingDate=" + borrowingDate
				+ ", langguage=" + langguage + ", borrower=" + ((borrower !=null)? borrower.getName() :null) + "]";
	}	
	
	public byte computRemainDays() {
		byte nbdays; 		
		LocalDate today = LocalDate.now(); 
		LocalDate returnDate = borrowingDate.plusDays(loanPeriod); 		
		Period p = Period.between(today, returnDate); 		
		nbdays = (byte) p.getDays();
		return nbdays; 
		
	}
	
	public void updatebook(Book book) {
		this.title = book.title; 
		this.author = book.author; 
		this.totalpages = book.totalpages; 
		this.loanPeriod = book.loanPeriod; 
		this.retalPrice = book.retalPrice; 
		this.langguage = book.langguage;
	}
	
	
}

























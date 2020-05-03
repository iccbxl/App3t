package be.coello.poo.app3t.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Person {

	protected UUID id; 
	private String name; 
	private String lastname;
	private String tel; 
	private byte maxBooks; 
	private LocalDate registrationDate; 
	private ArrayList<Book> books;
	
	public Person(UUID id, String name, String lastname, String tel, byte maxBooks, LocalDate registrationDate,
			ArrayList<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.tel = tel;
		this.maxBooks = maxBooks;
		this.registrationDate = registrationDate;
		this.books = books;
	}
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public byte getMaxBooks() {
		return maxBooks;
	}
	public void setMaxBooks(byte maxBooks) {
		this.maxBooks = maxBooks;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}



	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", tel=" + tel + ", maxBooks="
				+ maxBooks + ", registrationDate=" + registrationDate + ", books=" + books + "]";
	}


	public void borrows(Book b) {
	    // add book to this person 
		// add person to book
		// add boorrow date to book
		
	}
	
	
	public void retunrs(Book b) {
		// remove book from this person 
		// remove person in book // set null
		// remove borrowing date / set null
		
	}
	
	
}

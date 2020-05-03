package be.coello.poo.app3t.entities;

import java.util.ArrayList;

public class MyLibrary {

	/**
	 * Library name
	 */
	private String name;
	/**
	 * Books' list
	 */
	private ArrayList<Book> books;
	
	/**
	 * Members list
	 */
	private ArrayList<Person> people;

	
	public MyLibrary(String name) {
		super();
		this.name = name;
		this.books = new ArrayList<Book>(); 
		this.people = new ArrayList<Person>(); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	
	public void addBook(Book b) {
		this.books.add(b); 	
	}
	
	public void addPerson(Person person) {
		this.people.add(person);
	}
	
	public int totalBooks() {
		int cpt = 0; 
		// contar los libros en la libreria 
		
		
		return cpt; 
	}
	
	public int totalMembers() {
		int cpt = 0;  
				
		return cpt; 
	}
	
	
	public int loadMembers() {
		return 0; 
	}
	
	public int loadMembersFromCSVfile() {
		int cpt = 0 ; 
		
		return cpt; 
	}
	
	public boolean saveMembersToCSVfile() {
		
		
		return false; 
	}
	
	public int loadMembersFromXMLFile() {
		int cpt = 0; 
		return cpt; 
	}
	
	public boolean saveMembersToXMLFile() {
		
		return false; 
	}
	
	public Person isMemberExist(String name) {
		
		return null; 
	}
	
	
	@Override
	public String toString() {
		return "MyLibrary [name=" + name + ", books=" + books + ", people=" + people + "]";
	}
	
	
	
}

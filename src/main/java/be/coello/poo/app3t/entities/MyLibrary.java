package be.coello.poo.app3t.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class MyLibrary {

	private String name;
	private ArrayList<Book> books;
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
	
	/**
	 * Print the book list in the library
	 * @return
	 */
	public int printBooks() {
		int cpt = 0; 
		Iterator<Book> it = this.getBooks().iterator(); 
	
		while(it.hasNext()) {
			Book b = it.next();
			
			System.out.println(++cpt + " - " + b.getTitle() + " - " + b.getAuthor() );
		}
		
		return cpt; 
	}
	
	public int totalMembers() {
		int cpt = 0;  
		Iterator<Person> it = this.getPeople().iterator();
		
		while(it.hasNext()) {
			Person p = it.next();
			System.out.println(++cpt + " - " p.getName() + " - " + p.getLastname() );
		}
		
				
		return cpt; 
	}
	
	
	public int loadMembers(String filename) {
		int cpt = 0; 
		
		File f = new File(filename); 
		
		if(f.exists()) {
			
			FileReader fr = null; 
			BufferedReader br = null; 
			String[] data = null; 
			
			try {
				try {
					
					fr = new FileReader(f);
					br = new BufferedReader(fr);
					
					String Line = br.readLine();
					
					while( (Line) != null ) {
						data = Line.split(";");
						Person p = new Person(UUID.fromString(data[0]), data[1], data[2]);
						byte nbMaxBooks = Byte.parseByte(data[3]); 
						LocalDate registrationDate = LocalDate.parse(data[4], DateTimeFormatter.ofPattern("dd-MM-yy"));
						p.setMaxBooks(nbMaxBooks);
						p.setRegistrationDate(registrationDate);
						
						this.people.add(p);
						cpt++;
					}					
					
				} finally {
					br.close();
				}
				
			} catch (IOException e) {
			
			}
			
			
			System.out.println(people);
		}
		
		return cpt; 
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

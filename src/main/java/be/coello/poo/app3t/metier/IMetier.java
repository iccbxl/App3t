package be.coello.poo.app3t.metier;

import java.util.List;

import be.coello.poo.app3t.entities.Book;
import be.coello.poo.app3t.entities.Person;

public interface IMetier {

	//Get data
	public List<Person> getMembers(); 
	public void registre(Person p);
	public void update(Person p);
	public void unregistre(Person p);
	public List<Person> findByName(String name); 
	
	
	// books
	public List<Book> getBooks(); 
	public void registre(Book b);
	public void update(Book p);
	public void unregistre(Book p);
	public List<Book> findByTitle(String title); 
	
	
	
	
	// Business loginc
	public int computingRemainingDays(Book b); 
	
}

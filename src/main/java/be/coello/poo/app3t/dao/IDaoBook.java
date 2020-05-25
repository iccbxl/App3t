package be.coello.poo.app3t.dao;

import java.util.List;
import java.util.UUID;

import be.coello.poo.app3t.entities.Book;

public interface IDaoBook {
	// CRUD
	
	// C
	public void create(Book b); 
	
	// READ
	public List<Book> findAll();
	public Book findByTitle(String title);
	public Book findById(UUID id);
	public List<Book> findBy(String propert, String value);
	
	// U PDATE
	public void update(Book b); 
	
	// D ELETE
	public void delete(Book b); 
	
	

}

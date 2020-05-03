package be.coello.poo.app3t.dao;

import java.util.List;
import java.util.UUID;

import be.coello.poo.app3t.entities.Person;

public interface IDao {
	// -- CRUD
	//--------
	
	// CREATE 
	public void save(Person p); 
	
	//READ
	public List<Person> findAll(); 
	public Person findById(UUID id);
	public List<Person> findBy(String property, String value);
	
	
	// UPDATE
	public void update(Person p); 
	
	// DELETE
	public void delete(UUID id);
	public void delete(Person p);
 
	
	
	

}

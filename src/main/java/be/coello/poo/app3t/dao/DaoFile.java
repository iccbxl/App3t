package be.coello.poo.app3t.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import be.coello.poo.app3t.entities.Person;

public class DaoFile implements IDao {

	private List<Person> people = new ArrayList<Person>(); 
	private String filename; 
	
	
	public DaoFile() {
		this.filename = "data\\members.xml"; 
	}
	
	
	public String getFilemane() {
		return filename; 
	}
	
	
	public void setFilename(String filename) {
		this.filename = filename; 
	}
	
	
	
	
	
	
	public void save(Person p) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Person findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> findBy(String property, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UUID id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Person p) {
		// TODO Auto-generated method stub
		
	}

}

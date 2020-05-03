package be.coello.poo.app3t.metier;

import java.util.ArrayList;
import java.util.List;

import be.coello.poo.app3t.dao.IDao;
import be.coello.poo.app3t.entities.Book;
import be.coello.poo.app3t.entities.Person;

public class Metier implements IMetier {
	
	
	private IDao dao; 
	private List<Person> people = new ArrayList<Person>(); 
	
	
	
	

	public List<Person> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void registre(Person p) {
		// TODO Auto-generated method stub
		
	}

	public void update(Person p) {
		// TODO Auto-generated method stub
		
	}

	public void unregistre(Person p) {
		// TODO Auto-generated method stub
		
	}

	public List<Person> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> findByTel(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int computingRemainingDays(Book b) {
		// TODO Auto-generated method stub
		return 0;
	}

}

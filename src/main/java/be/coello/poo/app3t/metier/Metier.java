package be.coello.poo.app3t.metier;

import java.util.ArrayList;
import java.util.List;

import be.coello.poo.app3t.dao.IDao;
import be.coello.poo.app3t.entities.Book;
import be.coello.poo.app3t.entities.Person;

public class Metier implements IMetier {
	
	
	private IDao dao; 
	private List<Person> people = new ArrayList<Person>(); 
	
	public Metier() {
		
	}
	
	
	public Metier(IDao dao) {
		this.dao = dao; 
	}
	
	public IDao getDao() {
		return dao; 
	}	
	
	public void setDao(IDao dao) {
		this.dao = dao; 
	}

	public int computingRemainingDays(Book b) {		
		int remainingDays = 0; 
		
		// Fecha de prestamo
		// calculo de la duracio del prstamos
		// calculo del n days restantes
		
		return remainingDays;  
		
	}
	
	
	public List<Person> getMembers() {		
		return dao.findAll();
	}

	public void registre(Person p) {
		dao.save(p);
	}

	public void update(Person p) {
		dao.update(p);
	}

	public void unregistre(Person p) {
		dao.delete(p);	
	}
	
	public List<Person> findByName(String name) {		
		return dao.findBy("name", name);
	}
	
	public List<Person> findByTel(String tel) {
		return dao.findBy("tel", tel);
	}

	
	


}

package be.coello.poo.app3t.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import be.coello.poo.app3t.entities.Person;

public class DaoFile implements IDao {

	private List<Person> people = new ArrayList<Person>(); 
	private String filename; 
	
	
	public DaoFile() {
		this.filename = "data\\members.xml"; 
	}
	
	public DaoFile(String filename) {
		this.filename = filename;  
	}
	
	
	public String getFilemane() {
		return filename; 
	}
	
	
	public void setFilename(String filename) {
		this.filename = filename; 
	}
	
	
	
	
	
	
	public void save(Person p) {
		findAll();
		
		boolean find = false;
		Person currentPerson = null;
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()) {
			currentPerson = it.next();
			
			if(currentPerson.getId().equals(p.getId())) {
				update(p);
				find = true;
				return;
			}
		}
		
		if(!find) {
			people.add(p);
		}
		
		// write
		writeXMLFile(filename, this.people);
}

	public List<Person> findAll() {
		this.people = readXMLFile(filename);
		return people;
	}


	
	
	public Person findById(UUID id) {
		findAll(); 
		
		Person p = null; 
		
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()) {
			p = it.next();
			if(p.getId().equals(id)) {
				return p; 
			}
		}
		return null;
	}
	
	
	
	

	public List<Person> findBy(String property, String value) {
		findAll(); 
		ArrayList<Person> result = new ArrayList<Person>();
		String getterName = "get"+property.substring(0,1).toUpperCase()+property.substring(1);
		Method method = null; 
		
		try {
			method = Person.class.getDeclaredMethod(getterName, null);
			
			Iterator<Person> it = this.people.iterator();
			
			while(it.hasNext()) {
				Person p = it.next();
				String ps = method.invoke(p).toString();
				
				if(ps.equals(value)) {
					result.add(p);
				}
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}

	public void update(Person p) {
		findAll();
		
		boolean find = false;
		Person currentPerson = null;
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()) {
			currentPerson = it.next();
			
			if(currentPerson.getId().equals(p.getId())) {
				it.remove();
				find = true;
			}
		}
		
		if(find) {
			people.add(p);
		}
		
		// wirte
		//writeXMLFile(filename, this.people);
}
	
	
	public void delete(UUID id) {
		findAll();
		
		Person p = null;
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()) {
			p = it.next();
			
			if(p.getId().equals(id)) {
				it.remove();
			}
		}
		
		// write i file
		writeXMLFile(filename, this.people);
}
	
	

	public void delete(Person p) {
		Iterator<Person> it = people.iterator();
		
		while(it.hasNext()) {
			Person currentPerson = it.next();
			
			if(currentPerson.equals(p)) {
				it.remove();
			}
		}
		
		// wite file
		writeXMLFile(filename, this.people);
	}

	
	private String readFile(String filename) {
		//String content = null;
		String line = null;
		StringBuilder sb = new StringBuilder();
		File f = new File(filename);
		FileReader fr = null;
		BufferedReader br = null;
		
		if(f.exists()) {
			try {
				try {
					fr = new FileReader(f);
					br = new BufferedReader(fr);
					
					while((line = br.readLine()) != null) {
						sb.append(line);
					}
				} finally {
					br.close();
					fr.close();
					System.out.println("Fin de lecture");
				}
			} catch(Exception e) {
				
			}
		}
		
		return sb.toString();
}
	
	
	private List<Person> convertFromXMLStringtoList(String xml) {
		XStream xs = new XStream(new DomDriver());
		xs.alias("person", Person.class);
		
		return (List<Person>) xs.fromXML(xml);
	}

	
	private List<Person> readXMLFile(String filename) {
		List<Person> list = new ArrayList<Person>();
		
		String xml = readFile(filename);
		
		list = convertFromXMLStringtoList(xml);
		
		return list;
	}

	
	
	private void writeXMLFile(String filename, List<Person> people) {
		File f = new File(filename);
		FileWriter fr = null;
		BufferedWriter br = null;
		
		XStream xs = new XStream(new DomDriver());
		
		//Configuration du parser XML
		xs.alias("person", Person.class);
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		
		try {
			try {
				fr = new FileWriter(f);
				br = new BufferedWriter(fr);
				
				xs.toXML(people, br);
			} finally {
				br.close();
				fr.close();
				System.out.println("Fin d'écriture.");
			}
		} catch(Exception e) {
			
		}
}

}

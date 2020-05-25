package be.coello.poo.app3t.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import be.coello.poo.app3t.entities.Book;
import be.coello.poo.app3t.entities.Person;


public class DaoFileBook implements IDaoBook {
	
	public List<Book> books = new ArrayList<Book>();
	public String filename;
	
	
	public DaoFileBook() {		
		this.filename = "";  		
	}
	
	public DaoFileBook(String filename) {
		super();
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	public void create(Book b) {
		findAll();
		
		boolean find = false;
		Book cb = null;
		Iterator<Book> it = books.iterator();
		
		while(it.hasNext()) {
			cb = it.next();
			
			if(cb.getId().equals(b.getId())) {
				update(b);
				
				return;
			}
		}
		
		if(!find) {
			books.add(b);
		}
		
		// write
		writeXMLFile(filename, this.books);
		
	}

	
	
	public List<Book> findAll() {
		/**
		 *  give the file to read all books
		 */

				
		this.books = readXMLFile(filename);
		/**
		 * Return de books list find
		 */
		return books;
	}

	public Book findByTitle(String title) {
		findAll(); 
		
		Book b = null;
		
		Iterator<Book> it = books.iterator(); 
		
		while(it.hasNext()) {
			b = it.next(); 
			if(b.getTitle().equals(title)) {
				return b; 
			}
		}			
		return null;
	}

	
	
	
	
	public Book findById(UUID id) {
		findAll(); 	// All books	
		Book b = null; 		
		Iterator<Book> it = books.iterator();		
		while(it.hasNext()) {
			b = it.next();
			if(b.getId().equals(id)) {
				return b; 
			}
		}
		return null;
	}

	public List<Book> findBy(String propert, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Book b) {
	
		return; 
		
		
	}

	public void delete(Book b) {
		findAll(); 
		Book cb; 
		Iterator<Book> it = books.iterator(); 
		
		while(it.hasNext()) {
			cb = it.next(); 
			if(cb.getId().equals(b.getId())) {
				it.remove();
			}
		}
	
		// write i file
		writeXMLFile(filename, this.books);
	}
	
	
	
	//////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param filename
	 * @return
	 */
	private List<Book> readXMLFile(String filename) {		
		List<Book> list = new ArrayList<Book>();			
		String xml = readFile(filename);		
		list = convertFromXMLStringtoList(xml);			
		return list;
	}
	
	/**
	 * Read file
	 * @param filename File to red
	 * @return Data in filename
	 */
	private String readFile(String filename) {		
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
				}
			} catch(Exception e) {
				System.err.println(e);
			}
		} else {
			System.out.println( filename + " ERROR File no exist");
		}
		
		return sb.toString();

}
	
	
	@SuppressWarnings("unchecked")
	private List<Book> convertFromXMLStringtoList(String xml) {
		XStream xs = new XStream(new DomDriver());
		xs.alias("book", Book.class);		
		return (List<Book>) xs.fromXML(xml);
	}

	
	
	
	

	private void writeXMLFile(String filename, List<Book> books) {
		File f = new File(filename);
		FileWriter fr = null;
		BufferedWriter br = null;

		XStream xs = new XStream(new DomDriver());
		
		//Configuration du parser XML
		xs.alias("book", Book.class);
		
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
				
				xs.toXML(books, br);								
				
			} finally {
				br.close();
				fr.close();
				
			}
		} catch(Exception e) {
			
			System.out.println(e);
		}
}
	
	
	
	
	
	
	
	
	

}

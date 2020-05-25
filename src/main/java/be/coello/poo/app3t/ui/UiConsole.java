package be.coello.poo.app3t.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import be.coello.poo.app3t.entities.Book;
import be.coello.poo.app3t.entities.Person;
import be.coello.poo.app3t.metier.IMetier;

public class UiConsole  implements IUi {

	private IMetier metier; 
	private Scanner s = new Scanner(System.in); 
	private List<Person> members = new ArrayList<Person>(); 
	private List<Book> books = new ArrayList<Book>(); 
	private String title;
	private String author;
	private short totalpages;
	private String langguage;
	
	private String message =" ---------------------------------------------------------------"; 
	
	public UiConsole() {		
	}
	
	public UiConsole(IMetier metier) {
		this.metier = metier;
	}
	
	
	public IMetier getMetier() {
		return metier; 
	}
	
	public void setMetier(IMetier metier) {
		this.metier = metier;
	}
	
	public void run() {
		int choix; 
		String name ;
		String lastname ;
		
		
		// menu		System.out.println("1 - Show all members");
		System.err.print("-- MEMBERS --\n"
				+ " 1 - List \n"
				+ " 2 - Add \n"
				+ " 3 - Delete\n"
				+ " 4 - Edit\n"
				+ " 5 - Search\n"
				+ ""
				+ "-- BOOKS --\n"
				+ " 11 - List \n"
				+ " 12 - Add \n"
				+ " 13 - Delete \n"
				+ " 14 - Edit \n"
				+ " 15 - Search \n"
				+ "-- LIBRARY \n"				
				+ " 20 - Rent Book \n"
				+ " 21 - Return book \n"
				+ " 21 - Books by Member \n"
				+ " 21 - Calcule rate rent book by member \n"
				+ " 21 - Calcule rate refund late by book \n"
				+ " 21 - Calcule days to refund a book \n"
				+ " 21 - Export DB \n"
				+ " 21 - Import  DB \n"
				+ " 22 -------\n"
				+ " 0 - Logout \n\n");
		
		//System.out.println("1 - List members");
		//System.out.println("2 - Add members");
		//System.out.println("3 - Delete member");
		//System.out.println("0 - Logout");		
		
		// lacture choix user
		
		choix = s.nextInt(); 
		s.nextLine();
			
		

		
		
		// Traitement comande user
		

		switch(choix) {
			case 0:
				message = "By bye"; 
				return; 
			case 1: 
				// Get all members
				members = metier.getMembers();								
				// print all members
				System.err.print("-----------------------------------\n");
				System.err.print("- MEMBERS LIST\n");
				printMembers();	
				message = "Tanks";				
				break;
				
			case 2:				
				System.out.println("Member name please: ");
				name = s.nextLine();
				Person newMember = new Person(UUID.randomUUID(), name); 					
				metier.registre(newMember);					
				//message = "Registre ok "; 				
				System.err.print("- New Member add\n");
				System.out.println(newMember.toString());
				System.err.print("-----------------------------------\n");							
				System.err.print("- MEMBERS LIST\n");
				members = metier.getMembers();	
				printMembers();
				System.err.print("-----------------------------------\n");
				message = "Tanks";		
				break;				
				///############################################
				 
			case 3: 
				Person p = null;
				System.err.print("-- DELETE A MEMBER ---------------------------------\n");
				System.out.print("Veuillez entre le nom du membre: ");				
				name = s.nextLine();								
				members = metier.findByName(name);								
						
				
				if(members.isEmpty()) {
					System.out.println("Not member with1 this name");							
				} else {
					System.out.println("We find");	
					printMembers(members);	
					System.out.println("Wich member you want delete?");
					choix = s.nextInt(); s.nextLine();				
					// chosse the x person from the member list and delete				
					p = members.get( choix - 1 );				
					metier.unregistre(p);	
					
				}
				
				
				message = "End Delete Menu";		 				
				break;
				
				
				
				
			case 4: // Edit MEMBER
				// search a member by name o tel 
				// ask new info
				// save
				// show new info
				break;
				
			case 5: // Search a Member				
				break;
				
			case 6: 				
				break;
				
				
				
			case 7: 
				
				break;
				
				 
			case 11: // LIST Books
				// Get all members
				books = metier.getBooks();								
				// print all book
				System.err.print("-----------------------------------\n");
				System.err.print("- Book LIST \n");
				printAllBooks();	
				
							
				break;	
				
			case 12: // ADD Books				
				
				System.out.println("Book's title please:");
				title = s.nextLine();			
				
				System.out.println("Book's author please:");
				author = s.nextLine();			
				
				System.out.println("Book's langguage ( use onli 2 letters) :");
				langguage = s.nextLine();	
				
				System.out.println("Book's total page please:");
				totalpages = s.nextShort();			
														
				Book b = new Book(UUID.randomUUID(), title, author, totalpages, langguage); 
				
				metier.registre(b);				
						
				System.err.print("New Book add\n");
				
				System.out.println(b.toString());
				
				System.err.print("-----------------------------------\n");							
				System.err.print("Book List\n");
				books = metier.getBooks();	
				printAllBooks();
				
				break;				
				
				
			case 13: // DELETE Books	
				Book b2d = null;
				System.err.print("-- DELETE A Book ---------------------------------\n");
				System.out.print("Veuillez entre le title du book: ");				
				title = s.nextLine();								
				books = metier.findByTitle(title);								
						
				if(books.isEmpty()) {
					System.out.println("Dont find this book");
				}else{
					System.out.println("Book's list");
					System.out.println("Select a number to delete");
					choix = s.nextInt(); 
					b2d = books.get(choix - 1);
					metier.unregistre(b2d);
					
					
				}
				
				
				
				
				break;				
				
				
			case 14: // EDIT Books						
				break;				
				
				
				
			case 15: // SEARCH Books						
				break;				
								
				
			case 20: // RENT Books						
				break;				
				
			case 21: // REFOUND Books						
				break;				
				
			default: 
				System.out.println("Commande error");
		}
						
		// print message
		System.out.println(message);
		
	}
	
	
	
	/**
	 * i give the members list to print
	 * @param members
	 */
	private void printMembers(List<Person> members) {		
		Iterator<Person> it = members.iterator();
		int i=1;
		while(it.hasNext()) {
			Person p = it.next(); 
				System.out.println(i + ")\t REGISTRE DATE: "  + p.getRegistrationDate() + " Name: " + p.getName());
				i++;
		}		
	}
	
	
	/**
	 * print members that exist in this moment at members
	 */
	private void printMembers() {
		
		System.out.println("# \tREGISTRE DATE \t Name");
		
		Iterator<Person> it = members.iterator();
		int i = 1;
		while(it.hasNext()) {
			Person p = it.next(); 
			
			System.out.println(i + ")\t"  + p.getRegistrationDate() + "\t" + p.getName() );
			
			i++;
		}		
	}
	
	
	
	/**
	 * Print all Books
	 */
	private void printAllBooks() {
		Iterator<Book> it = books.iterator();
		int i = 1;
		while(it.hasNext()) {
			Book b = it.next(); 
			System.out.println(i + ")\t Book: " + b.getTitle());
			i++;
		}		
	}
	
	
	
	
}

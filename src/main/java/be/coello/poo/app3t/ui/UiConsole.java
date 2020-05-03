package be.coello.poo.app3t.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import be.coello.poo.app3t.entities.Person;
import be.coello.poo.app3t.metier.IMetier;

public class UiConsole  implements IUi {

	private IMetier metier; 
	private Scanner s = new Scanner(System.in); 
	private List<Person> members = new ArrayList<Person>(); 
	private String message; 
	
	public UiConsole() {
		
	}
	
	public IMetier getMetier() {
		return metier; 
	}
	
	public void setMetier(IMetier metier) {
		this.metier = metier;
	}
	
	public void run() {
		int choix; 
		
		// menu
		System.out.println("1 - Show all members");
		System.out.println("2 - Add members");
		System.out.println("3 - Delete member");
		System.out.println("0 - Logout");		
		
		// lacture choix user
		
		choix = s.nextInt(); 
		s.nextLine();
			
		
		// Traitement comande user
		switch(choix) {
			case 0:
				return; 
			case 1: 
				// Get all members
				members = metier.getMembers();				
				
				// print all members
				printMembers();				
				
				message = "";				
				break;
				
			case 2:
				System.out.println("Member name please: ");
				name = s.nextLine();
				
				Person newMember = new Person(UUID.randomUUID(), name); 
				break;
			case 3: 
				break;				
		}
		
		
		
		
		// print message
		System.out.println(message);
		
	}
	
	
	
	private void printMembers() {
		Iterator<Person> it = members.iterator();
		while(it.hasNext()) {
			Person p = it.next(); 
			System.out.println("Name: " + p.getName() + " Registred at: " + p.getRegistrationDate());
		}
	}
	
	
	
	
}

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
	private String message =" -- not mesage -9-"; 
	
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
		
		
		// menu		System.out.println("1 - Show all members");
		System.err.print("-----M E N U -------------------------\n"
				+ "1 - List Members \n"
				+ "2 - Add Members \n"
				+ "3 - Delete Members \n"
				+ "0 - Logout \n\n");
		
		//System.out.println("1 - List members");
		//System.out.println("2 - Add members");
		//System.out.println("3 - Delete member");
		//System.out.println("0 - Logout");		
		
		// lacture choix user
		
		choix = s.nextInt(); 
		s.nextLine();
			
		String name ;

		
		
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
				System.err.print("-----------------------------------\n");
				message = "end Menu 1";				
				break;
				
			case 2:
				
				System.out.println("Member name please: ");
				name = s.nextLine();
				
				Person newMember = new Person(UUID.randomUUID(), name); 
				
				metier.registre(newMember);				
				message = "Registre ok "; 
				
				
				System.err.print("-----------------------------------\n");
				System.err.print("- MEMBERS LIST\n");
				members = metier.getMembers();	
				printMembers();
				System.err.print("- New Member add\n");
				System.out.println(newMember.toString());
				System.err.print("-----------------------------------\n");
				message = "end Menu 2";		
				break;
				
				///############################################
				 
			case 3: 
				Person p = null;
				
				System.out.print("Veuillez entre le nom du membre: ");
				
				name = s.nextLine();
								
				members = metier.findByName(name); 
				System.err.print("-----------------------------------\n");
				printMembers();
				System.err.print("-----------------------------------\n");
				
				System.out.println("Chosse the member to delete");
				
				choix = s.nextInt(); s.nextLine();
				
				// chosse the x person from the member list and delete
				
				p = members.get( choix - 1 );
				
				metier.unregistre(p);
				
				message = "end Menu 3";		 
				
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
		while(it.hasNext()) {
			Person p = it.next(); 
				System.out.println("Name: " + p.getName() + " Registred at: " + p.getRegistrationDate());			
		}		
	}
	
	
	/**
	 * i print all member list
	 */
	private void printMembers() {
		Iterator<Person> it = members.iterator();		
		while(it.hasNext()) {
			Person p = it.next(); 
			System.out.println("Name: " + p.getName() + " Registred at: " + p.getRegistrationDate());
		}		
	}
	
	
	
	
}

package be.coello.poo.app3t.entities;

import java.util.UUID;

public class OnLineBook extends Book{

	private byte maxPeople; 
	private String content;
	
	
	public OnLineBook(UUID id, String title, String author, short totalpages, String langguage) {
		super(id, title, author, totalpages, langguage);
		this.maxPeople = 2;
		this.content = "";
	}
	
	
	public byte getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(byte maxPeople) {
		this.maxPeople = maxPeople;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "OnLineBook [maxPeople=" + maxPeople + ", content=" + content + "]";
	} 
	
	
	
	
}

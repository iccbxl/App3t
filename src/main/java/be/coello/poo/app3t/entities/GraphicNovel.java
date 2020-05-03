package be.coello.poo.app3t.entities;

import java.util.UUID;

public class GraphicNovel extends Book{

	private String catoonist; 
	private boolean color;
	
	
	public GraphicNovel(UUID id, String title, String author, short totalpages, String langguage, String catoonist) {
		super(id, title, author, totalpages, langguage);
		this.catoonist = catoonist;
		this.color = true;
	}
	
	
	public String getCatoonist() {
		return catoonist;
	}
	public void setCatoonist(String catoonist) {
		this.catoonist = catoonist;
	}
	
	
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return "GraphicNovel [catoonist=" + catoonist + ", color=" + color + "]";
	} 
	
	
	
	
	
}

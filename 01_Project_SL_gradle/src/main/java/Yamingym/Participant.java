package Yamingym;

public class Participant {
	
	private int id;
	private String name; 
	
	public Participant(String name, int id) {
		this.id = id;
		this.name = name; 
	}
	
	public int getID() {
		return this.id; 
	}
	
	public String getName() {
		return this.name; 
	}
	
	@Override
	public String toString() {
		return "(id: " + getID() + " name: " + getName() + ")";
	}

}

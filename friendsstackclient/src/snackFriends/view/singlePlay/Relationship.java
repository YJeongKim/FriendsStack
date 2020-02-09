package snackFriends.view.singlePlay;

import java.util.ArrayList;

public class Relationship {
	private String animal;
	private ArrayList<String> relationship;
	
	public Relationship() {}
	public Relationship(String animal,ArrayList<String> relationship) {
		this.animal=animal;
		this.relationship= new ArrayList<String>(relationship);
	} 
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {this.animal = animal;}
	public ArrayList<String> getRelationShip(){
		return relationship;
	}
	public void setRelationShip(ArrayList<String> relationship) {
		this.relationship = (ArrayList<String>)relationship.clone();
	}
	public ArrayList<String> getRelationship() {
		return relationship;
	}
	
}

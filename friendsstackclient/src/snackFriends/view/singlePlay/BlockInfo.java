package snackFriends.view.singlePlay;

public class BlockInfo {
	private String animal;
	private String relation;
	
	public BlockInfo(String animal, String relation) {
		this.animal=animal;
		this.relation=relation;
	}
	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	
}

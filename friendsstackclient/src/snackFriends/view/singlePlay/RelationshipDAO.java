package snackFriends.view.singlePlay;

import java.util.ArrayList;

public class RelationshipDAO {
	private static RelationshipDAO instance;
	private ArrayList<Relationship> relationShipList;

	private RelationshipDAO() {
		relationShipList = new ArrayList<Relationship>();
		ArrayList<String> catRelation = new ArrayList<>();
		catRelation.add("dog");
		catRelation.add("bear");
		ArrayList<String> dogRelation = new ArrayList<>();
		dogRelation.add("cat");
		dogRelation.add("rabbit");
		ArrayList<String> rabbitRelation = new ArrayList<>();
		rabbitRelation.add("dog");
		rabbitRelation.add("bee");
		ArrayList<String> bearRelation = new ArrayList<>();
		bearRelation.add("bee");
		bearRelation.add("cat");
		ArrayList<String> beeRelation = new ArrayList<>();
		beeRelation.add("bear");
		beeRelation.add("rabbit");
		relationShipList.add(new Relationship("cat", catRelation));
		relationShipList.add(new Relationship("dog", dogRelation));
		relationShipList.add(new Relationship("rabbit", rabbitRelation));
		relationShipList.add(new Relationship("bear", bearRelation));
		relationShipList.add(new Relationship("bee", beeRelation));

	}

	public static RelationshipDAO getInstance() {
		if (instance == null) {
			instance = new RelationshipDAO();
		}
		return instance;
	}

	public ArrayList<String> search(String animal) {
		for (Relationship r : relationShipList) {
			if (animal.equals(r.getAnimal())) {
				return r.getRelationShip();
			}
		}
		return null;
	}

	public void insert() {
	}

	public void update() {
	}

	public void delete() {
	}
}

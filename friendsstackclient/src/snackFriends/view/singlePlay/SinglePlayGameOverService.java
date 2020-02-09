package snackFriends.view.singlePlay;

public class SinglePlayGameOverService {
	public int getScore() {
		return BlockAdmin.getInstance().getBlockCount();
	}
	
}

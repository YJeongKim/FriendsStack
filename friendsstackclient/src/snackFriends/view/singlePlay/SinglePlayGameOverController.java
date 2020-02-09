package snackFriends.view.singlePlay;

public class SinglePlayGameOverController {
	public SinglePlayGameOverService singlePlayGameOverService;
	public SinglePlayGameOverController() {
		singlePlayGameOverService= new SinglePlayGameOverService();
	}
	public int getScore() {
		return singlePlayGameOverService.getScore();
	}
	
}

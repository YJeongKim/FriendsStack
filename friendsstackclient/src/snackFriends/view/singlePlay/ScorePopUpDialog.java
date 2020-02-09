package snackFriends.view.singlePlay;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

public class ScorePopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public ScorePopUpDialog(int score) {
		super(GameFrame.getInstance(), true);
		add(new ScorePopUp(this,score));
		setSize(765, 985);
		this.setLocationRelativeTo(null);
	}
}

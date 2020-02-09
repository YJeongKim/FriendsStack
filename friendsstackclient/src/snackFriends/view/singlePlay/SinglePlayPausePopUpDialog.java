package snackFriends.view.singlePlay;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

public class SinglePlayPausePopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public SinglePlayPausePopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new SinglePlayPausePopUp(this));
		setSize(555, 668);
		this.setLocationRelativeTo(null);
	}
}

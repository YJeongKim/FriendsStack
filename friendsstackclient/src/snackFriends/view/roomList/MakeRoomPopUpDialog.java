package snackFriends.view.roomList;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

public class MakeRoomPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public MakeRoomPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new MakeRoomPopUp(this));
		setSize(565, 282);
		this.setLocationRelativeTo(null);
	}
	
}

package snackFriends.view.mainScreen;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * 종료 팝업(ExitPopUp)창을 붙이기 위한 JDialog 클래스이다.
 * 
 * @author STF
 *
 */
public class ExitPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * ExitPopUp창을 생성하고 ExitPopUpDialog에 ExitPopUp을 add한다.
	 */
	public ExitPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new ExitPopUp(this));
		setSize(565, 505);
		this.setLocationRelativeTo(null);
	}

}

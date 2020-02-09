package snackFriends.view.multiPlay;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * 팁 팝업(TipPopUp)창을 붙이기 위한 JDialog 클래스이다.
 * @author SnackTimeFriends 
 */
public class TipPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * TipPopUp창을 생성하고 TipPopUpDialog에 TipPopUp을 add한다. 
	 */
	public TipPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new TipPopUp(this));
		setSize(695,985);
		this.setLocationRelativeTo(null);
	}
		
}

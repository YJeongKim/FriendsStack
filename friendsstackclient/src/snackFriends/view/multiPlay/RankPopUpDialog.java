package snackFriends.view.multiPlay;

import javax.swing.JDialog;

import snackFriends.view.bean.GameFrame;

/**
 * 결과 팝업(RankPopUp)창을 붙이기 위한 JDialog 클래스이다.
 * @author SnackTimeFriends
 *
 */
public class RankPopUpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * RankPopUp창을 생성하고 RankPopUpDialog에 RankPopUp을 add한다.
	 */
	public RankPopUpDialog() {
		super(GameFrame.getInstance(), true);
		add(new RankPopUp(this));
		setSize(765, 990);
		this.setLocationRelativeTo(null);
	}

}

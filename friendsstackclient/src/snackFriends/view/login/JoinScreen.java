package snackFriends.view.login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import snackFriends.view.bean.JoinInfo;

public class JoinScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private ImageIcon joinBaseBtnImg, joinEntryBtnImg;
	private ImageIcon cancelBaseBtnImg, cancelEntryBtnImg;
	private JFrame frame;
	private JButton joinButton;
	private JButton cancelButton;
	private JTextField id;
	private JPasswordField password;
	private JPasswordField passwordCheck;
	private JLabel passwordLabel;
	private JTextField email;
	private JComboBox<String> hintComboBox;
	private JTextField hintAnswer;

	private class JoinButtonHandler extends MouseAdapter {
		private JoinController joinController;

		public JoinButtonHandler() {
			joinController = new JoinController();
		}

		public void mouseEntered(MouseEvent e) {
			joinButton.setIcon(joinEntryBtnImg);
			joinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			joinButton.setIcon(joinBaseBtnImg);
			joinButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			int check = 0;
			String pass = new String(password.getPassword());
			String passCheck = new String(passwordCheck.getPassword());
			if (!CheckValid.idValidCheck(id.getText())) {
				id.setText("5-10자의 영문 숫자");
				check++;
			}
			if (!pass.equals(passCheck)) {
				passwordLabel.setText("비밀번호가 불일치 합니다.");
				check++;
			} else if (!CheckValid.passwordValidCheck(pass)) {
				passwordLabel.setText("8-15자의 영문 숫자 ");
				check++;
			}
			if (!CheckValid.emailValidCheck(email.getText())) {

				email.setText("최대 30글자의 이메일 양식");
				check++;
			}
			if (!CheckValid.passwordHintAnswerValidCheck(hintAnswer.getText())) {

				hintAnswer.setText("1-20글자");
				check++;
			}
			if (check == 0) {
				JoinInfo joinInfo = new JoinInfo();
				joinInfo.setId(id.getText());
				joinInfo.setPassword(pass);
				joinInfo.setEmail(email.getText());
				joinInfo.setPasswordHintQuestion(hintComboBox.getSelectedIndex() + 1);
				joinInfo.setPasswordHintAnwser(hintAnswer.getText());
				int joinCheck = joinController.join(joinInfo);
				if (joinCheck == 0)
					id.setText("중복");
				else if (joinCheck == 1) {
					clearText();
					new WelcomePopUpDialog(frame).setVisible(true);
				}
			}
		}
	}

	public void clearText() {
		id.setText("");
		password.setText("");
		passwordCheck.setText("");
		email.setText("");
		hintAnswer.setText("");
		passwordLabel.setText("");
	}

	private class CancelButtonHandler extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			cancelButton.setIcon(cancelEntryBtnImg);
			cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		public void mouseExited(MouseEvent e) {
			cancelButton.setIcon(cancelBaseBtnImg);
			cancelButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		public void mousePressed(MouseEvent e) {
			// 로그인 화면으로 이동
			clearText();
			frame.setContentPane(new LoginScreen(frame));
			frame.setVisible(true);
		}
	}

	public JoinScreen(JFrame frame) {
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		background = new ImageIcon("image/join/joinBackground.png");
		joinBaseBtnImg = new ImageIcon("image/join/join1.png");
		cancelBaseBtnImg = new ImageIcon("image/join/cancel1.png");
		joinEntryBtnImg = new ImageIcon("image/join/join2.png");
		cancelEntryBtnImg = new ImageIcon("image/join/cancel2.png");
		this.frame = frame;
		addJoinButton();
		addCancelButton();
		addId();
		addPassword();
		addEmail();
		addHint();
		// setBounds(100, 100, 755, 985);
	}

	public void addJoinButton() {
		joinButton = new JButton(joinBaseBtnImg);
		joinButton.setBounds(150, 800, 200, 90);
		joinButton.setBorderPainted(false);
		joinButton.setContentAreaFilled(false);
		joinButton.setFocusPainted(false);
		this.add(joinButton);
		joinButton.addMouseListener(new JoinButtonHandler());
	}

	public void addCancelButton() {
		cancelButton = new JButton(cancelBaseBtnImg);
		cancelButton.setBounds(397, 800, 200, 90);
		cancelButton.setBorderPainted(false);
		cancelButton.setContentAreaFilled(false);
		cancelButton.setFocusPainted(false);
		this.add(cancelButton);
		cancelButton.addMouseListener(new CancelButtonHandler());
	}

	public void addId() {
		id = new JTextField(10);
		id.setColumns(10);
		id.setBounds(360, 232, 250, 57);
		id.setBorder(null);
		id.setBackground(new Color(255, 239, 239));
		id.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setText("5-10자의 영문 숫자");
		this.add(id);
	}

	public void addPassword() {
		password = new JPasswordField(15);
		password.setColumns(10);
		password.setBounds(360, 352, 250, 57);
		password.setBorder(null);
		password.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		password.setHorizontalAlignment(JTextField.CENTER);
		password.setBackground(new Color(255, 239, 239));
		this.add(password);

		passwordCheck = new JPasswordField();
		passwordCheck.setColumns(10);
		passwordCheck.setBounds(360, 472, 250, 57);
		passwordCheck.setBorder(null);
		passwordCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		passwordCheck.setBackground(new Color(255, 239, 239));
		passwordCheck.setHorizontalAlignment(JTextField.CENTER);
		this.add(passwordCheck);

		passwordLabel = new JLabel();
		passwordLabel.setBounds(360, 409, 250, 57);
		passwordLabel.setBorder(null);
		passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		passwordLabel.setHorizontalAlignment(JTextField.CENTER);
		passwordLabel.setText("8-15자의 영문 숫자");
		passwordLabel.setForeground(Color.RED);
		this.add(passwordLabel);
	}

	public void addEmail() {
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(360, 585, 250, 57);
		email.setBorder(null);
		email.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		email.setBackground(new Color(255, 249, 229));
		email.setHorizontalAlignment(JTextField.CENTER);
		email.setText("최대 30글자의 이메일");
		this.add(email);
	}

	public void addHint() {
		String hints[] = { "나의 보물 1호는?", "나의 출신 초등학교는?", "나의 첫사랑은?" };
		hintComboBox = new JComboBox<String>(hints);
		hintComboBox.setBounds(95, 703, 195, 57);
		hintComboBox.setFont((new Font("배달의민족 주아", Font.PLAIN, 19)));
		hintComboBox.setBackground(new Color(191, 222, 172));
		hintComboBox.setBorder(new LineBorder(new Color(191, 222, 172)));
		this.add(hintComboBox);

		hintAnswer = new JTextField();
		hintAnswer.setColumns(10);
		hintAnswer.setBounds(360, 703, 250, 57);
		hintAnswer.setBackground(new Color(226, 240, 217));
		hintAnswer.setBorder(null);
		hintAnswer.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		hintAnswer.setHorizontalAlignment(JTextField.CENTER);
		hintAnswer.setText("1-20글자");
		this.add(hintAnswer);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(background.getImage(), 0, 0, 750, 952, null);
	}

}

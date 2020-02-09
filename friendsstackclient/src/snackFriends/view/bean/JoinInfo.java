package snackFriends.view.bean;

public class JoinInfo {
	private String id;
	private String password;
	private int passwordHintQuestion;
	private String passwordHintAnswer;
	private String email;

	public JoinInfo() {
		this(null, null, -1, null, null);
	}

	public JoinInfo(String[] joinInfo) {
		this(joinInfo[0], joinInfo[1], Integer.parseInt(joinInfo[2]), joinInfo[3], joinInfo[4]);
	}

	public JoinInfo(String id, String password, int passwordHintQuestion, String passwordHintAnswer, String email) {
		this.id = id;
		this.password = password;
		this.passwordHintQuestion = passwordHintQuestion;
		this.passwordHintAnswer = passwordHintAnswer;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public int getPasswordHintQuestion() {
		return passwordHintQuestion;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswordHintAnswer() {
		return passwordHintAnswer;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordHintQuestion(int passwordHintQuestion) {
		this.passwordHintQuestion = passwordHintQuestion;
	}

	public void setPasswordHintAnwser(String passwordHintAnwser) {
		this.passwordHintAnswer = passwordHintAnwser;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("");

		sb.append(id + "//");
		sb.append(password + "//");
		sb.append(passwordHintQuestion + "//");
		sb.append(passwordHintAnswer + "//");
		sb.append(email);

		return sb.toString();
	}
}

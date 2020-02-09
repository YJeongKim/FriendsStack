package snackFriends.view.bean;

public class LoginInfo {
	private String id;
	private String password;

	public LoginInfo() {
		this(null, null);
	}

	public LoginInfo(String[] loginInfo) {
		this(loginInfo[0], loginInfo[1]);
	}

	public LoginInfo(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id + "//" + password);
		return sb.toString();
	}
}

package snackFriends.view.login;

public class CheckValid {
	public static boolean idValidCheck(String id) {
		if (checkLength(10, 5, id)) {
			if (checkEngNum(id)) {
				return true;
			}
		}
		return false;
	}

	public static boolean passwordValidCheck(String password) {
		if (checkLength(15, 8, password)) {
			if (checkEngNum(password)) {
				return true;
			}
		}
		return false;
	}

	public static boolean emailValidCheck(String email) {
		if (checkLength(30, 1, email)) {
			if (email.contains("@") && email.contains(".")) {
				return true;
			}
		}
		return false;
	}

	public static boolean passwordHintAnswerValidCheck(String passwordHintAnswer) {
		if (checkLength(20, 1, passwordHintAnswer))
			return true;
		return false;
	}

	public static boolean checkEngNum(String str) {
		String temp = str.toUpperCase();
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = temp.charAt(i);
			if (!(ch >= 48 && ch <= 57 || (ch >= 65 && ch <= 90))) { // 숫자 || 영문자
				System.out.println(str + "잘못 입력");
				return false;
			}
		}
		return true;
	}

	public static boolean checkLength(int max, int min, String str) {
		int length = str.length();
		if (length <= max && length >= min)
			return true;
		System.out.println(str + length + "길이 제한");
		return false;
	}
}

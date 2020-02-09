package snackFriends.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerInfoDAO {
	private static PlayerInfoDAO instance = new PlayerInfoDAO();
	private ArrayList<PlayerInfo> playerInfoList;
	private static final String URL = "jdbc:mysql://localhost/friends_stack?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "12qwaszx";

	private PreparedStatement insertPlayerStmt;
	private PreparedStatement insertHintStmt;
	private PreparedStatement insertKongStmt;
	private PreparedStatement insertScoreStmt;
	private PreparedStatement getIdStmt;
	private PreparedStatement getKongStmt;
	private PreparedStatement hintQuestionStmt;
	private PreparedStatement hintAnswerStmt;
	private Connection con = null;
	private ResultSet rs = null;

	private void initPstmt() {
		// String insert = "Insert into join_info_view values(?,?,?,?,?)";
		String insertPlayer = "INSERT INTO player_info_tb (id,password,email)VALUES(?,?,?)";
		String insertHint = "INSERT INTO password_hint_tb (id,password_hint_question,password_hint_answer) VALUES (?,?,?)";
		String insertKong = "INSERT INTO kong_info_tb (id,kong) VALUES (?,0)";
		String insertScore = "INSERT INTO best_score_info_tb (id,best_score) VALUES (?,0);";
		String getId = "Select id from player_info_tb where email= ?";
		String getKong = "select kong from kong_info_tb where id = ?";
		String hintQuestion = "select password_hint_question from password_hint_tb where id =?";
		String hintAnswer = "select pit.password from password_hint_tb as pht left join player_info_tb as pit using(id)\r\n"
				+ "where id=? and pht.password_hint_answer=?";

		try {
			insertPlayerStmt = con.prepareStatement(insertPlayer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			insertHintStmt = con.prepareStatement(insertHint);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			insertKongStmt = con.prepareStatement(insertKong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			insertScoreStmt = con.prepareStatement(insertScore);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			getIdStmt = con.prepareStatement(getId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			getKongStmt = con.prepareStatement(getKong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			hintQuestionStmt = con.prepareStatement(hintQuestion);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			hintAnswerStmt = con.prepareStatement(hintAnswer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private PlayerInfoDAO() {
		playerInfoList = new ArrayList<PlayerInfo>();
		Collections.synchronizedList(playerInfoList);
		loadDriver();
		connect(URL, USER, PASS);
		initPstmt();
		PreparedStatement initStmt = null;
		try {
			String init = "select id, password from player_info_tb";
			initStmt = con.prepareStatement(init);
			rs = initStmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				System.out.println("id와 password 출력:" + id + "   " + password);
				this.playerInfoList.add(new PlayerInfo(id, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				initStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// try {
		// rs.close();
		// stmt.close();
		// con.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}

	public static PlayerInfoDAO getInstance() {
		return instance;
	}

	public void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC 드라이버가 검색되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾지 못했습니다.");
		}
	}

	public void connect(String url, String user, String pass) {
		System.out.println("데이터베이스 연결 중...");
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			e.getStackTrace();
		}
	}

	public boolean insert(PlayerInfo playerInfo) {
		if (playerInfo == null)
			return false;
		if (playerInfoList.add(playerInfo))
			return true;
		else
			return false;
	}

	public boolean insert(JoinInfo joinInfo) {
		System.out.println("insert시작...");
		if (joinInfo == null)
			return false;

		int result = 0;
		try {
			insertPlayerStmt.setString(1, joinInfo.getId());
			insertPlayerStmt.setString(2, joinInfo.getPassword());
			insertPlayerStmt.setString(3, joinInfo.getEmail());
			insertHintStmt.setString(1, joinInfo.getId());
			insertHintStmt.setInt(2, joinInfo.getPasswordHintQuestion());
			insertHintStmt.setString(3, joinInfo.getPasswordHintAnswer());
			insertKongStmt.setString(1, joinInfo.getId());
			insertScoreStmt.setString(1, joinInfo.getId());
			result = insertPlayerStmt.executeUpdate();
			insertHintStmt.executeUpdate();
			insertKongStmt.executeUpdate();
			insertScoreStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0)
			if (insert(new PlayerInfo(joinInfo.getId(), joinInfo.getPassword())))
				return true;
		return false;
	}

	// 회원탈퇴 추후 추가
	public boolean delete(String id) {
		return false;
	}

	// id,비밀번호 수정 추후 추가
	public boolean update(PlayerInfo playerInfo) {
		if (playerInfo == null)
			return false;

		return false;
		// 쿼리
	}

	public boolean searchID(String id) {
		if (id == null || id.equals(""))
			return false;

		int length = playerInfoList.size();

		for (int i = 0; i < length; i++) {
			if (id.equals(playerInfoList.get(i).getId()))
				return true;
		}
		return false;
	}

	public String searchEmail(String email) {
		String id = null;
		if (email == null || email.equals(""))
			return id;
		try {
			getIdStmt.setString(1, email);
			rs = getIdStmt.executeQuery();
			if (rs.next())
				id = rs.getString("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int search(PlayerInfo playerInfo) {
		System.out.println("PlayerInfoDAO.search()실행");
		int res = -1;
		if (playerInfo == null)
			return res;
		System.out.println(playerInfo);
		System.out.println(playerInfoList.indexOf(playerInfo));
		if (playerInfoList.indexOf(playerInfo) != -1) {
			try {
				getKongStmt.setString(1, playerInfo.getId());
				rs = getKongStmt.executeQuery();
				if (rs.next())
					res = rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public boolean searchPasswordHintQuestion(String id, int passwordHintQuestion) {
		if (id == null || id.equals(""))
			return false;
		int res = -1;
		try {
			hintQuestionStmt.setString(1, id);
			rs = hintQuestionStmt.executeQuery();
			if (rs.next())
				res = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passwordHintQuestion == res;
	}

	public String searchPasswordHintAnswer(String id, String passwordHintAnswer) {
		String res = null;
		if (id == null || id.equals("") || passwordHintAnswer == null)
			return res;
		try {
			hintAnswerStmt.setString(1, id);
			hintAnswerStmt.setString(2, id);
			rs = hintAnswerStmt.executeQuery();
			if (rs.next())
				res = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}

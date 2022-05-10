package co.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PracticeDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public List<practiceVO> getList() {
		String sql = "selcect * from ckList";
		getConnect();
		List<practiceVO> list = new ArrayList<practiceVO>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				practiceVO vo = new practiceVO(rs.getString("ckList"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	public void insertList(practiceVO vo) {
		String sql = "insert into ckList (check_li) values(?)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCkList());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void deleteList(String ckList) {
		String sql = "delete from ckList where check_li=?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ckList);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

	}

	public void getConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 주소
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.125:1521:xe", "hr", "hr"); // 드라이버 주소
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disConnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

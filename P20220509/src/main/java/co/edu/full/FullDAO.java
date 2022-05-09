package co.edu.full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	// 리스트
	public List<FullVO> getList() {
		String sql = "select * from full_calendar";
		getConnect();
		List<FullVO> list = new ArrayList<FullVO>(); // 하단의 while 값을 이곳에 리턴함.
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				FullVO vo = new FullVO(rs.getString("title"), // title
						rs.getString("start_date"), // start
						rs.getString("end_date") // end
				);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 한건입력

	public void insertSchedule(FullVO vo) {
		String sql = "insert into FULL_CALENDAR (title, start_date, end_date) values(?,?,?)";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());
			int r = psmt.executeUpdate();

			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	// 한건삭제

	public void deleteSchedule(String title) {
		String sql = "delete from FULL_CALENDAR where title=?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
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

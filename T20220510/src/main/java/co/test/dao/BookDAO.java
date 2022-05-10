package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	public List<BookVO> bookList() {
		conn();
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM book_info";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setBookCode(rs.getString("BOOK_CODE"));
				book.setBookTitle(rs.getString("BOOK_TITLE"));
				book.setBookAuthor(rs.getString("BOOK_AUTHOR"));
				book.setBookPress(rs.getString("BOOK_PRESS"));
				book.setBookPrice(rs.getInt("BOOK_PRICE"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public BookVO selectBook(String bookCode) {
		System.out.println(bookCode);
		conn();
		String sql = "SELECT * FROM book_info WHERE book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
				System.out.println();
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;

	}

	public boolean insertBook(BookVO book) {
		conn();
		String sql = "INSERT INTO book_info (book_code, book_title, book_author, book_press, book_price)\r\n"
				+ "VALUES(create_bookcode,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	public boolean updateBook(BookVO book) {
		conn();
		String sql = "UPDATE book_info set book_title=?, book_author=?, book_press=?, book_price=? where book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정");

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	public void deleteBook(String bookCode) {
		conn();
		String sql = "DELETE book_info where book_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
}
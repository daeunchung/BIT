package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.CalendarDto;

public class CalendarDao {

	private static CalendarDao dao = new CalendarDao();

	private CalendarDao() {
	}

	public static CalendarDao getInstance() {
		return dao;
	}

	public List<CalendarDto> getCalendarList(String id, String yyyyMM) {
		String sql = " select seq, id, title, content, rdate, wdate "
				+ " from (select row_number()over(partition by substr(rdate, 1, 8) order by rdate asc) as rnum, "
				+ "			seq, id, title, content, rdate, wdate " + "		 from calendar "
				+ "		 where id=? and substr(rdate, 1, 6) = ?) a " + " where rnum between 1 and 5 ";

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<CalendarDto> list = new ArrayList<CalendarDto>();

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int i = 1;
				CalendarDto dto = new CalendarDto(rs.getInt(i++), rs.getString(i++), rs.getString(i++),
						rs.getString(i++), rs.getString(i++), rs.getString(i++));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}

		return list;
	}

	public boolean addCalandar(CalendarDto cal) {

		String sql = " insert into calendar(id, title, content, rdate, wdate) " + " values(?, ?, ?, ?, now()) ";

		Connection conn = null;
		PreparedStatement psmt = null;

		int count = 0;

		try {
			conn = DBConnection.getConnection();

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cal.getId());
			psmt.setString(2, cal.getTitle());
			psmt.setString(3, cal.getContent());
			psmt.setString(4, cal.getRdate()); // 202207061230

			count = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			DBClose.close(conn, psmt, null);
		}
		return count > 0 ? true : false;

	}

}

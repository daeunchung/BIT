package com.example.jspwithdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.jspwithdb.DB.DBClose;
import com.example.jspwithdb.DB.DBConnection;
import com.example.jspwithdb.dto.CalendarDto;

public class CalendarDao {
	private static CalendarDao dao = new CalendarDao();

	private CalendarDao(){

	}

	public static CalendarDao getInstance(){
		return dao;
	}

	public List<CalendarDto> getCalendarList(String id, String yyyyMM){
		String sql = " select seq, id, title, content, rdate, wdate "
				   + " from(select row_number()over(partition by substr(rdate, 1, 8) order by rdate asc) as rnum, "
				   + "        seq, id, title, content, rdate, wdate "
				   + "      from calendar "
				   + "      where id='?' and substr(rdate, 1, 6) = '?') a "
				   + " where rnum between 1 and 5 ";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		List<CalendarDto> list = new ArrayList<>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyyMM);

			rs = psmt.executeQuery();
			while(rs.next()){
				CalendarDto dto = new CalendarDto(rs.getInt(1),
												rs.getString(2),
												rs.getString(3),
												rs.getString(4),
												rs.getString(5),
												rs.getString(6)
						);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBClose.close(conn, psmt, rs);
		}
		return list;
	}
}

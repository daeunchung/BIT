package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import db.DBClose;
import db.DBConnection;
import dto.CalendarDto;

public class CalendarDao {

	
	public boolean addCalandar(CalendarDto cal) {
	
	String sql = " insert into calendar(id, title, content, rdate, wdate) "
	+ " values(?, ?, ?, ?, now()) ";
	
	Connection conn = null;
	PreparedStatement psmt = null;
	
	int count = 0;
	
	try {
		conn = DBConnection.getConnection();
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, cal.getId());
		psmt.setString(2, cal.getTitle());
		psmt.setString(3, cal.getContent());
		psmt.setString(4, cal.getRdate());	// 202207061230
		
		count = psmt.executeUpdate();
	} catch (SQLException e){
		e.printStackTrace();
		
	}finally {
		
		DBClose.close(conn, psmt, null);
	}
	return count > 0 ? true: false;
	
	}
	
}

package lotte.com.a.util;

import java.util.Calendar;
import java.util.Date;

public class PollUtil {

	public static String two(String msg) {	// 5 -> 05
		return msg.trim().length()<2?"0"+msg.trim():msg.trim();
	}
	
	// 달력의 날짜를 20220715 형식으로 만들기
	public static String replaceDate(Calendar dd) {
		String s = "";
		int year = dd.get(Calendar.YEAR);
		int month = dd.get(Calendar.MONTH);
		int day = dd.get(Calendar.DATE);
		
		s = year + "" + PollUtil.two(month + "") + PollUtil.two(day + "");
		
		return s;
	}
	
	// 연월일을 비교. 투표가 끝났는지? 
	public static boolean isEnd(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		
		Calendar now = Calendar.getInstance();
		
		boolean b = Integer.parseInt(replaceDate(now)) > Integer.parseInt(replaceDate(c));		
		return b;
	}	
	
	// 투표 종료를 판정
	public static String pollState(Date d) {
		
		String s1 = "<div style='color:RED'>[종료]</div>";
		String s2 = "<div style='color:BLUE'>[진행중]</div>";
		
		return isEnd(d)?s1:s2;
	}
	
	public static java.sql.Date toDate(int year, int month, int day) {
		String s = year + "-" + two(month + "") + "-" + two(day + "");
		java.sql.Date d = java.sql.Date.valueOf(s);
		return d;
	}
	
}







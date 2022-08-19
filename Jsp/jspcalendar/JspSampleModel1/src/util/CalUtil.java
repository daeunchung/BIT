package util;


import java.util.List;

import dto.CalendarDto;

public class CalUtil {

	//문자열검사 -> 빈 문자열인 경우 true 리턴
	public boolean nvl(String msg){
		return msg == null || msg.trim().equals("")?true:false;
	}

	//1~9일 때 앞에 0붙이는 메서드
	public String two(String msg){
		return msg.trim().length() < 2 ? "0"+msg.trim() : msg.trim();
	}

	//날짜
	public String callist(int year, int month, int day){
		String str = "";
		
		str += String.format("&nbsp;<a href='callist.jsp?year=%d&month=%d&day=%d'>", year, month, day);
		str += String.format("%2d", day);
		str += "</a>";
		
		return str;
	}

	//pen 아이콘
	public String showPen(int year, int month, int day){
		String str = "";
		
		String image = "<img src='image/pen2.png' width='18px' height='18px'>";
		str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>", year, month, day, image);
		
		return str;
	}

	//
	public String dot3(String msg){
		String str = "";
		
		if(msg.length() >= 10){
			str = msg.substring(0, 10);
			str += "...";
		}
		else{
			str = msg.trim();
		}
		
		return str;
	}

	//
	public String makeTable(int year, int month, int day, List<CalendarDto> list){
		String str = "";
		
		String dates = (year+"")+two(month+"")+two(day+"");
		
		str += "<table>";
		for(CalendarDto dto : list){
			if(dto.getRdate().substring(0, 8).equals(dates)){
				str += "<tr>";
				str += "	<td style='padding:0px;border:1;background-color:white;border-color:blue;radius:3'>";
				str += "		<a href='caldetail.jsp?seq="+dto.getSeq()+"'>";
				str += "			<font style='font-size:10px'>";
				str += 					dot3(dto.getTitle());
				str += "			</font>";
				str += "		</a>";
				str += "	</td>";
				str += "</tr>";
			}
		}
		
		str += "</table>";
		
		return str;
	}
}

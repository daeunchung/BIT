package util;

import java.util.List;

import dto.CalendarDto;

public class calUtil {

	// 문자열검사 : 빈문자열->true
	public static boolean nvl(String msg){
		return msg == null || msg.trim().equals("")?true:false;
	}

	// 1 ~ 9 -> 01 ~ 09
	public static String two(String msg){
		return msg.trim().length() < 2 ?"0"+ msg.trim():msg.trim();
	}

	// 일별 일정 모두 보는 callist.jsp로 이동
	public static String callist(int year, int month, int day){
		String str = "";
		
		str += String.format("&nbsp;<a href='callist.jsp?year=%d&month=%d&day=%d'>", 
															year, month, day);
		str += String.format("%2d", day);		
		str += "</a>";
		
		return str;
	}

	// 일정 추가 link
	public static String showPen(int year, int month, int day){
		String str = "";
		
		String image = "<img src='image/pen2.png' width='18px' height='18px'>";
		str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>", 
													year, month, day, image);
		return str;	
	}

	//CGV에서 6시까지 영화보기로 하였음 -> CGV에서 6시까지...
	public static String dot3(String msg){		
		String str = "";
		if(msg.length() >= 10){
			str = msg.substring(0, 10);
			str += "...";
		}else{
			str = msg.trim();
		}
		return str;	
	}

	public static String makeTable(int year, int month, int day, List<CalendarDto> list){
		String str = "";
		
		// 2022 7 6 -> 20220706
		String dates = (year + "") + two(month + "") + two(day + "");
		
		str += "<table>";
	//	str += "<col width=''>";
		
		for(CalendarDto dto : list){
			if(dto.getRdate().substring(0, 8).equals(dates)){
				str += "<tr>"; 
			//	str += "  <td style='padding:0px; border:1; border-color:blue; radius:3'>";
				str += "  <td style='padding:0px; height:20; border-color:white'>";
				
				str += "    <a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";			
				str += "      <font style='font-size:10px'>";
				str += 				dot3(dto.getTitle());			
				str += "      </font>"; 			
				str += "    </a>";
				
				str += "  </td>"; 
				str += "</tr>";	
			}		
		}	
		str += "</table>";
		
		return str;
	}
}

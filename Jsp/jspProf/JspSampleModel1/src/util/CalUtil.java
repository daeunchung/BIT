package util;

public class CalUtil {

	// 문자열 검사 -> 빈 문자열인 경우 true 리턴
	public boolean nvl(String msg) {
		return msg == null || msg.trim().equals("")? true:false;
	}
}

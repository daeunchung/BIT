import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 
		 * Calendar :  일정관리, 인사관리, 입사정보
		 * 
		 * Date => JavaScript
		 * 
		 * Calendar -> java == Spring framework
		 * 
		 * RESTful -> Spring Boot
		 * JavaScript -> Date
		 * 
		 */
		
//		Calendar cal = new GregorianCalendar();
		
		Calendar cal = Calendar.getInstance();	// static 함수
		
		// 오늘 날짜 취득
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;	//0 ~ 11  꺼내 올때는 1 더하고 
		int day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		
		// 날짜 설정
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 8 - 1);				// 넣을 때는 1 빼고
		cal.set(Calendar.DATE, 15);
		
		 year = cal.get(Calendar.YEAR);
		 month = cal.get(Calendar.MONTH) + 1;	//0 ~ 11  꺼내 올때는 1 더하고 
		 day = cal.get(Calendar.DATE);
		
		System.out.println(year + "/" + month + "/" + day);
		
		String ampm = cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
		System.out.println(ampm);
		
		// 요일
		
		int weekday = cal.get(Calendar.DAY_OF_WEEK);	// 1(일) ~ 7(토)
		
		switch(weekday) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		
		
		// 오늘
//		 year = cal.get(Calendar.YEAR);
//		 month = cal.get(Calendar.MONTH) + 1;	//0 ~ 11  꺼내 올때는 1 더하고 
//		 day = cal.get(Calendar.DATE);
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 2-1);
		cal.set(Calendar.DATE, 8);

		 // last day
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		
		
		// 달력 출력 예제
		/*
		    일  월  화  수  목  금  토
		     *  *  *  1  2  3   4
		     5  6  7  8  9  10 11
		     12 13 14 15 16 17 18
		     19 20 21 22 23 24 25
		     26 27 28 29 30  *  *
		 */
		
		int MaxDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int getMaxDaysOfMonth(int month) {
			return MaxDays[month-1];
		}
		
		void printCalendar(int month) {
			System.out.println(" S  M  T  W  T  F  S ");
			System.out.println("---------------------");
			int maxDay = getMaxDaysOfMonth(month);
			
			for (int i = 0; i < MaxDays.length; i++) {
				System.out.println("%3d", i);
				if(i % 7 == 0)
					System.out.println();
			}
		}
		
	}

}

package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BbsDaoTest {

	@Test
	void test() {
		// 싱글턴
		BbsDao dao = BbsDao.getInstance();
		
		assertEquals(0, dao.getAllBbs("", ""));
		
		// assertArrayEquals(null, null);
		// assertNull(obj);
		
		
		// 
		// 0705 - 달력일정관리
		// 0706 - 자료실 크롤링 파이차트사용하기(구글차트 뿌리기)
		
		// 플젝 - 영화예약사이트
	}

}

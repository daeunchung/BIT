package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BbsDaoTest {

	@Test
	void test() {
		BbsDao dao = BbsDao.getInstance();
		assertEquals(30, dao.getAllBbs("", ""));	
		
		// assertArrayEquals(null, null);
		// assertNull(obj);
	}

}

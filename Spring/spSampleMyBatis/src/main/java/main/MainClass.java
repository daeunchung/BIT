package main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.MemberDto;

public class MainClass {
	public static void main(String[] args) throws Exception {
		
		// mybatis 설정파일을 읽어 들인다
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		// SqlSessionFactory 객체를 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		// SqlSession 객체 취득
		SqlSession session = factory.openSession();		// session <- 실세
		
		// insert
		/*
		//MemberDto mem = new MemberDto("aaa", 24, 178.2);
		//MemberDto mem = new MemberDto("bbb", 22, 181.1);
		MemberDto mem = new MemberDto("ccc", 25, 169.3);
		
		int count = session.insert("addmember", mem);
		if(count > 0) {
			session.commit();
			System.out.println("추가 성공!");
		}else {
			session.rollback();
			System.out.println("추가 실패~");
		}
		*/
			
		
		// select
		String id = "bbb";
		MemberDto mem = session.selectOne("find", id);
		System.out.println(mem.toString());
		
		
		List<MemberDto> list = session.selectList("allmember");
		for (MemberDto m : list) {
			System.out.println(m.toString());
		}
		
		
		// delete
		
		// update
		
	}
}





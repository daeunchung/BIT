package lotte.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lotte.com.a.MemberDto;

// DB와 대화
@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession session;
	
	String namespace = "Member.";

	@Override
	public List<MemberDto> allMember() {
												// Member.allMember
		List<MemberDto> list = session.selectList(namespace + "allMember");		
		return list;
	}
	
	
}







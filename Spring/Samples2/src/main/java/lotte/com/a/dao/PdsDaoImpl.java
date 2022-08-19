package lotte.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lotte.com.a.dto.PdsDto;

@Repository
public class PdsDaoImpl implements PdsDao{

	@Autowired
	SqlSession session;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> pdslist() {		
		return session.selectList(ns + "pdslist");
	}

	@Override
	public int uploadPds(PdsDto dto) {		
		return session.insert(ns + "uploadPds", dto);
	}

	@Override
	public PdsDto getPds(int seq) {		
		return session.selectOne(ns + "getPds", seq);
	}
	
	
}









package lotte.com.a.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lotte.com.a.dto.BbsDto;
import lotte.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {

	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {		
		return session.selectList(ns + "bbslist", bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {		
		return session.selectOne(ns + "getBbsCount", bbs);
	}
	
	@Override
	public boolean writeBbs(BbsDto dto) {
		int n = session.insert(ns + "writeBbs", dto);
		return n>0?true:false;
	}
	
	@Override
	public BbsDto getBbs(int seq) {		
		return session.selectOne(ns + "getBbs", seq);
	}
	
}

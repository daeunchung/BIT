package lotte.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotte.com.a.dao.BbsDao;
import lotte.com.a.dto.BbsDto;
import lotte.com.a.dto.BbsParam;

@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbslist(BbsParam bbs) {		
		return dao.bbslist(bbs);
	}

	@Override
	public int getBbsCount(BbsParam bbs) {		
		return dao.getBbsCount(bbs);
	}
	
	@Override
	public boolean writeBbs(BbsDto dto) {		
		return dao.writeBbs(dto);
	}
	
	@Override
	public BbsDto getBbs(int seq) {		
		return dao.getBbs(seq);
	}
}

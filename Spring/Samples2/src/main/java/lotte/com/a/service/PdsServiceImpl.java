package lotte.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotte.com.a.dao.PdsDao;
import lotte.com.a.dto.PdsDto;

@Service
public class PdsServiceImpl implements PdsService{

	@Autowired
	PdsDao dao;

	@Override
	public List<PdsDto> pdslist() {		
		return dao.pdslist();
	}

	@Override
	public int uploadPds(PdsDto dto) {		
		return dao.uploadPds(dto);
	}

	@Override
	public PdsDto getPds(int seq) {		
		return dao.getPds(seq);
	}		
	
}

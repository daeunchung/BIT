package lotte.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotte.com.a.dao.MemberDao;
import lotte.com.a.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Override
	public String getId(String id) {		
		int count = dao.getId(id);		
		
		return count>0?"NO":"YES";
	}

	@Override
	public boolean addmember(MemberDto dto) {
		int n = dao.addmember(dto);
		return n>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto dto) {		
		return dao.login(dto);
	}	
		
	
}





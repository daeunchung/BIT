package lotte.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lotte.com.a.MemberDto;
import lotte.com.a.dao.MemberDao;

// controller와 dao의 중간역할
// DB취득 데이터를 정리
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Override
	public List<MemberDto> allMember() {		
		return dao.allMember();
	}
	
	
}








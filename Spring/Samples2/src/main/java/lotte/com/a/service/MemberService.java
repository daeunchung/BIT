package lotte.com.a.service;

import lotte.com.a.dto.MemberDto;

public interface MemberService {

	String getId(String id);
	boolean addmember(MemberDto dto);
	MemberDto login(MemberDto dto);
}

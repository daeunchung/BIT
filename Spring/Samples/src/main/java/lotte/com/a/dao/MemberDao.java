package lotte.com.a.dao;

import lotte.com.a.dto.MemberDto;

public interface MemberDao {

	int getId(String id);
	int addmember(MemberDto dto);
	MemberDto login(MemberDto dto);
}

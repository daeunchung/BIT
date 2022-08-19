package lotte.com.a.dao;

import java.util.List;

import lotte.com.a.dto.PdsDto;

public interface PdsDao {

	List<PdsDto> pdslist();	
	int uploadPds(PdsDto dto);	
	PdsDto getPds(int seq);
}

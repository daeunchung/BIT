package lotte.com.a.service;

import java.util.List;

import lotte.com.a.dto.PdsDto;

public interface PdsService {
	List<PdsDto> pdslist();
	int uploadPds(PdsDto dto);
	
	PdsDto getPds(int seq);
}

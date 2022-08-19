package lotte.com.a.service;

import java.util.List;

import lotte.com.a.dto.BbsDto;
import lotte.com.a.dto.BbsParam;

public interface BbsService {

	List<BbsDto> bbslist(BbsParam bbs);	
	int getBbsCount(BbsParam bbs);
}

package lotte.com.a.dao;

import java.util.List;

import lotte.com.a.dto.BbsDto;
import lotte.com.a.dto.BbsParam;

public interface BbsDao {

	List<BbsDto> bbslist(BbsParam bbs);	
	int getBbsCount(BbsParam bbs);
	
	boolean writeBbs(BbsDto dto);
	
	BbsDto getBbs(int seq);
}

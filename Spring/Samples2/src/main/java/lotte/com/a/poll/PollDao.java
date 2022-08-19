package lotte.com.a.poll;

import java.util.List;

public interface PollDao {

	List<PollDto> polllist();	
	int isVoter(Voter voter);
	
	void makePoll(PollDto poll);
	void makePollSub(PollSubDto pollsub);
	
	PollDto getPoll(PollDto poll);
	List<PollSubDto> getPollSubList(PollDto poll);
	
	// 투표자 추가
	void pollingVoter(Voter voter);
	
	// 투표 주제에 카운터를 증가
	void pollingPoll(Voter voter);
	
	// 투표 보기에 카운터를 증가
	void pollingSub(Voter voter);
}






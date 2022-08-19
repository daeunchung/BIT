package lotte.com.a.poll;

/*
create table pollsub(
	pollsubid int auto_increment primary key,
    pollid int not null,
	answer varchar(1000) not null,
    acount decimal(8) not null
);

alter table pollsub
add
constraint pollsub_fk foreign key(pollid)
references poll(pollid);
*/

// 투표 항목(보기)
public class PollSubDto {
	private int pollsubid;		// seq
	private int pollid;			// 투표 주제 -> 외래키
	private String answer;		// 보기명 <- 사과, 배, 바나나
	private int acount;			// 이 보기를 선택한 사람 수
	
	public PollSubDto() {
	}

	public PollSubDto(int pollsubid, int pollid, String answer, int acount) {
		super();
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.acount = acount;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	@Override
	public String toString() {
		return "PollSubDto [pollsubid=" + pollsubid + ", pollid=" + pollid + ", answer=" + answer + ", acount=" + acount
				+ "]";
	}
	
	
	
}

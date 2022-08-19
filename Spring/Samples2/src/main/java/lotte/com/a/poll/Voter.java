package lotte.com.a.poll;

import java.util.Date;

/*
create table voter(
	voterid int auto_increment primary key,
    pollid int not null,
    pollsubid int not null,
    id varchar(50) not null,
    regdate date not null
);

alter table voter
add constraint voter_fk foreign key(pollid)
references poll(pollid);

alter table voter
add constraint voter_fk2 foreign key(pollsubid)
references pollsub(pollsubid);
*/

// 투표자
public class Voter {
	private int voterid;	// seq
	private int pollid;		// 질문
	private int pollsubid;	// 보기
	private String id;		// 누가
	private Date regdate;	// 언제
	
	public Voter() {
	}

	public Voter(int voterid, int pollid, int pollsubid, String id, Date regdate) {
		super();
		this.voterid = voterid;
		this.pollid = pollid;
		this.pollsubid = pollsubid;
		this.id = id;
		this.regdate = regdate;
	}
	
	public Voter(int pollid, String id) {
		super();
		this.pollid = pollid;
		this.id = id;
	}

	public int getVoterid() {
		return voterid;
	}

	public void setVoterid(int voterid) {
		this.voterid = voterid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Voter [voterid=" + voterid + ", pollid=" + pollid + ", pollsubid=" + pollsubid + ", id=" + id
				+ ", regdate=" + regdate + "]";
	}
	
}

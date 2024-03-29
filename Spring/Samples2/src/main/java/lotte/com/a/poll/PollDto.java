package lotte.com.a.poll;

import java.io.Serializable;
import java.util.Date;

/*
create table poll(
	pollid int auto_increment primary key,
    id varchar(50) not null,
    question varchar(1000) not null,
    sdate date not null,
    edate date not null,
    itemcount int not null,
    polltotal decimal(8) not null,
    regdate date not null
); 
*/
// 투표 질의(주제)
public class PollDto implements Serializable{
	private int pollid;		// seq
	private String id;		// 투표를 만든 사람
	private String question;	// 주제 -> 좋은 하는 과일은?
	private Date sdate;		// 투표 시작일
	private Date edate;		// 투표 종료일
	private Date regdate;	// 투표 만든날(등록)	
	private int itemcount;	// 보기 -> 2 ~ 10
	
	private int polltotal;	// 이 투표에 투표를 한사람 수
	
	private boolean vote;	// 로그인한 멤버가 이 투표에 투표를 했는지?
	
	public PollDto() {
	}

	public PollDto(int pollid, String id, String question, Date sdate, Date edate, Date regdate, int itemcount,
			int polltotal, boolean vote) {
		super();
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.regdate = regdate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.vote = vote;
	}

	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getItemcount() {
		return itemcount;
	}

	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}

	public int getPolltotal() {
		return polltotal;
	}

	public void setPolltotal(int polltotal) {
		this.polltotal = polltotal;
	}

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "PollDto [pollid=" + pollid + ", id=" + id + ", question=" + question + ", sdate=" + sdate + ", edate="
				+ edate + ", regdate=" + regdate + ", itemcount=" + itemcount + ", polltotal=" + polltotal + ", vote="
				+ vote + "]";
	}
	
}






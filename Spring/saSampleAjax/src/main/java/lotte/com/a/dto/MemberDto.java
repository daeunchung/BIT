package lotte.com.a.dto;

import java.io.Serializable;

public class MemberDto implements Serializable{
	
	private int number;
	private String name;
	
	public MemberDto() {
	}

	public MemberDto(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberDto [number=" + number + ", name=" + name + "]";
	}
	

}

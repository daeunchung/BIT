package main;

public class addressDTO {

	String name;
	String age;
	String phone;
	String addr;
	String relation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public addressDTO(String name, String age, String phone, String addr, String relation) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.addr = addr;
		this.relation = relation;
	}
	@Override
	public String toString() {
		return "addressDTO [name=" + name + ", age=" + age + ", phone=" + phone + ", addr=" + addr + ", relation="
				+ relation + "]";
	}
	
	
}

package dto;

public class MemberDto {

	private String id;
	private int age;
	private double height;
	
	public MemberDto() {
	}

	public MemberDto(String id, int age, double height) {
		super();
		this.id = id;
		this.age = age;
		this.height = height;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", age=" + age + ", height=" + height + "]";
	}
}

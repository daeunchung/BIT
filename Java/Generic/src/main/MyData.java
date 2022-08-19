package main;

public class MyData {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyData(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyData [name=" + name + "]";
	}
	
	
}

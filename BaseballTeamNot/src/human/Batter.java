package human;

public class Batter extends Human implements BatterInterface {

	double AB;	// 타수
	double H;	// 안타
	double BA;	// 타율
	
	public Batter(int no, String name, int age, int height, double aB, double h, double bA) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.height = height;
		AB = aB;
		H = h;
		BA = bA;
	}
	
	public double getAB() {
		return AB;
	}
	public void setAB(double aB) {
		AB = aB;
	}
	public double getH() {
		return H;
	}
	public void setH(double h) {
		H = h;
	}
	public double getBA() {
		return BA;
	}
	public void setBA(double bA) {
		BA = bA;
	}
	
	@Override
	public String toString() {
		return "Batter [no=" + no + ", name=" + name + ", age=" + age + ", height=" + height + "]"
		+ " [AB=" + AB + ", H=" + H + ", BA=" + BA + "]";
	}
	
	
}

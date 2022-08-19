package human;

public class Pitcher extends Human implements PitcherInterface {

	int win;	// 승
	int lose;	// 패
	double PR;	// 방어률 Protection Rate
	
	public Pitcher(int win, int lose, double pR) {
		this.win = win;
		this.lose = lose;
		PR = pR;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public double getPR() {
		return PR;
	}
	public void setPR(double pR) {
		PR = pR;
	}
	
	@Override
	public String toString() {
		return "Pitcher [no=" + no + ", name=" + name + ", age=" + age + ", height=" + height + "]"
				+ " [win=" + win + ", lose=" + lose + ", PR=" + PR + "]";
	}
	
	
}

package dao;

public interface BaseballDao {
	public void insert();	
	public void delete();	
	public void select();	
	public void update();
	
	public int search(String name);
	
	public void allprint();
	
	public void dataSave();	
	public void dataLoad();
	
	public void hitRanking();
}

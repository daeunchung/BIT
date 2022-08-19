package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import dto.BatterDto;
import dto.HumanDto;
import dto.PitcherDto;
import file.DataProc;

public class BaseballDaoImpl implements BaseballDao {
	Scanner sc = new Scanner(System.in);

	private List<HumanDto> list = new ArrayList<HumanDto>();
	
	private int memberNum;
	
	private DataProc dp;
	
	public BaseballDaoImpl() {
		
		dp = new DataProc("lions");
		dp.createFile();
		
		dataLoad();			
		
		// 등록번호를 맞춰주기 위한 처리 		
		
		if(list.size() > 0) {
			int lastIndexNumber = list.get( list.size() - 1 ).getNumber();
			memberNum = 1001 + ( lastIndexNumber % 1000 );
		}else {
			memberNum = 1001;
		}		
	}
	
	@Override
	public void insert() {
		// 투수/타자 ?
		System.out.print("투수(1)/타자(2) = ");
		int pos = sc.nextInt();
		
		// human
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
		HumanDto human = null;
		
		if(pos == 1) { // 투수
			
			System.out.print("승 = ");
			int win = sc.nextInt();
			
			System.out.print("패 = ");
			int lose = sc.nextInt();
			
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			human = new PitcherDto(memberNum, name, age, height, win, lose, defence);
			
		}
		else {	// 타자
			
			System.out.print("타수 = ");
			int batcount = sc.nextInt();
			
			System.out.print("안타수 = ");
			int hit = sc.nextInt();
			
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			human = new BatterDto(memberNum + 1000, name, age, height, batcount, hit, hitAvg);
		}		
	
		list.add(human);
		
		memberNum++;	// 선수 등록 번호	
	}
	
	@Override
	public void delete() {
		System.out.print("삭제하고 싶은 선수명 = ");
		String name = sc.next();
		
		int index = search(name.trim());	// "이병규 " != "이병규" 
		if(index == -1) {
			System.out.println("선수명단에 없습니다");
			return;
		}		
		
		HumanDto h = list.remove(index);
		System.out.println(h.getName() + "선수의 데이터를 삭제 하였습니다");
		
	}
	
	@Override
	public void select() {
		System.out.print("검색하고 싶은 선수명 = ");
		String name = sc.next();
				
		List<HumanDto> findList = new ArrayList<HumanDto>();
		
		for (int i = 0; i < list.size(); i++) {
			String memName = list.get(i).getName();
			if(name.equals(memName)) {
				HumanDto h = list.get(i);
				findList.add( h );				
			}
		}
		
		if(findList.isEmpty()) {
			System.out.println("검색한 선수는 찾을 수 없습니다");
			return;
		}
		
		System.out.println("검색된 선수 명단입니다 >> ");
		for (int i = 0; i < findList.size(); i++) {
			HumanDto h = findList.get(i);
			System.out.println(h.toString());
		}		
	}
	
	@Override
	public void update() {
		System.out.print("수정하고 싶은 선수명 = ");
		String name = sc.next();
		
		int index = search(name.trim());	
		if(index == -1) {
			System.out.println("선수명단에 없습니다");
			return;
		}
		
		HumanDto human = list.get(index);
		
		if(human instanceof PitcherDto) {
			System.out.print("방어율 = ");
			double defence = sc.nextDouble();
			
			PitcherDto p = (PitcherDto)human;
			p.setDefence(defence);					
		}
		else if(human instanceof BatterDto) {
			System.out.print("타율 = ");
			double hitAvg = sc.nextDouble();
			
			BatterDto b = (BatterDto)human;
			b.setHitAvg(hitAvg);			
		}		
		
		System.out.println("성공적으로 수정되었습니다");
	}
	
	@Override
	public int search(String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			HumanDto h = list.get(i);
			if(name.equals(h.getName())) {
				index = i;
				break;
			}
		}		
		
		return index;
	}
	
	@Override
	public void allprint() {
		
		for (HumanDto h : list) {
			System.out.println(h.toString());
		}
		
	}
	
	@Override
	public void dataSave() {		
		String datas[] = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			HumanDto h = list.get(i);
			datas[i] = h.alldata();
		}		
		
		dp.fileSave(datas);		
	}
	
	@Override
	public void dataLoad() {
		String datas[] = dp.fileLoad();
		
		for (int i = 0; i < datas.length; i++) {			
			String data[] = datas[i].split("-");
			int pos = Integer.parseInt(data[0]);
			
			HumanDto human = null;
			if(pos < 2000) {	// 투수
				human = new PitcherDto(	Integer.parseInt(data[0]),						
											data[1], 
											Integer.parseInt(data[2]), 
											Double.parseDouble(data[3]), 
											Integer.parseInt(data[4]), 
											Integer.parseInt(data[5]), 
											Double.parseDouble(data[6]));
			}
			else {				// 타자
				human = new BatterDto(	Integer.parseInt(data[0]),						
											data[1], 
											Integer.parseInt(data[2]), 
											Double.parseDouble(data[3]), 
											Integer.parseInt(data[4]), 
											Integer.parseInt(data[5]), 
											Double.parseDouble(data[6]));
			}	
			
			list.add(human);			
		}		
	}
	
	@Override
	public void hitRanking() {
		
		TreeMap<String, BatterDto> map = new TreeMap<String, BatterDto>();
		int count = 0;	// key값의 중복을 막기위한 변수
		for (int i = 0; i < list.size(); i++) {
			HumanDto h = list.get(i);
			if(h instanceof BatterDto) {				
				map.put(((BatterDto)h).getHitAvg() + "" + count, (BatterDto)h);
				count++;
			}			
		}
		
		// 타율은 내림차순으로
		Iterator<String> it = map.descendingKeySet().iterator();
		
		while(it.hasNext()) {
			String k = it.next();
			BatterDto v = map.get(k);
			System.out.println("타율:" + v.getHitAvg() + "\t선수명:" + v.getName());
		}		
	}
}








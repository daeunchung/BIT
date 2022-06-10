package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import human.Batter;
import human.Human;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 과제 (싱글턴x)
		 * Baseball Team 선수 관리 프로그램
		 * 
		 * human : 번호, 이름, 나이, 키( height)
		 * Collection 은 List  또는 Map 으로 
		 * 
		 * Pitcher : 승/패 방어율
		 * Batter : 타수, 안타수, 타율
		 * 
		 * 선수관리 DAO
		 * 추가, 삭제, 검색, 수정, 파일저장, 파일읽기
		 * 
		 * File class
		 * Read, Write
		 */
		List<Human> dao = new ArrayList<Human>();
		
		// 추가
		Scanner sc = new Scanner(System.in);
		int pNo = sc.nextInt();
		String pName = sc.next();
		int pAge = sc.nextInt();
		int pHeight = sc.nextInt();
		double AB = sc.nextDouble();
		double H = sc.nextDouble();
		double BA = sc.nextDouble();
		dao.add(new Batter(pNo, pName, pAge, pHeight));
		
		// 삭제
		
		
		// 검색 ( 동명이인 ok )
		
		// 수정 
		
		// 파일 저장
		
		// 파일 읽기

	}

}

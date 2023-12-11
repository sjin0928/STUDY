package com.mystudy.set1_hashset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HashSet_Lotto {

	public static void main(String[] args) {
		// Set을 이용한 로또 만들기 : 1~45 랜덤숫자 6개를 Set에 저장
		// 1. 로또번호 6개를 추첨해서 Set에 저장하고 화면 출력
		//    Math.random() : 0.0 ~ 0.9999999.. 랜덤으로 실수형 데이터 생성(0 <= ran <= 1)
		//    Math.random() 사용 : Math.random() * 45 >> 0~44 +1
		// 2. 출력은 작은숫자부터 큰숫자 형태로 (오름차순)출력
		//    예) 금주의 로또번호 5, 8, 10, 25, 33, 41
		// -----------------------------------------------------------
		// 다만들고 List
		
		//1. 로또번호 6개를 추첨해서 Set에 저장하고 화면 출력
		//    Math.random() : 0.0 ~ 0.9999999.. 랜덤으로 실수형 데이터 생성(0 <= ran <= 1)
		//    Math.random() 사용 : Math.random() * 45 >> 0~44 +1
		HashSet<Integer> set = new HashSet<>(); 
		// <>에는 참조형 데이터만 기입
		
		for (int i = 0; i < 6; i++) {
			Integer a = (int) ((Math.random() * 45) + 1);
			if (set.contains(a)) {
				//System.out.println("재추첨");
				a = (int) ((Math.random() * 45) + 1);
				set.add(a);
			} else {
				set.add(a);
			}
		}
		System.out.println("로또번호 : " + set);
		set.clear();
		
		for (;set.size() < 6; ) { //6개가 될때까지 // ~까지 반복은 while 이 나음
			int ranNum = (int)((Math.random() * 45) + 1);
			set.add(ranNum);
		}
		System.out.println("로또번호 : " + set);
		System.out.println();
		
		set.clear();
		while (set.size() < 6) { //6개가 될때까지 // ~까지 반복은 while 이 나음
			set.add((int)((Math.random() * 45) + 1));
			
		}
	
		System.out.println("로또번호 : " + set);
		System.out.println();
		
		
		
		// 2. 출력은 작은숫자부터 큰숫자 형태로 (오름차순)출력
		//    예) 금주의 로또번호 5, 8, 10, 25, 33, 41
		
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(set);
		list.sort(null);
		System.out.println("금주의 로또번호 : " + list);

		
		ArrayList<Integer> lottoList = new ArrayList<Integer>(set);
		Collections.sort(lottoList);
		System.out.println("정렬 후 : " + lottoList);
		
		System.out.println("===금주의 로또번호 발표 ===");
		System.out.print("금주의 로또번호 : ");
		boolean isfirst = true;
		for (Integer num : lottoList) {
			if (isfirst) {
				System.out.print(num);
				isfirst = false;
			} else {
				System.out.print("," + num);
			}
			
		}
	}

}

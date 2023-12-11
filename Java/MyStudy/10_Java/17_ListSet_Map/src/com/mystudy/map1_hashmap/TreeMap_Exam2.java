package com.mystudy.map1_hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap_Exam2 {

	public static void main(String[] args) {
		// Map<K,V> 인터페이스 : 키(Key)-값(value) 쌍으로 데이터 저장 관리
		// - 특징 : 키(Key)-값(value), 순서는 없음 (list만 순서있음)
		// - 키(Key) : 중복 안됨(중복값 없이 유일한 데이터)
		// - 값(value) : 중복데이터 저장 가능
		// ------------------------------------------
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		// map 은 중괄호에 데이터 출력
		// 입력 - Create, Insert
		// 키값이 정렬되어 저장
		System.out.println("\n=== 입력(추가) ==========");
		System.out.println("map.isEmpty() : " + map.isEmpty());
		map.put("홍길동", 100);
		map.put("김유신", 95);
		map.put("강감찬", 88);
		map.put("박혁거세", 95);
		map.put("황기동", 95);
		System.out.println("map : " + map);
		System.out.println("데이터갯수 : " + map.size());
		System.out.println("map.isEmpty() : " + map.isEmpty());
		System.out.println("-------------");
		
		// 새로운 데이터 입력시 null값 반환
		// null은 참조형데이터에만 저장가능 int에 저장 못함
		Integer returnObj = map.put("계백", 88); 
		System.out.println("map.put(\"계백\", 88) 리턴값 : " + returnObj);
		
		returnObj = map.put("홍길동", 95); // 동일 Key에 데이터 입력시 수정처리됨
		System.out.println("map.put(\"홍길동\", 95) 리턴값 : " + returnObj);
		// 기존값을 리턴해줌
		

		System.out.println("\n=== 조회(검색) ==========");
		// 조회(검색) - Read
		int returnValue = map.get("홍길동"); // Value Integer타입을 반환
		System.out.println("map.get(\"홍길동\") : " + returnValue);
		System.out.println("map : " + map);
		
		System.out.println("\n=== 수정 ==========");
		System.out.println("map.replace(\"홍길동\", 99) 리턴값 : "
				+ map.replace("홍길동", 99));
		
		System.out.println("map.replace(\"을지문덕\", 99) 리턴값 : "
				+ map.replace("을지문덕", 99));
		// 기존값을 찾은 후 변경하기 때문에 리턴값은 찾아낸 기존데이터 출력됨
		System.out.println("map : " + map);
		
		
		System.out.println("\n=== 삭제 ==========");
		System.out.println("map.remove(\"홍길동\", 100) 리턴값 : "
				+ map.remove("홍길동", 100));
		
		System.out.println("map.remove(\"홍길동\") : " + map.remove("홍길동"));
		System.out.println("map : " + map);
		System.out.println("\n=== 전체 데이터 처리 ==========");
		System.out.println("=== keySet() 사용 ==========");
		
		Set<String> keySet = map.keySet();//key값을 set(배열)로 받음
		
		System.out.println("keySet : " + keySet);
		
		for (String key : keySet) {
			System.out.println(key + "-" + map.get(key));
			
		}

		System.out.println("---");
		// 개인적으로 iterator() 사용방식
		Iterator<String> ite2 = keySet.iterator();
		
		System.out.println("================================");
		
		Collection<Integer> values = map.values();
		
		System.out.println("values : " + values);
		
		for (Integer value : values) {
			System.out.println("점수 : " + value);
		}
		
		System.out.println("----------");
		
		int sum = 0;
		for (Integer value : values) {
			sum += value;
		}
		System.out.println("::점수합계 : " + sum);
		
		System.out.println("======= entrySet() 사용 ================");
		//Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println("entrySet : " + entrySet);
		
		System.out.println("----- entrySet.iterator() -----------");		
		Iterator<Entry<String, Integer>> ite = entrySet.iterator();
		while (ite.hasNext()) {
			Entry<String, Integer> entry = ite.next();
			System.out.println("key : " + entry.getKey() + ", "
					 + "value: " + entry.getValue());
			// 엔트리에는 키값확인, 밸류값확인 메소드도 있따
		}
		
		System.out.println("\n---개선된 for 문 사용 -----------");
		// 개인적실습 : entrySet 데이터 개선된(향상된)for문 사용 출력
		for (Entry<String, Integer> e : entrySet) {
			System.out.println(e);
			
		}
		
		// TreeMap 고유기능 사용
		Set<String> mapDe = map.descendingKeySet();
	}

}

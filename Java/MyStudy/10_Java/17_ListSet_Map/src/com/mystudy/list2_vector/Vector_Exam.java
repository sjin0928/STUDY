package com.mystudy.list2_vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Vector_Exam {

	public static void main(String[] args) {
		// Vector 클래스 : List 인터페이스 구현체
		Vector<String> v = new Vector<String>();
		// 
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");
		// vector는 list에 구현된 기능을 쓸 수 있음
		
		System.out.println("v.size() : " + v.size());
		// 변수명.size() : 크기, 길이 데이터가 생길때마다 늘어남
		
		System.out.println("v.capacity() : " + v.capacity());
		// 변수명.capacity() : 저장공간
		// List에는 없고, Vector에만 정의된 고유기능
		
		String temp = v.toString();
		// 변수명.toString() : 문자열로 쓰겠다~
		
		System.out.println(temp);
		
		v.remove(2);
		System.out.println(v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		System.out.println("\n--- v.trimToSize() 실행 후 ---");
		v.trimToSize();
		// 데이터가 저장된 공간 외의 여유공간 삭제
		System.out.println(v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.addElement("4문자열");
		// 데이터 추가 기능 ; 벡터 고유 기능
		// 리스트에도 있는지 확인하고자 하면 벡터꺼 list로 바꿔보면 됨
		System.out.println(v);
		System.out.println("v.size() : " + v.size());
		System.out.println("v.capacity() : " + v.capacity());
		
		v.add("AAA");
		// 맨뒤에 추가
		System.out.println(v);
		
		v.add(2, "BBB");
		// 삽입, 특정위치에 입력(insert)
		System.out.println(v);
		
		Vector<String> v2 = (Vector) v.clone();
		// 저장된건 String 타입이므로 vector 로 형변환 후 사용
		System.out.println("v : " + v);
		System.out.println("v2 : " + v2);
		
		// (개인별) 주소값 복사인지 물리적으로 분리된 복사인지 확인
		System.out.println("\n" + v.equals(v2));
		System.out.println("\n" + (v == v2));
		// 분리된 복사임 // 주소값 불일치
		
		System.out.println("\n=============================");
		
		Enumeration<String> enu = v.elements();
		// v.elements()는 enumeration 타입으로 받음
		// 데이터 갯수의 확인이 불가능 하므로 for문 사용은 권장하지 않음
		// token처럼 한번쓰면 없어짐
		while (enu.hasMoreElements()) {
			System.out.println("enu.nextElement() : " + enu.nextElement());
		}
		
//!!	// (개인별) 기본 for문 사용하여 화면출력(enumeration 객체 사용)
		// vector의 사이즈를 사용하여만듬~	
		
		System.out.println("\n=============================");
		Iterator<String> ite = v.iterator();
		// collection에서 제공 이터러블 인터페이스를 구현한 메소드에는 iterator가 있따.
		
		System.out.println("ite.hasNext() : " + ite.hasNext());
		while (ite.hasNext()) {
			System.out.println("ite.next() : " + ite.next());
		}
		System.out.println("ite.hasNext() : " + ite.hasNext());
		// token처럼 한번쓰면 없어짐 // 없는데 출력하면 exception
		
		// 데이터를 받을 변수 : 집합객체
		System.out.println("\n====개선된 for 문 사용 데이터 조회 ====");
		for(String str : v) {
			System.out.println(str);
		}
		
		System.out.println("끝");
			
		
		
		
		
		
		
		
		
		
	}

}

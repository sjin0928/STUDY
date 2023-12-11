package com.mystudy.stringbuilder;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
		// StringBuilder 클래스
		// 변수선언하면서 데이터저장 = 극히 드문 경우에만 가능한 방식 
		StringBuilder sb = new StringBuilder("Hello Java!!!");
		System.out.println(sb);
		String str = sb.toString();
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		
		System.out.println("\n--- String : 데이터 불변(immutable) ---");
		String str1 = sb.toString();
		System.out.println("str1 : " + str1);
		String str2 = str1.concat(" 반갑습니다");
		System.out.println("str2 : " + str2);
		System.out.println("str1 == str2" + (str1 == str2));
		
		System.out.println("\n--- StringBuilder : 데이터 변경 가능 ---" );
		System.out.println("sb : " + sb.toString());
		sb.append(" 반갑습니다").append("~~~");
		System.out.println("append 후 sb : " + sb.toString());
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		// 길이는 늘어나도 저장공간은 늘어나지 않음
		
		sb.reverse();
		System.out.println("reverse g sb : " + sb.toString());
		sb.reverse();
		System.out.println("reverse g sb : " + sb.toString());
		
		System.out.println("\n==== delete(), insert(), replace() ====");
		//Hello Java!!! 반갑습니다~~~
		StringBuilder sb2 = sb.delete(0, 6);
		System.out.println("sb2.delete(0, 6) : " + sb2.toString());
		System.out.println("sb : " + sb.toString());
		System.out.println("sb == sb2 : " + (sb == sb2));
		
//		System.out.println(sb.insert(0, "Hello"));
//		=> return값을 출력
		sb.insert(0, "Hello");
		System.out.println("sb.insert(0, \"Hello\") : " + sb.toString());
		
		sb.replace(0, 5, "Hi,");
		System.out.println("sb.replace(0, 5, \"Hi,\") : " + sb.toString());
		System.out.println("sb.length() : " + sb.length());
		System.out.println("sb.capacity() : " + sb.capacity());
		System.out.println("----------------");
		
		// 저장공간을 미리 확보하고 사용
		sb2 = new StringBuilder(100);
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		sb2.append("안녕하세요 반갑습니다!!!");
		System.out.println("sb2 : " + sb2.toString());
		
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println("--- trimToSize() 실행하면 ---");
		sb2.trimToSize();
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		

		System.out.println("---- sb2.setLength(5) 실행하면 -----");
		sb2.setLength(5);
		// sb2.setLength(5); // 데이터 크기 설정(작게 설정하면 delete 효과)
		// sb2.delete(5, sb.length());
		// => 앞에 5개 남기고 모두 삭제
		System.out.println("sb2 : " + sb2.toString());
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		System.out.println("---- sb2.setLength(0) 실행하면 -----");
		sb2.setLength(0); //전체데이터삭제
		// sb2.delete(0, sb.length()); //전체데이터삭제
		System.out.println("sb2 : -" + sb2.toString() + "-");
		System.out.println("sb2.length() : " + sb2.length());
		System.out.println("sb2.capacity() : " + sb2.capacity());
		
		
	}

}

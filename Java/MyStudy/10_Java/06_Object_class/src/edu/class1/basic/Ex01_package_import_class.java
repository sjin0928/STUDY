/* package 선언문 : java파일의 맨 첫번째(첫 실행 코드) 위치하며 한번만 작성함.
 * 자바(class) 파일의 위치를 나타냄.
 * 일반적으로 회사의 도메인명을 반대로 적용하여 사용
 * 작성예 ) com.naver,project, com.itwill.mystudy
 */

package edu.class1.basic;
// import 선언문 : 선택항목이지만 일반적으로 사용
// java.lang 패키지 이외의 패키지에 있는 타입을 사용)

import java.util.Scanner; // 선택사항...?

// import java.util.*; // 대표문자 (wild card) * 사용가능

// class 선언문 : 필수 항목
public class Ex01_package_import_class {

	public static void main(String[] args) {
		// java.util.Scanner scan = new java.util.Scanner(System.in);
		Scanner scan = new Scanner (System.in);
		// 스캐너 타입의 인스턴스(객체) (=하나의 데이터)를 만든다
		System.out.println(">> 인사말 : ");
		
		String hello = scan.nextLine(); // 메소드
		System.out.println("인사말출력 : " + hello);
	}

}

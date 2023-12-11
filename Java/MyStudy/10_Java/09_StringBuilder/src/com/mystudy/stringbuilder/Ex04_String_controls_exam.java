package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex04_String_controls_exam {

	public static void main(String[] args) {
		/* 문자열 다루기
		0.문자열 데이터
		  String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		  => split했을때 데이터 저장 // Tokenizer는 사라짐
		  String str2 = "    TOM   을지문덕 김유신 연개소문";
		1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
		     (String split() 또는 StringTokenizer 클래스 사용)
		      예) 홍길동 이순신 이순신 Tom 홍길동 TOM...
		2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		      예) 홍길동,이순신,이순신,Tom,홍길동,TOM...   
		4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		      예) 홍,이,이,T,홍,T,을... 
		5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
		      예) 인덱스번호:을지문덕
		********************************/
		// 0.문자열 데이터
		String str1 = "홍길동 이순신  이순신 Tom 홍길동";
		String str2 = "    TOM   을지문덕 김유신 연개소문";
		//1. 위의 문자열을 StringBuilder 변수 sb를 이용해서 하나의 문자열로 만들고,
		System.out.println("== 1.");
		StringBuilder sb = new StringBuilder();
		sb.append(str1).append(str2);
		System.out.println("sb : " + sb.toString());
		System.out.println();
		  
		// 1. 강의내용 동일
				  
		  
		// 2-1. sb의 문자열을 빈칸 1개(" ")를 구분자로 잘라서(이름만 추출) 화면 출력(데이터확인)
		//     (String split() 또는 StringTokenizer 클래스 사용)
		//      예) 홍길동 이순신 이순신 Tom 홍길동 TOM...
		System.out.println("== 2-1. StringTokenizer");
		StringTokenizer st = new StringTokenizer(sb.toString(), " ");
		while (st.hasMoreTokens()) {
			System.out.print(st.nextToken());
			System.out.print(" ");
		}
		System.out.println("\n");
		
		System.out.println("== 2-1.2-2. String split()");
		//sb.trimToSize();
		String [] namesp = (sb.toString()).split(" ");
		System.out.println(Arrays.toString(namesp));
		System.out.println();
		//System.out.println(sb.append(" "));
		
		
//		2-1. 강의내용 
		//String str = sb.toString();
		//String[] namespp = str.split(" ");
		System.out.println("====== 2번 강의내용 ==========");
		
		String[] namess = sb.toString().split(" ");
		System.out.println(Arrays.toString(namess));
		
		//equals 사용
		for (int i = 0; i < namess.length; i++) {
			System.out.println(i + " : -" + namess[i] + "-");
		}
		System.out.println("-----");

		//화면에 출력 : 홍길동,이순신,이순신,Tom,홍길동,TOM...
		System.out.println("--- equals() 사용 ----");
		for (int i = 0; i < namess.length; i++) {
			if (namess[i] != null && !"".equals(namess[i])) {
				System.out.println(i + " : -" + namess[i] + "-");
			}
		} 
		System.out.println();
		
		System.out.println("--- length() > 0 사용 ----");
		for (int i = 0; i < namess.length; i++) {
			if (namess[i] != null && namess[i].trim().length() > 0) {
				System.out.println(i + " : -" + namess[i] + "-");
			}
		} 
		System.out.println();
		System.out.println("======== null, continue ========");
		for (int i = 0; i < namess.length; i++) {
			if(namess[i] == null) continue;
			if(namess[i].trim().length() <1) continue;
			if(i == 0) {
				System.out.print(namess[i]);
			} else {
				System.out.print("," + namess[i]);
			}
		} 
		System.out.println("\n");
		
		// 2-2. 문자열을 저장할 수 있는 배열변수(names)에 저장
		System.out.println("== 2-2.StringTokenizer ");
		st = new StringTokenizer(sb.toString(), " ");
		String [] names = new String[st.countTokens()];
		for (int i = 0; i < names.length; i++) {
			names[i] = st.nextToken();
		}
		System.out.println(Arrays.toString(names));
		System.out.println();

		
		// 3. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
		// 예) 홍길동,이순신,이순신,Tom,홍길동,TOM...
		System.out.println("== 3. Token");
		StringBuilder aa = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if(i < names.length - 1) {
				aa.append(names[i]);
				aa.append(",");
			}else {
				aa.append(names[i]);
			}
		}
		System.out.print(aa.toString());
		System.out.println("\n");
		
		System.out.println("== 3. split");
		aa = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (!namesp[i].equals(" ")) {
				aa.append(namesp[i]);
			}
		}
		System.out.print(aa.toString());
		System.out.println("\n");
		
		// 강의내용 33
		StringBuilder sb3 = new StringBuilder();
		for (int i = 0; i < namess.length; i++) {
			if(namess[i] == null) continue;
			if (namess[i].trim().length() <1) continue;
			if(i == 0) {
				sb3.append(namess[i]);
			} else {
				sb3.append(",").append(namess[i]);
			}
		} 
		System.out.println("sb3 : " + sb3.toString());
		
		// 4. 데이터의 첫글자만 추출해서 콤마(,)로 구분하여 한라인에 출력(StringBuilder 사용)
	    //  예) 홍,이,이,T,홍,T,을...
		System.out.println("== 4. ");
		aa = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if(i < names.length - 1) {
				aa.append(names[i].charAt(0)).append(",");
			}else {
				aa.append(names[i].charAt(0));
			}
		}
		System.out.println(aa);
		System.out.println();
		
		System.out.println("== 4. ");
		// 여기부터 안함
		
		
		// 강의내용 44
		System.out.println("강의내용44444444");
		StringBuilder sb4 = new StringBuilder();
		for (int i = 0; i < namess.length; i++) {
			if(namess[i] == null) continue;
			if(namess[i].trim().length() <1) continue;
			sb4.append(namess[i].charAt(0)).append(",");
		}
//		sb4.delete(sb4.length()-1, sb4.length());
		sb4.deleteCharAt(sb4.length()-1);
		System.out.println("sb4 : " + sb4.toString());
		
		
		// 5. 배열의 문자열중 이름의 글자수가 4 이상인 값을 "인덱스번호:이름" 출력
	    //  예) 인덱스번호:을지문덕
		
		System.out.println("== 5. ");
		aa = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			if (4 <= names[i].length()) {
				System.out.println(i + " : " + names[i]);
			}
		}
		System.out.println();
		
		// 강의내요~
		System.out.println("===== StringTokenizer 사용 ======");
		System.out.println("StringBuilder sb : " + sb);
		StringTokenizer tokens = new StringTokenizer(sb.toString(), " ");
		// StringTokenizer 안에는 StringBuilder 기재 못함 toString으로 변경
		System.out.println("토큰갯수 : " + tokens.countTokens());
		
		while (tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
			
		}
		System.out.println("==============");
		System.out.println("토큰개수 : " + tokens.countTokens());
		
		tokens = new StringTokenizer(sb.toString(), " ");
		System.out.println("토큰개수 : " + tokens.countTokens());
		
		String[] names2 = new String[tokens.countTokens()];
		System.out.println("names2.length : " + names2.length);
		
		System.out.println(Arrays.toString(names2));
		
		int idx = 0;
		while (tokens.hasMoreTokens()) {
			// 배열에 저장
			names2[idx] = tokens.nextToken();
			idx++;
		}
		//for문으로 만들지 않고 변수 별도로 지정후 증감식 삽입
		System.out.println(Arrays.toString(names2));

	}

}

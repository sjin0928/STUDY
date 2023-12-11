package com.mystudy.array;

public class Ex03_array_star {

	public static void main(String[] args) {
		/* 별찍기
		 * [1]
		 ** [1,2]
		 *** [1,2,3]
		 **** [1,2,3,4]
		 ***** [1,2,3,4,5]
		 ---------------*/
		//''char //""String
		// char 타입의 데이터를 5개 저장할 수 있는 배열을 만들고 별(*) 입력
		//char[] ch = new char[5];
//		char[] ch = {'*', '*', '*', '*', '*'};
		char[] ch = {'!', '@', '#', '$', '%'};
		
		int cnt = 1;
		for (int i = 1; i <= ch.length; i++) {
//			ch[i] = '*';
			for (int e = 0; e < cnt; e++) {
				System.out.print(ch[e]);
			}
			System.out.println();
			cnt++;
		}
		
		System.out.println();
		System.out.print(ch[0]);
		System.out.println();
		System.out.print(ch[0]);
		System.out.print(ch[1]);
		System.out.println();
		System.out.print(ch[0]);
		System.out.print(ch[1]);
		System.out.print(ch[2]);
		System.out.println();
		System.out.println("================");
		
		for (int e = 1; e <= ch.length; e++) {
			for (int i = 0; i < e; i++) {
//				ch[i] = '*';
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		
		
	}

}


public class Ex10_while {
	public static void main(String[] args) {
		// 반복문 : while, do ~ while
		/* while 반복문 사용 형태
		 while (조건식(true or false) { 실행문 }
		 반복인자의 선언 및 초기값 설정;
		 while (실행조건식) {
		 	반복인자값 증감설정 (선택적);
		 	실행문(들);
		 	반복인자값 증감설정 (선택적);
		 }
		 
		 ---------------------------------*/
		// 1~10까지 화면 출력
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------------");
		
		// while문 작성
		int i = 1;
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		System.out.println("--------------------");
		
		i = 0;
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		System.out.println("--------------------");
		
		i = 0;
		while (i < 10) {
			i++;
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("--------------------");
				
		System.out.println("===== break, continue ====");
		// break, continue를 while과 사용시 무한루프가 생길 수 있음.
		// 증감식 전에 continue를 넣으면 증감이 안걸림
		// break : 현재 실행중인 반복문을 종료하고 빠져나감
		// while 무한반복
		
		//for (;;) {
		//	for 무한 반복 식	
		//}
		
		int num = 1;
		while (true) { // 조건식에 true를 넣으면 무한반복
			System.out.println(num);
			if(num >= 10) break; // 순서 : 9 -> 증가 ->출력 (10) ->중단
			num ++;
		}
		
		num = 1;
		System.out.println("---- continue ----");
		while (num <= 10) {
			num ++;
			if (num == 5) continue; // 증감식이 continue 문 앞에 위치해야함
			System.out.println(num);
		}
		
		System.out.println("---- for continue ----");
		for (int m = 1; m <= 10; m++) {
			if (m % 2 == 0) continue;
			System.out.println(m);
		}
		
		System.out.println("===== do ~ while =====");
		// 반복인자의 선언 및 초기값 설정;
		// do { 실행문(들); 반복인자값 증감설정 (선택적); 
		//   } while (실행조건식) ;
		// 
		
		// 1~10 출fur
		num = 1000;
		do { // while의 조건에 만족하지 않아도 무조건 1번은 실행
			System.out.println("do~while : " + num); 
			num ++;
		} while (num <= 10);
		
		System.out.println("======================");
		System.out.println("--- 내부 반복문에서 break 처리시 ---");
		for (int out = 1; out <= 3; out++) {
			System.out.println("::out : " + out);
			
			for(int in = 1; in <= 5; in ++) {
				System.out.println("out : " + out + ", in : " + in);
				if (out == 2) break; // 내부 반복문만 종료
			}
			
			System.out.println("--------------------");			
		}
		
		System.out.println("=====================");
		System.out.println("====중첩 반복문 모두 중단하기");
		// 중첩 반복문을 모두 종료해야 하는 경우 (위치지정 break문 사용)
		// 라벨지정
		outFor: 
		for (int out = 1; out <= 3; out++) {
			System.out.println("::out : " + out);
			
			for(int in = 1; in <= 5; in ++) {
				System.out.println("out : " + out + ", in : " + in);
				if (out == 2) break outFor; // out 반복문 종료
			}
			
			System.out.println("--------------------");			
		}
		System.out.println(">> 프로그램 종료---");		
		
		System.out.println("------------");
		
	}

}

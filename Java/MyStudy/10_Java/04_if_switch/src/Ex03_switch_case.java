
public class Ex03_switch_case {

	public static void main(String[] args) {
		// switch case 문 : 동등비교구문
		/*
		 * 
		switch (조건값 key) {
		case 비교값 1:
			실행문 ;
			break;

		default: (해당되는게 없을때 /else와 비슷)
			실행할 문장
			
			break;
		} ----------------------------*/
		
		int month = 2;
		
		switch (month) {
		case 1 : 
			System.out.println("31까지 있습니다.");
			break;
		case 2 : 
			System.out.println("28일 또는 29일까지 있습니다.");
			break;
		case 3 : 
			System.out.println("31일까지 있습니다.");
			break;
		case 4 : 
			System.out.println("30일까지 있습니다.");
			break;
		default : 
			System.out.println("일치하는 값이 없습니다.");
			break; // break가 없으면 전부 출력
		}
		System.out.println("-------------------");
	
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7: case 8: case 10: case 12:
			System.out.println("31일까지 있습니다.");
			break;
		case 2: 
			System.out.println("28일 또는 29일까지 있습니다.");
			break;
		case 4:
			System.out.println("30일까지 있습니다.");
			break;
		}
		System.out.println("========================");
		/* 추첨결과에 따라 상품지급
		 1등 : 냉장고, 2등 : 김치냉장고, 3등 : 세탁기, 4등 : 청소기
		 등수안에 없으면(꽝인경우) : 휴지
		 추첨 결과 당첨상품 출력하시오
		 출력예시) 당첨상품 : 냉장고
		 --------------------*/
		String result = "1등";
		String resultMsg;
		switch (result) {
		case "1등" :
			resultMsg = "냉장고";
			break;
		case "2등" :
			resultMsg = "김치냉장고";
			break;
		case "3등" : 
			resultMsg = "세탁기";
			break;
		case "4등" : 
			resultMsg = "청소기";
			break;
		default :
			resultMsg = "휴지";
			break;
				}
		System.out.println("추첨 결과 : " + result);
		System.out.println("당첨 상품 : " + resultMsg);
		
		
		
	}
	

}

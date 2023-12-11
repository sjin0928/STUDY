package com.mystudy.string;

public class Ex03_StringExam {

	public static void main(String[] args) {
		// String str = "901012-1234567"; //주민번호
		// 1. 전체자리수 14개 여부확인, '-'위치: 7번째 여부 확인
		// 2. 생년월일 출력(1-2:년도, 3-4:월, 5-6:일)
		//   예) 90년 10월 12일 또는 1990년 10월 12일
		// 3. 성별 확인하고 출력(1,3: 남성, 2,4: 여성)
		// 4. 데이터 값 검증(월: 1~12, 일: 1~31)
		//참고) int num = Integer.parseInt("10"); //"10" -> 10
		//---------------------------------------------------
		//String이 char의 배열이므로 인덱스값 사용 가능
		String str = "901012-1234567";

		// 1. 전체자리수 14개 여부확인,
		// 매개변수 = 파라미터값 
		System.out.println("== 1.");
		System.out.println("전체자리수 " + str.length() + "개 입니다.");
		if (str.length() == 14) {
			System.out.println("[정상] 전체자리수 14개 입니다.");
		}else {
			System.out.println("[오류] 자리수 입력 오류 : 재입력");
		}

		// '-'위치: 7번째 여부 확인 // charAt, indexOf, substring
		if (str.indexOf("-") == 6) {
			System.out.println("[정상] -는 7번째 자리에 있습니다.");
		} else {
			System.out.println("[오류] -가 " + str.indexOf("-") + "번째 자리에 있습니다.");
			
		}
		
		System.out.println();
		System.out.println("== substring 사용 : 9010122-345671152 입력");
		str = "90101ㅇ2-345671152";
		if (str.substring(6,7).equals("-")) {
			System.out.println("정상");
		} else {
			System.out.println("[오류] 7번째 문자" + str.substring(6, 7));
		}
		
		System.out.println();
		// 실제로는 오류시에만 문구발생하게 하는 경우가 많다~
		System.out.println("== 오류일때만 실행");

		if (!"-".equals(str.substring(6, 7))) {
			System.out.println("[오류] 7번째 문자 : " + str.substring(6, 7));
		}
		
		System.out.println("== indexOf");
		if (str.indexOf("-") != 6) {
			System.out.println("[오류] -가 " + str.indexOf("-") + "번째 자리에 있습니다.");
		}
		System.out.println("== charAt");
		if (str.charAt(6) != '-') {
			System.out.println("[오류]");
		}
		
		System.out.println();
		str = "901012-1234567";
		
		// 2. 생년월일 출력(1-2:년도, 3-4:월, 5-6:일)
		System.out.println("== 2.");
		System.out.println(str.substring(0,2) + "년 " 
							+ str.substring(2, 4) + "월 "
							+ str.substring(4, 6) + "일");
		System.out.println("19" + str.substring(0,2) + "년 " 
				+ str.substring(2, 4) + "월 "
				+ str.substring(4, 6) + "일");

		// 강의내용
		System.out.println("== 강의내용 ==========");
		str = "202012-3234567";
		String yymmdd = str.substring(0, 6);
		System.out.println(yymmdd);
		String yy = str.substring(0,2);
		String mm = str.substring(2,4);
		String dd = str.substring(4,6);
		System.out.println(yy + "년 " + mm + "월 " + dd + "일");
		System.out.println("19" + yy + "년 " + mm + "월 " + dd + "일");
		System.out.println();
		
		System.out.println("-- charAt---------");
		char charFlag = str.charAt(7);
		String yyyy = "";
		if (charFlag == '1' || charFlag == '2') {
			yyyy = "19" + yy;
			System.out.println(yyyy + "년 " + mm + "월 " + dd + "일");
		} else if (charFlag == '3' || charFlag == '4') {
			yyyy = "20" + yy;
			System.out.println(yyyy + "년 " + mm + "월 " + dd + "일");
		}
		System.out.println();
		
		System.out.println("-- substring---------");
		String flag = str.substring(7, 8);
		// substring은 숫자 3이지만 새로운 객체가 생성되므로 주소값은 다름
		// ==은 주소값 비교이므로 가능한사용 x
		System.out.println("flag : " + flag);
		if ("1".equals(flag) || "2".equals(flag)) {
			yyyy = "19" + yy;
		} else if ("1".equals(flag) || "2".equals(flag)) {
			yyyy = "20" + yy;
		}
		System.out.println(yyyy + "년 " + mm + "월 " + dd + "일");
		System.out.println();
		
		
		str = "901012-1234567";
		// 3. 성별 확인하고 출력(1,3: 남성, 2,4: 여성)
		System.out.println("== 3.");
		char i = str.charAt(7);
		if(i == '1' || i == '3') {
			System.out.println("셩별은 남성입니다.");
		} else if (i == '2' || i == '4') {
			System.out.println("셩별은 여성입니다.");
		} else {
			System.out.println("재입력");
		}
		System.out.println();

		// 강의내용
		System.out.println("== 강의내용 ==========");
		char gender = str.charAt(7);
		if (gender == '1' || gender =='3') {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "(남성)");
		} else if (gender == '2' || gender =='4') {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "(여성)");
		} else {
			System.out.println("주민번호 뒷자리(첫글자) : " + gender + "외국인???");
		}
		
		switch (gender) {
			case '1' : 
			case '3' : 
				System.out.println("주민번호 뒷자리(첫글자) : " + gender + "(남성)");
				break;
			case '2' : 
			case '4' :
				System.out.println("주민번호 뒷자리(첫글자) : " + gender + "(여성)");
				break;
			default : 
				System.out.println("주민번호 뒷자리(첫글자) : " + gender + "외국인???");
		}
		
		System.out.println();

		// 4. 데이터 값 검증(월: 1~12, 일: 1~31)
		// 참고) int num = Integer.parseInt("10"); //"10" -> 10
		System.out.println("== 4.");
		String month = str.substring(2, 4);
		int monthInteger = Integer.parseInt(month);
		if (1 <= monthInteger && 12 >= monthInteger ) {
			System.out.println(monthInteger + "월 (1월 ~ 12월에 있음)");
		}
		String day = str.substring(4, 6);
		int dayInteger = Integer.parseInt(day);
		if (1 <= dayInteger && 31 >= dayInteger ) {
			System.out.println(dayInteger + "일 (1일 ~ 31일에 있음)");
		}
		System.out.println();

		// 강의내용
		System.out.println("== 강의내용 ==========");
		month = str.substring(2, 4);
		monthInteger = Integer.parseInt(month);
		if (monthInteger >= 1 && monthInteger <= 12) {
			System.out.println("[정상] 월 데이터 정상 (1~12)");
		} else {
			System.out.println("[비정상] 데이터 : " + monthInteger);
		}
		if (monthInteger < 1 || monthInteger > 12) {
			System.out.println("[비정상] 데이터 : " + monthInteger);
		} else {
			System.out.println("[정상] 월 데이터 정상 (1~12)");
		}
		
		// 일자 데이터 확인 (1~31 범위내에 있는지)
		int date = Integer.parseInt(str.substring(4, 6));
		if (date >= 1 && date <=31) {
			System.out.println("[정상] 일자 데이터 정상(1 ~ 31)");
		}else {
			System.out.println("[비정상] 일자 데이터 아님(1 ~ 31)" + date);
		}
		

	}

}

package com.mystudy.scanner3_cafe;

public class ScannerCafeTest2 {
	public static void main(String[] args) {
		System.out.println("==== main() 시작 ======");
		System.out.println("AMERICANO : " + ScannerCafe.AMERICANO);
		ScannerCafe cafe = new ScannerCafe();
		
		cafe.openCafe();
		System.out.println("==== main() 끝 ======");
	}
		   

}

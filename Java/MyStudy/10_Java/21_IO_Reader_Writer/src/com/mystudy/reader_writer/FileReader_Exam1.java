package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam1 {

	public static void main(String[] args) {
		// 문자(Character) 단위 입력 처리
		// FileReader : 파일로 부터 문자단위 데이터 읽기
		// 문자단위 : 1, A, $ - 1byte 문자 (또는 2byte)
		// 			가, 대, 한 - 3byte(또는 2byte) 문자(한글, 아랍어, 태국어, 일본어, 중국어,...)
		//-------------------
		
		File file = new File("file/test_char.txt");
		System.out.println("파일크기 : " + file.length());
		
		FileReader fr = null;
		
		try {
			// 1. 객체(인스턴스)생성
			fr = new FileReader(file);
			int readChar = fr.read();
			System.out.println("첫번째 문자 : " + readChar
					+ ", char : " + (char)readChar);
			readChar = fr.read();
			System.out.println("첫번째 문자 : " + readChar	+ ", char : " + (char)readChar);
			readChar = fr.read();
			System.out.println("첫번째 문자 : " + readChar	+ ", char : " + (char)readChar);
			readChar = fr.read();
			System.out.println("첫번째 문자 : " + readChar	+ ", char : " + (char)readChar);
			readChar = fr.read();
			System.out.println("첫번째 문자 : " + readChar	+ ", char : " + (char)readChar);
			// 2. 객체 사용 작업처리(1문자읽고, 화면에 출력)
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//3. 사용객체 닫기(close)
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

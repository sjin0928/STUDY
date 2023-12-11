package com.mystudy.reader_writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_Exam2 {
	public static void main(String[] args) {
		// (실습) FileReader_Exam1 내용을 반복문으로 변경 처리
		
		File file = new File("file/test_char.txt");
		FileReader fr = null;
		
		try {
			//1. 객체(인스턴스)생성
			fr = new FileReader(file);

			//2. 객체사용-작업처리
			while (true) {
				int readValue = fr.read();
				if (readValue == -1) break;
				System.out.println("byte : " + readValue
				+ " char : " + (char)readValue);
				//System.out.print((char)readValue);
			}
			
		} catch (FileNotFoundException e) {
		//	e.printStackTrace();
			System.out.println(">> [예외] 파일없음");
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(">> [예외] 파일을 읽지 못함");
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

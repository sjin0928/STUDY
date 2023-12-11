package com.mystudy.io4_filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		// 파일복사 : 원본 파일에서 읽고, 대상 파일에 쓰기
		// ---------------------------------
		
		//File inputFile = new File("temp.txt"); // 원본파일
		//File outputFile = new File("file/temp_copy.txt"); //복사본
		
		//File inputFile = new File("file/img101.jpg"); // 원본파일
		//File outputFile = new File("file/img101_copy.jpg"); //복사본
		
		File inputFile = new File("src/com/mystudy/io4_filecopy/FileCopy.java"); // 원본파일 .은 슬래시로 변경
		File outputFile = new File("file/FileCopy.java_vackup.java"); //복사본
		
		
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 파일을 읽고, 쓰기위한 객체 생성(FileInputStream, FileOutputStream)
			fis = new FileInputStream(inputFile);
			fos = new FileOutputStream(outputFile);

			System.out.println(">> 파일복사 시작-------");
			
			//2. 1byte 읽고, 1byte 쓰기 - read(), write(데이터) 반복 처리
			while (true) {
				int readValue = fis.read();
				if (readValue == -1) break;
				fos.write(readValue);
				
			}
			
			System.out.println(">> 파일복사 끝-----------------");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//3. 사용객체닫기
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					if (fos != null) {
						fos.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}

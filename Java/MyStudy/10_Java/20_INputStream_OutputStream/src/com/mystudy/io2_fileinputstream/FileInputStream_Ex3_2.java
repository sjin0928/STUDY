package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStream_Ex3_2 {

	public static void main(String[] args) {
		// (실습) Ex3_1 파일을 반복문으로 사용
		
		//0. 사용할 파일 객체 생성
		//File file = new File("file/test01.txt");
		
		
		FileInputStream fis = null;

		try {
			//fis = new FileInputStream(file);
			
			//0. 사용할 파일 객체 생성
			File file = new File("file/test01.txt");
			
			//1. 파일을 읽어서 작업할 객체 생성(FileInputStream)
			fis = new FileInputStream(file);
			
			//2. 객체 사용 파일데이터 읽어서 화면 출력 (byte[] 사용, 반복문으로 처리)
			byte bytes[] = new byte[10];
			
			//System.out.println("갯수 : " + readCnt + ", " + Arrays.toString(bytes));
			while(true) {
				int readCnt = fis.read(bytes);
				for (int i = 0; i < readCnt; i++) {
					System.out.print(bytes[i] + " - ");
					System.out.println((char)bytes[i]);
				}
				if(readCnt == -1) break;
			}

			// 반복문의 끝까지 출력되므로 못씀
//			while(true) {
//				int readCnt = fis.read(bytes);
//				for(byte read : bytes) {
//					System.out.print(read + " - ");
//					System.out.println((char)read);
//				}
//				if(readCnt == -1) break;
//				}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		//3. 객체 닫기(close)

	}

}

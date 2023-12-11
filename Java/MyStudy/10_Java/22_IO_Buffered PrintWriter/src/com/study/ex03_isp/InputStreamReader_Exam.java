package com.study.ex03_isp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_Exam {

	public static void main(String[] args) {
		// InputStream >>> Reader
		// byte 처리 계열 >>> 문자(Character)처리 계열 전환
		// InputStreamReader : InputStream >>>>> Reader 전환
		// Output StreamWriter : OutputStream >>>>> Writer 전환
		//--------------------------
		
		File file = new File("file/test_isr.txt");
		
		FileInputStream fis = null;
		
		InputStreamReader isr = null;
		
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(file);
			
//			int readValue = fis.read(); //1byte 읽기
//			System.out.println((char)readValue);
//			readValue = fis.read();
//			System.out.println((char)readValue);
			//1byte 읽기 // 영어와 숫자 외에는 2~3byte
			
			//byte 단위 처리방식에서 문자단위 처리방식으로 전환(변경)
			isr = new InputStreamReader(fis);
			int readValue = isr.read(); 
			System.out.println((char)readValue);
			readValue = isr.read(); 
			System.out.println((char)readValue);
			
			// ----------
			// 버퍼기능 사용하여 문자기준으로 라인단위 읽기처리
			br = new BufferedReader(isr); // reader 계열만 읽을수 있음
			//String str = br.readLine();
			//System.out.println("br.readline() : " + str);
			
			while(true) {
				String str = br.readLine(); // EOF 만나면 null 리턴
				if(str == null) break;
				System.out.println(str);
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		

	}

}

package com.mystudy.reader_writer_filecopy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyCharacterExam {

	public static void main(String[] args) {
		// FileReader, FileWriter 사용해서 파일 복사
		// 원본파일 : file/test_char.txt
		// 대상파일 : file/test_char_copy.txt
		// 처리 : 원본파일에서 읽고, 대상파일에서 쓰기/저장(문자단위 처리)
		
		// 0. 사용할 파일(File)객체 생성
		
		// File fileIn = new File("file/test_char.txt");
		// File fileOut = new File("file/test_char_copy.txt");
		// 파일이 존재하는지 확인하는 용도로 사용하기 좋음
		
		//1-1. FileReader, FileWriter 객체를 저장할 변수 선언
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			//1-2. FileReader, FileWriter 객체를 생성
			fr = new FileReader("file/test_char.txt");
			fw = new FileWriter("file/test_char_copy.txt");
			
			//2. 반복작업(원본파일에서 읽고, 대상파일에 쓰기)
			
			while (true) {
				int readValue = fr.read();
				if(readValue == -1)break;
				fw.write(readValue);

			}
//				readValue = fr.read();
//				fw.write(readValue);
//			fw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//3. 사용객체 닫기(close)
		
		
		
		

	}

}

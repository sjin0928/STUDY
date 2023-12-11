package com.mystudy.io2_fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_Ex1 {

	public static void main(String[] args) {
		
		System.out.println("====main() 시작 =============");
		File file = new File("temp.txt");
		
		FileInputStream fis = null;
		try {
			// 파일로부터 읽기 위한 작업 진행
			// 1. 사용할 객체 생성
			
			fis = new FileInputStream(file);
			// 파일(temp.txt) 객체를 전달받아 객체생성
			// 파일이 실재하면 read 메소드를 쓰면 데이터를 읽음 
			
			// 2. 객체 사용 작업 정리
			int readValue = fis.read();
			System.out.println("read() int 값 : " + readValue);
			System.out.println("read() int 값 : " + (char)readValue);
			
			System.out.println("--- 전체 데이터 읽어서 화면 출력 ---");
			while (true) {
				readValue = fis.read();
				// EOF(End Of File)를 만나면 (읽을 데이터가 없으면) -1값 리턴
				if(readValue == -1) break; // 파일의 끝 (EOF)면 종료
				System.out.println("read() int 값 : " + readValue);
				System.out.println("read() int 값 : " + (char)readValue);
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			// 상위인 IOException으로 한번에 예외처리
			
			//	} catch (FileNotFoundException e) {
			//	//e.printStackTrace(); // 발생 예외 출력
			//	System.out.println("[예외발생]" + e.getMessage());
			//} catch (IOException e) {
			//	e.printStackTrace();
		} finally {
			//3. 객체 사용 후 닫기(close)
			if(fis != null) {
				try{
					fis.close(); // 리스트업해야함
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("====main() 끝 =============");
	}

}

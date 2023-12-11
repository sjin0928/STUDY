package com.study.ex02_bufferd_filecopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriter_Exam {

	public static void main(String[] args) {
		File file = new File("file/test_osw.txt");
		FileOutputStream fos = null;
		
		OutputStreamWriter osw = null; 
		// OutputStreamWriter 객체 생성해서 텍스트를 출력
		// Hello Java~~ 안녕!!!
		
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos); //input은 자주쓰지만output은 잘안씀
			
			//fos.write(65); // byte 값을 넣으면 나옴
			
			osw.write("Hello Java~~ 안녕!!!123456\n");

			fos.write(65); // 먼저 출력됨
			fos.write('s');
			fos.write('1');
			fos.write('대'); // 출력안됨
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			try {
//				fos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}



		}
		
		
		

	}

}

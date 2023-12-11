package com.study.ex04_printwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_OutputStream_Exam {

	public static void main(String[] args) {
		// PrintWriter <--- FileOutputStram <-- File 
		// PrintWriter <--- FileWriter <-- File
		// +> 결과 동일
		// FileOutputStream fos = null;
		PrintWriter pw = null;
		
		try {
			//fos = new FileOutputStream(new File("file/pw_out.txt"));
			
			// 방식1 : 생성된 객체를 변수에 모두 저장
			File file = new File("file/pw_out.txt");
			FileWriter fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			
			// 방식2 : 한번에 처리(최종 사용 객체만 생성 사용)
			// pw = new PrintWriter(new FileWriter(new File("file/pw_out.txt")));
			pw = new PrintWriter(new FileWriter("file/pw_out.txt"));
			
			pw.write("안녕하세요");
			pw.write("점심시간 후 오후~~~\n");
			
			pw.print("지금 자바 공부중~~~");
			pw.print("아직은 안졸리다");
			pw.println();
			
			pw.println("조금 지나면 졸릴 수도 있다");
			pw.println("끝나려면 4시간 남았다.");
			
			pw.printf("%10s %10s %10s %n", "이제", "20분", "남았다");
			// %n 줄바꿈  // %10 10글자 공백
			pw.printf("%-50s%n", "18분정도 남았습니다.");
			pw.printf("%50s%n", "18분정도 남았습니다.");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		
				
	}

}

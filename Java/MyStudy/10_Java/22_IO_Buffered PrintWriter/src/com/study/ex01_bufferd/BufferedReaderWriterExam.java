package com.study.ex01_bufferd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExam {

	public static void main(String[] args) {
		// 버퍼(buffer) 기능이 구현되어 있는 클래스
		// 버퍼 : 데이터를 저장하는 공간(메모리 상에)
		// 저장하여 데이터를 보냄 속도를 빠르게 하기 위해
		// BuffersReader, BufferdWriter
		// File >> FileReader >> BufferedReader
		// ------------------------------
		
		FileReader fr = null;
		FileWriter fw = null;
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		
		
		try {
			// 파일로부터 읽기 위한 객체(인스턴스) 생성
			File inFile = new File ("file/test_buf_rw_in.txt");
			fr = new FileReader(inFile);
			bufferedReader = new BufferedReader(fr);// 버퍼기능 + 파일 읽기 
			
			// 파일에 쓰기위한 객체 생성
			File outFile = new File ("file/test_buf_rw_out.txt");
			fw = new FileWriter(outFile);
			bufferedWriter = new BufferedWriter(fw); // 버퍼기능 + 파일쓰기
			
			// 파일에 먼저 쓰기
			bufferedWriter.write("안녕하세요. 자바 공부중입니다.\n");
			bufferedWriter.write("Hello Java!!!!!");
			bufferedWriter.newLine(); // 줄바꿈해줌
			bufferedWriter.write("재미있나요???");
			bufferedWriter.newLine();
			
			bufferedWriter.flush();
			bufferedWriter.write("-----------------------");
			
			// 파일로부터 읽고, 파일에 쓰기(버퍼기능 이용)
			// 파일에서 읽기(한번읽기)
			
			String str = bufferedReader.readLine();
			System.out.println("readLine() : " + str);
			
			// 파일에 쓰기
			bufferedWriter.write(str); // 문자열 출력
			bufferedWriter.newLine(); // 줄바꿈
			
			// 남은 데이터 모두 읽고 쓰기
			str = bufferedReader.readLine(); //EOF : null 리턴
			while (str != null) {
				bufferedWriter.write(str); // 문자열 출력
				str = bufferedReader.readLine(); //EOF : null 리턴
				if(str != null) {
					bufferedWriter.newLine(); // 줄바꿈
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close처리는 마지막 객체만 해주면 됨
			try {
				if(bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
				
		System.out.println("main 끝");

	}

}

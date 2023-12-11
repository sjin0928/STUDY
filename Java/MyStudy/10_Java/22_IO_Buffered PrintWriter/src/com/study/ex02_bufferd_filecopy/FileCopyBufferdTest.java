package com.study.ex02_bufferd_filecopy;

import java.awt.image.BufferedImageOp;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyBufferdTest {

	public static void main(String[] args) {
		// BufferedInputStream, BufferedOutputSteam 적용
		// 파일 복사(binary) : image102.jpg >> img102_copy.jpg
		// File >>> FileInputStream >> BufferedInputStream
		// --------------------
		
		File inputFile = new File("file/img101.jpg");
		File outputFile = new File ("file/img101_copy.jpg");
		
		// 파일로부터 읽고, 쓰기 위한 객체(인스턴스)를 저자하기 위한 변수
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		// 버퍼(buffer) 사용을 위한 변수 선언
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null; 
		
		try {
			// 파일 읽고, 쓰기 위한 객체 생성
			fis = new FileInputStream(inputFile); // 읽기
			fos = new FileOutputStream(outputFile); // 쓰기
			
			System.out.println(">> 파일복사 시작 (버퍼없이) ---------------");
			long startTime = System.currentTimeMillis();
			// 파일 복사 (버퍼없이) : 바이트(byte) 단위 읽고, 쓰기
			
			int readValue = fis.read();
			while(readValue != -1) {
				fos.write(readValue);
				readValue = fis.read();
			}
			long endTime = System.currentTimeMillis();
			System.out.println(">> 파일복사 끝 (버퍼없이) ---------------");
			System.out.println("startTime : " + startTime);
			System.out.println("endTime : " + endTime);
			System.out.println("byte 복사시간 : " + (endTime - startTime) + "(ms)");
			
			fis.close();
			fos.close();
			//stream은 재사용 불가
			
			System.out.println("======================");
			// 버퍼기능이 있는 클래스로 구현
			bis = new BufferedInputStream(new FileInputStream(inputFile));
			bos = new BufferedOutputStream(new FileOutputStream("file/img101_buf_copy.jpg"));

			System.out.println(">> 파일복사 시작 (버퍼) ---------------");
			startTime = System.currentTimeMillis();
			
			readValue = bis.read();
			while (readValue != -1) {
				bos.write(readValue);
				readValue = bis.read();
			}
			
		
			endTime = System.currentTimeMillis();
			System.out.println(">> 파일복사 끝 (버퍼) ---------------");
			//System.out.println("startTime : " + startTime);
			//System.out.println("endTime : " + endTime);
			System.out.println("byte 복사시간 : " + (endTime - startTime) + "(ms)");
			
			bos.close();
			bis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

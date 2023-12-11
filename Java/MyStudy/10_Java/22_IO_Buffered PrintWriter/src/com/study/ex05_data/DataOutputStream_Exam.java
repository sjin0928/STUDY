package com.study.ex05_data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStream_Exam {

	public static void main(String[] args) {
		// DataInputStream, DataOutputStream
		// 기본데이터 타입의 데이터 읽고, 쓰기
		// -------------
		// 파일에 기본데이터 타입 값을 파일에 쓰고, 읽어서 화면 출력
		
		File file = new File("file/data_io_stream.txt");
		
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			// 기본 데이터 타입 값을 파일에 쓰기(출력)
			dos.writeBoolean(true);
			dos.writeByte(127);
			dos.writeInt(12000);
			dos.writeDouble(Math.PI);
			dos.writeUTF("Hello~");
			
			System.out.println(">>> 파일에 출력완료");
			
			// 파일에 저장된 데이터를 읽어서 화면 출력
			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
				

	}

}

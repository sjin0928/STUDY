package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientEcho {

	public static void main(String[] args) {
		// 클라이언트(사용자=user) : 쓰고, 읽기 (output -> input)
		// 서버 접속 후 메시지를 1번 보내고(쓰고) - PrintWriter
		// 서버에서 보내온 메시지를 받기(읽기) - BufferdReader
		// PrintWriter <-- OutputStream
		// BufferdReader <-- InputStreamReader <-- InputStream
		// ------------------
		// (추가) 보내는 메시지를 Scanner를 이용 화면에서 직접 입력하여 처리
		// ---------------
		Scanner scan = new Scanner(System.in);
		
		Socket socket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		//System.out.println(InetAddress.getLocalHost());
		try {
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			System.out.println("[클라이언트] 서버 접속 완료");
			//서버쪽으로 쓰고, 읽기 위한 객체 만들기
			
			//OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(socket.getOutputStream());

			//InputStream is = socket.getInputStream();
			//InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 한번씩만 읽으므로 반복문을 써야함
			while (true) {
				// 입력창
				System.out.print("[클라이언트] 보낼 문자를 입력하세요 : ");
				String out = scan.nextLine();

				// 쓰기
				pw.println(out);
				pw.flush(); // 버퍼에 있는 데이터 강제로 출력
				if(out.equals("종료")) break;
				
				// 읽기
				String str = br.readLine();
				
				System.out.println("[클라이언트] 서버로부터 돌려받은 메시지 : " + str);
				
			}
			

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(pw != null) pw.close();
			
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}

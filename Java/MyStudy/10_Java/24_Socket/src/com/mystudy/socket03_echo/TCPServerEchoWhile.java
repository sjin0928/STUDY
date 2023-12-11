package com.mystudy.socket03_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEchoWhile {

	public static void main(String[] args) {
		// 서버! : 메시지를 읽고, 쓰기 input->output
		// 클라이언트가 보내온 메시지를 1번 받고(읽기) - BufferedReader
		// 받은 메시지를 클라이언트에게 다시 보내기 - PrintWriter
		// BufferdReader <-- InputStreamReader <-- InputStream
		// PrintWriter <-- OutputStream
		// --------
		
		ServerSocket server = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			server = new ServerSocket(10000);
			System.out.println("[서버] 클라이언트 접속 대기중");
			System.out.println(">> IP주소 : 포트번호 - " 
					+ InetAddress.getLocalHost().getHostAddress()
					+ " : " + server.getLocalPort());
			
			Socket socket = server.accept();
			System.out.println("[서버] 클라이언트 접속 완료");
			System.out.println(":: 접속정보 : " + socket.getInetAddress());
			
			// 데이터를 받고, 받은 데이터 돌려주기(읽고, 쓰기)
			
			//InputStream is = socket.getInputStream();
			br = new BufferedReader
					(new InputStreamReader(socket.getInputStream()));
			
			//OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(socket.getOutputStream());
			
			// 한번씩만 읽으므로 반복문을 써야함
			while(true) {
				//읽기
				String str = br.readLine();
				
				System.out.println("[서버] 클라이언트로부터 메시지 : " + str);

				if(str.equals("종료")) {
					System.out.println("[서버] 클라이언트에서 중단 요청");break;
				}
				
				//돌려보내기
				pw.println(str);
				pw.flush(); // 버퍼에 있는 데이터를 출력(전송)
				System.out.println("[서버] 메시지를 보냄 : " + str);
				
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
				System.out.println("close : PrintWriter");
			}
			
			try {
				if(br != null) {
					br.close();
					System.out.println("close : BufferedReader");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(server != null) {
					server.close();
					System.out.println("close : ServerSocket");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

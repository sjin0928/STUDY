package com.mystudy.net_multi2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// 내부클래스를 사용한 읽기, 쓰기 쓰레드 생성하여 사용
// 쓰기쓰레드 : 메시지 작성 및 전송을 독립적으로 처리(언제든지 메시지 보내기 - 쓰기 전용)
// 읽기쓰레드 : 서버쪽에서 보내온 메시지를 받아 화면에 표시(언제든지 메시지 받기 - 읽기 전용)
public class TCPClientMultiChat {
	
	public void start() {
		System.out.println(">>> 클라이언트 시작");
		
		Socket socket = null;
		
		try {
			//localhost
			socket = new Socket("192.168.18.31", 10000);
			System.out.println(">> 서버 접속 완료");
			
			// 메시지 보내기 쓰레드 생성 (쓰기 전용)
			ClientSender ClientSender = new ClientSender (socket);
			ClientSender.start(); // 실행!!!!

			// 메시지 받기 쓰레드 생성(읽기 전용)
			ClientReceiver ClientReceiver = new ClientReceiver (socket);
			ClientReceiver.start(); // 실행!!!!
			
			//Scanner 사용해서 보낼 메시지 화면에서 입력처리

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println(">> 클라이언트 종료");

	}
	
	// 메시지 보내기 전용 쓰레드
	private class ClientSender extends Thread {
		Socket socket; // 저장객체
		DataOutputStream out;
		
		public ClientSender(Socket socket) {
			this.socket = socket;
			
			try {
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] ClientSender 생성자 "
						 + " out 객체 생성 실패-------");
			}
		}
		@Override
		public void run() {
			// 메시지 작성해서 서버로 전송
			if(out == null) {
				System.out.println(":: 출력객체가 없어 작업 종료");
				return; // 리턴값 없으므로 메소드 종료
			}
			
			// Scanner 이용하여 보낼 메시지 화면에서 입력처리
			Scanner scan = new Scanner(System.in);
			
			try {
				// 메시지를 계속 받아야 하므로 예외 트라이캐치문을 반복문 바깥으로 뺌
				// 예외가 발생하면 트라이캐치문에서 처리해야하므로 반복문을 자동으로 나감
				while (true) {
					// 쓰기만 함 --------------
					System.out.print("전송 메시지 입력 : ");
					String msg = scan.nextLine();
					System.out.println();

					out.writeUTF(msg); // 메시지 쓰기
				}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	// 서버에서 보내온 메시지 읽기 전용 쓰레드
	private class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		
		public ClientReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 서버에서 받아온 메시지 화면 출력
		@Override
		public void run() {
			// 출력 반복해야됨
			while(true) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					//e.printStackTrace();
					System.out.println("[예외발생] " + e.getMessage());
					break; // 더이상 읽을 수 없으면 반복(작업) 중단
					// 내부에서 캐치를 했으므로 탈출할 break 가 있어야함
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// 메인에서는 객체만 생성하여 호출
		new TCPClientMultiChat().start();
	}

}

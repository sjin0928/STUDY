package com.mystudy.net_multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

// 다중 접속을 처리할 수 있는 서버(서버에서 읽기만 - 독립적인 쓰레드)
public class TCPServerMulti_InnerClass {

	public static void main(String[] args) {
		System.out.println("==== main() 시작 =======");
		
		new TCPServerMulti_InnerClass();
		
		System.out.println("==== main() 끝 =======");

	}
	
	public TCPServerMulti_InnerClass() {
		serverStart();
	}

	private void serverStart() {
		// 서버소켓을 만들고, 클라이언트 접속처리를 반복한다
		ServerSocket server = null;
		
		try {
			System.out.println(">> 서버소켓 객체 생성");
			server = new ServerSocket(10000);
			
			while (true) {
				// 접속을 반복하여 다중 접속
				System.out.println(">> 접속 대기중~~~ " 
						+ InetAddress.getLocalHost().getHostAddress()
						+ ":" + server.getLocalPort());
				
				Socket socket = server.accept();
				System.out.println("사용자가 접속되었습니다 - " 
						+ socket.getRemoteSocketAddress());
				
				// 접속된 클라이언트(사용자)에 대한 처리 - 쓰레드 생성(읽기전용)
				// 읽는 쓰레드도 반복문에 넣어 계속 읽을 수 있음
				System.out.println(":: 접속유저 읽기 전용 쓰레드 만들었다~~");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 내부클래스
	// ServerReceiver : 클라이언트에서 보내온 메시지 수신 전용
	private class ServerReceiver extends Thread {
		Socket socket;

		public ServerReceiver(Socket socket) {
			this.socket = socket;
		}// 저장하는 역할

		@Override
		public void run() {
			// 클라이언트에서 보내온 메시지를 읽어서 화면(콘솔)에 표시
			System.out.println(">>> 읽기 전용 쓰레드 시작 -----");
			BufferedReader br = null;
			try {
				//문자단위로 읽는 BufferedReader 객체선언
				br = new BufferedReader
						(new InputStreamReader(socket.getInputStream()));
				
				System.out.println(">> 읽기시작");
				
				// 읽기 반복
				while (true) {
					String msg = br.readLine(); // 줄바꿈 이전 라인단위 읽기
					if(msg == null || "exit".equalsIgnoreCase(msg)) {
						break;
					}
					System.out.println(">> " + msg);
				}
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] " + e.getMessage());
			} finally {
				System.out.println(socket.getInetAddress().getHostAddress() + "> 클라이언트 종료");
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}// end class

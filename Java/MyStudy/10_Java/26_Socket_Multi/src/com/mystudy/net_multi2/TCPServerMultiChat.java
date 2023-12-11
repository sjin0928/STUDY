package com.mystudy.net_multi2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// == 멀티채팅 서버측 기능 ===

// 다중 접속을 처리할 수 있는 서버(서버에서 읽기만 - 독립적인 쓰레드)
// 읽기전용 쓰레드 : 접속자가 보낸 메시지를 언제든지 읽을 수 있어야한다.
// 접속자 명단 가지고 있기
// 받은(읽은) 메시지를 접속자 모두에게 전송하는 기능
public class TCPServerMultiChat {
	
	private HashMap<String, DataOutputStream> clients;

	public TCPServerMultiChat() {
		// 객체 생성
		clients = new HashMap<String, DataOutputStream>();
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

	// 내부클래스 - 읽기쓰레드
	// ServerReceiver : 클라이언트에서 보내온 메시지 수신 전용
	private class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in = null;
		DataOutputStream out = null;
		String name; // 접속자명단 map에 기재용

			
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			//문자단위로 읽는 BufferedReader 객체선언
			try {
				in = new DataInputStream(socket.getInputStream());
				// 접속자 명단 등록을 하기 위해 만듬
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// 저장하는 역할

		@Override
		public void run() {
			// 생성될때 : 필드의 사용자명단(Clients)에 추가
			// 종료될때 : 필드의 사용자명단(Clients)에서 제외(삭제)
			// 메시지를 받고~ 받은 메시지를 전체에게 전달
			System.out.println(">>> 읽기 전용 쓰레드 시작 -----");
			try {
				// 사용자 등록 작업
				name = socket.getInetAddress().getHostAddress();
				clients.put(name, out); // 접속자 정보 등록
				
				while (true) {
					String msg = in.readUTF(); // 줄바꿈 이전 라인단위 읽기
					if(msg == null || "exit".equalsIgnoreCase(msg)) {
						break;
					}
					System.out.println(name + "> " + msg);

					// 접속자 전원에게 메시지 일괄 전송하기
					sendToAll(msg);	// 메소드 호출
					
				}
				
			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("[예외발생] " + e.getMessage());
			} finally {
				System.out.println(socket.getInetAddress().getHostAddress() + "> 클라이언트 종료");
				// 종료할때 접속자 명단에서 제외(Clients에서 삭제)
				clients.remove(name);
				String outmsg ="<" + name + ">님이 나갔습니다~";
				sendToAll(outmsg);
				System.out.println(outmsg);
				
			}
		}
		
		// 접속자 전원에게 메시지 일괄 전송하기
		private void sendToAll(String msg) {
			for(DataOutputStream out : clients.values()) {
				try {
					out.writeUTF(msg);
				}catch (Exception e) {
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("==== main() 시작 =======");
		
		new TCPServerMultiChat().serverStart();
		
		System.out.println("==== main() 끝 =======");

	}
	

}// end class

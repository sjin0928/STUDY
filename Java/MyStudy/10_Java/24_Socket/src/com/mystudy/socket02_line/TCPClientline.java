package com.mystudy.socket02_line;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientline {
	public static void main(String[] args) throws UnknownHostException {
		// 서버 접속 후 printWrite 사용해서 메시지 1번 보내기
		// OutputStream ---> PrintWriter
		//------------------------
		System.out.println(">>> 클라이언트 시작");
		Socket socket = null;
		System.out.println("현재컴퓨터IP : " + InetAddress.getLocalHost());
		System.out.println(">>> 서버 접속 시도~~");
		
		try {
			//1. 소켓(Socket) 생성 : 접속할 IP 주소, 포트(port) 정보로 서버접속
			socket = new Socket(InetAddress.getLocalHost(), 10000);
			System.out.println(">>> 서버 접속 성공~~~~~");
			
			//2. 소켓으로부터 입, 출력 객체 생성 - InputStream, OutputStream
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			//3. 전송(out)할 데이터가 있으면 쓰기(write)
			String msg = "안녕하세요. 만나서 반갑습니다. 소켓통신 공부중~~";
			pw.print(msg);
			pw.print("잘 되고 있나요?");
			pw.println("ㅎㅎㅎㅎㅎ !!!!");
			
			pw.flush();
			// 둘중 한개만 하면됨 flush or close
			
			//4. 읽을 데이터가 있으면 읽기
			
			pw.close();
			// 안하면 데이터 전송 안됨 (buffer 기능 있음)
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null) {
					socket.close();	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> 클라이언트 종료");
	}
}

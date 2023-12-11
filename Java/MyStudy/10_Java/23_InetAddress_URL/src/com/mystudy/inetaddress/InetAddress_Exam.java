package com.mystudy.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Exam {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress : IP주소 관련 클래스
		// IP 주소는 집주소처럼 네트워크상에 있는 고유번호(주소)
		InetAddress iaddr = InetAddress.getLocalHost();
		System.out.println("iaddr : " + iaddr);
		System.out.println("호스트명 : " + iaddr.getHostName());
		System.out.println("호스트 IP주소 : " + iaddr.getHostAddress());
		
		System.out.println("--- 네이버 주소 검색 ---");
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("naver : " + naver);
		System.out.println("호스트명 : " + naver.getHostName());
		System.out.println("호스트 IP주소 : " + naver.getHostAddress());
		
		System.out.println("--- 네이버 IP 주소들 검색 ---");
		InetAddress[] iaArray = InetAddress.getAllByName("www.naver.com");
		// getAllByName 여러개 데이터를 저장하는 배열 타입임
		
		for (InetAddress ia : iaArray) {
			System.out.println("호스트명 : " + ia.getHostName());
			System.out.println("IP주소 : " + ia.getHostAddress());
		}

	}

}

package com.mystudy.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URL_Exam {

	public static void main(String[] args) throws MalformedURLException {
		// 프로토콜://호스트(서버네임):포트번호/           경로(패스)  ?질의(query) &(데이터가 여러개면 &으로 구분하여씀)
		// https://n.news.naver.com/article/001/0014109448?cds=news_media_pc&type=editn
		// URL 은 데이터가 어디에 있는지 알려주는 위치정보
		
		URL url = new URL("http", "mystudy.com", 8080,
				"/aaa/bbb/index.jsp?id=hong&password=1234#content");
		//http://mystudy.com:8080/aaa/bbb/index.jsp?id=hong&password=1234#content
		System.out.println("url : " + url);
		
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		int defaultPort = url.getDefaultPort();
		// 기본포트만 사용할때는 생략가능
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트번호(port) : " + port);
		System.out.println("기본포트(defaultPort) : " + defaultPort);
		System.out.println("경로-패스(path) : " + path);
		System.out.println("쿼리-질문(요청)(query) : " + query);
		System.out.println("참조(reference) : " + ref);
		
		System.out.println("--");
		url = new URL("https://n.news.naver.com/article/001/0014109600?type=main");
		System.out.println("url : " + url);
		protocol = url.getProtocol();
		host = url.getHost();
		port = url.getPort();
		defaultPort = url.getDefaultPort();
		path = url.getPath();
		query = url.getQuery();
		ref = url.getRef();
		
		System.out.println("프로토콜(protocol) : " + protocol);
		System.out.println("호스트(host) : " + host);
		System.out.println("포트번호(port) : " + port);
		System.out.println("기본포트(defaultPort) : " + defaultPort);
		System.out.println("경로-패스(path) : " + path);
		System.out.println("쿼리-질문(요청)(query) : " + query);
		System.out.println("참조(reference) : " + ref);
		
	}

}

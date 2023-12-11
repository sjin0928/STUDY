package com.mystudy.member.dao;

import java.util.List;

import com.mystudy.member.vo.MemberVO;

public class MemberDAO_Test {

	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectAll();
		
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
		
		MemberVO mem = new MemberVO("kang", "강감찬", "3333", "010-3333-3333", "경기"); 
		int result = dao.insert(mem);
		
		list = dao.selectAll();
		System.out.println("입력건수 : " + result);
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
		
	}

}

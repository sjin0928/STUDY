package com.mystudy.ex01_random;

import java.util.Random;

public class Random_Exam2 {

	public static void main(String[] args) {
		Random ran = new Random();
		
		System.out.println("--- nextInt() ----");
		for (int i = 0; i < 20; i ++) {
			int ranInt = ran.nextInt(5); //0~4 의 난수
			System.out.print(ranInt + " ");
		}
		System.out.println();
		System.out.println("=================");
		System.out.println(ran.nextDouble() + " - Random의 nextDouble()");
		System.out.println(Math.random() + " - Math.random()");

	}

}

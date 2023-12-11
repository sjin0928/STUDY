package com.study.ex06_object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectInputOutputStream2_List {

	public static void main(String[] args) {
		// StudentVO 객체들을 ArrayList에 담아서 파일에 저장하고
		// 파일에서 읽어들인 ArrayList 객체에 담긴 VO 데이터를 화면 출력
		// 사용할 파일명 : file/object_io_list.data
		// ------------------------------------------
		
		// VO 데이터 생성 --> List에 저장 --> 파일에 출력
		StudentVO stu1 = new StudentVO("홍길동", 88, 99, 55);
		StudentVO stu2 = new StudentVO("김유신", 55, 77, 22);
		
		ArrayList<StudentVO> list = new ArrayList<StudentVO>() ;
		list.add(stu1);
		list.add(stu2);
		
		// 파일에서 List 읽기 --> List에 있는 VO 가져다 화면 출력
		File file = new File("file/object_io_list.data");
		ObjectOutputStream oos = null;
		
		
		try {
			//쓰기
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("== 파일에서 List 읽기(Input) ==");
		
		
		ObjectInputStream ois = null;
		
		//읽기
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			
			@SuppressWarnings("unchecked")
			ArrayList<StudentVO> inList = (ArrayList<StudentVO>) ois.readObject();

			for (StudentVO stuout : inList) {
				System.out.println("이름 : " + stuout.getName() + "\n"
						+ "국어 : " + stuout.getKor() + " 영어 : " + stuout.getEng() + 
						" 수학 : " + stuout.getMath() + " 합계 : " + stuout.getTot() + 
						" 평균 : " + stuout.getAvg() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}

}

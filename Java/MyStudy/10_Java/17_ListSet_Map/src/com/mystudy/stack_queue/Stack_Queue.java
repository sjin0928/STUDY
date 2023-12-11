package com.mystudy.stack_queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Stack_Queue {

	/*
	 * 큐(Queue) 인터페이스 : 형태상 파이프 형태(선입선출 : FIFO- First in First out)
	 *   - offer(), poll(), peek()
	 * 스택(Stack)클래스 : 형태상 바닥이 막힌 통의 형태
	 * (후입선출 : LIFO - Last in First out)
	 *  -push(), pop(), peek()
	 */
	
	
	public static void main(String[] args) {
		// 큐(Queue) 인터페이스 - LinkedList 클래스를 큐 형태로 사용
		//List<String> list = new LinkedList<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1.첫째");
		queue.add("2.둘째");
		queue.offer("3.셋째");
		queue.offer("4.넷째");
		queue.offer("5.다섯째");
		
		System.out.println("queue : " + queue);
		System.out.println("갯수 : " + queue.size());

		System.out.println("======== peek() ==========");
		String data = queue.peek();
		// 데이터를 읽어오지만 사라지지않음
		// peek() : 현재 사용할 수 있는 데이터를 확인만(읽어오기, 참조, 조회)
		System.out.println("peek data : " + data);
		System.out.println("queue.peek() : " + queue.peek());
		System.out.println("갯수 : " + queue.size());
		System.out.println("queue : " + queue);
		System.out.println();
		
		System.out.println("======== poll() ==========");
		// poll() : 데이터 읽은 후 삭제
		//System.out.println("queue.poll() : " + queue.poll());
		//System.out.println("queue.poll() : " + queue.poll());
		// System.out.println("queue.remove() : " + queue.remove());
		// 현재 데이터 삭제 (return값을 사용할 수는 있음)
		//System.out.println("queue.poll() : " + queue.poll());
		//System.out.println("queue.poll() : " + queue.poll());
		//System.out.println("queue.poll() : " + queue.poll());
		//System.out.println("queue.poll() : " + queue.poll());
		// System.out.println("queue.remove() : " + queue.remove());
		// NoSuchElementException 발생
		System.out.println("갯수 : " + queue.size());
		System.out.println("queue : " + queue);
		System.out.println("queue.isEmpty() : " + queue.isEmpty());
		// collection의 확장으로 remove, isEmpty 사용 가능
		System.out.println();
		
		System.out.println("---- 큐 전체 데이터 추출(사용) ----");
		while (!queue.isEmpty()) {
			// 데이터 사용 하기
			System.out.println("While queue.poll() : " + queue.poll());
		}
		
		System.out.println("갯수 : " + queue.size());
		System.out.println("queue : " + queue);
		System.out.println("queue.isEmpty() : " + queue.isEmpty());
		
		System.out.println("==================");
		System.out.println();
		
		System.out.println("스택(Stack) : LIFO - 후입선출");
		Stack<String> stack = new Stack<>();
		stack.push("1. 첫째"); // stack 기능
		stack.add("2. 둘째"); // Vector 기능
		stack.push("3. 셋째");
		stack.push("4. 넷째");
		System.out.println("stack" + stack);
		System.out.println("stack.size() : " + stack.size());
		System.out.println("stack.empty() : " + stack.empty());
		System.out.println();
		
		System.out.println("------peek() : 사용할 수 있는 데이터 확인(참조) ----------");
		System.out.println("stack.peek() : " + stack.peek());
		System.out.println("stack.peek() : " + stack.peek());
		System.out.println("stack.size() : " + stack.size());
		System.out.println();
		
		System.out.println("------pop() : 꺼내쓰기----------");
		//System.out.println("stack.pop() : " + stack.pop());
		//System.out.println("stack.pop() : " + stack.pop());
		//System.out.println("stack.pop() : " + stack.pop());
		//System.out.println("stack.pop() : " + stack.pop());
		// System.out.println("stack.pop() : " + stack.pop());
		// 데이터가 없어 EmptyStackException 발생 
		System.out.println("stack" + stack);
		System.out.println("stack.size() : " + stack.size());
		
		System.out.println("--- 스택 전체 데이터 사용 ----");
		System.out.println("stack.empty() : " + stack.empty());
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("stack" + stack);
		System.out.println("stack.size() : " + stack.size());
		
		
		
	}
	
	

}

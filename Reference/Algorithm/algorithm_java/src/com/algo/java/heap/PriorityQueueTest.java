package com.algo.java.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
//		PriorityQueue<Integer> queue = new PriorityQueue<>();
//		
//		
//		// 기본 정렬, 오름차순
//		queue.offer(10);
//		queue.offer(5);
//		queue.offer(11);
//		queue.offer(-1);
//		
//		while(!queue.isEmpty()) {
//			System.out.println(queue.poll());
//		}
		
//		PriorityQueue<Student> queue = new PriorityQueue<>();
//		
//		// Comparable 구현하지 않으면 예외 발생
//		queue.offer(new Student(5, 10));
//		queue.offer(new Student(7, 60));
//		queue.offer(new Student(3, 40));
//		queue.offer(new Student(1, 30));
//		
//		while(!queue.isEmpty()) {
//			System.out.println(queue.poll());
//		}
		
		PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {

				return o1.getScore() - o2.getScore(); // 점수 기준 오름차순
			}
		});
		
		// Comparator 구현
		queue.offer(new Student(5, 10));
		queue.offer(new Student(7, 60));
		queue.offer(new Student(3, 40));
		queue.offer(new Student(1, 30));
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}

class Student /*implements Comparable<Student>*/{
	
	private int no;
	private int score;
	
	public Student(int no, int score) {
		this.no = no;
		this.score = score;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}

	
//	// 방법 1. Comparable 구현
//	@Override
//	public int compareTo(Student o) {
//		
//		return this.no - o.no; // 번호 기준 오름차순 정렬
//	}

}

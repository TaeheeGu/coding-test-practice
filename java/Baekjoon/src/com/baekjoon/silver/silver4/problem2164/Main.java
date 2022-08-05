package com.baekjoon.silver.silver4.problem2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

// 2164번 카드 2, 실버4
// 
public class Main {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());

		Queue<Integer> queue = new ArrayDeque<Integer>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
			// offer() vs add() : 큐에 아무것도 없을 때 동작이 상이하다.
			
			// add(), remove(), element() 문제상황에서 예외 발생
			// offer(), poll(), peek() 문제상황에서 false 반환
		}

		// 마지막 한 장이 남을 때까지
		while (queue.size() > 1) {
			// 제일 위에 있는 카드 버리기
			queue.poll();

			// 다음 위에 있는 카드 제일 아래로 옮기기
			int temp = queue.poll();
			queue.offer(temp);
		}

		// 마지막 한 장 출력하기
		sb.append(queue.poll());

		out.write(sb.toString());
		out.close();
	}
}
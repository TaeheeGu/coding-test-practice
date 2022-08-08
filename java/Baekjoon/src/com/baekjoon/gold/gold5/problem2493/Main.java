package com.baekjoon.gold.gold5.problem2493;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//2493번, 탑, 골드5
//https://www.acmicpc.net/problem/2493
public class Main {
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		// 탑의 수
		int N = Integer.parseInt(in.readLine());

		// 탑들의 높이
		String[] split = in.readLine().split(" ");
		int[] towers = new int[N];
		for (int i = 0; i < N; i++) {
			towers[i] = Integer.parseInt(split[i]);
		}

		Stack<Tower> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty()) {
				// 스택의 top이 현재 입력 값(높이)보다 크면, 신호 수신 가능
				if (stack.peek().height > towers[i - 1]) {
					sb.append(stack.peek().no).append(" ");
					break;
				}

				// 스택의 top이 현재 입력 값보다 작으면, 신호 수신 불가능
				stack.pop();
			}

			// 스택이 비었다는 뜻은 신호 수신이 가능한 탑이 없다는 뜻으로 0을 출력
			if (stack.isEmpty()) {
				sb.append("0 ");
			}

			// 현재 입력을 가지고 탑을 생성하여 스택에 push
			stack.push(new Tower(i, towers[i - 1]));
		}

		out.write(sb.toString());
		out.close();
	}
}

class Tower {
	public int no; // 탑의 번호: 숫자가 작을수록 왼쪽에 위치
	public int height; // 탑의 높이

	public Tower(int no, int height) {
		this.no = no;
		this.height = height;
	}
}

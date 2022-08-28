package com.baekjoon.gold.gold4.problem16637;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 백준, 16637번, 괄호 추가하기, 골드4
// https://www.acmicpc.net/problem/16637
public class Main {

	private static int N;
	private static List<Character> ops;
	private static List<Integer> nums;

	static int max;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		char[] c = in.readLine().toCharArray();

		nums = new ArrayList<>();
		ops = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				nums.add(c[i] - '0');
			} else {
				ops.add(c[i]);
			}
		}

		max = Integer.MIN_VALUE;

		dfs(0, nums.get(0));

		sb.append(max);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int idx, int sum) {
		if (idx >= ops.size()) {
			max = Math.max(max, sum);
			return;
		}

		// 괄호 안치는 경우
		// 지금까지의 연산 결과에 연산자 오른쪽 숫자를 연산한다.
		dfs(idx + 1, calc(sum, nums.get(idx + 1), ops.get(idx)));

		// 괄호 치는 경우
		// 다음으로 오는 연산자를 먼저 계산 후 왼쪽 값과 연산을 실행한다.
		if (idx < ops.size() - 1) {
			int temp = calc(nums.get(idx + 1), nums.get(idx + 2), ops.get(idx + 1));
			
			dfs(idx + 2,  calc(sum, temp, ops.get(idx)));

		}

	}

	private static int calc(int num1, int num2, char operator) {

		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;

		case '*':
			return num1 * num2;
		}

		return 0;
	}

}

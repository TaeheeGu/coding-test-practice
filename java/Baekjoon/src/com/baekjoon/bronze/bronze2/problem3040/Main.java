package com.baekjoon.bronze.bronze2.problem3040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 3040번, 백설 공주와 일곱 난쟁이, 브론즈 2
// https://www.acmicpc.net/problem/3040
public class Main {

	static int[] answer;
	static int[] selected;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		numbers = new int[9];
		selected = new int[7];
		answer = new int[7];

		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(in.readLine());
		}

		comb(0, 0);

		for (int i = 0; i < 7; i++) {
			sb.append(answer[i]).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {

		if (cnt == 7) {
			int sum = 0;

			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}

			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					answer[i] = selected[i];
				}
			}

			return;
		}

		for (int i = start; i < 9; i++) {
			selected[cnt] = numbers[i];
			comb(i + 1, cnt + 1);
		}
	}
}

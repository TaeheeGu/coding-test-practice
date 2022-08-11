package com.baekjoon.silver.silver2.problem6603;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 6603번 로또, 실버2
// https://www.acmicpc.net/problem/6603
public class Main {

	static int[] input;
	static int[] numbers;
	static int K;
	static final int R = 6;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		while (true) {
			String[] split = in.readLine().split(" ");

			K = Integer.parseInt(split[0]);
			
			if (K == 0) {
				break;
			}

			input = new int[K];
			numbers = new int[R];

			for (int i = 0; i < K; i++) {
				input[i] = Integer.parseInt(split[i + 1]);
			}

			comb(0, 0);

			sb.append("\n");

		}

		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {

		if (cnt == R) {
			for (int idx = 0; idx < R; idx++) {
				sb.append(numbers[idx]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < K; i++) {
			numbers[cnt] = input[i];
			comb(i + 1, cnt + 1);
		}
	}
}
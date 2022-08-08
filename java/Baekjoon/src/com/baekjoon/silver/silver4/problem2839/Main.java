package com.baekjoon.silver.silver4.problem2839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2839번, 설탕 배달, 실버 4
// https://www.acmicpc.net/problem/2839
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int answer = -1;

		if (N % 5 == 0) {
			answer = N / 5;
		}
		else if (N % 5 == 1) {
			answer = (N / 5) - 1 + 2;
		}
		else if (N % 5 == 2 && N > 7) {
			answer = (N / 5) - 2 + 4;
		}
		else if (N % 5 == 3) {
			answer = N / 5 + 1;
		}
		else if (N % 5 == 4 && N > 9) {
			answer = N / 5 - 1 + 3;
		}

		if (answer == -1 && N % 3 == 0) {
			answer = N / 3;
		}

		sb.append(answer);

		out.write(sb.toString());
		out.close();
	}
}

package com.baekjoon.silver.silver1.problem9081;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 9081번 단어 맞추기, 실버 1
// https://www.acmicpc.net/problem/9081
public class Main {

	static char[] word;
	static int N;

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 0; t < T; t++) {
			word = in.readLine().toCharArray();
			N = word.length;

			nextPerm();
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void nextPerm() {
		int i = N - 1;
		while (i > 0 && word[i - 1] >= word[i]) {
			--i;
		}

		if (i == 0) {
			for (int idx = 0; idx < N; idx++) {
				sb.append(word[idx]);
			}
			return;
		}

		int j = N - 1;
		while (word[i - 1] >= word[j]) {
			--j;
		}

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		for (int idx = 0; idx < N; idx++) {
			sb.append(word[idx]);
		}
		return;
	}

	private static void swap(int i, int j) {
		char temp = word[i];
		word[i] = word[j];
		word[j] = temp;
	}
}

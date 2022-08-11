package com.baekjoon.silver.silver2.problem2961;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2961번, 도영이가 만든 맛있는 음식, 실버2
// https://www.acmicpc.net/problem/2961
public class Main {

	static int N;
	static int[][] SB;
	static boolean[] isSelected;
	static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());

		SB = new int[N][2];
		isSelected = new boolean[N];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			SB[i][0] = Integer.parseInt(st.nextToken());
			SB[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(0);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void subset(int idx) {

		if (idx == N) {

			int sumS = 1;
			int sumB = 0;
			boolean using = false;

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sumS *= SB[i][0];
					sumB += SB[i][1];
					using = true;
				}
			}
			if (using) {
				answer = Math.min(answer, (Math.abs(sumS - sumB)));
			}

			return;
		}

		isSelected[idx] = true;
		subset(idx + 1);

		isSelected[idx] = false;
		subset(idx + 1);
	}
}

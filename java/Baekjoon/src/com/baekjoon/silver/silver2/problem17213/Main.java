package com.baekjoon.silver.silver2.problem17213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준, 17213번, 실버2
// https://www.acmicpc.net/problem/17213
public class Main {

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());

		int answer = 0;

		// 모든 종류의 과일을 하나씩은 훔친다.
		// 하나씩 훔친 다음 중복해서 훔쳐도 상관 없다! -> 중복조합
		// nHr = n+r-1Cr = n+r-1Cn-1
		// nC0 = 1, nCc = 1
		// n+1Cr+1 = nCr + nCr+1

		int R = M - N;

		if (R == 0) {
			answer = 1;
		} else {
			int[][] dp = new int[N + R][N + R];

			for (int i = 0; i < N + R; i++) {
				dp[i][0] = 1;
				dp[i][i] = 1;
			}

			for (int i = 2; i < N + R; i++) {
				for (int j = 1; j < N + R; j++) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}

			answer = dp[N + R - 1][R];
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

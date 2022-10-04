package com.baekjoon.silver.silver3.problem1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[1] = 0;

		for (int i = 1; i <= N; i++) {
			if (i + 1 <= N) {
				dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			}
			if (i * 2 <= N) {
				dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			}
			if (i * 3 <= N) {
				dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
			}
		}

		int answer = dp[N];
		sb.append(answer);
		out.write(sb.toString());
		out.close();

	}
}

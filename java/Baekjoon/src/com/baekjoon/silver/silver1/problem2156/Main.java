package com.baekjoon.silver.silver1.problem2156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int[] wine = new int[N + 3];

		for (int i = 3; i < N + 3; i++) {
			wine[i] = Integer.parseInt(in.readLine());
		}

		int[] dp = new int[N + 3];

		for (int i = 3; i < N + 3; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]));
		}

//		System.out.println(Arrays.toString(dp));
		int answer = dp[N + 2];

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

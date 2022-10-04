package com.baekjoon.silver.silver1.problem1149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		int[][] RGB = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][3];
		dp[0][0] = RGB[0][0];
		dp[0][1] = RGB[0][1];
		dp[0][2] = RGB[0][2];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = RGB[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = RGB[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = RGB[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(dp[N-1][i], answer);
		}
		
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

}

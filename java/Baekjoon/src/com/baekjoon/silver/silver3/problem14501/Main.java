package com.baekjoon.silver.silver3.problem14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[] T;
	static int[] P;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		T = new int[N + 1]; // 걸리는 시간
		P = new int[N + 1]; // 이득

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		answer = 0;

		for(int i = 1; i <= N; i++) {
			dfs(i, 0);
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int day, int profit) {
		if (day == N + 1) {
			answer = Math.max(answer, profit);
			return;
		}

		int after = day + T[day] - 1;
		if (after <=  N) {
			dfs(after + 1, profit + P[day]);
		}
		dfs(day + 1, profit);
	}
}

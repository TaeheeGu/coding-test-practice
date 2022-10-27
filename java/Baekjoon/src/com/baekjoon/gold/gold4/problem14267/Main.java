package com.baekjoon.gold.gold4.problem14267;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// boj, 14267
public class Main {

	static int N, M;
	static int[] boss;
	static int[] answer;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boss = new int[N + 1];
		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			boss[i] = Integer.parseInt(st.nextToken());
		}

		answer = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			answer[to] += w;
		}

		for (int i = 2; i <= N; i++) {
			answer[i] += answer[boss[i]];
		}

		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append(" ");
		}

		out.write(sb.toString());
		out.close();

	}
}

package com.baekjoon.silver.silver1.problem11660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11660번, 구간 합 구하기5, silver1
// https://www.acmicpc.net/problem/11660
public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 각 행의 연속된 값의 합을 저장한다. 0, 1열까지의 합, 2열까지의 합 ... n 열까지의 합
		int[][] store = new int[N + 1][N + 1]; // 10^6 = 1,000,000

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j < N + 1; j++) {
				store[i][j] = store[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) { // 100,000
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken()); // start
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); // end
			
			int sum = 0;

			for(int x = x1; x <= x2; x++) {
				sum += store[x][y2] - store[x][y1 - 1];
			}
			sb.append(sum).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}
}

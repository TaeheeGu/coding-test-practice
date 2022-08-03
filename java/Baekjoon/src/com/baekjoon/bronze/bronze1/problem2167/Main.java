package com.baekjoon.bronze.bronze1.problem2167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2167번, 2차원 배열의 합
// https://www.acmicpc.net/problem/2167
public class Main {
	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] store = new int[N + 1][M + 1];

		for (int n = 1; n < N + 1; n++) {
			st = new StringTokenizer(in.readLine());
			for (int m = 1; m < M + 1; m++) {
				store[n][m] = store[n][m - 1] + Integer.parseInt(st.nextToken());
			}
		}

		int K = Integer.parseInt(in.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(in.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int sum = 0;

			for(int row = i; row <= x; row++) {
				sum += store[row][y] - store[row][j - 1];
			}
			sb.append(sum).append("\n");
		}
		out.write(sb.toString());
		out.close();
	}
}

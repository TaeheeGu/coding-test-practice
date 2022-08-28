package com.baekjoon.gold.gold5.problem17070;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 17070번, 파이프 옮기기1, 골드 5
// https://www.acmicpc.net/problem/17070
public class Main {

	private static int N;
	private static int[][] room;

	private static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		room = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;

		dfs(0, 1, 1); // dir 1: 가로, 2: 세로, 3: 대각

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int r, int c, int dir) {

		if (r == N - 1 && c == N - 1) {
			answer++;
		}

		// 가로
		if (dir == 1) {
			if (check(r, c + 1)) {
				dfs(r, c + 1, 1);
			}
			if (check(r, c + 1) && check(r + 1, c + 1) && check(r + 1, c)) {
				dfs(r + 1, c + 1, 3);
			}
		}

		// 세로
		if (dir == 2) {
			if (check(r + 1, c)) {
				dfs(r + 1, c, 2);
			}
			if (check(r, c + 1) && check(r + 1, c + 1) && check(r + 1, c)) {
				dfs(r + 1, c + 1, 3);
			}
		}

		// 대각선
		if (dir == 3) {
			if (check(r, c + 1)) {
				dfs(r, c + 1, 1);
			}
			if (check(r + 1, c)) {
				dfs(r + 1, c, 2);
			}
			if (check(r, c + 1) && check(r + 1, c + 1) && check(r + 1, c)) {
				dfs(r + 1, c + 1, 3);
			}
		}
	}

	private static boolean check(int r, int c) {
		return ((0 <= r && r < N) && (0 <= c && c < N) && room[r][c] != 1);
	}
}

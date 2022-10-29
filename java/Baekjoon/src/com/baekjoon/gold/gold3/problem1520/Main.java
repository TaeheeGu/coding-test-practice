package com.baekjoon.gold.gold3.problem1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;
	static int[][] map, dp;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][M];
		visited = new boolean[N][M];
		
		dp[N-1][M-1] = 1;
		answer = 0;
		dfs(0, 0);

		sb.append(dp[0][0]);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int r, int c) {

		if (r == N - 1 && c == M - 1) {
			return;
		}

		if (visited[r][c]) {
			return;
		}

		visited[r][c] = true;

		for (int idx = 0; idx < 4; idx++) {
			int nextR = r + dx[idx];
			int nextC = c + dy[idx];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
				continue;
			}

			if (map[nextR][nextC] < map[r][c]) {
				dp[r][c] += dp[nextR][nextC];

				if (dp[nextR][nextC] == 0) {
					dfs(nextR, nextC);
				}
			}
		}
	}

}

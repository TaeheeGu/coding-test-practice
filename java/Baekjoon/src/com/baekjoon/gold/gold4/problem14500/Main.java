package com.baekjoon.gold.gold4.problem14500;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;
	static int[][] arr;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];
		answer = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				visited[n][m] = true;
				dfs(n, m, arr[n][m], 1);
				visited[n][m] = false;
			}
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int row, int col, int sum, int cnt) {
		if (cnt == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];

			if (checking(nextRow, nextCol) && !visited[nextRow][nextCol]) {

				if (cnt == 2) {
					visited[nextRow][nextCol] = true;
					dfs(row, col, sum + arr[nextRow][nextCol], cnt + 1);
					visited[nextRow][nextCol] = false;
				}

				visited[nextRow][nextCol] = true;
				dfs(nextRow, nextCol, sum + arr[nextRow][nextCol], cnt + 1);
				visited[nextRow][nextCol] = false;
			}
		}

	}

	private static boolean checking(int row, int col) {
		return ((0 <= row && row < N) && (0 <= col && col < M));
	}
}

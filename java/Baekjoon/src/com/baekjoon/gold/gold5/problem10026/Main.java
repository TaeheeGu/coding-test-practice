package com.baekjoon.gold.gold5.problem10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// BOJ, 10026번 적록색약, 골드 5
// https://www.acmicpc.net/problem/10026
public class Main {

	private static int N;
	private static char[][] img;
	private static boolean[][] nVisited;
	private static boolean[][] wVisited;

	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		img = new char[N][N];

		nVisited = new boolean[N][N];
		wVisited = new boolean[N][N];

		int normal = 0;
		int weakens = 0;

		for (int i = 0; i < N; i++) {
			img[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!nVisited[i][j]) {
					dfs(i, j, nVisited);
					normal++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (img[i][j] == 'G') {
					img[i][j] = 'R';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!wVisited[i][j]) {
					dfs(i, j, wVisited);
					weakens++;
				}
			}
		}

		sb.append(normal).append(" ").append(weakens);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int r, int c, boolean[][] visited) {

		visited[r][c] = true;
		char color = img[r][c];

		for (int i = 0; i < 4; i++) {
			int nextR = r + dx[i];
			int nextC = c + dy[i];

			if ((0 <= nextR && nextR < N) && (0 <= nextC && nextC < N) && !visited[nextR][nextC]) {

				if (color == img[nextR][nextC]) {
					dfs(nextR, nextC, visited);

				}

			}
		}

	}

}

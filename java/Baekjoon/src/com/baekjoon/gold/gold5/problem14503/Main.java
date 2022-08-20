package com.baekjoon.gold.gold5.problem14503;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준, 14503번, 로봇청소기, 골드 5
// https://www.acmicpc.net/problem/14503
public class Main {

	private static int[] dx = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	private static int[] dy = { 0, 1, 0, -1 }; // 상, 우, 하, 좌

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		outter: while (true) {

			if (board[r][c] == 0) {
				board[r][c] = -1;
				answer++;
			}

			int dir = d;

			for (int i = 0; i < 4; i++) {
				dir = (dir + 3) % 4;

				int nextR = r + dx[dir];
				int nextC = c + dy[dir];

				if (board[nextR][nextC] == 0) {
					r = nextR;
					c = nextC;
					d = dir;
					continue outter;
				}
			}

			int testR = r + dx[(d + 2) % 4];
			int testC = c + dy[(d + 2) % 4];

			if (board[testR][testC] == 1) {
				break outter;
			}
			r = testR;
			c = testC;

		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

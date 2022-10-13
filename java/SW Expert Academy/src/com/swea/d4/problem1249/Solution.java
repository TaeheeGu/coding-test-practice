package com.swea.d4.problem1249;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {

	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] split = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = split[j] - '0';
				}
			}

			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			dp[0][0] = -1;

			bfs();
			int answer = dp[N - 1][N - 1];

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0, 0, 0));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			int sum = cur.sum;

			for (int idx = 0; idx < 4; idx++) {
				int nextR = r + dx[idx];
				int nextC = c + dy[idx];

				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) {
					continue;
				}

				int nextSum = sum + map[nextR][nextC];
				if (nextSum < dp[nextR][nextC]) {
					dp[nextR][nextC] = nextSum;
					queue.offer(new Point(nextR, nextC, nextSum));
				}
			}
		}

	}
}

class Point {
	int r;
	int c;
	int sum;

	public Point(int r, int c, int sum) {
		this.r = r;
		this.c = c;
		this.sum = sum;
	}
}

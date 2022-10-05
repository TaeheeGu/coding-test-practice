package com.baekjoon.gold.gold4.problem2636;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2636
public class Main {

	static int R, C;
	static int[][] cheese;

	static int[] dx = { -1, 1, 0, 0, };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cheese = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < C; c++) {
				cheese[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int sec = 0;
		int cnt = 0;
		int temp = 0;
		while (true) {
			temp = cnt;
			cnt = bfs();

			if (cnt == 0) {
				break;
			} else {
				sec++;
			}
		}

		sb.append(sec).append("\n").append(temp);
		out.write(sb.toString());
		out.close();
	}

	private static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		int cnt = 0;

		for (int r = 0; r < R; r++) {
			queue.offer(new Point(r, 0));
			queue.offer(new Point(r, C - 1));

			visited[r][0] = true;
			visited[r][C - 1] = true;
		}
		for (int c = 1; c < C; c++) {
			queue.offer(new Point(0, c));
			queue.offer(new Point(R - 1, c));

			visited[0][c] = true;
			visited[R - 1][c] = true;
		}

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int row = cur.r;
			int col = cur.c;

			for (int idx = 0; idx < 4; idx++) {
				int nextR = row + dx[idx];
				int nextC = col + dy[idx];

				if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
					continue;
				}
				if (visited[nextR][nextC]) {
					continue;
				}
				if (cheese[nextR][nextC] == 0) {
					visited[nextR][nextC] = true;
					queue.offer(new Point(nextR, nextC));
				}
				if (cheese[nextR][nextC] != 0) {
					visited[nextR][nextC] = true;
					cheese[nextR][nextC] = 0;
					cnt++;
				}
			}
		}
		return cnt;
	}
}

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

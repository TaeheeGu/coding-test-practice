package com.baekjoon.gold.gold4.problem14502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 골드4, 14502번 연구소
public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M, answer;
	static int[][] map, test;

	static List<Point> space, virus;
	static boolean[][] visited;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		space = new ArrayList<>();
		virus = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(in.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if (map[n][m] == 0) {
					space.add(new Point(n, m));
				}
				if (map[n][m] == 2) {
					virus.add(new Point(n, m));
				}
			}
		}
		answer = Integer.MIN_VALUE;
		numbers = new int[3];
		comb(0, 0);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {
		if (cnt == 3) {
			test = new int[N][M];

			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					test[n][m] = map[n][m];
				}
			}

			for (int i = 0; i < 3; i++) {
				int row = space.get(numbers[i]).row;
				int col = space.get(numbers[i]).col;
				test[row][col] = 1;
			}

			visited = new boolean[N][M];
			Queue<Point> queue = new ArrayDeque<>();
			for (int i = 0; i < virus.size(); i++) {
				Point current = virus.get(i);
				visited[current.row][current.col] = true;
				queue.offer(current);
			}

			while (!queue.isEmpty()) {
				Point cur = queue.poll();
				int row = cur.row;
				int col = cur.col;

				for (int idx = 0; idx < 4; idx++) {
					int nextRow = row + dx[idx];
					int nextCol = col + dy[idx];

					if (check(nextRow, nextCol) && !visited[nextRow][nextCol] && test[nextRow][nextCol] == 0) {
						visited[nextRow][nextCol] = true;
						test[nextRow][nextCol] = 2;
						queue.offer(new Point(nextRow, nextCol));
					}
				}
			}

			int temp = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (test[n][m] == 0) {
						temp++;
					}
				}
			}
			answer = Math.max(answer, temp);
			return;
		}

		for (int i = start; i < space.size(); i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}

	}

	private static boolean check(int row, int col) {
		return ((0 <= row && row < N) && (0 <= col && col < M));
	}
}

class Point {
	int row;
	int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
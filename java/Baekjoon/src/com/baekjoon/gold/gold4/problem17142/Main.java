package com.baekjoon.gold.gold4.problem17142;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, P, answer, total;
	static int[][] map;
	static List<Point> list;
	static int[] numbers;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		list = new ArrayList<>();
		total = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Point(i, j, 0));
					map[i][j] = -2; // 비활성 바이러스
				}
				if (map[i][j] == 1) {
					map[i][j] = -1; // 벽
				}
				if (map[i][j] == 0) {
					total++; // 빈 공간
				}
			}
		}

		P = list.size();
		numbers = new int[M];
		answer = Integer.MAX_VALUE;
		
		if(total == 0) {
			answer = 0;
		}
		else {
			comb(0, 0);
		}

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {
		if (cnt == M) {

			int[][] test = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					test[i][j] = map[i][j];
				}
			}

			boolean[][] visited = new boolean[N][N];
			Queue<Point> queue = new ArrayDeque<>();
			int zero = total;
			int temp = -1;

			for (int i = 0; i < M; i++) {
				Point point = list.get(numbers[i]);
				visited[point.r][point.c] = true;
				queue.offer(point);
			}

			que:
			while (!queue.isEmpty()) {
				Point cur = queue.poll();

				int r = cur.r;
				int c = cur.c;
				int depth = cur.depth;

				for (int idx = 0; idx < 4; idx++) {
					int nextR = r + dx[idx];
					int nextC = c + dy[idx];

					if (!((0 <= nextR && nextR < N) && (0 <= nextC && nextC < N))) {
						continue;
					}
					if (visited[nextR][nextC] || test[nextR][nextC] == -1) {
						continue;
					}

					if (test[nextR][nextC] == 0) {
						zero--;
						if (zero == 0) {
							temp = depth + 1;
							break que;
						}
					}
					visited[nextR][nextC] = true;
					queue.offer(new Point(nextR, nextC, depth + 1));

				}

			}

			if (temp != -1) {
				answer = Math.min(temp, answer);
			}
			return;
		}

		for (int i = start; i < P; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}

	}
}

class Point {
	int r;
	int c;
	int depth;

	public Point(int r, int c, int depth) {
		this.r = r;
		this.c = c;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", depth=" + depth + "]";
	}

}

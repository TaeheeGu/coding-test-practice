package com.swea.d5.problem7793;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static char[][] map;
	static boolean[][] visited, destroyed;
	static int[][] move;
	static Queue<Point> start, deviles;

	static final char START = 'S';
	static final char END = 'D';
	static final char DEVIL = '*';
	static final char ROCK = 'X';
	static final char SPACE = '.';

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			start = new ArrayDeque<Point>();
			Point end = null;
			deviles = new ArrayDeque<Point>();

			move = new int[N][M];
			visited = new boolean[N][M];
			destroyed = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				char[] split = in.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = split[j];
					if (map[i][j] == START) {
						visited[i][j] = true;
						move[i][j] = 0;
						start.offer(new Point(i, j, 0));
						map[i][j] = SPACE;
					}
					if (map[i][j] == END) {
						end = new Point(i, j, 0);
					}
					if (map[i][j] == DEVIL) {
						destroyed[i][j] = true;
						deviles.offer(new Point(i, j));
					}
				}
			}

			while (!start.isEmpty()) {
				skill();
				moving();
			}

			int answer = move[end.r][end.c];
			if (answer != 0) {
				sb.append(answer);
			} else {
				sb.append("GAME OVER");
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void moving() {
		int cnt = start.size();

		for (int i = 0; i < cnt; i++) {
			Point cur = start.poll();
			int row = cur.r;
			int col = cur.c;
			int depth = cur.depth;

			for (int idx = 0; idx < 4; idx++) {
				int nextR = row + dx[idx];
				int nextC = col + dy[idx];

				if (!checking(nextR, nextC) || visited[nextR][nextC]) {
					continue;
				}

				if (map[nextR][nextC] == SPACE) {
					visited[nextR][nextC] = true;
					move[nextR][nextC] = depth + 1;
					start.offer(new Point(nextR, nextC, depth + 1));
				}
				if (map[nextR][nextC] == END) {
					visited[nextR][nextC] = true;
					move[nextR][nextC] = depth + 1;
					start.clear();
					return;
				}
			}
		}

	}

	private static void skill() {
		int cnt = deviles.size();

		for (int i = 0; i < cnt; i++) {
			Point cur = deviles.poll();
			int row = cur.r;
			int col = cur.c;

			for (int idx = 0; idx < 4; idx++) {
				int nextR = row + dx[idx];
				int nextC = col + dy[idx];

				if (checking(nextR, nextC) && !destroyed[nextR][nextC] && map[nextR][nextC] == SPACE) {
					destroyed[nextR][nextC] = true;
					map[nextR][nextC] = DEVIL;
					deviles.offer(new Point(nextR, nextC));
				}
			}
		}

	}

	private static boolean checking(int r, int c) {
		return ((0 <= r && r < N) && (0 <= c && c < M));
	}
}

class Point {
	int r;
	int c;
	int depth;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public Point(int r, int c, int depth) {
		this.r = r;
		this.c = c;
		this.depth = depth;
	}

}
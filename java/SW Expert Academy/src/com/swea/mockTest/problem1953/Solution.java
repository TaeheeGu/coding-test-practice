package com.swea.mockTest.problem1953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, R, C, L, answer;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> queue;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 0;
			visited = new boolean[N][M];
			bfs();

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void bfs() {
		queue = new ArrayDeque<>();
		queue.offer(new Point(R, C, 1));
		visited[R][C] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			int depth = cur.depth;

			if (depth > L) {
				break;
			}

			answer++;

			int curType = map[r][c];
			for (int dir = 0; dir < 4; dir++) {
				int nextR = r + dx[dir];
				int nextC = c + dy[dir];

				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || visited[nextR][nextC]
						|| map[nextR][nextC] == 0) {
					continue;
				}

				int nextType = map[nextR][nextC];
				if (curType == 1) {
					// 상
					if (dir == 0) {
						checkingUp(nextType, nextR, nextC, depth + 1);
					}
					// 하
					if (dir == 1) {
						checkingDown(nextType, nextR, nextC, depth + 1);
					}
					// 좌
					if (dir == 2) {
						checkingLeft(nextType, nextR, nextC, depth + 1);
					}
					// 우
					if (dir == 3) {
						checkingRIght(nextType, nextR, nextC, depth + 1);
					}
				}
				if (curType == 2) {
					// 상
					if (dir == 0) {
						checkingUp(nextType, nextR, nextC, depth + 1);
					}
					// 하
					if (dir == 1) {
						checkingDown(nextType, nextR, nextC, depth + 1);
					}
				}
				if (curType == 3) {
					// 좌
					if (dir == 2) {
						checkingLeft(nextType, nextR, nextC, depth + 1);
					}
					// 우
					if (dir == 3) {
						checkingRIght(nextType, nextR, nextC, depth + 1);
					}
				}
				if (curType == 4) {
					// 상
					if (dir == 0) {
						checkingUp(nextType, nextR, nextC, depth + 1);
					}
					// 우
					if (dir == 3) {
						checkingRIght(nextType, nextR, nextC, depth + 1);
					}

				}
				if (curType == 5) {
					// 하
					if (dir == 1) {
						checkingDown(nextType, nextR, nextC, depth + 1);
					}
					// 우
					if (dir == 3) {
						checkingRIght(nextType, nextR, nextC, depth + 1);
					}

				}
				if (curType == 6) {
					// 하
					if (dir == 1) {
						checkingDown(nextType, nextR, nextC, depth + 1);
					}
					// 좌
					if (dir == 2) {
						checkingLeft(nextType, nextR, nextC, depth + 1);
					}

				}
				if (curType == 7) {
					// 상
					if (dir == 0) {
						checkingUp(nextType, nextR, nextC, depth + 1);
					}
					// 좌
					if (dir == 2) {
						checkingLeft(nextType, nextR, nextC, depth + 1);
					}
				}

			}

		}

	}

	private static void checkingRIght(int nextType, int nextR, int nextC, int depth) {
		if (nextType == 1 || nextType == 3 || nextType == 6 || nextType == 7) {
			visited[nextR][nextC] = true;
			queue.offer(new Point(nextR, nextC, depth));
		}

	}

	private static void checkingLeft(int nextType, int nextR, int nextC, int depth) {
		if (nextType == 1 || nextType == 3 || nextType == 4 || nextType == 5) {
			visited[nextR][nextC] = true;
			queue.offer(new Point(nextR, nextC, depth));
		}

	}

	private static void checkingDown(int nextType, int nextR, int nextC, int depth) {
		if (nextType == 1 || nextType == 2 || nextType == 4 || nextType == 7) {
			visited[nextR][nextC] = true;
			queue.offer(new Point(nextR, nextC, depth));
		}

	}

	private static void checkingUp(int nextType, int nextR, int nextC, int depth) {
		if (nextType == 1 || nextType == 2 || nextType == 5 || nextType == 6) {
			visited[nextR][nextC] = true;
			queue.offer(new Point(nextR, nextC, depth));
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

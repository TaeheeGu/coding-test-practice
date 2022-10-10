package com.baekjoon.gold.gold2.problem4991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final char CLEAN = '.';
	static final char DIRTY = '*';
	static final char FURNITURE = 'x';
	static final char START = 'o';

	static int W, H, answer;
	static int[][] map;
	static boolean[][][] visited;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0) {
				break;
			}

			map = new int[H][W];
			int cnt = 0;
			Point start = null;
			for (int h = 0; h < H; h++) {
				char[] split = in.readLine().toCharArray();
				for (int w = 0; w < W; w++) {
					if (split[w] == START) {
						start = new Point(h, w, 0, 0);
					}
					if (split[w] == FURNITURE) {
						map[h][w] = -1;
					}
					if (split[w] == DIRTY) {
						map[h][w] = ++cnt;
					}

				}
			}

			answer = Integer.MAX_VALUE;
			bfs(start, cnt);

			answer = answer == Integer.MAX_VALUE ? -1 : answer;

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void bfs(Point start, int count) {
		visited = new boolean[H][W][1 << count];
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start.r][start.c][0] = true;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int r = cur.r;
			int c = cur.c;
			int cnt = cur.cnt;
			int depth = cur.depth;

			for (int idx = 0; idx < 4; idx++) {
				int nextR = r + dx[idx];
				int nextC = c + dy[idx];

				if (nextR < 0 || nextR >= H || nextC < 0 || nextC >= W || visited[nextR][nextC][cnt]) {
					continue;
				}

				int currnet = map[nextR][nextC];

				if (currnet == -1) {
					continue;
				}
				if (currnet == 0) {
					visited[nextR][nextC][cnt] = true;
					queue.offer(new Point(nextR, nextC, cnt, depth + 1));
					continue;
				}
				if (currnet != 0 && currnet != -1) {
					int newCnt = 1 << currnet - 1 | cnt;
					
					if (1 << count == newCnt + 1) {
						answer = Math.min(answer, depth + 1);
					} else {
						visited[nextR][nextC][newCnt] = true;
						queue.offer(new Point(nextR, nextC, newCnt, depth + 1));
					}
				}

			}

		}

	}
}

class Point {
	int r;
	int c;
	int cnt;
	int depth;

	public Point(int r, int c, int cnt, int depth) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.depth = depth;
	}
}

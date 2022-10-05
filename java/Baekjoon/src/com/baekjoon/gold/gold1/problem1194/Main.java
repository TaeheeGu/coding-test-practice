package com.baekjoon.gold.gold1.problem1194;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 골드 1, 1194 - 달이 차오른다, 가자
public class Main {

	static int N, M, answer;
	static char[][] map;
	static boolean[][][] visited;

	static final char SPACE = '.';
	static final char WALL = '#';
	static final char OUT = '1';

	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		int startRow = -1;
		int startCol = -1;

		for (int i = 0; i < N; i++) {
			char[] split = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = split[j];
				if (map[i][j] == '0') {
					startRow = i;
					startCol = j;
				}
			}
		}

		answer = Integer.MAX_VALUE;
		visited = new boolean[N][M][64];
		bfs(startRow, startCol);

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void bfs(int r, int c) {
		visited[r][c][0] = true;
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(r, c, 0, 0));

		while (!queue.isEmpty()) {

			Point cur = queue.poll();
			int row = cur.r;
			int col = cur.c;
			int depth = cur.depth;
			int keys = cur.keys;

//			System.out.println(cur.toString());

			if (answer < depth) {
				return;
			}

			for (int idx = 0; idx < 4; idx++) {
				int nextR = row + dx[idx];
				int nextC = col + dy[idx];

				if (checking(nextR, nextC) && !visited[nextR][nextC][keys] && map[nextR][nextC] != WALL) {
					char next = map[nextR][nextC];

					if (next == SPACE || next == '0') {
						visited[nextR][nextC][keys] = true;
						queue.offer(new Point(nextR, nextC, depth + 1, keys));
					}
					// 출구인 경우
					if (next == OUT) {
//						System.out.println("도착 row: " + nextR + " col: " + nextC + " depth: " + (depth + 1) + " keys " + keys);
						answer = Math.min(answer, depth + 1);
						return;
					}
					// 문인 경우
					if ('A' <= next && next <= 'F') {
						int door = 1 << (next - 'A');
						if ((keys & door) > 0) {
							visited[nextR][nextC][keys] = true;
							queue.offer(new Point(nextR, nextC, depth + 1, keys));
						}
					}
					// 열쇠 경우
					if ('a' <= next && next <= 'f') {
						int newKey = 1 << (next - 'a');
						newKey = newKey | keys;

						// 새로운 키를 가지고 탐색한 적이 없는 경우
						if (!visited[nextR][nextC][newKey]) {
							visited[nextR][nextC][keys] = true;
							visited[nextR][nextC][newKey] = true;
							queue.offer(new Point(nextR, nextC, depth + 1, newKey));
						}
					}
				}
			}

		}

	}

	private static boolean checking(int row, int col) {
		return ((0 <= row && row < N) && (0 <= col && col < M));
	}
}

class Point {
	int r;
	int c;
	int depth;
	int keys;

	public Point(int r, int c, int depth, int keys) {
		this.r = r;
		this.c = c;
		this.depth = depth;
		this.keys = keys;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", depth=" + depth + ", keys=" + keys + "]";
	}

}

package com.swea.mockTest.problem2382;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int dx[] = { 0, -1, 1, 0, 0 }; // 0, 상, 하, 좌, 우
	static int dy[] = { 0, 0, 0, -1, 1 };
	static int N, M, K;
	static Bacteria[][] map;
	static Queue<Point> queue;

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
			K = Integer.parseInt(st.nextToken());

			map = new Bacteria[N][N];
			queue = new ArrayDeque<>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[r][c] = new Bacteria(size, dir, size);
				queue.offer(new Point(r, c));
			}

			for (int i = 1; i <= M; i++) {
				move();
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != null) {
						answer += map[i][j].size;
					}
				}
			}
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void move() {
		Bacteria[][] nextMap = new Bacteria[N][N];
		Queue<Point> nextQue = new ArrayDeque<>();
		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			int r = cur.r;
			int c = cur.c;
			int size = map[r][c].size;
			int dir = map[r][c].dir;

			int nextR = r + dx[dir];
			int nextC = c + dy[dir];

			// 가장 자리에 위치하게 되는 경우
			if (nextR == N - 1 || nextR == 0 || nextC == N - 1 || nextC == 0) {
				dir = changeDir(dir);
				size = size / 2;
			}

			if (size == 0) {
				continue;
			}

			// 다음 위치에 다른 군집이 있는 경우
			if (nextMap[nextR][nextC] != null) {
				// 기존의 값의 합
				int totalSize = nextMap[nextR][nextC].size;
				totalSize = size + totalSize;
				// 기존 최댓값
				int preSize = nextMap[nextR][nextC].preSize;

				// 기존의 값이 큰 경우 기존의 방향 유지
				if (preSize > size) {
					dir = nextMap[nextR][nextC].dir;
				} else {
					preSize = size;
				}
				nextMap[nextR][nextC] = new Bacteria(totalSize, dir, preSize);
			}
			// 다음 위치에 다른 군집이 없는 경우, 다음 방문을 위해 큐에 삽입
			if (nextMap[nextR][nextC] == null) {
				nextQue.offer(new Point(nextR, nextC));
				nextMap[nextR][nextC] = new Bacteria(size, dir, size);
			}
		}
		map = nextMap;
		queue = nextQue;

	}

	private static int changeDir(int dir) {
		if (dir == 1) {
			return 2;
		}
		if (dir == 2) {
			return 1;
		}
		if (dir == 3) {
			return 4;
		}
		if (dir == 4) {
			return 3;
		}

		return 0;
	}

}

class Bacteria {
	int size;
	int dir;
	int preSize;

	public Bacteria(int size, int dir) {
		this.size = size;
		this.dir = dir;
	}

	public Bacteria(int size, int dir, int preSize) {
		this.size = size;
		this.dir = dir;
		this.preSize = preSize;
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

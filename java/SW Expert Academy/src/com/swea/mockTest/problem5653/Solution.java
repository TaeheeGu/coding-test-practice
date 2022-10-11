package com.swea.mockTest.problem5653;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K, answer;
	static Cell[][] map;
	static Queue<Point> queue;
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
			K = Integer.parseInt(st.nextToken());

			map = new Cell[N + 2 * K + 2][M + 2 * K + 2];
			queue = new ArrayDeque<>();
			for (int i = K + 1; i < N + K + 1; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = K + 1; j < M + K + 1; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life != 0) {
						Cell cell = new Cell(life, 0, life * 2, false);
						queue.offer(new Point(i, j));
						map[i][j] = cell;
					}
				}
			}

			answer = 0;
			for (int k = 1; k <= K; k++) {
				bfs(k);

//				System.out.println(k);
//				for (int i = 0; i < (N + 2 * K + 2); i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}
//				System.out.println();
			}

			for (int i = 0; i < (N + 2 * K + 2); i++) {
				for (int j = 0; j < (M + 2 * K + 2); j++) {
					if (map[i][j] != null && !map[i][j].isDead) {
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void bfs(int time) {

		Queue<Point> temp = new ArrayDeque<>();

		while (!queue.isEmpty()) {

			Point cur = queue.poll();
			int r = cur.r;
			int c = cur.c;

			int life = map[r][c].life;
			int currentLife = map[r][c].currentLife;
			boolean isDead = map[r][c].isDead;

			// 이미 죽은 세포
			if (isDead) {
				continue;
			}
			// 이미 번식한 경우
			if (currentLife > 0) {
				map[r][c].currentLife -= 1;
				temp.offer(new Point(r, c));

			}

			// 아직 번식하지 않은 경우
			if (currentLife == life) {
				// 번식
				for (int idx = 0; idx < 4; idx++) {
					int nextR = r + dx[idx];
					int nextC = c + dy[idx];

					// 이미 번식한 세포가 있는 경우
					if (map[nextR][nextC] != null) {
						if (time == map[nextR][nextC].creatTime) {
							map[nextR][nextC].life = Math.max(map[nextR][nextC].life, life);
							map[nextR][nextC].currentLife = map[nextR][nextC].life * 2;
						}
					}
					// 빈 칸인 경우
					if (map[nextR][nextC] == null) {
						Cell newCell = new Cell(life, time, life * 2, false);
						map[nextR][nextC] = newCell;
						temp.offer(new Point(nextR, nextC));
					}
				}
			}
			// 이미 번식하고 남은 생명력을 다쓴 경우
			if (map[r][c].currentLife == 0) {
				map[r][c].isDead = true;
			}
		}

		queue = temp;
	}
}

class Cell {
	int life;
	int creatTime;
	int currentLife;
	boolean isDead;

	public Cell(int life, int creatTime, int currentLife, boolean isDead) {
		this.life = life;
		this.creatTime = creatTime;
		this.currentLife = currentLife;
		this.isDead = isDead;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isDead);
		return builder.toString();
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
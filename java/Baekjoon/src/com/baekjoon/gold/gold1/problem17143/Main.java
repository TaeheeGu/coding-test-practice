package com.baekjoon.gold.gold1.problem17143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BJ 골드 1, 17143 - 낚시왕
public class Main {

	static int R, C, M, answer;
	static int[] dx = { 0, -1, 1, 0, 0 }; // 1번 인덱스부터 사용
	static int[] dy = { 0, 0, 0, 1, -1 }; // 0, 위, 아래, 오른쪽, 왼쪽
	static Shark[][] map;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken()); // row
		C = Integer.parseInt(st.nextToken()); // col
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(r, c, s, d, z);
			map[r][c] = shark;
		}

		answer = 0;
		for (int i = 1; i <= C; i++) {
			fishing(i);
			move();
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void move() {
		Shark[][] nextMap = new Shark[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {

				Shark shark = map[i][j];

				if (shark == null) {
					continue;
				}

				int dir = shark.d;
				int nextR = shark.r;
				int nextC = shark.c;

				if (dir == 3 || dir == 4) {
					nextC = shark.c + (dy[dir] * shark.s);
					while (!(1 <= nextC && nextC <= C)) {
						if (nextC < 1) {
							nextC = 1 + Math.abs(1 - nextC);
							dir = 3;
						}
						if (nextC > C) {
							nextC = C - (nextC - C);
							dir = 4;
						}
					}

				}
				if (dir == 1 || dir == 2) {
					nextR = shark.r + (dx[dir] * shark.s);
					while (!(1 <= nextR && nextR <= R)) {
						if (nextR < 1) {
							nextR = 1 + Math.abs(1 - nextR);
							dir = 2;
						}
						if (nextR > R) {
							nextR = R - (nextR - R);
							dir = 1;
						}
					}
				}

				Shark nextShark = new Shark(nextR, nextC, shark.s, dir, shark.z);

				if (nextMap[nextR][nextC] == null) {
					nextMap[nextR][nextC] = nextShark;
					continue;
				}
				if (nextMap[nextR][nextC].z < nextShark.z) {
					nextMap[nextR][nextC] = nextShark;
				}
			}
		}
		map = nextMap;
	}

	private static void fishing(int col) {
		for (int i = 1; i <= R; i++) {
			if (map[i][col] != null) {
				answer += map[i][col].z;
				map[i][col] = null;
				return;
			}
		}
	}
}

class Shark {
	int r;
	int c;
	int s; // 속력
	int d; // 이동 방향
	int z; // 크기

	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public String toString() {
		return "Shark s=" + s + ", z=" + z;
	}

}

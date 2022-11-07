package com.baekjoon.gold.gold4.problem17144;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static List<Integer> clearner;

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		clearner = new ArrayList<>(); // 공기 청정기 위치

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				int cur = Integer.parseInt(st.nextToken());

				map[i][j] = cur;

				if (cur == -1) {
					clearner.add(i);
				}
			}
		}

		for (int i = 0; i < T; i++) {
			map = spread(map);
			map = clear(map);
//
//			for (int j = 0; j < R; j++) {
//				System.out.println(Arrays.toString(map[j]));
//			}
		}

		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					answer += map[i][j];
				}
			}
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static int[][] clear(int[][] map) {

		map[clearner.get(0) - 1][0] = 0;
		for (int r = clearner.get(0) - 1; r > 0; r--) {
			map[r][0] = map[r - 1][0];
		}
		for (int c = 0; c < C - 1; c++) {
			map[0][c] = map[0][c + 1];
		}
		for (int r = 0; r < clearner.get(0); r++) {
			map[r][C - 1] = map[r + 1][C - 1];
		}
		for (int c = C - 1; c > 1; c--) {
			map[clearner.get(0)][c] = map[clearner.get(0)][c - 1];
		}
		map[clearner.get(0)][1] = 0;

		map[clearner.get(1) + 1][0] = 0;
		for (int r = clearner.get(1) + 1; r < R - 1; r++) {
			map[r][0] = map[r + 1][0];
		}
		for (int c = 0; c < C - 1; c++) {
			map[R - 1][c] = map[R - 1][c + 1];
		}
		for (int r = R - 1; r > clearner.get(1); r--) {
			map[r][C - 1] = map[r - 1][C - 1];
		}
		for (int c = C - 1; c > 1; c--) {
			map[clearner.get(1)][c] = map[clearner.get(1)][c - 1];
		}

		map[clearner.get(1)][1] = 0;

		return map;
	}

	private static int[][] spread(int[][] map) {
		int[][] next = new int[R][C];
		next[clearner.get(0)][0] = -1;
		next[clearner.get(1)][0] = -1;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int val = map[r][c];
				if (val > 0) {
					int temp = val / 5;
					int cnt = 0;

					for (int i = 0; i < 4; i++) {
						int nextR = r + dx[i];
						int nextC = c + dy[i];
						if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
							continue;
						}
						if (map[nextR][nextC] == -1) {
							continue;
						}
						next[nextR][nextC] += temp;
						cnt++;
					}

					next[r][c] += val - temp * cnt;
				}
			}
		}

		return next;
	}
}
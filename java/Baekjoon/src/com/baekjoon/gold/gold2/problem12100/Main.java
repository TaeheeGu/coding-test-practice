package com.baekjoon.gold.gold2.problem12100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

xxx
public class Main {

	static int N, answer;
	static int[][] board, test;
	static boolean[][] used;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[5]; // 5번 이동 가능
		answer = 0;
		repetitionPerm(0); // 중복 순열

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void repetitionPerm(int cnt) {
		if (cnt == 5) {
			copy(); // 각 단위에서 사용될 보드, 원본 유지
			for (int i = 0; i < 5; i++) {
				int dir = numbers[i];
				game(dir); // 정해진 방향으로 이동

			}
			findMax(); // 이동 종료 후 최댓값 탐색
			return;
		}

		for (int i = 0; i < 4; i++) {
			numbers[cnt] = i;
			repetitionPerm(cnt + 1);
		}

	}

	private static void findMax() {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp = Math.max(temp, test[i][j]);
			}
		}
		answer = Math.max(answer, temp);
	}

	private static void game(int dir) {

		used = new boolean[N][N];

		// 위로 이동하는 경우 0행부터 올린다.
		if (dir == 0) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (test[r][c] == 0) {
						continue;
					}
					moving(r, c, dir);
				}
			}
			return;
		}

		// 아래로 이동하는 경우 N-1행부터 내린다.
		if (dir == 1) {
			for (int r = N - 1; r >= 0; r--) {
				for (int c = 0; c < N; c++) {
					if (test[r][c] == 0) {
						continue;
					}
					moving(r, c, dir);
				}
			}
			return;
		}

		// 왼쪽로 이동하는 경우 0열부터 왼쪽 이동
		if (dir == 2) {
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					if (test[r][c] == 0) {
						continue;
					}
					moving(r, c, dir);
				}
			}
			return;
		}

		// 오른쪽으로 이동하는 경우 N-1열 부터 오른쪽 이동
		if (dir == 3) {
			for (int c = N - 1; c >= 0; c--) {
				for (int r = 0; r < N; r++) {
					if (test[r][c] == 0) {
						continue;
					}
					moving(r, c, dir);
				}
			}
			return;
		}
	}

	private static void moving(int r, int c, int dir) {
		int curR = r;
		int curC = c;
		while (true) {
			int nextR = curR + dx[dir];
			int nextC = curC + dy[dir];

			if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N || used[nextR][nextC]
					|| test[nextR][nextC] != test[curR][curC]) {
				break;
			}
			// 다음 위치가 비어있는 경우
			if (test[nextR][nextC] == 0) {
				test[nextR][nextC] = test[curR][curC];
				test[curR][curC] = 0;

				curR = nextR;
				curC = nextC;
				continue;
			}

			// 다음 위치의 블록과 현재 블록의 값이 같고 합쳐진적이 없다면
			if (test[nextR][nextC] == test[curR][curC] && !used[nextR][nextC]) {
				test[nextR][nextC] = test[curR][curC] * 2;
				test[curR][curC] = 0;
				used[nextR][nextC] = true;
				break;
			}

		}
	}

	private static void copy() {
		test = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				test[i][j] = board[i][j];
			}
		}
	}
}

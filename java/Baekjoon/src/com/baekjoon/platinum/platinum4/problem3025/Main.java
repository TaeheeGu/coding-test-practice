package com.baekjoon.platinum.platinum4.problem3025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 백준, 3025번, 돌 던지기, 플래티넘4
// https://www.acmicpc.net/problem/3025
time overflow
public class Main {

	private static int R, C;
	private static char[][] board;

	private static Point[] dp;
	private static Obstacle[] obstacles;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];

		obstacles = new Obstacle[C];
		for (int i = 0; i < C; i++) {
			obstacles[i] = new Obstacle(i);
		}

		for (int i = 0; i < R; i++) {
			char[] split = in.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = split[j];
				if (board[i][j] == 'X') {
					obstacles[j].rows.add(i);
				}

			}
		}

		int N = Integer.parseInt(in.readLine());

		dp = new Point[C];

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(in.readLine()) - 1; // 열 번호는 1번부터 시작
			if (dp[n] == null) {
				move(0, n, n);
			} else {
				int r = dp[n].r;
				int c = dp[n].c;

				move(r, c, n);
			}
//			move(0, n, n);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void move(int r, int c, int init) {

		if (obstacles[c].rows.isEmpty()) {
			board[R - 1][c] = 'O';
			obstacles[c].rows.add(R - 1);
			if (dp[init] == null) {
				dp[init] = new Point(R - 2, c);
//				System.out.println("1 " + init + " - " + dp[init].r +  " : " + dp[init].c);
			}
			else if(R - 1 > dp[init].r) {
				dp[init] = new Point(R - 2, c);
//				System.out.println("2 " + init + " - " + dp[init].r +  " : " + dp[init].c);
			}

		} else {
			Collections.sort(obstacles[c].rows);
			if (r > obstacles[c].rows.get(obstacles[c].rows.size() - 1)) {
				board[R - 1][c] = 'O';
				obstacles[c].rows.add(R - 1);
				
				if (dp[init] == null) {
					dp[init] = new Point(R - 2, c);
//					System.out.println("3 " + init + " - " + dp[init].r +  " : " + dp[init].c);
				}
				
				else if(R - 1 > dp[init].r + 1) {
					dp[init] = new Point(R - 2, c);
//					System.out.println("4 " + init + " - " + dp[init].r +  " : " + dp[init].c);
				}
				
			} else {

				for (int i = 0; i < obstacles[c].rows.size(); i++) {
					int oR = obstacles[c].rows.get(i);

					if (r <= oR) {
						if (board[oR][c] == 'X') {
							board[oR - 1][c] = 'O';
							obstacles[c].rows.add(oR - 1);
							if (dp[init] == null) {
								dp[init] = new Point(oR - 2, c);
//								System.out.println("5 " + init + " - " + dp[init].r +  " : " + dp[init].c);
							}
							else if(oR - 1 > dp[init].r + 1) {
								dp[init] = new Point(oR - 2, c);
//								System.out.println("6 " + init + " - " + dp[init].r +  " : " + dp[init].c);
							}

						} else if (board[oR][c] == 'O') {
							if (check(oR - 1, c - 1) && board[oR - 1][c - 1] == '.' && check(oR, c - 1)
									&& board[oR][c - 1] == '.') {

								move(oR, c - 1, init);

							} else if (check(oR - 1, c + 1) && board[oR - 1][c + 1] == '.' && check(oR, c + 1)
									&& board[oR][c + 1] == '.') {

								move(oR, c + 1, init);
							}
						}
						break;
					}
				}
			}
		}

		return;
	}

	private static boolean check(int r, int c) {

		if ((0 <= r && r < R) && (0 <= c && c < C)) {
			return true;
		}
		return false;
	}
}

class Point {
	public int r;
	public int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Obstacle {
	public List<Integer> rows = new ArrayList<>();
	public int col;

	public Obstacle(int col) {
		this.col = col;
	}
}

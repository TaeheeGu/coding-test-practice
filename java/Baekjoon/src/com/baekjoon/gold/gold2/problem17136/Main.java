package com.baekjoon.gold.gold2.problem17136;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 17136번, 색종이 붙이기, 골드2
// https://www.acmicpc.net/problem/17136
public class Main {

	private static int[][] board;
	private static int answer;
	private static int[] count = { 0, 5, 5, 5, 5, 5 }; // 1~5

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		board = new int[10][10];

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;

		solve(0, 0, 0);

		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void solve(int r, int c, int cnt) {

		if (r == 9 && c == 10) {
			answer = Math.min(answer, cnt);

			return;
		}

		if (cnt >= answer) {
			return;
		}

		if (c > 9) {
			solve(r + 1, 0, cnt);
			return;
		}

		if (board[r][c] == 1) {
			for (int w = 5; w >= 1; w--) {
				if (count[w] > 0 && check(r, c, w)) {
					
					count[w]--;
					attach(r, c, w, 0);
					solve(r, c + 1, cnt + 1);
					
					attach(r, c, w, 1);
					count[w]++;

				}
			}
		} else {
			solve(r, c + 1, cnt);
		}
	}

	private static boolean check(int r, int c, int w) {

		if ((0 <= r + w && r + w <= 10) && (0 <= c + w && c + w <= 10)) {
			for (int x = r; x < r + w; x++) {
				for (int y = c; y < c + w; y++) {
					if (board[x][y] == 0) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	private static void attach(int r, int c, int w, int state) {
		for (int x = r; x < r + w; x++) {
			for (int y = c; y < c + w; y++) {
				board[x][y] = state;

			}
		}
		return;
	}
}

package com.baekjoon.gold.gold4.problem17281;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static int[][] board;

	static int[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		board = new int[N + 1][10];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[10];
		visited = new boolean[10];
		answer = 0;

		numbers[4] = 1;
		visited[1] = true;

		perm(1);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {
		if (cnt == 4) {
			cnt++;
		}

		if (cnt == 10) {

			int hiiter = 1;
			int points = 0;

			for (int inning = 1; inning <= N; inning++) {
				int outCount = 0;
				boolean[] base = { false, false, false, false }; // 0, 1루, 2루, 3루
				while (outCount < 3) {

					if (hiiter == 10) {
						hiiter = 1;
					}

					if (board[inning][numbers[hiiter]] == 0) {
						outCount++;
						hiiter++;
						continue;
					}

					int hitting = board[inning][numbers[hiiter]];

					// 홈런
					if (hitting == 4) {
						points++;
						for (int i = 1; i < 4; i++) {
							if (base[i]) {
								base[i] = false;
								points++;
							}
						}
						hiiter++;
						continue;
					}

					// 안타
					for (int i = 3; i >= 1; i--) {
						if (base[i]) { // 주자가 있는 경우
							if (i + hitting >= 4) {
								points++;
							} else {
								base[i + hitting] = true;
							}
							base[i] = false;
						}
					}
					hiiter++;
					base[hitting] = true;

				}
			}

			answer = Math.max(answer, points);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				numbers[cnt] = i;
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}
}

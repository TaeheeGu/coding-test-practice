package com.swea.d4.problem1210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1210번, [S/W 문제해결 기본] 2일차 - Ladder1 D4
public class Solution {

	public static final int len = 100;

	public static int[] dx = { 0, 0, -1 }; // 좌 - 0, 우 - 1, 상 - 2
	public static int[] dy = { -1, 1, 0 };

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = 10; // test_case 개수

		for (int t = 1; t <= T; t++) {
			int test_case = Integer.parseInt(in.readLine());

			sb.append("#" + test_case + " ");

			int[][] map = new int[len][len];

			int ans = -1;

			for (int i = 0; i < len; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < len; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			loop: for (int col = 0; col < len; col++) {
				int row = len - 1;

				if (map[row][col] != 2) {
					continue;
				}

				int newRow = row;
				int newCol = col;
				int direction = 2;

				while (true) {
					if (newRow == 0) {
						ans = newCol;
						break loop;
					}
					for (int idx = 0; idx < 3; idx++) {

						if (direction == 0 && idx == 1) {
							continue;
						}

						if (direction == 1 && idx == 0) {
							continue;
						}

						if ((newRow + dx[idx]) < 0 || (newRow + dx[idx]) > len - 1 || (newCol + dy[idx]) < 0
								|| (newCol + dy[idx]) > len - 1) {
							continue;
						}

						if (map[newRow + dx[idx]][newCol + dy[idx]] == 1) {
							direction = idx;
							newRow += dx[idx];
							newCol += dy[idx];
							break;
						}
					}
				}
			}
			sb.append(ans + "\n");
		}
		out.write(sb.toString());
		out.close();
	}
}

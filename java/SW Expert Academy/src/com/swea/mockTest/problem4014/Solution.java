package com.swea.mockTest.problem4014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N, X, answer;
	static int[][] map;

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
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 0;
			for (int i = 0; i < N; i++) {
				checkRow(i);
				checkCol(i);
			}

			sb.append(answer).append("\n");
		}
		out.write(sb.toString());
		out.close();
	}

	private static void checkRow(int row) {
		int pre = 1;
		int post = 0;
		int height = map[row][0];
		boolean flag = false;
		boolean isPossible = true;

		for (int col = 1; col < N; col++) {
			int cur = map[row][col];

			// 현재 위치의 높이와 기존의 높이가 2이상 차이나는 경우
			if (Math.abs(cur - height) >= 2) {
				isPossible = false;
				break;
			}

			// 현재 위치 높이와 기존의 높이가 같은 경우
			if (height == cur) {
				if (flag) {
					post++;
					if (post == X) {
						isPossible = true;
						flag = false;
						post = 0;
					}
					continue;
				}
				pre++;
				continue;
			}

			// 현재 위치 높이가 기존의 높이보다 큰 경우
			if (cur > height) {
				// 앞서 높이의 길이가 경사로 건설 높이보다 작은 경우
				if (pre < X) {
					isPossible = false;
					break;
				}
				// 경사로 건설 후 현재 높이를 기준으로 탐색
				height = cur;
				pre = 1;
				continue;
			}

			// 현재 높이가 기존의 높이보다 낮은 경우
			if (cur < height) {
				if (flag) {
					isPossible = false;
					break;
				}
				flag = true;
				isPossible = false;
				post = 1;
				pre = 0;
				height = cur;
			}
		}

		if (isPossible) {
			answer++;
		}
	}

	private static void checkCol(int col) {
		int pre = 1;
		int post = 0;
		int height = map[0][col];
		boolean flag = false;
		boolean isPossible = true;

		for (int row = 1; row < N; row++) {
			int cur = map[row][col];

			// 현재 위치의 높이와 기존의 높이가 2이상 차이나는 경우
			if (Math.abs(cur - height) >= 2) {
				isPossible = false;
				break;
			}

			// 현재 위치 높이와 기존의 높이가 같은 경우
			if (height == cur) {
				if (flag) {
					post++;
					if (post == X) {
						isPossible = true;
						flag = false;
						post = 0;
					}
					continue;
				}
				pre++;
				continue;
			}

			// 현재 위치 높이가 기존의 높이보다 큰 경우
			if (cur > height) {
				// 앞서 높이의 길이가 경사로 건설 높이보다 작은 경우
				if (pre < X) {
					isPossible = false;
					break;
				}
				// 경사로 건설 후 현재 높이를 기준으로 탐색
				height = cur;
				pre = 1;
				continue;
			}

			// 현재 높이가 기존의 높이보다 낮은 경우
			if (cur < height) {
				if (flag) {
					isPossible = false;
					break;
				}
				flag = true;
				isPossible = false;
				post = 1;
				pre = 0;
				height = cur;
			}
		}

		if (isPossible) {
			answer++;
		}
	}
}

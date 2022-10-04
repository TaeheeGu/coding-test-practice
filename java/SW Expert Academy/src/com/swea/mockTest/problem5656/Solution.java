package com.swea.mockTest.problem5656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 5656. [모의 SW 역량테스트] 벽돌 깨기
public class Solution {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, W, H;
	static int[][] arr;
	static int[][] test;
	static int temp;
	static int answer;
	static int[] numbers;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			arr = new int[H][W];
			int total = 0;

			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(in.readLine());
				for (int w = 0; w < W; w++) {
					arr[h][w] = Integer.parseInt(st.nextToken());
					if (arr[h][w] != 0) {
						total++;
					}
				}
			}

			numbers = new int[N];
			answer = Integer.MIN_VALUE;
			repetitionPerm(0, 0);

			answer = total - answer;

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void repetitionPerm(int start, int cnt) {
		if (cnt == N) {

			test = new int[H][W];
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					test[h][w] = arr[h][w];
				}
			}

			temp = 0;

			for (int i = 0; i < N; i++) {

				int col = numbers[i];
				visited = new boolean[H][W];

				for (int h = 0; h < H; h++) {
					if (test[h][col] != 0) {
						solve(h, col);
						break;
					}

				}

				gravity();
			}

			answer = Math.max(answer, temp);

			return;
		}

		for (int i = start; i < W; i++) {
			numbers[cnt] = i;
			repetitionPerm(start, cnt + 1);
		}
	}

	private static void gravity() {
		for (int h = 0; h < H - 1; h++) {
			for (int w = 0; w < W; w++) {
				if (test[h + 1][w] == 0) {

					for (int i = h + 1; i >= 1; i--) {
						test[i][w] = test[i - 1][w];
					}
					test[0][w] = 0;

				}
			}
		}

	}

	private static void solve(int row, int col) {
		if (test[row][col] == 0 || visited[row][col]) {
			return;
		}

		if (test[row][col] == 1) {
			visited[row][col] = true;
			test[row][col] = 0;
			temp++;
			return;

		}
		if (test[row][col] > 1) {
			visited[row][col] = true;

			for (int x = 1; x < test[row][col]; x++) {
				for (int idx = 0; idx < 4; idx++) {
					int nextRow = row + dx[idx] * x;
					int nextCol = col + dy[idx] * x;

					if (check(nextRow, nextCol) && !visited[nextRow][nextCol]) {
						solve(nextRow, nextCol);
					}
				}
			}

			test[row][col] = 0;
			temp++;
			return;

		}

	}

	private static boolean check(int row, int col) {
		return ((0 <= row && row < H) && (0 <= col && col < W));
	}
}

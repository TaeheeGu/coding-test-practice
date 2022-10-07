package com.baekjoon.gold.gold3.problem17779;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

xxx

public class Main {

	static int N, total, answer;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		map = new int[N + 1][N + 1];

		total = 0;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}

		System.out.println(total);

		answer = Integer.MAX_VALUE;
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if ((1 <= x && x < x + d1 + d2 && x + d1 + d2 <= N)
								&& (1 <= y - d1 && y - d1 < y && y < y + d2 && y + d2 <= N)) {
//							System.out.println(x + " " + y + " " + d1 + " " + d2);
							calc(x, y, d1, d2);
						}
					}
				}
			}
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void calc(int x, int y, int d1, int d2) {
		boolean[][] visited = new boolean[N + 1][N + 1];
		
		int[][] test = new int[N + 1][N + 1];
		
		/**
		 * 
		 * 경계선 안쪽도 체크, 방문하지 못하도록 작업 필요
		 * 
		 */

		// 경계선은 true로 체크
		for (int d = 0; d <= d1; d++) {
			int r = x + d;
			int c = y - d;
			visited[r][c] = true;
		}
		for (int d = 0; d <= d2; d++) {
			int r = x + d;
			int c = y + d;
			visited[r][c] = true;
		}
		for (int d = 0; d <= d2; d++) {
			int r = (x + d1) + d;
			int c = (y - d1) + d;
			visited[r][c] = true;
		}
		for (int d = 0; d <= d1; d++) {
			int r = (x + d2) + d;
			int c = (y + d2) - d;
			visited[r][c] = true;
		}

		int[] size = new int[5];

		// 1번 구역
		for (int r = 1; r < x + d1; r++) {
			for (int c = 1; c <= y; c++) {
				if (!visited[r][c]) {
					size[0] += map[r][c];
					test[r][c]= 1; 
				}
			}
		}

		// 2번 구역
		for (int r = 1; r <= x + d2; r++) {
			for (int c = y + 1; c <= N; c++) {
				if (!visited[r][c]) {
					size[1] += map[r][c];
					test[r][c]= 2; 
				}
			}
		}

		// 3번 구역
		for (int r = x + d1; r <= N; r++) {
			for (int c = 1; c < y - d1 + d2; c++) {
				if (!visited[r][c]) {
					size[2] += map[r][c];
					test[r][c]= 3; 
				}
			}
		}

		// 4번 구역
		for (int r = x + d2 + 1; r <= N; r++) {
			for (int c = y - d1 + d2; c <= N; c++) {
				if (!visited[r][c]) {
					size[3] += map[r][c];
					test[r][c]= 4; 
				}
			}
		}

		size[4] = total - (size[0] + size[1] + size[2] + size[3]);

		int min = size[0];
		int max = size[0];
		for (int i = 1; i < 5; i++) {
			min = Math.min(min, size[i]);
			max = Math.max(max, size[i]);
		}

		System.out.println(Arrays.toString(size) + " " + (size[0] + size[1] + size[2] + size[3] + size[4]));
		System.out.println(max + " " + min);
		System.out.println();
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(test[i]));
		}
		System.out.println();
		System.out.println("ans" + (max - min));
		answer = Math.min(answer, (max - min));
	}
}

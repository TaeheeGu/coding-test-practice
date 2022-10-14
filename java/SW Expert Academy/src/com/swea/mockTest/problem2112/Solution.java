package com.swea.mockTest.problem2112;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int D, W, K, answer;
	static int[][] film;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			dfs(0, 0);

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();

	}

	private static void dfs(int idx, int cnt) {
		if (checking()) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (cnt > answer) {
			return;
		}
		if (idx == D) {
			return;
		}

		dfs(idx + 1, cnt);

		int[] origin = new int[W];
		for (int w = 0; w < W; w++) {
			origin[w] = film[idx][w];
		}

		// 현재 막을 1로 변경
		for (int w = 0; w < W; w++) {
			film[idx][w] = 1;
		}
		dfs(idx + 1, cnt + 1);

		// 현재 막을 0으로 변경
		for (int w = 0; w < W; w++) {
			film[idx][w] = 0;
		}
		dfs(idx + 1, cnt + 1);

		// 현재 막 변경 없음
		for (int w = 0; w < W; w++) {
			film[idx][w] = origin[w];
		}

	}

	private static boolean checking() {

		for (int w = 0; w < W; w++) {
			boolean check = false;
			int temp = 1;

			for (int d = 1; d < D; d++) {
				if (film[d - 1][w] == film[d][w]) {
					temp++;
				} else {
					temp = 1;
				}
				if (temp == K) {
					check = true;
					break;
				}
			}

			if (!check) {
				return false;
			}
		}

		return true;
	}
}

package com.baekjoon.gold.gold4.problem1915;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][M + 1];
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			char[] split = in.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = split[j - 1] - '0';
				if (arr[i][j] == 1) {
					int leftTop = arr[i - 1][j - 1];
					int top = arr[i - 1][j];
					int left = arr[i][j - 1];

					if (leftTop != 0 && top != 0 && left != 0) {
						arr[i][j] = Math.min(Math.min(leftTop, top), left) + 1;
					} else {
						arr[i][j] = 1;
					}
					answer = Math.max(arr[i][j], answer);
				}
			}
		}

		sb.append(answer * answer);
		out.write(sb.toString());
		out.close();
	}
}

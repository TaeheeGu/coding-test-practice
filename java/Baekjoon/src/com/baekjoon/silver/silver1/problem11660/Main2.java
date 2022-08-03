package com.baekjoon.silver.silver1.problem11660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/** 반복횟수 줄이기!!!! **/
public class Main2 {

	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		// N과 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 2차원 배열 생성
		// 사직은 (1, 1)
		int[][] arr = new int[N + 1][N + 1];
		int[][] store = new int[N + 1][N + 1];

		// 2차원 배열에 데이터 입력
		for (int i = 1; i < N + 1; i++) {  // 10^6 = 1,000,000
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 누적 합 구하기
		for (int i = 1; i < N + 1; i++) {  // 10^6 = 1,000,000
			for (int j = 1; j < N + 1; j++) {
				// 해당 위치까지의 모든 원소의 합
				store[i][j] = store[i][j - 1] + store[i - 1][j] - store[i - 1][j - 1] + arr[i][j];
			}
		}

		for (int i = 0; i < M; i++) { // 100,000
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken()); // start
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); // end

			// 일반화 식으로 계산
			// (x2, y2) - (x1 - 1, y2) - (x2, y1 - 1) + (x1 - 1, y1 -1)
			int sum = store[x2][y2] - store[x1 - 1][y2] - store[x2][y1 - 1] + store[x1 - 1][y1 - 1];

			sb.append(sum).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}
}

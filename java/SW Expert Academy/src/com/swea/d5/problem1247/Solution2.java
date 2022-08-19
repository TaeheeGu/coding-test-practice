package com.swea.d5.problem1247;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 1247 - [S/W 문제해결 응용] 3일차 - 최적 경로, D5
// 
public class Solution2 {

	static int N;
	static int companyX, companyY, homeX, homeY;
	static int answer;

	static int[][] customers;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine());

			companyX = Integer.parseInt(st.nextToken()); // 출발
			companyY = Integer.parseInt(st.nextToken());

			homeX = Integer.parseInt(st.nextToken()); // 도착
			homeY = Integer.parseInt(st.nextToken());

			customers = new int[N][N];
			answer = Integer.MAX_VALUE;
			isSelected = new boolean[N];
			numbers = new int[N];

			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken()); // 고객 x 좌표
				customers[i][1] = Integer.parseInt(st.nextToken()); // 고객 y 좌표
			}

			// 순열로 고객의 방문 순서 결정
			// 결정된 방문 순서에 따른 거리 계산 비교
			perm(0, 0);
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt, int sum) {

		if (sum > answer) {
			return;
		}

		if (cnt == N) {
			sum += dist(customers[numbers[N - 1]][0], customers[numbers[N - 1]][1], homeX, homeY);

			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				continue;
			}
			int distance = 0;
			isSelected[i] = true;
			numbers[cnt] = i;

			if (cnt == 0) {
				distance = dist(companyX, companyY, customers[numbers[cnt]][0], customers[numbers[cnt]][1]);
			}
			else if (cnt > 0) {
				int fromX = customers[numbers[cnt - 1]][0];
				int fromY = customers[numbers[cnt - 1]][1];
				int toX = customers[numbers[cnt]][0];
				int toY = customers[numbers[cnt]][1];

				distance = dist(fromX, fromY, toX, toY);
			}

			perm(cnt + 1, sum + distance);
			isSelected[i] = false;

		}
	}

	private static int dist(int fromX, int fromY, int toX, int toY) {

		int distance = Math.abs(fromX - toX) + Math.abs(fromY - toY);

		return distance;
	}
}

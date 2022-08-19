package com.swea.d5.problem1247;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 1247 - [S/W 문제해결 응용] 3일차 - 최적 경로, D5
// 
public class Solution {

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
			perm(0);
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {

		if (cnt == N) {
			int temp = 0;
			temp += dist(companyX, companyY, customers[numbers[0]][0], customers[numbers[0]][1]);

			for (int i = 0; i < N - 1; i++) {
				int fromX = customers[numbers[i]][0];
				int fromY = customers[numbers[i]][1];
				int toX = customers[numbers[i + 1]][0];
				int toY = customers[numbers[i + 1]][1];

				temp += dist(fromX, fromY, toX, toY);
			}

			temp += dist(customers[numbers[N - 1]][0], customers[numbers[N - 1]][1], homeX, homeY);

			answer = Math.min(answer, temp);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				perm(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	private static int dist(int fromX, int fromY, int toX, int toY) {

		int distance = Math.abs(fromX - toX) + Math.abs(fromY - toY);

		return distance;
	}
}

package com.baekjoon.gold.gold5.problem15686;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//  BJ 15686 - 치킨 배달, 골드 5
// https://www.acmicpc.net/problem/15686
public class Main {

	static int N, M;

	static int homeIdx, chickenIdx;

	static int[][] home, chicken;

	static int[][] selectedChicken;
	
	static int min;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new int[2 * N][2];
		chicken = new int[13][2];

		homeIdx = 0;
		chickenIdx = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					home[homeIdx][0] = i;
					home[homeIdx][1] = j;
					homeIdx++;
				} else if (num == 2) {
					chicken[chickenIdx][0] = i;
					chicken[chickenIdx][1] = j;
					chickenIdx++;
				}
			}
		}

		selectedChicken = new int[M][2];
		min = Integer.MAX_VALUE;

		comb(0, 0);

		sb.append(min);
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {

		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < homeIdx; i++) {
				int distance = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int temp = Math.abs(home[i][0] - selectedChicken[j][0])
							+ Math.abs(home[i][1] - selectedChicken[j][1]);
					distance = Math.min(distance, temp);
				}
				sum += distance;
			}
			min = Math.min(sum, min);
			return;
		}

		for (int i = start; i < chickenIdx; i++) {
			selectedChicken[cnt] = chicken[i];
			comb(i + 1, cnt + 1);
		}
	}
}

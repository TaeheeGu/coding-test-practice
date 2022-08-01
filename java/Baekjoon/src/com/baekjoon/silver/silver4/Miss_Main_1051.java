package com.baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1051번 : 숫자 정사각형
// https://www.acmicpc.net/problem/1051
public class Miss_Main_1051 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 1;
		int size = 1;
		int maxSize = Math.min(n, m);
		int[] pointX = { 0, 0, 1, 1 }; // 왼위, 오위, 오아래, 왼아래
		int[] pointY = { 0, 1, 1, 0 };

		while (size < maxSize) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					pointY += 1;
				}
			}

			if (arr[pointX[0]][pointY[0]] == arr[pointX[1]][pointY[1]]
					&& arr[pointX[0]][pointY[0]] == arr[pointX[2]][pointY[2]]
					&& arr[pointX[0]][pointY[0]] == arr[pointX[3]][pointY[3]]) {
				answer = size;
			}
			size++;
		}

	}
}

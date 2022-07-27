package com.backjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1051번 : 숫자 정사각형
// https://www.acmicpc.net/problem/1051
public class Main_1051 {
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

		int answer = 0;
		int size = 1;
		int maxSize = Math.min(n, m);
		int[] pointX = { 0, 0, 0, 0 }; // 왼위, 오위, 오아래, 왼아래
		int[] pointY = { 0, 0, 0, 0 };

		while (size <= maxSize) {
			for(int i = 0; i < 4; i++) {
				int x = pointX[i];
				int y = pointY[i];
				
				if(x)
			}
			size++;
		}

	}
}

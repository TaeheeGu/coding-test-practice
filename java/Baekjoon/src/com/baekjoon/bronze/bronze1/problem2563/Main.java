package com.baekjoon.bronze.bronze1.problem2563;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2563번, 색종이, 브론즈1
// https://www.acmicpc.net/problem/2563
public class Main {
	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine()); // 색종이 수

		int[][] paper = new int[100][100];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			for (int x = X; x < X + 10; x++) {
				for (int y = Y; y < Y + 10; y++) {
					paper[x][y] = 1;
				}
			}
		}

		int area = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {
					area++;
				}
			}
		}
		sb.append(area);

		out.write(sb.toString());
		out.close();
	}
}

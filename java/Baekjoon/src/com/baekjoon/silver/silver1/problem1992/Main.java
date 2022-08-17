package com.baekjoon.silver.silver1.problem1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1992번, 쿼드트리, 실버1
// https://www.acmicpc.net/problem/1992
public class Main {

	static StringBuilder sb;

	static int[][] images;

	static int N;


	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		images = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] split = in.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				images[i][j] = split[j] - '0';
			}
		}

		divide(0, 0, N);

		out.write(sb.toString());
		out.close();
	}

	private static void divide(int startX, int startY, int size) {
		int temp = check(startX, startY, size);
		
		if (temp != -1) {
			sb.append(temp);
			return;
		}
		
		int half = size / 2;
		
		sb.append("(");
		
		divide(startX, startY, half); // 좌상
		divide(startX, startY + half, half); // 우상
		divide(startX + half, startY, half); // 좌하
		divide(startX + half, startY + half, half); // 우하
		
		sb.append(")");

	}

	private static int check(int startX, int startY, int size) {

		int temp = images[startX][startY];

		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (temp != images[i][j]) {
					return -1;
				}
			}
		}

		return temp;
	}
}

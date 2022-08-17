package com.baekjoon.silver.silver1.problem1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//1074번, Z, 실버1
//https://www.acmicpc.net/problem/1074
public class Main {
	private static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()); // 행
		int c = Integer.parseInt(st.nextToken()); // 열

		answer = 0;

		divide(r, c, N);

		
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void divide(int r, int c, int n) {
		int size = 1;
		for (int i = 0; i < n; i++) {
			size *= 2;
		}
		if(n == 0) {
			return;
		}

		if (r < size / 2 && c < size / 2) {
			answer += 0;
			divide(r, c, n - 1);
		}
		else if (r < size / 2 && c >= size / 2) {
			answer += size / 2 * size / 2;
			divide(r, (c - size / 2), n - 1);
		}
		else if (r >= size / 2 && c < size / 2) {
			answer += size / 2 * size / 2 * 2;
			divide((r - size / 2), c, n - 1);
		}
		else if (r >= size / 2 && c >= size / 2 ) {
			answer += size / 2 * size / 2 * 3;
			divide((r - size / 2), (c - size / 2), n - 1);
		}
	}

}

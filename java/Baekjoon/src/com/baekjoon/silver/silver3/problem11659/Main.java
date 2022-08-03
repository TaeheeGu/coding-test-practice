package com.baekjoon.silver.silver3.problem11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11659번, 구간 합 구하기4, Silver3
// https://www.acmicpc.net/problem/11659
public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합의 개수

		int[] arr = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) { // 100,000
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] store = new int[N + 1]; // 0개합, 1개합, 2개합, 3개합 ... N 개 합

		for (int i = 1; i < N + 1; i++) {
			store[i] = store[i - 1] + arr[i - 1];
		}

		for (int i = 0; i < M; i++) { // 100,000
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int sum = 0;

			sum = store[end] - store[start - 1]; // end까지의 합 - start-1까지의 합 = start ~ end 까지의 합

			sb.append(sum + "\n");
		}
		out.write(sb.toString());
		out.close();
	}
}

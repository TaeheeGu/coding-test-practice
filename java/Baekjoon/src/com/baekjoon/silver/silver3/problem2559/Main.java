package com.baekjoon.silver.silver3.problem2559;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2559번 ,수열 실버3
// https://www.acmicpc.net/problem/2559
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] temper = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < temper.length; i++) {
			temper[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;

		for (int i = 0; i < K; i++) {
			sum += temper[i];
		}

		int max = sum;

		for (int i = 0; i <  N - K; i++) {
			sum += temper[i + K] - temper[i];
			max = Math.max(max, sum);
		}

		sb.append(max);

		out.write(sb.toString());
		out.close();
	}
}

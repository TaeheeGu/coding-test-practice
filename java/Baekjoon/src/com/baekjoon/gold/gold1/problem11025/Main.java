package com.baekjoon.gold.gold1.problem11025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 11025번 , 요세푸스 문제 3, 골드 1
// https://www.acmicpc.net/problem/11025
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int num = 0;

		for (int i = 0; i < N; i++) {
			num = ((num + K - 1) % (i + 1)) + 1;
		}

		sb.append(num);

		out.write(sb.toString());
		out.close();
	}
}

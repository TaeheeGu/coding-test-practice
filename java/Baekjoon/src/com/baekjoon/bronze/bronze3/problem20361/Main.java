package com.baekjoon.bronze.bronze3.problem20361;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 20361번, 일우는 야바위꾼, 브론즈 3
// https://www.acmicpc.net/problem/20361
public class Main {

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // N 컵의 개수
		int X = Integer.parseInt(st.nextToken()); // X 공을 숨긴 위치
		int K = Integer.parseInt(st.nextToken()); // K 컵의 위치를 바꾸는 횟수

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == X) {
				X = B;
				continue;
			}
			if (B == X) {
				X = A;
				continue;
			}

		}
		
		sb.append(X);

		out.write(sb.toString());
		out.close();
	}
}

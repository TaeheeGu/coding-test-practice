package com.baekjoon.silver.silver4.problem1049;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1049번 : 기타줄
// https://www.acmicpc.net/problem/1049
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 끊어진 기타 줄 개수
		int m = Integer.parseInt(st.nextToken()); // 브랜드 개수

		int pack = Integer.MAX_VALUE; // 패키지 가격 중 최소 값
		int one = Integer.MAX_VALUE; // 낱개 가격 중 최소 값

		int answer = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			pack = Math.min(Integer.parseInt(st.nextToken()), pack); // 6개 패키지 가격
			one = Math.min(Integer.parseInt(st.nextToken()), one); // 낱개 가격
		}

		// 단일로만 사는 경우 가격, 패키지로만 사는 경우 가격, 패키지와 단일을 섞어서 사는 가격
		answer = Math.min((n * one), Math.min(((n / 6 + 1) * pack), (n / 6 * pack + n % 6 * one)));
		bw.write(answer + "");
		bw.close();
	}
}

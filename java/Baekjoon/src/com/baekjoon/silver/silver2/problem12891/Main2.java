package com.baekjoon.silver.silver2.problem12891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12891번, DNA 비밀번호, 실버2
// https://www.acmicpc.net/problem/12891
public class Main2 {
	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int S = Integer.parseInt(st.nextToken()); // 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

		char[] split = in.readLine().toCharArray();

		char[] subSt = { 'A', 'C', 'G', 'T' };
		int[] count = new int[4];

		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		int[] subCount = new int[4];
		int answer = 0;
		boolean check = false;

		for (int i = 0; i < P; i++) { // 0 ~ P-1
			for (int j = 0; j < 4; j++) {
				if (split[i] == subSt[j]) {
					subCount[j]++;
				}
			}
		}

		for (int j = 0; j < 4; j++) {
			if (subCount[j] >= count[j]) {
				check = true;
			} else {
				check = false;
				break;
			}
		}

		if (check) {
			answer++;
		}

		for (int i = P; i < S; i++) {

			for (int j = 0; j < 4; j++) {
				// 빠지는 문자 0, 1, 2 ..
				if (split[i - P] == subSt[j]) {
					subCount[j]--;
				}
				// 들어가는 문자 P, P+1 ...
				if (split[i] == subSt[j]) {
					subCount[j]++;
				}
			}

			for (int j = 0; j < 4; j++) {
				if (subCount[j] >= count[j]) {
					check = true;
				} else {
					check = false;
					break;
				}
			}

			if (check) {
				answer++;
			}

		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

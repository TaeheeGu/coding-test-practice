package com.baekjoon.gold.gold5.problem1759;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// BJ 1759, 암호 만들기, 골드 5
// https://www.acmicpc.net/problem/1759
public class Main {

	static int L, C;
	static char[] input;
	static int[] num;

	static char[] vowel = { 'a', 'i', 'e', 'o', 'u' };
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new char[C];

		String[] split = in.readLine().split(" ");
		for (int i = 0; i < C; i++) {

			input[i] = split[i].charAt(0);

		}

		num = new int[L];

		Arrays.sort(input);

		comb(0, 0);

		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {

		if (cnt == L) {
			char[] pw = new char[L];
			int v = 0; // 모음의 개수
			int c = 0; // 자음의 개수

			for (int i = 0; i < L; i++) {
				char temp = input[num[i]];

				for (int j = 0; j < vowel.length; j++) {
					if (temp == vowel[j]) {
						v++;
						break;
					}
				}

				pw[i] = temp;
			}

			c = L - v;

			if (v >= 1 && c >= 2) {
				sb.append(pw).append("\n");
			}

			return;
		}

		for (int i = start; i < C; i++) {
			num[cnt] = i;
			comb(i + 1, cnt + 1);
		}

	}
}
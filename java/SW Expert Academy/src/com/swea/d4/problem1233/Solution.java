package com.swea.d4.problem1233;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// SWEA 1233 [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사, D4
public class Solution {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(in.readLine());

			char[][] data = new char[N][4];

			for (int i = 0; i < N; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < split.length; j++) {
					data[i][j] = split[j].charAt(0);
				}
			}
			

			int answer = 1;

			if (N % 2 == 0) {
				answer = 0;
				sb.append(answer).append("\n");
				continue;
			}

			for (int i = 0; i < N; i++) {
				if (data[i][1] == '+' || data[i][1] == '-' || data[i][1] == '*' || data[i][1] == '/') {
					if (data[i][2] == '\u0000' || data[i][3] == '\u0000') {
						answer = 0;
						break;
					}
				} else {
					if (data[i][2] != '\u0000' || data[i][3] != '\u0000') {
						answer = 0;
						break;
					}
				}

			}
			
			sb.append(answer).append("\n");

		}

		out.write(sb.toString());
		out.close();
	}
}

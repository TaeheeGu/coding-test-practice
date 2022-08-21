package com.baekjoon.bronze.bronze1.problem1032;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준, 1032번, 명령 프롬프트, 브론즈 1
// https://www.acmicpc.net/problem/1032
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		String[] file = new String[N];

		for (int i = 0; i < N; i++) {
			file[i] = in.readLine();
		}

		String answer = "";

		int len = file[0].length();

		outer:
		for (int i = 0; i < len; i++) {
			char temp = file[0].charAt(i);

			for (int j = 1; j < N; j++) {
				if (temp != file[j].charAt(i)) {
					answer += "?";
					continue outer;
				}
			}

			answer += temp;
		}

		sb.append(answer).append("\n");
		out.write(sb.toString());
		out.close();
	}
}

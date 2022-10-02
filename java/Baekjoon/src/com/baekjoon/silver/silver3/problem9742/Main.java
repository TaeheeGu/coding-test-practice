package com.baekjoon.silver.silver3.problem9742;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static int K;
	static int num;
	static String answer;
	static char[] temp;
	static char[] testcase;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		String input;

		while ((input = in.readLine()) != null) {

			testcase = input.split(" ")[0].toCharArray();
			N = testcase.length;
			K = Integer.parseInt(input.split(" ")[1]);

			num = 0;
			visited = new boolean[N];
			answer = "";
			temp = new char[N];

			perm(0);

			if (answer.equals("")) {
				answer = "No permutation";
			}

			sb.append(input).append(" = ").append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {
		if (num > K) {
			return;
		}
		if (cnt == N) {
			num++;
			if (num == K) {
				for (int i = 0; i < N; i++) {
					answer += temp[i];
				}
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				temp[cnt] = testcase[i];
				visited[i] = true;
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}
}

package com.swea.mockTest.problem4008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static char[] operator = { '+', '-', '*', '/' };
	static int[] count = { 0, 0, 0, 0 };
	static int[] numbers;

	static char[] selected;
	static boolean[] visited;

	static int N, min, max;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				count[i] = Integer.parseInt(st.nextToken());
			}

			numbers = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			selected = new char[N - 1];
			visited = new boolean[N - 1];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;

			comb(0, 0, 0);

			int answer = Math.abs(max - min);
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int depth, int cnt) {
		if (depth == count[cnt]) {
			if (cnt == 3) {
				int temp = numbers[0];
				for (int i = 0; i < N - 1; i++) {
					char oper = selected[i];
					int next = numbers[i + 1];

					if (oper == '+') {
						temp += next;
					} else if (oper == '-') {
						temp -= next;
					} else if (oper == '*') {
						temp *= next;
					} else if (oper == '/') {
						temp /= next;
					}
				}

				min = Math.min(min, temp);
				max = Math.max(max, temp);

				return;
			}
			comb(0, 0, cnt + 1);
		}

		for (int i = start; i < N - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[i] = operator[cnt];
				comb(i + 1, depth + 1, cnt);
				visited[i] = false;
			}
		}
	}

}

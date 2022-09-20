package com.baekjoon.silver.silver3.problem2992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private static char[] split;
	private static int value;

	private static int N;
	private static int[] numbers;
	private static boolean[] visited;
	private static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		String input = in.readLine();

		value = Integer.valueOf(input);
		split = input.toCharArray();
		Arrays.sort(split);

		N = split.length;

		numbers = new int[N];
		visited = new boolean[N];

		answer = 0;

		perm(0);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {
		if (answer != 0) {
			return;
		}

		if (cnt == N) {
			if (split[0] > split[numbers[0]]) {
				return;
			}

			String strTemp = "";
			for (int i = 0; i < N; i++) {
				strTemp += split[numbers[i]];
			}
			
			int temp = Integer.valueOf(strTemp);
			
			if(value < temp) {
				answer = temp;
			}
			
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				numbers[cnt] = i;
				visited[i] = true;
				perm(cnt + 1);
				visited[i] = false;
			}
		}
	}
}

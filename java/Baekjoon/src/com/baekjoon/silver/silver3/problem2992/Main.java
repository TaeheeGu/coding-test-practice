package com.baekjoon.silver.silver3.problem2992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private static int value;
	private static char[] split;

	private static int N;
	private static int[] numbers;
	private static String answer;

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

		answer = "";

		perm(0, 0);

		out.write(sb.toString());
		out.close();
	}

	private static void perm(int start, int cnt) {

		if (answer.length() == N) {
			return;
		}
		
		if(cnt == N) {
			
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = split[i];
			perm(start + 1, cnt + 1);
		}
	}
}

package com.baekjoon.silver.silver1.problem16943;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static char[] A;
	static int B;

	static int N;
	static int answer;

	static char[] numbers;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		A = st.nextToken().toCharArray();
		B = Integer.parseInt(st.nextToken());

		N = A.length;
		answer = -1;
		visited = new boolean[N];
		numbers = new char[N];

		perm(0);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {
		if (cnt == N) {

			String temp = "";

			for (int i = 0; i < N; i++) {
				temp += numbers[i];
			}

			int numA = Integer.parseInt(temp);

			if ((numA + "").length() == N && numA < B) {
				answer = Math.max(answer, numA);
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				numbers[cnt] = A[i];
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}
}

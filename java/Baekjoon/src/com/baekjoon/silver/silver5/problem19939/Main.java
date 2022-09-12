package com.baekjoon.silver.silver5.problem19939;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int answer = -1;
		int sum = 0;
		int[] balls = new int[K];
		boolean check = true;

		for (int i = 0; i < K; i++) {
			sum += i + 1;
			balls[i] = i + 1;
			if (sum > N) {
				check = false;
				break;
			}
		}

		while (check) {
			if (N - sum == 0) {
				answer = balls[K - 1] - balls[0];
				break;
			}

			if (N - sum < K) {
				answer = balls[K - 1] - balls[0] + 1;
				break;
			}

			if (N - sum >= K) {
				for (int i = 0; i < K; i++) {
					balls[i] = balls[i] + 1;
				}
				sum += K;
			}
		}

//		System.out.println(Arrays.toString(balls));
		
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

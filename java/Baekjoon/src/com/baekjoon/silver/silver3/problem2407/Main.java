package com.baekjoon.silver.silver3.problem2407;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		BigInteger[][] arr = new BigInteger[101][101];

		
		for (int n = 1; n < 101; n++) {
			for (int r = 0; r <= n; r++) {
				if (r == 0) {
					arr[n][r] = BigInteger.ONE;
					continue;
				}
				if (n == r) {
					arr[n][r] = BigInteger.ONE;
					continue;
				}
				arr[n][r] = arr[n - 1][r - 1].add(arr[n - 1][r]);
			}
		}

		sb.append(arr[N][M]);

		out.write(sb.toString());
		out.close();
	}
}

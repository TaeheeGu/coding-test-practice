package com.baekjoon.gold.gold4.problem15685;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine());

		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long answer = 0;
		for (int i = 0; i < N; i++) {
			answer += 1;
			if (A[i] - B > 0) {
				answer += (A[i]- B) / C;
				if((A[i]- B) % C > 0) {
					answer += 1;
				}
			}
		}
		
		sb.append(answer);

		out.write(sb.toString());
		out.close();
	}
}

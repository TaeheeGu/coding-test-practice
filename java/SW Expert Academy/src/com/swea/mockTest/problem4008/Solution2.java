package com.swea.mockTest.problem4008;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2 {

	static int N;
	static int[] oper = { 0, 0, 0, 0 };
	static int[] nums;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());
			nums = new int[N];

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
		}

	}
}

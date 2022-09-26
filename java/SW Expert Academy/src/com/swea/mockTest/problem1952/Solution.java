package com.swea.mockTest.problem1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			int[] price = new int[4];
			int[] use = new int[13];

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}

			int[] dp = new int[13];
			for (int i = 1; i <= 12; i++) {
				int DAY = dp[i - 1] + use[i] * price[0];
				int MONTH = dp[i - 1] + price[1];
				int MONTH3 = (i >= 3) ? dp[i-3] + price[2] : Integer.MAX_VALUE;
				int YEAR = (i == 12) ? price[3] : Integer.MAX_VALUE;
				dp[i] = Math.min(DAY, Math.min(MONTH, Math.min(MONTH3, YEAR)));
			}

			sb.append("#").append(t).append(" ").append(dp[12]).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

}

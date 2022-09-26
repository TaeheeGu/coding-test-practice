package com.swea.mockTest.problem1952;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution2 {

	static int min;
	static int[] price;
	static int[] use;

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			price = new int[4];
			use = new int[12];

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}

			min = price[3];
			dfs(0, 0);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int idx, int sum) {
		if (idx >= 12) {
			min = Math.min(min, sum);
			return;
		}
		dfs(idx + 1, sum + use[idx] + price[0]);
		dfs(idx + 1, sum + price[1]);
		dfs(idx + 3, sum + price[2]);
	}

}

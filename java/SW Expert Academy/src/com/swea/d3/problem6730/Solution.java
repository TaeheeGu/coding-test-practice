package com.swea.d3.problem6730;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(in.readLine());

			int up = 0;
			int down = 0;

			StringTokenizer st = new StringTokenizer(in.readLine());
			int pre = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N; i++) {
				int current = Integer.parseInt(st.nextToken());

				if (pre < current) {
					up = Math.max(up, (current - pre));
				} else if (pre > current) {
					down = Math.max(down, (pre - current));
				}

				pre = current;
			}

			sb.append(up).append(" ").append(down).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

}

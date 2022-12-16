package com.baekjoon.gold.gold4.problem5052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(in.readLine());

			List<String> list = new ArrayList<>(N);

			for (int i = 0; i < N; i++) {
				list.add(in.readLine());
			}

			Collections.sort(list);

			String answer = "YES";

			for (int i = 0; i < N - 1; i++) {
				String pre = list.get(i);
				String next = list.get(i + 1);

				if (pre.length() > next.length()) {
					continue;
				}

				if (pre.equals(next.substring(0, pre.length()))) {
					answer = "NO";
					break;
				}
			}

			sb.append(answer).append('\n');
		}

		out.write(sb.toString());
		out.close();

	}
}

package com.swea.d4.problem3289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 3289 - 서로소집합, d4
public class Solution {

	private static int[] parents;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parents = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());

				int operator = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (operator == 0) {
					union(a, b);
				}

				if (operator == 1) {
					if (find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}

			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void union(int a, int b) {

		int parentA = find(a);
		int parentB = find(b);

		if (parentA == parentB) {
			return;
		}

		parents[parentA] = parentB;

	}

	private static int find(int a) {

		int parentA = parents[a];

		if (parentA == a) {
			return parentA;
		}

		else {
			return parents[a] = find(parentA);

		}
	}

}

package com.swea.d4.problem7465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 7465. 창용 마을 무리의 개수 D4
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU
public class Solution {

	private static int[] root;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("s_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int M = Integer.parseInt(st.nextToken()); // 관계 수

			// 서로소 집합의 루트 개수를 확인

			int answer = N;
			root = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				root[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (union(a, b)) {
					answer--;
				}
			}
			
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static boolean union(int a, int b) {

		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return false;
		} else {
			root[rootB] = rootA;
			return true;
		}
	}

	private static int find(int a) {

		if (a == root[a]) {
			return a;
		}

		return root[a] = find(root[a]);
	}
}

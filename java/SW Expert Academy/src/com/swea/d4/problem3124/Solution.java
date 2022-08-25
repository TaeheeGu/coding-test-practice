package com.swea.d4.problem3124;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// SWEA 3124 - 최소 스패닝 트리, d4
public class Solution {

	static int[] parents;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			int[][] edges = new int[e][3];

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());
				edges[i][0] = Integer.parseInt(st.nextToken()); // 정점 a
				edges[i][1] = Integer.parseInt(st.nextToken()); // 정점 b
				edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치
			}

			// 가중치 기준 오름차순 정렬
			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return o1[2] - o2[2];
				}

			});

//			System.out.println(Arrays.deepToString(edges));

			parents = new int[v + 1];

			for (int i = 1; i <= v; i++) {
				parents[i] = i;
			}

			int cnt = 0;
			long result = 0;

			for (int i = 0; i < e; i++) {

				if (cnt == v - 1) {
					break;
				}

				int a = edges[i][0];
				int b = edges[i][1];
				int c = edges[i][2];

				if (union(a, b)) {

					
					result += c;
					cnt++;
				}

			}

			sb.append(result).append("\n");

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

			parents[rootB] = rootA;
			return true;
		}
	}

	private static int find(int a) {

		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

}

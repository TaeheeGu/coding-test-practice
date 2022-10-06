package com.swea.d6.problem1263;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 1263 - 사람 네트워크2
public class Solution {

	static final int INF = 99999;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			int N = Integer.parseInt(st.nextToken());

			int[][] D = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					D[i][j] = Integer.parseInt(st.nextToken());

					if (i != j && D[i][j] == 0) {
						D[i][j] = INF;
					}
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {

					if (k == i) {
						continue;
					}

					for (int j = 0; j < N; j++) {

						if (k == j || i == j) {
							continue;
						}

						D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
					}
				}
			}

			int answer = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				int temp = 0;
				for (int j = 0; j < N; j++) {
					temp += D[i][j];
				}
				answer = Math.min(answer, temp);
			}

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}
}

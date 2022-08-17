package com.swea.mockTest.problem5644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//  SWEA 5644 - [모의 SW 역량테스트] 무선 충전

public class Solution {

	private static int[] dx = { 0, 0, 1, 0, -1 }; // 이동x, 상, 우, 하, 좌
	private static int[] dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			int M = Integer.parseInt(st.nextToken());
			int BC_cnt = Integer.parseInt(st.nextToken());

			int[] A = new int[M];
			int[] B = new int[M];

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			int[][] BC = new int[BC_cnt][4];

			for (int i = 0; i < BC_cnt; i++) {
				st = new StringTokenizer(in.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken()); // 열, x
				BC[i][1] = Integer.parseInt(st.nextToken()); // 행, y
				BC[i][2] = Integer.parseInt(st.nextToken()); // 범위
				BC[i][3] = Integer.parseInt(st.nextToken()); // 성능
			}

			int max = 0;

			int Ax = 1;
			int Ay = 1;
			int Bx = 10;
			int By = 10;
			int idx = 0;

			while (true) {

				int[] chargeA = new int[BC_cnt];
				int[] chargeB = new int[BC_cnt];

				for (int i = 0; i < BC_cnt; i++) {

					int BCx = BC[i][0];
					int BCy = BC[i][1];
					int BCc = BC[i][2];
					int BCp = BC[i][3];

					int distA = Math.abs(Ax - BCx) + Math.abs(Ay - BCy);
					if (distA <= BCc) {
						chargeA[i] = BCp;
					}

					int distB = Math.abs(Bx - BCx) + Math.abs(By - BCy);
					if (distB <= BCc) {
						chargeB[i] = BCp;
					}

				}

				int chargeSum = 0;

				for (int i = 0; i < BC_cnt; i++) {
					for (int j = 0; j < BC_cnt; j++) {
						if (i == j && chargeA[i] == chargeB[j]) {
							chargeSum = Math.max(chargeSum, chargeA[i]);
						} else {
							chargeSum = Math.max(chargeSum, (chargeA[i] + chargeB[j]));
						}
					}
				}

				max += chargeSum;

				if (idx >= M) {
					break;
				}

				Ax += dx[A[idx]];
				Ay += dy[A[idx]];
				Bx += dx[B[idx]];
				By += dy[B[idx]];

				idx++;
			}
			sb.append(max).append("\n");

		}

		out.write(sb.toString());
		out.close();
	}
}

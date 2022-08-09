package com.swea.d4.problem1861;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


//SWEA 1861 - 정사각형방  D4
public class Solution {

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };

	static int[][] room;
	static int N;
	static int cnt;


	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());
			room = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			int roomId = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 0;
					move(i, j, 1);

					if (cnt >= max) {
						if (cnt == max) {
							roomId = Math.min(room[i][j], roomId);
						} else {
							roomId = room[i][j];
						}
						max = cnt;
					}
				}
			}
			sb.append(roomId).append(" ").append(max).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	public static void move(int x, int y, int count) {

		boolean check = false;

		for (int idx = 0; idx < 4; idx++) {
			int nextX = x + dx[idx];
			int nextY = y + dy[idx];

			if ((0 <= nextX && nextX < N) && (0 <= nextY && nextY < N)) {
				if (room[nextX][nextY] - room[x][y] == 1) {
					check = true;
					move(nextX, nextY, count + 1);
				}
			}
		}
		
		if (!check) {
			cnt = Math.max(cnt, count);
		}
	}
}

package com.backjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 오목
// https://www.acmicpc.net/problem/2615
public class Main_2615 {

	static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 }; // |,-, \, /
	static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int[][] map = new int[19][19];

	static boolean check(int color, int x, int y) {
		return x > 18 || x < 0 || y > 18 || y < 0 || map[x][y] != color;
	}

	static int[] count(int color, int x, int y, int idx) {
		int ansX = x;
		int ansY = y;
		int newX = x;
		int newY = y;
		int cnt = 0;
		for (int j = 0; j < 19; j++) {
			newX += dx[idx];
			newY += dy[idx];
			if (check(color, newX, newY)) {
				break;
			}
			cnt++;
			if (newY < ansY) {
				ansX = newX;
				ansY = newY;
			}
			if (newY == ansY) {
				ansX = Math.min(ansX, newX);
			}
		}
		return new int[] { cnt, ansX, ansY };
	}

	static int[] solution(int color, int x, int y) {

		int[] answer = { 0, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int[] arr1 = count(color, x, y, i * 2);
			int[] arr2 = count(color, x, y, i * 2 + 1);
			int count = arr1[0] + arr2[0] + 1;

			if (count == 5) {
				answer[0] = color;
				int ansX;
				int ansY;

				int x1 = arr1[1];
				int y1 = arr1[2];
				int x2 = arr2[1];
				int y2 = arr2[2];

				if (y1 < y2) {
					ansY = y1;
					ansX = x1;
				} else if (y1 > y2) {
					ansY = y2;
					ansX = x2;
				} else {
					ansY = y1;
					ansX = Math.min(x1, x2);
				}

				answer[1] = ansX + 1;
				answer[2] = ansY + 1;
				return answer;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] result = new int[3];

		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
			}
		}
		loop: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				if (map[i][j] == 1) {
					result = solution(1, i, j);
				}
				if (map[i][j] == 2) {
					result = solution(2, i, j);
				}
				if (result[0] != 0) {
					bw.write(result[0] + "\n" + result[1] + " " + result[2]);
					bw.close();
					break loop;
				}
			}
		}
		if (result[0] == 0) {
			bw.write("0");
			bw.close();
		}
	}
}

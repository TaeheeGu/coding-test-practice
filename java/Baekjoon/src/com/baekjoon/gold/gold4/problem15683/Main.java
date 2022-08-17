package com.baekjoon.gold.gold4.problem15683;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BJ 15683 - 감시, 골드 4
// https://www.acmicpc.net/problem/15683
public class Main {

	static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	static int[] dy = { 1, 0, -1, 0 };

	static int N, M, R, answer;
	static int[][] office;

	static int[] numbers;

	static List<CCTV> cctvs;

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		office = new int[N][M];

		R = 0;
		answer = Integer.MAX_VALUE;

		cctvs = new ArrayList<CCTV>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				int type = Integer.parseInt(st.nextToken());
				office[i][j] = type;

				if (type != 0 && type != 6) {
					cctvs.add(new CCTV(i, j, type));
				}
			}
		}

		for (int i = cctvs.size(); i > 0; i--) {

			// 5번의 경우 회전의 결과가 항상 같다.
			if (cctvs.get(i - 1).type == 5) {
				int x = cctvs.get(i - 1).x;
				int y = cctvs.get(i - 1).y;
				for (int idx = 0; idx < 4; idx++) {
					trans(x, y, idx, office);
				}
				cctvs.remove(i - 1);
			} else {
				R++;
			}

		}

		numbers = new int[R];
		perm(0);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static boolean check(int newX, int newY) {
		if (0 <= newX && newX < N && 0 <= newY && newY < M && office[newX][newY] != 6) {
			return true;
		}
		return false;
	}

	private static void trans(int x, int y, int idx, int[][] arr) {
		while (true) {
			int newX = x + dx[idx];
			int newY = y + dy[idx];

			if (!check(newX, newY)) {
				break;
			}

			if (arr[newX][newY] == 0) {
				arr[newX][newY] = -1;
			}
			x = newX;
			y = newY;
		}
	}

	private static int count(int[][] arr) {
		int blind = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					blind++;
				}
			}
		}
		return blind;
	}

	private static void perm(int cnt) {

		if (cnt == R) {

			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = office[i][j];
				}
			}

			for (int i = 0; i < cctvs.size(); i++) {
				int type = cctvs.get(i).type;
				int x = cctvs.get(i).x;
				int y = cctvs.get(i).y;
				int idx = numbers[i];

				if (type == 1) {
					trans(x, y, idx, arr);
				}
				if (type == 2) {
					trans(x, y, idx % 4, arr);
					trans(x, y, (idx + 2) % 4, arr);
				}
				if (type == 3) {
					trans(x, y, idx, arr);
					trans(x, y, (idx + 3) % 4, arr);
				}
				if (type == 4) {
					trans(x, y, idx, arr);
					trans(x, y, (idx + 2) % 4, arr);
					trans(x, y, (idx + 3) % 4, arr);
				}
			}
			int temp = count(arr);

			answer = Math.min(answer, temp);

			return;
		}

		for (int i = 0; i < 4; i++) {
			numbers[cnt] = i;
			perm(cnt + 1);
		}
	}
}

class CCTV {
	public int x;
	public int y;
	public int type;

	public CCTV(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

}

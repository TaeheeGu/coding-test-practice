package com.baekjoon.silver.silver3.problem1063;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준, 1063번, 킹, 실버3
// https://www.acmicpc.net/problem/1063
public class Main {

	private static String[] kingMoving = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" }; // 우, 좌, 하, 상, 우상, 좌상, 우하, 좌하

	private static int[] dx = { 0, 0, -1, 1, 1, 1, -1, -1 };
	private static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");

		int kingC = (split[0].charAt(0) - 'A') + 1;
		int kingR = split[0].charAt(1) - '0';

		int stoneC = (split[1].charAt(0) - 'A') + 1;
		int stoneR = split[1].charAt(1) - '0';

		int N = Integer.parseInt(split[2]);

		int[] moving = new int[N];

		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < 8; j++) {
				if (temp.equals(kingMoving[j])) {
					moving[i] = j;
					break;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			int idx = moving[i];

			int nextKingR = kingR + dx[idx];
			int nextKingC = kingC + dy[idx];

			int nextStoneR = stoneR + dx[idx];
			int nextStoneC = stoneC + dy[idx];

			if (check(nextKingR, nextKingC)) {

				if (nextKingR == stoneR && nextKingC == stoneC) {
					if (check(nextStoneR, nextStoneC)) {
						kingR = nextKingR;
						kingC = nextKingC;

						stoneR = nextStoneR;
						stoneC = nextStoneC;
					} else {
						continue;
					}
				} else {
					kingR = nextKingR;
					kingC = nextKingC;
				}

			}

			else {
				continue;
			}
		}

		char kingCharC = (char) ((kingC - 1) + 'A');
		char stoneCharC = (char) ((stoneC - 1) + 'A');

		sb.append(kingCharC).append(kingR).append("\n").append(stoneCharC).append(stoneR);

		out.write(sb.toString());
		out.close();
	}

	private static boolean check(int r, int c) {
		if ((1 <= r && r <= 8) && (1 <= c && c <= 8)) {
			return true;
		}
		return false;
	}
}

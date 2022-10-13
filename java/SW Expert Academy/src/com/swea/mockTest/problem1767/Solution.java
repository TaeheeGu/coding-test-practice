package com.swea.mockTest.problem1767;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, answer, maxCore;
	static int[][] map;
	static List<Core> list;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());
			map = new int[N][N];

			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
							// 가장자리 제외하고 연결 여부 확인
							list.add(new Core(i, j));
						}
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			answer = Integer.MAX_VALUE;
			dfs(0, 0, 0);

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int idx, int coreCnt, int len) {
		if (idx == list.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				answer = len;
			} else if (coreCnt == maxCore) {
				answer = Math.min(answer, len);
			}
			return;
		}

		Core cur = list.get(idx);
		int r = cur.r;
		int c = cur.c;

		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nextR = r;
			int nextC = c;
			while (true) {
				nextR = nextR + dx[i];
				nextC = nextC + dy[i];

				if (nextR < 0 || nextR > N - 1 || nextC < 0 || nextC > N - 1) {
					break;
				}
				if (map[nextR][nextC] == 1) {
					count = 0;
					break;
				}
				count++;
			}

			// 현재 방향으로 현재 코어를 연결하지 못한 경우
			if (count == 0) {
				// 다음 코어 탐색
				dfs(idx + 1, coreCnt, len);
			}

			// 현재 방향에서 현재 코어 연결 가능한 경우
			else {
				// 전선 연결 표시
				nextR = r;
				nextC = c;
				while (true) {
					nextR = nextR + dx[i];
					nextC = nextC + dy[i];
					if (nextR < 0 || nextR > N - 1 || nextC < 0 || nextC > N - 1) {
						break;
					}
					map[nextR][nextC] = 1;
				}
				dfs(idx + 1, coreCnt + 1, len + count);

				// 다음 탐색 위해 초기화
				nextR = r;
				nextC = c;
				while (true) {
					nextR = nextR + dx[i];
					nextC = nextC + dy[i];
					if (nextR < 0 || nextR > N - 1 || nextC < 0 || nextC > N - 1) {
						break;
					}
					map[nextR][nextC] = 0;
				}
			}
		}

	}
}

class Core {
	int r;
	int c;

	public Core(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
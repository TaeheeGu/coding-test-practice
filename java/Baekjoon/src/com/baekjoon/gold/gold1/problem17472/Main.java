package com.baekjoon.gold.gold1.problem17472;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//  BJ 17472 - 다리 만들기 2, 골드 1
// https://www.acmicpc.net/problem/17472
public class Main {

	private static int N, M, cnt;
	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 }; // 상하좌우
	private static boolean[][] visited;
	private static int[][] map;

	private static int[] root;
	private static List<Bridge> bridges;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N][M];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					++cnt;
					dfs(i, j);
				}
			}
		}

//		System.out.println(Arrays.deepToString(map));

		root = new int[cnt + 1];

		for (int i = 1; i < cnt + 1; i++) {
			root[i] = i;
		}

		bridges = new ArrayList<Bridge>();

		// 다리길이는 2 이상
		// i : 다리 건설을 시작할 섬 번호, 완전탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {

					int islandNum = map[i][j];

//					System.out.println(islandNum);
//					System.out.println(i + " " + j);
//					System.out.println();

					for (int idx = 0; idx < 4; idx++) {
						int len = 0;
						buildBridge(i, j, idx, len, islandNum);
					}

				}
			}
		}

		Collections.sort(bridges, new Comparator<Bridge>() {

			@Override
			public int compare(Bridge o1, Bridge o2) {
				if (o1.length != o2.length) {
					return o1.length - o2.length;
				}
				return o1.from - o2.to;
			}
		});

		int result = 0;
		for (int i = 0; i < bridges.size(); i++) {
			Bridge bridge = bridges.get(i);

			int a = bridge.from;
			int b = bridge.to;

			if (union(a, b)) {
				result += bridge.length;
			}
		}

		int temp = find(root[1]);
		for (int i = 2; i < cnt + 1; i++) {
			if (temp != find(root[i])) {
				result = -1;
				break;
			}
		}

//		System.out.println(bridges.toString());
		sb.append(result);
		out.write(sb.toString());
		out.close();
	}

	private static void buildBridge(int r, int c, int idx, int len, int islandNum) {

		int nR = r + dx[idx];
		int nC = c + dy[idx];

		if ((0 <= nR && nR < N) && (0 <= nC && nC < M)) {

			if (map[nR][nC] == islandNum) {

//				System.out.println("same " + nR + " " + nC);
				return;
			}

			if (map[nR][nC] != 0) {

				if (len >= 2) {
					bridges.add(new Bridge(islandNum, map[nR][nC], len));
//					System.out.println(bridges.toString());
				}
				return;
			}

			buildBridge(nR, nC, idx, len + 1, islandNum);

		}
		return;
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return false;
		}

		root[rootB] = rootA;
		return true;

	}

	private static int find(int a) {
		if (a == root[a]) {
			return a;
		}
		return root[a] = find(root[a]);
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		map[r][c] = cnt;

		for (int i = 0; i < 4; i++) {
			int nR = r + dx[i];
			int nC = c + dy[i];

			if ((0 <= nR && nR < N) && (0 <= nC && nC < M) && !visited[nR][nC] && map[nR][nC] == 1) {
				dfs(nR, nC);
			}
		}
	}
}

class Bridge {
	public int from;
	public int to;
	public int length;

	public Bridge(int from, int to, int length) {
		this.from = from;
		this.to = to;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Bridge [from=" + from + ", to=" + to + ", length=" + length + "]";
	}

}

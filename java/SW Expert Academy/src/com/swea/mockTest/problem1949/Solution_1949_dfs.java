package com.swea.mockTest.p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_dfs {

	static int N, K, answer;
	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			int maxHeight = 0; // 등산로를 조성할 봉우리의 최고 높이
			answer = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(map[i][j], maxHeight); // 입력값에서 최대값을 찾는다.
				}
			}

			List<Node> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) {
						list.add(new Node(i, j)); // 최대 높이에 해당하는 위치를 리스트에 저장
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k <= K; k++) { // 공사가 가능한 모든 깊이에 대해 모든 지역에서 확인
						map[i][j] -= k; // 공사
						for(int idx = 0; idx < list.size(); idx++) { // 최고 높이의 봉우리 위치에서 등산로 조성 시작
							Node cur = list.get(idx);
							if(i == cur.r && j == cur.c && map[i][j] != maxHeight ) { // 최고 높이에서 공사가 이루어져 더 이상 최고 높이 봉우리가 아닌 경우 등산로 조성하지 않는다.
								continue;
							}
							visited = new boolean[N][N]; // dfs 탐색을 위한 방문 여부
							visited[cur.r][cur.c] = true; // 시작 위치 방문처리
							dfs(cur.r, cur.c, 1); // 탐색 시작
						}
						map[i][j] += k; // 원래 상태로 되돌리기
					}
				}
			}
			
			sb.append(answer).append("\n");

		}
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int r, int c, int depth) {
		for(int i = 0; i < 4; i++) { // 현재 위치 상하좌우 탐색
			int nextR = r + dx[i];
			int nextC = c + dy[i];
			
			// 지도를 벗어나지 않고, 방문한적 없으며, 다음 위치가 현재 위치보다 작은 경우 등산로 조성이 가능하다.
			if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < N && !visited[nextR][nextC] && map[nextR][nextC] < map[r][c]) {
				visited[nextR][nextC] = true;
				dfs(nextR, nextC, depth + 1); // 다음 등산로 조성 여부 탐색
				visited[nextR][nextC] = false;
			}
			// 등산로 조성이 불가능한 경우
			else {
				answer = Math.max(answer, depth); // 현재 등산로 길이와 기존의 등산로 길이 비교
			}
		}
	}
}

class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
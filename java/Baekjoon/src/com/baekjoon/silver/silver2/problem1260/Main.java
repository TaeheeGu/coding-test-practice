package com.baekjoon.silver.silver2.problem1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 1260 - DFS와 BFS , 실버 2
// https://www.acmicpc.net/problem/1260
public class Main {

	static int[][] adjMatrix;
	static boolean[] visitedDFS, visitedBFS;
	static int N, M;

	static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 시작 정점

		adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}

		visitedDFS = new boolean[N + 1];
		visitedBFS = new boolean[N + 1];
		
		dfs(V);
		sb.append("\n");
		bfs(V);

		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int cur) {

		visitedDFS[cur] = true;
		sb.append(cur).append(" ");

		for (int i = 0; i < N + 1; i++) {
			if (!visitedDFS[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
				dfs(i);
			}
		}
	}
	
	private static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<>();

		visitedBFS[V] = true; // 0번 정점을 시작으로
		queue.offer(V);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			sb.append(cur).append(" ");

			// 현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N + 1; i++) {
				if (!visitedBFS[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우

					visitedBFS[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}

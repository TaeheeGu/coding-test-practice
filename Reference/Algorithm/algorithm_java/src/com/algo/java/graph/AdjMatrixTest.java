package com.algo.java.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
 */
public class AdjMatrixTest {

	static int[][] adjMatrix;
	static int N;
	
	static boolean[] visitedDFS;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int E = sc.nextInt();

		adjMatrix = new int[N][N]; // 0으로 자동으로 초기화

		for (int i = 0; i < E; i++) { // 간선 정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = 1; // 무향 그래프
		}

		bfs();
		
		visitedDFS = new boolean[N];
		
		dfs(0);

	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();

		boolean[] visited = new boolean[N]; // 방문관리 배열

		visited[0] = true; // 0번 정점을 시작으로
		queue.offer(0);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			System.out.println((char) (cur + 'A'));

			// 현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우

					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		System.out.println();
	}

	private static void dfs(int cur) {
		
		visitedDFS[cur] = true;
		System.out.println((char) (cur + 'A'));

		
		for (int i = 0; i < N; i++) {
			if (!visitedDFS[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
				dfs(i);
			}
		}
	}

}

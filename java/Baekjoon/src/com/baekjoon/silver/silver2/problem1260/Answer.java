package com.baekjoon.silver.silver2.problem1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

//BJ 1260 - DFS와 BFS , 실버 2
//https://www.acmicpc.net/problem/1260
public class Answer {

	private static StringBuilder sb;
	private static int N, M;
	private static Edge[] edgeList; // 간선리스트

	private static boolean[] visited; // DFS에서 사용할 방문여부 체크 배열

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		int V = Integer.parseInt(split[2]); // 시작 정점 번호

		edgeList = new Edge[M];

		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int from = Integer.parseInt(split[0]);
			int to = Integer.parseInt(split[1]);

			edgeList[i] = new Edge(from, to);
		}

		visited = new boolean[N + 1]; // 인덱스 1번부터 사용
		dfs(V);
		
		sb.append("\n");
		
		bfs(V);

		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int cur) {

		visited[cur] = true;
		sb.append(cur).append(" ");

		// cur의 인접정점들 처리
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) { // 방문하지 않았으며 인접한 경우

				for (Edge edge : edgeList) {

					// 문제에서 간선은 양방향이므로 아래와 같이 확인
					if ((edge.from == cur && edge.to == i) || (edge.from == i && edge.to == cur)) {
						dfs(i);
						break;
					}
				}
			}
		}
	}
	
	private static void bfs(int V) {
		Queue<Integer> queue = new ArrayDeque<>();

		boolean[] visitedBFS = new boolean[N + 1];
		visitedBFS[V] = true; // 0번 정점을 시작으로
		queue.offer(V);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			sb.append(cur).append(" ");

			// 현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 1; i < N + 1; i++) {
				if (!visitedBFS[i]) { // 방문하지 않았으며 인접한 경우

					for(Edge edge : edgeList) {
						
						if ((edge.from == cur && edge.to == i) || (edge.from == i && edge.to == cur)) {
							
							visitedBFS[i] = true;
							queue.offer(i);
							break;
						}
					}
				}
			}
		}
	}
}

// 간선 정보 저장
class Edge {
	public int from;
	public int to;

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
}

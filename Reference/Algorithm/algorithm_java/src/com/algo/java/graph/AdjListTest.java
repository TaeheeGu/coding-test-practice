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

public class AdjListTest {
	static class Node {
		int to;
		Node next;
		// int weight; // 가중치
		
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[N];
		visited = new boolean[N];
		
		for (int i = 0; i < E; i++) { // 간선 정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		bfs(0);
	
//		dfs(0);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();

		boolean[] visitedBFS = new boolean[N]; // 방문관리 배열

		visitedBFS[0] = true; // 0번 정점을 시작으로
		queue.offer(0);

		while (!queue.isEmpty()) {

			int cur = queue.poll();

			System.out.println((char) (cur + 'A'));

			// 현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (!visited[temp.to]) { // 방문하지 않았으며 인접한 경우

					visited[temp.to] = true;
					queue.offer(temp.to);
				}
			}
		}
		System.out.println();
	}
	
	private static void dfs(int cur) {
	
		visited[cur] = true;
		System.out.println((char) (cur + 'A'));

		// 자신의 인접 리스트를 끝까지 바라본다.
		for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) { // 방문하지 않았으며 인접한 경우
				dfs(temp.to);
			}
		}
	}
}

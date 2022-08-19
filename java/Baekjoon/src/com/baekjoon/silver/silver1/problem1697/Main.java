package com.baekjoon.silver.silver1.problem1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1697번, 숨바꼭질, 실버1
// https://www.acmicpc.net/problem/1697
public class Main {

	static int N, K;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;
		visited = new boolean[100001]; // 각 숫자에 대한 방문 여부

		if (N >= K) {
			answer = N - K;
		} else {
			bfs(N);
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void bfs(int n) {
		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(new Node(n, 0));

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();

			int current = curNode.cur;
			int depth = curNode.depth;

			if (current == K) {
				answer = depth;
				break;
			}

			if ((0 <= current - 1 && current - 1 < visited.length) && !visited[current - 1]) {
				queue.offer(new Node(current - 1, depth + 1));
				visited[current - 1] = true;
			}
			if ((0 <= current + 1 && current + 1 < visited.length) && !visited[current + 1]) {
				queue.offer(new Node(current + 1, depth + 1));
				visited[current + 1] = true;
			}
			if ((0 <= current * 2 && current * 2 < visited.length) && !visited[current * 2]) {
				queue.offer(new Node(current * 2, depth + 1));
				visited[current * 2] = true;
			}
		}
		return;
	}
}

class Node {
	public int cur;
	public int depth;

	public Node(int cur, int depth) {
		this.cur = cur;
		this.depth = depth;
	}
}

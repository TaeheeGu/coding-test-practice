package com.swea.d4.problem1238;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 1238. [S/W 문제해결 기본] 10일차 - Contact D4
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD
public class Solution {

	private static int N;
	private static int start;
	private static int answer;

	private static Node[] nodes;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			nodes = new Node[101]; // 1 ~ 100 번까지 존재 가능

			for (int i = 1; i < 101; i++) {
				nodes[i] = new Node(i);
			}

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				nodes[from].to.add(to);

			}

			answer = -1;
			visited = new boolean[101];

			bfs();

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		nodes[start].depth = 0;
		visited[start] = true;
		int curDepth = 0;

		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			int temp = nodes[current].depth;

			if (temp > curDepth) {
				answer = current;
				curDepth = temp;
			}

			if (temp == curDepth) {
				answer = Math.max(answer, current);
			}

			for (int i = 0; i < nodes[current].to.size(); i++) {

				int to = nodes[current].to.get(i);

				if (visited[to]) {
					continue;
				}

				visited[to] = true;
				nodes[to].depth = nodes[current].depth + 1;
				queue.offer(nodes[to].from);

			}
		}

	}
}

class Node {
	public int from;
	public List<Integer> to = new ArrayList<Integer>();
	public int depth;

	public Node(int from) {
		this.from = from;
	}
}

package com.baekjoon.gold.gold5.problem13023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BJ 13023 - ABCDE, 골드 5
// https://www.acmicpc.net/problem/13023
public class Main {

	static boolean[] visited;
	static Node[] nodes;
	static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		nodes = new Node[N];

		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodes[a].b.add(b);
			nodes[b].b.add(a);
		}

		answer = 0;
		
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
			if(answer == 1) {
				break;
			}
		}
		

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int current, int depth) {

		if (depth == 4) {
			answer = 1;
			return;
		}

		visited[current] = true;
		Node curNode = nodes[current];

		for (int i = 0; i < curNode.b.size(); i++) {
			if (visited[curNode.b.get(i)]) {
				continue;
			}
			dfs(curNode.b.get(i), depth + 1);
		}
		
		visited[current] = false;
	}

}

class Node {

	public int a;
	public List<Integer> b = new ArrayList<Integer>();

	public Node(int a) {
		this.a = a;
	}

}

package com.baekjoon.gold.gold4.problem1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//  BJ 1753 - 최단경로, 골드 4
// https://www.acmicpc.net/problem/1753
public class Main {

	private static int V, E;
	private static int[] distance;
	private static boolean[] visited;
	private static List<Node>[] nodes;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(in.readLine());

		nodes = new ArrayList[V + 1];
		
		for(int i = 1; i < V+1; i++) {
			nodes[i]= new ArrayList<>(); 
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodes[from].add(new Node(to, weight));
		}

		distance = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if(distance[i]== Integer.MAX_VALUE ) {
				sb.append("INF");
			}
			else {
				sb.append(distance[i]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		queue.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			int to = curNode.to;
			
			if(visited[to]) {
				continue;
			}
			
			visited[to] = true;
			
			for(Node node : nodes[to]) {
				if(distance[node.to] > distance[to] + node.weight) {
					
					distance[node.to] = distance[to] + node.weight;
					
					queue.add(new Node(node.to, distance[node.to]));
				}
			}
			
		}
		
	}
}

class Node implements Comparable<Node>{
	public int to;
	public int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

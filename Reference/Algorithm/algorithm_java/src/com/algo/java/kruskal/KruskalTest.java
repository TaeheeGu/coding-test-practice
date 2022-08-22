package com.algo.java.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}

	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeList;

	static void make() { // 크기가 1인 서로소 집합 생성

		parents = new int[V];
		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부무로하는(대표자) 집합을 만든다.
			parents[i] = i;
		}
	}

	static int find(int a) { // a의 대표자 찾기
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]); // 우리의 대표를 나의 부모로 : path compression
	}

	static boolean union(int a, int b) { // 리턴값 : true => union 성공
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;

		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));

		}

		make();
		Arrays.sort(edgeList);

		int result = 0;
		int count = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {

				result += edge.weight;

				if (++count == V - 1) {
					break;
				}

			}
		}
		
		System.out.println(result);
	}

}

/**
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1

output==>10

7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51

output==>175
 **/
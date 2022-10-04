package com.baekjoon.gold.gold4.problem17471;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, answer;
	static List<List<Integer>> adj;
	static int[] size;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		size = new int[N + 1]; // 인구 수
		adj = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			int X = Integer.parseInt(st.nextToken());
			for (int x = 0; x < X; x++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			adj.add(list);
		}

		answer = Integer.MAX_VALUE;

		for (int i = 1; i <= N / 2; i++) {
			numbers = new int[i];
			comb(1, 0, i);
		}

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int depth, int cnt) {
		if (depth == cnt) {
			List<Integer> groupA = new ArrayList<>();
			List<Integer> groupB = new ArrayList<>();

			for (int i = 0; i < cnt; i++) {
				groupA.add(numbers[i]);
			}

			for (int i = 1; i <= N; i++) {
				if (!groupA.contains(i)) {
					groupB.add(i);
				}
			}
			int sizeA = 0;
			int sizeB = 0;

			sizeA = bfs(groupA);
			sizeB = bfs(groupB);

			if (sizeA != 0 && sizeB != 0) {
				answer = Math.min(answer, Math.abs(sizeA - sizeB));
			}

			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[depth] = i;
			comb(i + 1, depth + 1, cnt);
		}

	}

	private static int bfs(List<Integer> group) {
		boolean[] visited = new boolean[N + 1];

		Queue<Integer> queue = new ArrayDeque<>();
		int cur = group.get(0);
		queue.offer(cur);
		visited[cur] = true;
		int temp = size[cur];


		while (!queue.isEmpty()) {
			cur = queue.poll();

			for (int i = 0; i < adj.get(cur - 1).size(); i++) {
				int next = adj.get(cur - 1).get(i);
				if (group.contains(next) && !visited[next]) {
					queue.offer(next);
					visited[next] = true;
					temp += size[next];
				}
			}
		}

		for (int i : group) {
			if (!visited[i]) {
				return 0;
			}
		}
		return temp;
	}

}

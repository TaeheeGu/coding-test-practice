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
	static List<Integer>[] adj;
	static int[] size;

	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		size = new int[N + 1]; // 인구 수
		adj = new List[N + 1];

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(in.readLine());
			while (true) {
				try {
					list.add(Integer.parseInt(st.nextToken()));
				} catch (Exception e) {
					break;
				}
			}
			adj[i] = list;
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

	private static void comb(int start, int cnt, int depth) {
		if (cnt == depth) {
			List<Integer> first = new ArrayList<>();
			List<Integer> second = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				second.add(i);
			}
			for (int i = 0; i < depth; i++) {
				first.add(numbers[i]);
			}
			for (int i = 0; i < depth; i++) {
				second.remove(Integer.valueOf(numbers[i]));
			}

			int firstSum = bfs(first);
			int secondSum = bfs(second);

			if (firstSum != 0 && secondSum != 0) {
				answer = Math.min(answer, Math.abs(firstSum - secondSum));
			}

			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1, depth);
		}

	}

	private static int bfs(List<Integer> list) {
		boolean[] visited = new boolean[N + 1];

		int start = list.get(0);

		Queue<Integer> queue = new ArrayDeque<>();

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < adj[current].size(); i++) {
				int next = adj[current].get(i);
				if (list.contains(next) && !visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			int idx = list.get(i);
			if (!visited[idx]) {
				return 0;
			}
			sum += size[idx];
		}

		return sum;
	}

}

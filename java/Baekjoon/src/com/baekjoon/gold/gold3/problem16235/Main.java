package com.baekjoon.gold.gold3.problem16235;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] map;
	static int[][] A;
	static Queue<Tree> trees;
	static Queue<Tree> deads;

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken()); // 배열 크기
		M = Integer.parseInt(st.nextToken()); // 나무 개수
		K = Integer.parseInt(st.nextToken()); // 년

		map = new int[N + 1][N + 1];
		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;

			}
		}

		trees = new ArrayDeque<>();
		deads = new ArrayDeque<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(r, c, age));
		}

		for (int k = 0; k < K; k++) {
			spring();
			summer();
			fall();
			winter();
		}

		int answer = trees.size();
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += A[i][j];

			}
		}

	}

	private static void fall() {
		Queue<Tree> temp = new ArrayDeque<>();
		Queue<Tree> older = new ArrayDeque<>();
		Queue<Tree> youth = new ArrayDeque<>();

		while (!trees.isEmpty()) {
			Tree tree = trees.poll();
			int r = tree.r;
			int c = tree.c;

			older.offer(tree);

			if (tree.age % 5 == 0) {
				for (int idx = 0; idx < 8; idx++) {
					int nextR = r + dr[idx];
					int nextC = c + dc[idx];
					if (nextR < 1 || nextR > N || nextC < 1 || nextC > N) {
						continue;
					}
					youth.offer(new Tree(nextR, nextC, 1));
				}
			}
		}
		
		temp.addAll(youth);
		temp.addAll(older);
		trees = temp;

	}

	private static void summer() {
		while (!deads.isEmpty()) {
			Tree tree = deads.poll();
			map[tree.r][tree.c] += tree.age / 2;
		}
	}

	private static void spring() {
		Queue<Tree> lives = new ArrayDeque<>();

		while (!trees.isEmpty()) {
			Tree tree = trees.poll();
			int r = tree.r;
			int c = tree.c;
			int age = tree.age;

			if (map[r][c] >= age) {
				map[r][c] -= age;
				lives.offer(new Tree(r, c, age + 1));
			} else {
				deads.offer(tree);
			}
		}
		
		trees = lives;
	}
}

class Tree {
	int r;
	int c;
	int age;

	public Tree(int r, int c, int age) {
		this.r = r;
		this.c = c;
		this.age = age;
	}
}
package com.algo.java;

import java.util.Arrays;

// nPr, nCr, 2^n
public class PermCombSubs {
	static int N = 4, R = 3, C = 0;

	static int[] a = { 1, 2, 3, 4 };
	static int[] b = new int[R];

	static boolean[] visited = new boolean[N];

	public static void main(String[] args) throws Exception {
//		perm(0); // 순열 4P3
//		repetitionPerm(0); // 중복 순열
//		comb(0, 0); // 조합
		subs(0); // 부분집합
		System.out.println(C);
	}

	// 부분 집합
	private static void subs(int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		visited[depth] = true;
		subs(depth + 1);
		visited[depth] = false;
		subs(depth + 1);

	}

	// 조합
	private static void comb(int depth, int start) {
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = start; i < N; i++) {
			b[depth] = a[i];
			comb(depth + 1, i + 1);
		}
	}

	// 중복 조합
	private static void repetitionComb(int depth, int start) {
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = 0; i < N; i++) {
			b[depth] = a[i];
			repetitionComb(depth + 1, i + 1);
		}
	}

	// 순열
	private static void perm(int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			b[depth] = a[i];
			perm(depth + 1);
			visited[i] = false;
		}
	}

	// 중복 순열
	private static void repetitionPerm(int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(b));
			C++;
			return;
		}

		for (int i = 0; i < N; i++) {
			b[depth] = a[i];
			repetitionPerm(depth + 1);
		}
	}
}

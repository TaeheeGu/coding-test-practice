package com.swea.advanced.problem3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// No. 3 [연습문제] suffle
public class Solution {

	private static int N;

	private static int[] sorted;
	private static int[] reversSorted;

	private static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			sorted = new int[N];
			reversSorted = new int[N];
			List<Integer> cards = new ArrayList<Integer>(N);

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				cards.add(Integer.parseInt(st.nextToken()));

				sorted[i] = i + 1;
				reversSorted[i] = N - i;
			}

			answer = Integer.MAX_VALUE;

			checking(cards, 0);

			if (answer == Integer.MAX_VALUE) {
				answer = -1;
			}

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void checking(List<Integer> cards, int cnt) {

		if (cnt > 5) {
			return;
		}

		boolean sortCheck = true;
		boolean reversSortCheck = true;

		for (int i = 0; i < N; i++) {
			if (cards.get(i) != sorted[i]) {
				sortCheck = false;
			}
			if (cards.get(i) != reversSorted[i]) {
				reversSortCheck = false;
			}
		}

		if (sortCheck || reversSortCheck) {
			answer = Math.min(answer, cnt);
			return;
		}

		if (cnt == 5) {
			return;
		}

		Queue<Integer> left = new ArrayDeque<>();
		Queue<Integer> right = new ArrayDeque<>();

		for (int x = 0; x < N; x++) {
			List<Integer> tempCards = new ArrayList<>(N);

			for (int i = 0; i < N / 2; i++) {
				left.offer(cards.get(i));
				right.offer(cards.get(i + N / 2));
			}

			if (x < N / 2) {
				for (int i = 0; i < N / 2 - x; i++) {
					tempCards.add(left.poll());
				}

				while (!right.isEmpty()) {

					tempCards.add(right.poll());

					if (!left.isEmpty()) {
						tempCards.add(left.poll());
					}
				}
			}

			if (x >= N / 2) {
				for (int i = 0; i < x - N / 2 + 1; i++) {
					tempCards.add(right.poll());
				}

				while (!left.isEmpty()) {

					tempCards.add(left.poll());

					if (!right.isEmpty()) {
						tempCards.add(right.poll());
					}
				}
			}

			checking(tempCards, cnt + 1);
		}
	}
}

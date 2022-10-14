package com.swea.mockTest.problem2115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, C, answer;
	static int[][] map;
	static List<Honey> list;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					list.add(new Honey(i, j, 0));
				}
			}

			for (int i = 0; i < list.size(); i++) {
				for (int j = 1; j <= M; j++) {
					numbers = new int[j];
					comb(i, 0, 0, j);
				}
			}

			Collections.sort(list, new Comparator<Honey>() {
				@Override
				public int compare(Honey o1, Honey o2) {
					return o2.profit - o1.profit;
				}
			});

			answer = 0;
			numbers = new int[2];
			combTwo(0, 0);

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void combTwo(int start, int cnt) {
		if (cnt == 2) {
			int temp = 0;
			int firstIdx = numbers[0];
			int secondIdx = numbers[1];

			Honey first = list.get(firstIdx);
			Honey second = list.get(secondIdx);

			if (first.r != second.r || Math.abs(first.c - second.c) >= M) {
				temp = first.profit + second.profit;
			}

			answer = Math.max(answer, temp);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			numbers[cnt] = i;
			combTwo(i + 1, cnt + 1);
		}

	}

	private static void comb(int idx, int start, int cnt, int R) {
		if (cnt == R) {
			Honey cur = list.get(idx);
			int r = cur.r;
			int c = cur.c;
			int profit = cur.profit;
			int temp = 0;
			int sum = 0;

			for (int i = 0; i < R; i++) {
				int getHoney = map[r][c + numbers[i]];
				sum += getHoney;
				if (sum > C) {
					temp = 0;
					break;
				}
				temp += getHoney * getHoney;
			}
			if (temp > profit) {
				cur.profit = temp;
			}
			return;
		}

		for (int i = start; i < M; i++) {
			numbers[cnt] = i;
			comb(idx, i + 1, cnt + 1, R);
		}

	}

}

class Honey {
	int r;
	int c;
	int profit;

	public Honey(int r, int c, int profit) {
		this.r = r;
		this.c = c;
		this.profit = profit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Honey [r=").append(r).append(", c=").append(c).append(", profit=").append(profit).append("]");
		return builder.toString();
	}

}

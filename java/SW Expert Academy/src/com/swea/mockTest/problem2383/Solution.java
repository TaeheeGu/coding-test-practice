package com.swea.mockTest.problem2383;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, K, answer;
	static int[][] map;
	static List<Person> persons;
	static List<Stair> stairs;

	static int[] numbers;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			map = new int[N][N];
			persons = new ArrayList<>();
			stairs = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						Person person = new Person(i, j, 0, 0, -1);
						persons.add(person);
					}
					if (map[i][j] != 0 && map[i][j] != 1) {
						Stair stair = new Stair(i, j, 0);
						stairs.add(stair);
					}
				}
			}

			K = persons.size();

			// 각 사람 위치에서 계단 까지 거리
			for (int i = 0; i < K; i++) {
				Person person = persons.get(i);
				int first = Math.abs(person.r - stairs.get(0).r) + Math.abs(person.c - stairs.get(0).c);
				int second = Math.abs(person.r - stairs.get(1).r) + Math.abs(person.c - stairs.get(1).c);
				person.first = first;
				person.second = second;
			}

			answer = Integer.MAX_VALUE;
			for (int i = 1; i <= K / 2; i++) {
				numbers = new int[i];
				comb(0, 0, i);
			}

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt, int k) {
		if (cnt == k) {
			List<Integer> first = new ArrayList<>();
			List<Integer> second = new ArrayList<>();

			for (int i = 0; i < k; i++) {
				first.add(numbers[i]);
			}
			for (int i = 0; i < K; i++) {
				if (!first.contains(i)) {
					second.add(i);
				}
			}

			int firstTime = moveToFirst(first, stairs.get(0));
			int secondTime = moveToSecond(second, stairs.get(1));

			answer = Math.min(answer, Math.max(firstTime, secondTime));
			return;
		}

		for (int i = start; i < K; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1, k);
		}
	}

	private static int move(List<Integer> list, Stair stair) {
		int time = 1;

		Queue<Person> queue = new ArrayDeque<>();
		for (int i = 0; i < list.size(); i++) {
			Person person = persons.get(i);
			queue.offer(person);
		}
		int cnt = 0;

		while (true) {
			Queue<Person> temp = new ArrayDeque<>();

			while (!queue.isEmpty()) {

				Person person = queue.poll();

				if (person.first == 0) {
					person.first = -1;
					person.down = 0;
					temp.offer(person);
				}

				if (person.first > 0) {
					person.first -= 1;
					temp.offer(person);
				}

				if (person.down == map[stair.r][stair.c]) {
					cnt -= 1;
					continue;
				}

				if (person.down > 0) {
					person.down += 1;
					temp.offer(person);
					continue;
				}

				if (person.down == 0) {
					if (cnt < 3) {
						cnt++;
						person.down += 1;
					}
					temp.offer(person);

				}
			}
			if (temp.isEmpty()) {
				break;
			}
			queue = temp;
			time++;
		}

		return time;
	}
}

class Person {
	int r;
	int c;
	int first; // 첫 번째 계단 까지 거리
	int second; // 두 번째 계단 까지 거리
	int down;

	public Person(int r, int c, int first, int second, int down) {
		this.r = r;
		this.c = c;
		this.first = first;
		this.second = second;
		this.down = down;
	}

}

class Stair {
	int r;
	int c;
	int cnt;

	public Stair(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
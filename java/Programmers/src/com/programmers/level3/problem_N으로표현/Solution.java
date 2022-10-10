package com.programmers.level3.problem_N으로표현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int number = Integer.parseInt(in.readLine());

		int answer = solution(N, number);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	public static int solution(int N, int number) {
		int answer = 0;

		if (N == number) {
			return 1;
		}

		List<Set<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			dp.add(new HashSet<>());
		}
		dp.get(1).add(N);

		for (int cur = 2; cur < 9; cur++) {
			Set<Integer> current = dp.get(cur);

			for (int a = 1; a < cur; a++) {
				Set<Integer> pre = dp.get(a);
				Set<Integer> next = dp.get(cur - a);

				for (int i : pre) {
					for (int j : next) {
						current.add(i + j);
						current.add(i - j);
						current.add(i * j);
						if (i != 0 && j != 0) {
							current.add(i / j);
						}

					}
				}

			}
			String temp = "";
			for (int i = 0; i < cur; i++) {
				temp += N;
			}
			current.add(Integer.valueOf(temp));
		}

		answer = -1;
		for (Set<Integer> sub : dp) {
			if (sub.contains(number)) {
				return answer = dp.indexOf(sub);
			}
		}
		return answer;
	}
}
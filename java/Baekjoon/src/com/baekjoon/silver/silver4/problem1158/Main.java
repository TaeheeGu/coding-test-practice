package com.baekjoon.silver.silver4.problem1158;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ 1158 - 요세푸스 문제
// https://www.acmicpc.net/problem/1158
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		sb.append("<");

		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		int idx = 0;
		int count = 1;

		while (!list.isEmpty()) {
			if (idx >= list.size()) {
				idx -= list.size();
			}

			if (count == K) {
				sb.append(list.get(idx));
				list.remove(idx);
				count = 1;

				if (list.isEmpty()) {
					sb.append(">");
				} else {
					sb.append(", ");
				}

			} else {
				count++;
				idx++;
			}

		}

		out.write(sb.toString());
		out.close();
	}
}

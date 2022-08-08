package com.baekjoon.silver.silver4.problem11399;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 11399번, ATM, 실버 4
// https://www.acmicpc.net/problem/11399
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		List<Integer> list = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		int temp = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			temp += list.get(i);
			sum += temp;
		}

		sb.append(sum);

		out.write(sb.toString());
		out.close();
	}
}

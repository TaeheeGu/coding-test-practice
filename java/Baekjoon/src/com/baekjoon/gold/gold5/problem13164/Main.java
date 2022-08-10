package com.baekjoon.gold.gold5.problem13164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 13164번 행복 유치원, 골드5
// https://www.acmicpc.net/problem/13164
public class Main {
	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] height = new int[N];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < height.length; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>(N-1);
		int sum = 0;
		
		for (int i = 0; i < N - 1; i++) {
			int temp = height[i + 1] - height[i];
			list.add(temp);
			sum += temp;
		}

		Collections.sort(list, Collections.reverseOrder());
		
		for(int i = 0; i < K-1; i++) {
			sum -= list.get(i);
		}

		sb.append(sum);
		
		out.write(sb.toString());
		out.close();
	}
}

package com.baekjoon.silver.silver1.problem11286;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// BJ 11286 - 절대값 힙, 실버 1
// https://www.acmicpc.net/problem/11286
public class Main {
	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(in.readLine());
			if (x == 0 && absHeap.isEmpty()) {
				sb.append(0).append("\n");
			} else if (x == 0 && !absHeap.isEmpty()) {
				sb.append(absHeap.poll()).append("\n");
			} else {
				absHeap.offer(x);
			}
		}

		out.write(sb.toString());
		out.close();
	}
}

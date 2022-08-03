package com.baekjoon.bronze.bronze1.problem1259;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// 1259번 팰린드롬수 bronze1
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		while (true) {
			char[] split = in.readLine().toCharArray();
			int n = split.length;

			if (n == 1 && split[0] == '0') {
				break;
			}
			if (n == 1) {
				sb.append("yes\n");
				continue;
			}

			Queue<Character> que = new LinkedList<>();
			if(n % 2 == 0) {
				for (int i = 0; i < n / 2; i++) { // 0 1 ;n/2 = 2
					que.add(split[i]);
				}
				for (int i = n - 1; i >= n / 2; i--) { // 3
					if (que.peek() == split[i]) {
						que.remove();
					} else {
						break;
					}
				}
			} else {
				for (int i = 0; i < n / 2; i++) { // 0 1 ;n/2 = 2
					que.add(split[i]);
				}
				for (int i = n - 1; i > n / 2; i--) { // 3
					if (que.peek() == split[i]) {
						que.remove();
					} else {
						break;
					}
				}
			}

			if (que.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}

		out.write(sb.toString());
		out.close();
	}
}

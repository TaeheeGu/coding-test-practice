package com.baekjoon.bronze.bronze3.problem11034;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 캥거루 세마리2. 브론즈3
// https://www.acmicpc.net/problem/11034
public class Main {
	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		while (true) {
			try {
				StringTokenizer st = new StringTokenizer(in.readLine());

				int left = Integer.parseInt(st.nextToken());
				int center = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());

				int cnt = 0;

				while (true) {
					if (center - left <= 1 && right - center <= 1) {
						break;
					}
					if (center - left <= right - center) { // 왼쪽 캥거루가 오른쪽으로
						left = center;
						center = right - 1;
					} else {
						right = center;
						center = left + 1;
					}
					cnt++;
				}
				sb.append(cnt).append("\n");
			} catch (Exception e) {
				break;
			}
		}

		out.write(sb.toString());
		out.close();
	}
}

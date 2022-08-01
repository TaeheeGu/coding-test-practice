package com.baekjoon.silver.silver3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//1244번, 스위치 켜고 끄기
// https://www.acmicpc.net/problem/1244

public class Main_1244 {

	static int check(int toggle) {
		if (toggle == 1) {
			return 0;
		}
		return 1;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] arr = new int[n];

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int number = Integer.parseInt(st.nextToken()); // 받은 수

			if (gender == 1) { // 남학생인 경우
				int x = number;
				int times = 1;
				while (true) {
					int idx = x * times - 1;
					if (idx > n - 1) {
						break;
					} else {
						arr[idx] = check(arr[idx]);
						times++;
					}
				}
			}
			if (gender == 2) { // 여학생인 경우
				arr[number - 1] = check(arr[number - 1]);
				int y1 = number - 1;
				int y2 = number - 1;
				while (true) {
					if (--y1 < 0 || ++y2 > n - 1) {
						break;
					}
					if (arr[y1] == arr[y2]) {
						arr[y1] = check(arr[y1]);
						arr[y2] = check(arr[y2]);
						continue;
					} else {
						break;
					}
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			sb.append(arr[i - 1]);
			if (i % 20 == 0) {
				sb.append("\n");
			} else {
				sb.append(" ");
			}
		}

		bw.write(sb.toString());
		bw.close();
	}
}
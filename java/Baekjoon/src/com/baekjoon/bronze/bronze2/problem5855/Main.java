package com.baekjoon.bronze.bronze2.problem5855;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 거스름돈
// https://www.acmicpc.net/problem/5585
public class Main {

	static final int Money = 1000;
	static int[] change = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		int n = Money - input;
		int cnt = 0;

		for (int i = 0; i < change.length; i++) {
			int temp = n / change[i];
			if (temp >= 1) {
				cnt += temp;
				n -= change[i] * temp;
			}
		}
		bw.write(cnt + "");
		bw.close();
	}
}

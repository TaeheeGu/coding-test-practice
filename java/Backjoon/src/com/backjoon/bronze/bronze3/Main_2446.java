package com.backjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 9
// https://www.acmicpc.net/problem/2446
public class Main_2446 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < n - i; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i * 2 - 1; j++) {
				sb.append("*");
			}
			bw.write(sb + "\n");
			bw.flush();
			sb.setLength(0);
		}
		for(int i = 2; i <= n;i++) {
			for (int j = 0; j < n - i; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i * 2 - 1; j++) {
				sb.append("*");
			}
			bw.write(sb + "\n");
			bw.flush();
			sb.setLength(0);
		}
		bw.close();
	}
}

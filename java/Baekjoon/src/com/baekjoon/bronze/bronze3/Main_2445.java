package com.baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 8
// https://www.acmicpc.net/problem/2445
public class Main_2445 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			for (int j = 0; j < (n - i) * 2; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			bw.write(sb + "\n");
			bw.flush();
			sb.setLength(0);
		}
		for(int i = n-1; i >0;i--) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			for (int j = 0; j < (n - i) * 2; j++) {
				sb.append(" ");
			}
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			bw.write(sb + "\n");
			bw.flush();
			sb.setLength(0);
		}
		bw.close();
	}
}

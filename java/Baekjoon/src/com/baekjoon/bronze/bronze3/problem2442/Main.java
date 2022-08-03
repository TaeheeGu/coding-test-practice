package com.baekjoon.bronze.bronze3.problem2442;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 5
// https://www.acmicpc.net/problem/2442
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String star = new String(new char[i * 2 - 1]).replace("\0", "*");
			for (int j = 0; j < n - i; j++) {
				bw.write(" ");
				bw.flush();
			}
			bw.write(star + "\n");
		}
		bw.close();

		// 숫자로 출력하기
//		int cnt = 1;
//		for (int i = 1; i <= n; i++) {
//			StringBuilder sb = new StringBuilder();
//			for (int j = 0; j < n - i; j++) {
//				sb.append("   ");
//			}
//			for (int j = 0; j < i * 2 - 1; j++) {
//				sb.append(String.format("%3d", cnt++));
//			}
//			bw.write(sb + "\n");
//			bw.flush();
//		}
//		bw.close();
	}
}

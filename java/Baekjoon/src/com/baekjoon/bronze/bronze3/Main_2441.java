package com.baekjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 4
// https://www.acmicpc.net/problem/2441
public class Main_2441 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

//		for (int i = n; i > 0; i--) {
//			String star = new String(new char[i]).replace("\0", "*");
//			for (int j = 0; j < n - i; j++) {
//				bw.write(" ");
//				bw.flush();
//			}
//			bw.write(star + "\n");
//		}
//		bw.close();

		// 숫자로 출력하기
//		int cnt = 1;
//		for (int i = n; i > 0; i--) {
//			StringBuilder sb = new StringBuilder();
//			for (int j = 0; j < n - i; j++) {
//				sb.append("   ");
//			}
//			for (int j = 0; j < i; j++) {
//				sb.append(String.format("%3d", cnt++));
//			}
//			bw.write(sb + "\n");
//			bw.flush();
//		}
//		bw.close();
	}
}

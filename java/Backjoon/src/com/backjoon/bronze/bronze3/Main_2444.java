package com.backjoon.bronze.bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 7
// https://www.acmicpc.net/problem/2444
public class Main_2444 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String star1 = new String(new char[i * 2 - 1]).replace("\0", "*");
			for (int j = 0; j < n - i; j++) {
				bw.write(" ");
				bw.flush();
			}
			bw.write(star1 + "\n");
			bw.flush();
		}
		for (int i = n - 1; i > 0; i--) {
			String star2 = new String(new char[i * 2 - 1]).replace("\0", "*");
			for (int j = 0; j < n - i; j++) {
				bw.write(" ");
				bw.flush();
			}
			bw.write(star2 + "\n");
			bw.flush();
		}
		bw.close();
	}
}

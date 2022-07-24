package com.backjoon.bronze.bronze3;

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

		for (int i = n; i > 0; i--) {
			String star = new String(new char[i]).replace("\0", "*");
			for (int j = 0; j < n - i; j++) {
				bw.write(" ");
				bw.flush();
			}
			bw.write(star + "\n");
		}
		bw.close();
	}
}

package com.backjoon.bronze.bronze4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 3
// https://www.acmicpc.net/problem/2440
public class Main_2440 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = n; i > 0; i--) {
			String star = new String(new char[i]).replace("\0", "*");
			bw.write(star + "\n");
			bw.flush();
		}
	}
}

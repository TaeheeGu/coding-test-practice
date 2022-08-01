package com.baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


// 2980번 : 도로와 신호등
// https://www.acmicpc.net/problem/2980
public class Miss_Main_2980 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] d = new int[n];
		int[] r = new int[n];
		int[] g = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			d[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
		}
		
		int time = 0;
		int distance = 0;
		int idx = 0;
		boolean go = false;
		
		while(distance < l) {
			if(distance == d[idx]) {
				
			}
		}
	}
}

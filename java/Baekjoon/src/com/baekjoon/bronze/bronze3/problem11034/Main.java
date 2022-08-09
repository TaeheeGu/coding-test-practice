package com.baekjoon.bronze.bronze3.problem11034;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 캥거루 세마리2. 브론즈3
// https://www.acmicpc.net/problem/11034
public class Main {
	public static void main(String[] args) throws IOException {

		//		System.setIn(new FileInputStream("input.txt")); 

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
	
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int left = Integer.parseInt(st.nextToken());
			int center = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			
			
		}

		out.write(sb.toString());
		out.close();
	}
}

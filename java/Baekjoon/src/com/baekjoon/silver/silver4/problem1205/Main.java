package com.baekjoon.silver.silver4.problem1205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준, 1205번, 등수 구하기, 실버4
// https://www.acmicpc.net/problem/1205
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		if(N == 0) {
			System.out.println(1);
			return;
		}
		
		int[] scores = new int[P];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			scores[i]= Integer.parseInt(st.nextToken()); 
		}

		
		int answer = -1;
		
		if(!(N == P && score <= scores[N-1])) {
			answer = 1;
			for(int i = 0; i < N; i++) {
				if(score < scores[i]) {
					answer++;
				}
				else {
					break;
				}
			}
		}

		
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

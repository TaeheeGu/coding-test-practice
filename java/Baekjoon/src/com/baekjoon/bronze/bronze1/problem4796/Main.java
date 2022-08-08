package com.baekjoon.bronze.bronze1.problem4796;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		int test_case = 1;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			if(L == 0) {
				break;
			}
			
			int answer = 0;
			
			answer = (V / P) * L;
			
			if (V % P > L) {
				answer += L;
			} else {
				answer += V % P;
			}
			
			sb.append("Case ")
				.append(test_case)
				.append(": ")
				.append(answer)
				.append("\n");
			
			test_case++;
		}
		
		out.write(sb.toString());
		out.close();
	}
}

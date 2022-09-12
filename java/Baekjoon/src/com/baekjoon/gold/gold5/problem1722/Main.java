package com.baekjoon.gold.gold5.problem1722;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int problem = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= N;i++) {
			list.add(i);
		}
		
		if(problem == 1) {
			int[] answer = new int[N];
			long K = Long.parseLong(st.nextToken()) - 1;
			
			for(int i = 1; i < N; i++) {
				long temp = fact(N-i);
				
				int cur = (int) (K / temp);
				
				answer[i-1] = list.get(cur);
				list.remove(cur);
				
				K -= cur * temp;

			}
			answer[N-1] = list.get(0);
			
			for(int i = 0; i < N; i++) {
				sb.append(answer[i]).append(" ");
			}
		}
		
		if(problem == 2) {
			long answer = 0;
			for(int i = 0; i < N; i++) {
				int cur = Integer.parseInt(st.nextToken()); 
				long temp = fact(N-i-1);

				answer += list.indexOf(cur) * temp;
				list.remove(list.indexOf(cur));
				
			}
			
			sb.append(answer + 1);
		}

		out.write(sb.toString());
		out.close();
	}

	private static long fact(int n) {
		long temp = 1;
		for(int i = 1; i <= n; i++) {
			temp *= i;
		}
		return temp;
	}
}

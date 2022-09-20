package com.baekjoon.gold.gold5.problem13975;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
			int K = Integer.parseInt(in.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0; i < K; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			long answer = 0;
			
			while(pq.size() > 1) {
				long a = pq.poll();
				long b = pq.poll();

				long sum = a + b;
				answer += sum;
				
				pq.offer(sum);
			}
			
			sb.append(answer).append("\n");
		}
		
		out.write(sb.toString());
		out.close();
	}
}

package com.baekjoon.silver.silver3.problem17204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int K = Integer.parseInt(st.nextToken()); // 보성이 번호

		int target[] = new int[N];

		for (int i = 0; i < N; i++) {
			target[i] = Integer.parseInt(in.readLine());
		}
		
		Set<Integer> game = new HashSet<Integer>();

		int size = 0;
		int answer = -1;
		int start = 0;
		int cnt = 0;
		
		while(true) {
			size = game.size();
			cnt++;
			int next = target[start];
			if(next == K) {
				answer = cnt;
				break;
			}
			
			start = next;
			game.add(next);
			
			if(size == game.size()) {
				break;
			}
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

package com.baekjoon.silver.silver2.problem1326;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준, 1326번, 폴짝폴짝, 실버2
// https://www.acmicpc.net/problem/1326
public class Main {

	private static int N;
	private static int start;
	private static int end;
	private static int[] arr;
	private static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		arr = new int[N + 1]; // 1번 인덱스 부터 사용

		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(in.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		answer = -1;

		bfs(start);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void bfs(int a) {

		Queue<Integer> queue = new ArrayDeque<Integer>();

		int[] cnt = new int[N + 1]; // 몇 번째 방문인지 기록
		boolean[] visited = new boolean[N + 1];
		visited[a]= true; 

		queue.offer(a);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			
//			System.out.println("cur" + " " + current);

			if (visited[end]) {
				answer = cnt[end];
				return;
			}

			for (int i = 1; i <= N; i++) {
				int right = current + (arr[current] * i);
				
				if(right > N) {
					break;
				}
//				System.out.println(right);
				
				if (!visited[right]) {					
					cnt[right] = cnt[current] + 1;
					visited[right] = true;
					queue.offer(right);
				}

			}
			
			for (int i = 1; i <= N; i++) {
				int left = current - (arr[current] * i);
				
				if(left < 1) {
					break;
				}
//				System.out.println(left);
				
				if (!visited[left]) {					
					cnt[left] = cnt[current] + 1;
					visited[left] = true;
					queue.offer(left);
				}

			}
		}

	}
}

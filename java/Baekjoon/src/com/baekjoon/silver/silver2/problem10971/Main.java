package com.baekjoon.silver.silver2.problem10971;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준, 10971번, 외판원 순회2, 실버2
// https://www.acmicpc.net/problem/10971
public class Main {

	private static int N;
	private static int[][] city;
	private static boolean[] visited;
	private static int result;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		city = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, i, 0, 0);	
		}

		sb.append(result);
		out.write(sb.toString());
		out.close();
	}

	private static void dfs(int start,int from, int dist, int cnt) {

		if(cnt == N-1) {
			if(city[from][start] != 0){
//				System.out.println(Arrays.toString(visited));
				result = Math.min(result, dist + city[from][start]);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && city[from][i] != 0) {
				visited[i] = true;
				dfs(start, i, dist + city[from][i], cnt+1);
				visited[i] = false;
			}
		}

	}

}

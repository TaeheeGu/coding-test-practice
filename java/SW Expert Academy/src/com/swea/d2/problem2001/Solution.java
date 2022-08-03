package com.swea.d2.problem2001;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2001. 파리 퇴치 D2
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
public class Solution {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] fly = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = -1;
			
			// 배열안에서 파리채의 시작점(좌상단)
			for (int i = 0; i < (N - M + 1); i++) {
				for (int j = 0; j < (N - M + 1); j++) {
					
					// 파리채에 잡하는 파리의 수 확인하기
					int temp = 0;
					for (int x = i; x < i + M; x++) {
						for (int y = j; y < j + M; y++) {
							temp += fly[x][y];
						}
					}
					max = Math.max(max, temp);
					
				}
			}
			sb.append(max).append("\n");

		}
		out.write(sb.toString());
		out.close();
	}
}

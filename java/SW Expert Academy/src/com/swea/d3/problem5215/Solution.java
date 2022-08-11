package com.swea.d3.problem5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 5215. 햄버거 다이어트 D3
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
public class Solution {

	static int N; // 재료의 수
	static int L; // 제한 칼로리
	static int[][] TK; // 재료의 점수, 재료의 칼로리
	static int max; // 조건에 맞는 최대 점수
	static boolean[] isSelected; // 부분집합 구성 시 사용할 flag

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			TK = new int[N][2];
			isSelected = new boolean[N];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				TK[i][0] = Integer.parseInt(st.nextToken());
				TK[i][1] = Integer.parseInt(st.nextToken());
			}

			// 부분집합 사용
			subset(0);

			sb.append(max).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void subset(int index) {

		// 기저 조건
		if (index == N) { // 더 이상 고려할 원소가 없다면 부분집합 구성 완성

			int sumT = 0; // 점수의 합
			int sumK = 0; // 칼로리의 합

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sumT += TK[i][0];
					sumK += TK[i][1];
				}
			}

			// 만약 제한 칼로리 이하이면
			if (sumK <= L) {

				// 맛에 대한 점수 최대값 갱신
				if (sumT > max) {
					max = sumT;
				}
			}
			return;
		}

		// 유도 부분
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1);

		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);

	}
}

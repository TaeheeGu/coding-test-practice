package com.baekjoon.gold.gold2.problem3109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BJ 3109 - 빵집, 골드 2
//https://www.acmicpc.net/problem/3109
public class Main {

	// 우상, 우, 우하
	private static final int[] dr = { -1, 0, 1 };
	private static final int[] dc = { 1, 1, 1 };

	private static final char BLANK = '.'; // 빈 칸
	private static final char PIPE = 'p'; // 파이프

	private static int R; // 빵집 근처의 모습 행 수
	private static int C; // 빵집 근처의 모습 열 수
	private static char[][] data; // 빵집 근처의 모습
	private static int answer; // 파이프라인의 최대 개수

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		// 빵집 근처의 모습
		data = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				data[i][j] = line.charAt(j);
			}
		}

		// 답 초기화
		answer = 0;

		// 파이프 건설 시작
		for(int i = 0; i < R; i ++) {
			dfs(i, 0);
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static boolean dfs(int r, int c) {

		// 기저 부분
		// 빵집에 도착했다면
		if (c == (C - 1)) {
			answer++; // 놓을 수 있는 파이프라인 개수 1 증가
			return true;
		}
		
		// 유도 부분

		// 진입 지접에 파이프 설치
		data[r][c] = PIPE;

		// 우상, 우, 우하 순으로 3방향 탐색
		for (int i = 0; i < 3; i++) {

			// 이동할 좌표 구하기
			int testR = r + dr[i];
			int testC = c + dc[i];

			// 경계 안이고 빈 칸이면 이동
			if ((0 <= testR && testR < R) && (0 <= testC && testC < C) && data[testR][testC] == BLANK) {
				if (dfs(testR, testC)) { // 빵집까지 도착했다면 true이기 떄문에 다른 방향 탐색을 멈춘다. (가지치기)
					return true;
				}
			}
		}
		return false;
	}
}

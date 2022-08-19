package com.baekjoon.gold.gold3.problem17135;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// BJ 17135 - 캐슬 디펜스, 골드 3
// https://www.acmicpc.net/problem/17135
public class Main {

	static int N, M, D;
	static int[] numbers;

	static int[][] map;

	static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[3];
		answer = 0;

		comb(0, 0);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {

		if (cnt == 3) {
			int temp = 0;

			// 초기 배열 값 저장
			int[][] tempArr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tempArr[i][j] = map[i][j];
				}
			}

			// 최대 행 길이 N 번 반복 가능
			for (int n = 0; n < N; n++) {
				// 공격할 적의 위치를 저장할 배열
				boolean[][] isSelected = new boolean[N][M];

				// 조합으로 선택한 궁수 위치
				for (int idx = 0; idx < 3; idx++) {
					int archerR = N;
					int archerC = numbers[idx];

					int minDist = Integer.MAX_VALUE; // 적과의 최소 거리
					int minR = Integer.MAX_VALUE; // 최소 거리 좌표 r
					int minC = Integer.MAX_VALUE; // 최소 거리 좌표 c

					// 맵 탐색
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							// 적이 있을 때
							if (map[i][j] == 1) {
								int distance = dist(archerR, archerC, i, j); // 적과의 거리

								if (distance <= minDist) { // 현재 적과의 거리가 최소 거리보다 작거나 같을 때

									if (distance < minDist) { // 최소 거리보다 가까운 경우
										minDist = distance; // 최소 거리 갱신
										minR = i;
										minC = j;
									}

									if (distance == minDist) { // 최소거리와 동일한 경우
										if (j < minC) { // 왼쪽에 있을 떄
											minR = i;
											minC = j;
										}
									}

								}
							}
						}
					}
					if (minDist <= D) { // 갱신된 최소거리가 사거리안에 들어올 경우
						isSelected[minR][minC] = true;
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (isSelected[i][j]) {
							temp++;
							map[i][j] = 0;
						}
					}
				}

				// 성 바로 위는 0으로
				for (int i = 0; i < M; i++) {
					map[N - 1][i] = 0;
				}

				// 나머지는 한칸 아래로
				for (int i = N - 1; i >= 1; i--) {
					for (int j = 0; j < M; j++) {
						map[i][j] = map[i - 1][j];
					}
				}

				// 맨 위 칸은 0으로
				for (int i = 0; i < M; i++) {
					map[0][i] = 0;
				}
			}

			answer = Math.max(answer, temp);

			// map 초기 상태로 되될리기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = tempArr[i][j];
				}
			}
			return;
		}

		for (int i = start; i < M; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

	private static int dist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
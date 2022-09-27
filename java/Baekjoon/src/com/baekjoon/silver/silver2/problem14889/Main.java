package com.baekjoon.silver.silver2.problem14889;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static int answer;
	static int[] numbers;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		numbers = new int[N / 2];
		answer = Integer.MAX_VALUE; // 최솟값을 구하기 위한 초기값

		numbers[0] = 1; // 가지치기
		comb(2, 1); // 1번을 포함한 모든 경우의 수와 1번을 포함하지 않는 모든 경우의 수로 나눌 수 있다.
		// 6명인 경우 1,2,3을 뽑는 것은 4,5,6을 뽑는 것과 동일
		// 따라서, N명 중 N/2명을 뽑는 작업을 절반만 수행하는 것은 전체를 확인하는 것과 같다.

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {
		if (answer == 0) {
			// 차이가 0보다 작을 순 없다. 0이 되는 경우가 앞서 존재한다면 최솟값은 무조건 0
			return;
		}

		// 선택한 N/2 명  vs 선택하지 않은 N/2명
		if (cnt == N / 2) {
			List<Integer> teamStart = new ArrayList<Integer>(); // 스타트팀
			List<Integer> teamRink = new ArrayList<Integer>(); // 링크팀

			for (int i = 1; i <= N; i++) {
				teamStart.add(i);
			}
			
			// 링크팀에 뽑힌 팀은 스타트팀에 속하지 않는다.
			for (int i = 0; i < N / 2; i++) {
				teamRink.add(numbers[i]);
				teamStart.remove(Integer.valueOf(numbers[i]));
			}
			
			// 스타트 팀의 합
			int S = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					S += arr[teamStart.get(i)][teamStart.get(j)];
				}
			}

			// 링크 팀의 합
			int R = 0;
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					R += arr[teamRink.get(i)][teamRink.get(j)];
				}
			}

			answer = Math.min(answer, Math.abs(S - R));

			return;
		}

		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}

	}
}

package com.baekjoon.gold.gold5.problem21758;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		// 타입은 long으로
		// 1. 한쪽 끝에 꿀벌, 한쪽 끝에 벌통이 위치한 경우
		// 1-2. 왼쪽 끝과 오른쪽 끝 중 통의 위치 선택
		// 2. 양쪽 끝에 꿀벌이 위치 가운데 벌통이 있는 경우, 양쪽 끝을 뺀 누적합 + 벌통의 위치 값

		// 타입은 long

		int N = Integer.parseInt(in.readLine());

		int[] arr = new int[N];
		long sum = 0L; // 최초 누적합

		long answer = 0L;
		int max = Integer.MIN_VALUE;

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];

			if (i != 0 && i != N - 1) {
				max = Math.max(max, arr[i]);
			}
		}

		// 1. 한쪽 끝에 꿀벌, 다른 한쪽 끝에 벌통이 위치
		long first = 0L; // 자신이 위치한 곳 제외
		long calFisrt = 0L;
		long calSecond = 0L;

		long temp1 = 0L;

		first = sum - arr[N - 1]; // 자신이 위치한 곳 제외

		calFisrt = first;
		calSecond = first;

		for (int i = N - 2; i >= 0; i--) {
			calSecond -= arr[i];
			calFisrt = first - arr[i];

			if (temp1 < calFisrt + calSecond) {
				temp1 = calFisrt + calSecond;
			}
		}

		long temp2 = 0L;
		first = sum - arr[0]; // 자신이 위치한 곳 제외

		calFisrt = first;
		calSecond = first;

		for (int i = 1; i < N; i++) {
			calSecond -= arr[i];
			calFisrt = first - arr[i];

			if (temp1 < calFisrt + calSecond) {
				temp1 = calFisrt + calSecond;
			}
		}

		// 2. 양쪽 끝에 꿀벌이 위치
		long temp3 = sum - (arr[0] + arr[N - 1]);
		temp3 += max; // 나머지중 가장 큰 값을 벌통으로

		answer = Math.max(temp1, Math.max(temp2, temp3));

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

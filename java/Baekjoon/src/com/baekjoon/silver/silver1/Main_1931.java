package com.baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 1931번 : 회의실 배정
// https://www.acmicpc.net/problem/1931
public class Main_1931 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 시작하는 시간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}
		
		// 회의실 배정은 가장 먼저 끝나는 회의를 선택한다.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { // 끝나는 시간이 같은 경우
					return o1[0] - o2[0]; // 시작 시간 기준으로 정렬
				}
				return o1[1] - o2[1]; // 끝나느 시간 기준으로 정렬
			}
		});
		int time = 0; // 현재 시간
		int cnt = 0; // 회의 개수
		
		for (int i = 0; i < n; i++) {
			if(arr[i][0] >= time) { // 시작 시간이 현재 시간 이후 일 때 
				cnt++;
				time = arr[i][1];
			}
		}
		bw.write(cnt + "");
		bw.close();		
	}
}

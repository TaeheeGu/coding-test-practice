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
		
		// 1. 한쪽 끝에 꿀벌, 한쪽 끝에 벌통이 위치한 경우, 왼쪽 끝과 오른쪽 끝 중 작은 값을 꿀벌의 위치로
		// 2. 양쪽 끝에 꿀벌이 위치 가운데 벌통이 있는 경우, 양쪽 끝을 뺀 누적합 + 벌통의 위치 값
		
		// 타입은 long
		
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		int sum = 0; // 최초 누적합
		
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			
			최소 최대 값 구하기
		}
		
		// 1. 한쪽 끝에 꿀벌, 다른 한쪽 끄트에 벌통이 위치

		// 2. 양쪽 끝에 꿀벌이 위치
		sum = sum - (arr[0] + arr[N-1]);
		
		
		out.write(sb.toString());
		out.close();
	}
}

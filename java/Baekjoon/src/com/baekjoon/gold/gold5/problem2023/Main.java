package com.baekjoon.gold.gold5.problem2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2023번, 신기한 소수, 골드5
//https://www.acmicpc.net/problem/2023
public class Main {

	// 결과를 한 번에 출력하기 위한 StringBuilder
	private static StringBuilder sb = new StringBuilder();
	private static int N;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		// 맨 앞 첫자리는 소수로 고정
		int[] prime = { 2, 3, 5, 7 };
		for (int i = 0; i < prime.length; i++) {
			appendNumber(prime[i]);
		}

		out.write(sb.toString());
		out.close();
	}

	private static void appendNumber(int num) {
		// 기저부분(종료 조건)
		if (String.valueOf(num).length() == N) {
			sb.append(num).append("\n");
			return;
		}

		// 유도 부분
		for (int i = 0; i < 10; i++) {
			int testNum = num * 10 + i; // num * 10 + (0 ~ 9) 까지의 수를 구한다.
			if (isPrime(testNum)) { // testNum이 소수인지 판별 후 소수이면 다음 소수를 구하기 위해 재귀 호출
				appendNumber(testNum);
			}
		}
	}

	// num 값이 소수인지 판별하는 메서드
	private static boolean isPrime(int num) {

		if (num < 2) {
			return false;
		}

		// 1과 자기 자신을 제외한 숫자로 나눠 떨어지면 소수가 아님
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}

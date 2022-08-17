package com.baekjoon.silver.silver1.problem1541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BJ 1541 - 잃어버린 괄호, 실버 2
//https://www.acmicpc.net/problem/1541
public class Answer {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		// - 연산 기준으로 나눈다.
		String[] split = in.readLine().split("-");

		int[] numbers = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			String s = split[i];

			String[] exp = s.split("\\+");
			int sum = 0;
			for (int j = 0; j < exp.length; j++) {
				sum += Integer.parseInt(exp[j]);
			}
			numbers[i] = sum;
		}

		// numbers에 담긴 수를 순서대로 뺼셈한다.
		int answer = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			answer -= numbers[i];
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}

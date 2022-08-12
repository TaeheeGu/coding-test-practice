package com.baekjoon.gold.gold4.problem16637;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준, 16637번, 괄호 추가하기, 골드4
// https://www.acmicpc.net/problem/16637
public class Main {
	
	static int max;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		
		char[] expr = in.readLine().toCharArray();
		
		max = Integer.MIN_VALUE;
		
		calc(expr);
		
		sb.append(max);
		out.write(sb.toString());
		out.close();
	}
	
	private static void calc(char[] expr) {
		
		int num1 = expr[0] - '0';
		for (int i = 1; i < expr.length; i+=2) {
			
			int num2 = expr[i + 1] - '0';		
			char temp = expr[i];

			switch (temp) {
			case '+':
				num1 = num1 + num2;
				break;
			case '-':
				num1 = num1 - num2;
				break;
			case '*':
				num1 = num1 * num2;
				break;
			}	
		}
		max = Math.max(max, num1);
		
		return;
	}
}

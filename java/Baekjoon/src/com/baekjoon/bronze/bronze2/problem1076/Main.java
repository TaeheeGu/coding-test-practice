package com.baekjoon.bronze.bronze2.problem1076;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 백준, 1076번, 저항, 브론즈2
// https://www.acmicpc.net/problem/1076
public class Main {
	public static void main(String[] args) throws Exception {

		//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		
		long answer = 0;
		
		String first = in.readLine();
		for(int i = 0; i < 10; i ++) {
			if(first.equals(color[i])) {
				answer += i * 10;
				break;
			}
		}
		
		String second = in.readLine();
		for(int i = 0; i < 10; i ++) {
			if(second.equals(color[i])) {
				answer += i;
				break;
			}
		}
		
		String third = in.readLine();
		for(int i = 0; i < 10; i ++) {
			if(third.equals(color[i])) {
				for(int j = 0; j < i; j++) {
					answer *= 10;
				}
				break;
			}
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
} 
/*
black	0	1
brown	1	10
red		2	100
orange	3	1,000
yellow	4	10,000
green	5	100,000
blue	6	1,000,000
violet	7	10,000,000
grey	8	100,000,000
white	9	1,000,000,000
*/
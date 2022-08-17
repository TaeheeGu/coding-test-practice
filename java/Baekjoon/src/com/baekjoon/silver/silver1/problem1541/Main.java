package com.baekjoon.silver.silver1.problem1541;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BJ 1541 - 잃어버린 괄호, 실버 2
// https://www.acmicpc.net/problem/1541
public class Main {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		char[] temp = in.readLine().toCharArray();

		List<String> exp = new ArrayList<>();

		String strNum = "";

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != '-' && temp[i] != '+') {
				strNum += temp[i];
			} else {
				exp.add(strNum);
				exp.add(temp[i] + "");
				strNum = "";
			}
		}
		exp.add(strNum); // 마지막 숫자 추가
		
		boolean minus = false;

		int min = Integer.parseInt(exp.get(0));

		for (int i = 1; i < exp.size(); i++) {
			if (exp.get(i).equals("-")) {
				minus = true;
			}

			if (!exp.get(i).equals("-") && !exp.get(i).equals("+")) {
				if (minus) {
					min -= Integer.parseInt(exp.get(i));
				} else {
					min += Integer.parseInt(exp.get(i));
				}
			}
		}

		sb.append(min);
		out.write(sb.toString());
		out.close();
	}

}

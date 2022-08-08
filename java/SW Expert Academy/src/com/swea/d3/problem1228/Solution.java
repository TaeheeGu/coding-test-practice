package com.swea.d3.problem1228;

import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//[S/W 문제해결 기본] 8일차 - 암호문1 D3

public class Solution {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int len = Integer.parseInt(in.readLine());

			List<String> pw = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < len; i++) {
				pw.add(st.nextToken());
			}

			int count = Integer.parseInt(in.readLine());
			int command = 0;
			st = new StringTokenizer(in.readLine());

			while (command != count) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				List<String> insertPw = new ArrayList<>();

				for (int i = 0; i < y; i++) {
					insertPw.add(st.nextToken());
				}
				
				List<String> leftSubPw = pw.subList(0, x);
				List<String> rightSubPw = pw.subList(x, pw.size());
				
				List<String> newPw = new ArrayList<>();
				newPw.addAll(leftSubPw);
				newPw.addAll(insertPw);
				newPw.addAll(rightSubPw);
				
				pw = newPw;
				
				command++;
			}
			for (int i = 0; i < 10; i++) {
				sb.append(pw.get(i)).append(" ");
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}
}

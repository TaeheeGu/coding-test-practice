package com.baekjoon.silver.silver4.problem10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 10828번, 스택, silver4
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> stack = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String command = st.nextToken();

			if (command.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				stack.add(x);
			}
			if (command.equals("pop")) {
				if(stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.get(stack.size() - 1) + "\n");
					stack.remove(stack.size() - 1);
				}
			}
			if (command.equals("size")) {
				sb.append(stack.size() + "\n");
			}
			if (command.equals("empty")) {
				if(stack.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
			if (command.equals("top")) {
				if(stack.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.get(stack.size() - 1) + "\n");
				}
			}
		}
		out.write(sb.toString());
		out.close();
	}
}

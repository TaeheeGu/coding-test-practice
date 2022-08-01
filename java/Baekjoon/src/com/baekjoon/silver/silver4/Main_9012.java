package com.baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_9012 {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(in.readLine());

		loop: for (int t = 1; t <= T; t++) {
			Queue<Character> queue = new LinkedList<>();
			char[] charArr = in.readLine().toCharArray();

			String answer = "YES";

			for (int i = 0; i < charArr.length; i++) {
				if (charArr[i] == '(') {
					queue.add('(');
				}
				if (charArr[i] == ')') {
					if (queue.isEmpty()) {
						answer = "NO";
						out.write(answer + "\n");
						out.flush();
						continue loop;
					}
					queue.remove();
				}
			}
			if (!queue.isEmpty()) {
				answer = "NO";
			}

			out.write(answer + "\n");
			out.flush();
		}
		out.close();
	}
}

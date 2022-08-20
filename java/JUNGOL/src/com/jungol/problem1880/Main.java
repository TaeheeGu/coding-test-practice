package com.jungol.problem1880;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 정올 1880번, 암호 풀기
// http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1153
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		char[] key = in.readLine().toCharArray();

		char[] pw = in.readLine().toCharArray();

		for (int i = 0; i < pw.length; i++) {
			if (pw[i] == ' ') {
				sb.append(" ");
				continue;
			}
			if ('A' <= pw[i] && pw[i] <= 'Z') {
				int encryption = pw[i] - 'A';
				sb.append((char)(key[encryption] - 32));
			} else {
				int encryption = pw[i] - 'a';
				sb.append(key[encryption]);
			}
		}

		out.write(sb.toString());
		out.close();
	}
}

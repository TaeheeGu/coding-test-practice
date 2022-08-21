package com.baekjoon.silver.silver3.problem1213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 백준, 1213번, 팰린드롬 만들기, 실버 3
// https://www.acmicpc.net/problem/1213
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		char[] english = in.readLine().toCharArray();

		char[] answer = new char[english.length];

		Arrays.sort(english);

		int[] cnt = new int[26];

		for (int i = 0; i < english.length; i++) {
			int idx = english[i] - 'A';
			cnt[idx]++;
		}

		boolean possible = true;
		int start = 0;
		int end = english.length - 1;
		
		boolean checking = true;

		for (int i = 0; i < 26; i++) {
			if (cnt[i] == 0) {
				continue;
			}
			if (cnt[i] % 2 == 0) {
				for(int j = 0; j < (cnt[i] / 2); j++) {
					answer[start + j] = (char)('A' + i);
					answer[end - j] = (char)('A' + i);
				}
				start = start + cnt[i]/2;
				end= end - cnt[i]/2;
			}
			else {
				if(!possible || answer.length%2 == 0) {
					checking = false;
					break;
				}
				else if (cnt[i] > 1) {
					for(int j = 0; j < (cnt[i] / 2); j++) {
						answer[start + j] = (char)('A' + i);
						answer[end - j] = (char)('A' + i);
					}
					start = start + cnt[i]/2;
					end= end - cnt[i]/2;
					
					answer[answer.length / 2] = (char)('A' + i);
					possible = false;
				}
				else if(cnt[i] == 1){
					answer[answer.length / 2] = (char)('A' + i);
					possible = false;
				}
			}
		}

		if(checking) {
			sb.append(answer);
		}
		else {
			sb.append("I'm Sorry Hansoo");
		}
		out.write(sb.toString());
		out.close();
	}
}

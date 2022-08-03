package com.swea.d3.problem1289;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1289번, 원재의 메모리 복구하기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN
public class Solution {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//		System.setIn(new FileInputStream("input.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			int cnt = 0;
			char[] memory = br.readLine().toCharArray();
			char[] init = new char[memory.length];

			for (int i = 0; i < memory.length; i++) {
				init[i] = '0';
			}

			for (int i = 0; i < memory.length; i++) {
				if (init[i] != memory[i]) {
					char temp = memory[i];
					for (int j = i; j < memory.length; j++) {
						init[j] = temp;
					}
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
	/**교수님 풀이
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			char[] memory = br.readLine().toCharArray();

			int answer = 0;

			// 메모리의 첫번째 값이 1일 경우는 한번 바꾼걸로 카운트
			if (memory[0] == '1') {
				answer++;
			}

			for (int i = 0; i < memory.length - 1; i++) {
				if (memory[i] != memory[i + 1]) {
					answer++;
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
	**/

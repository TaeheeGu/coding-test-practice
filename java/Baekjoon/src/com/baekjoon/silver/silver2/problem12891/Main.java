package com.baekjoon.silver.silver2.problem12891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 12891번, DNA 비밀번호, 실버2
// https://www.acmicpc.net/problem/12891
public class Main {
	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		int S = Integer.parseInt(st.nextToken()); // 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

		char[] split = in.readLine().toCharArray();

		char[] subSt = { 'A', 'C', 'G', 'T' };
		int[] count = new int[4];

		st = new StringTokenizer(in.readLine());

		for (int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Character> queue = new ArrayDeque<Character>();

		for (int i = 0; i < S; i++) {
			queue.offer(split[i]);
		}

		int answer = 0;
		int[] subCount = new int[4];

		Queue<Character> pw = new ArrayDeque<Character>(); // 부분문자열을 저장할 큐

		for (int i = 0; i < P; i++) { // 최초의 부분문자열
			char temp = queue.poll();
			for (int j = 0; j < 4; j++) { // 해당하는 문자의 개수 카운트
				if (temp == subSt[j]) {
					subCount[j]++;
					break;
				}
			}
			pw.offer(temp); // 부분문자열 큐에 추가
		}

		boolean check = false;

		while (true) {
			for (int i = 0; i < 4; i++) { // 부분문자열의 각 문자 개수 확인
				if (subCount[i] >= count[i]) { // 최소 개수보다 많은 경우
					check = true;
				} else { // 최소 개수 보다 적은 경우, 비밀번호가 될 수 없다.
					check = false;
					break;
				}
			}

			if (check) { // 비밀번호 가능 여부 확인, 종류의 수 증가
				answer++;
			}

			if (queue.isEmpty()) { // 전체 문자열을 모두 사용하여 검사한 경우 종료
				break;
			}

			char outPw = pw.poll(); // 비밀번호 부분 문자열의 맨 앞 문자 제거
			for (int i = 0; i < 4; i++) { // 제거된 문자의 개수 카운트 감소
				if (outPw == subSt[i]) {
					subCount[i]--;
				}
			}

			char inPW = queue.poll(); // 남은 전체 문자열에서 맨 앞의 문자 가져오기
			for (int i = 0; i < 4; i++) { // 가져온 문자에 해당하는 개수 증가
				if (inPW == subSt[i]) {
					subCount[i]++;
				}
			}
			pw.offer(inPW); // 가져온 문자를 비밀번호(부분 문자열)에 추가

		}
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}
}


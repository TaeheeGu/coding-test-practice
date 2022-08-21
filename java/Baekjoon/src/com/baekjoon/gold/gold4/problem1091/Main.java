package com.baekjoon.gold.gold4.problem1091;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준, 1091번, 카드 섞기, 골드 4
// https://www.acmicpc.net/problem/1091
public class Main {

	static int N;
	static int[] P;
	static int[] S;
	static int[] card;

	static List<Integer> player0;
	static List<Integer> player1;
	static List<Integer> player2;

	static int answer;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		P = new int[N];
		S = new int[N];
		card = new int[N]; // 현재 카드 정보

		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		player0 = new ArrayList<>();
		player1 = new ArrayList<>();
		player2 = new ArrayList<>();

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
			card[i] = S[i];

			if (P[i] == 0) {
				player0.add(S[i]);
			} else if (P[i] == 1) {
				player1.add(S[i]);
			} else if (P[i] == 2) {
				player2.add(S[i]);
			}

		}

		answer = 0;
		
		int[] temp = new int[N];

		for (int i = 0; i < N; i++) {
			temp[i] = card[i];
		}

		while (true) {
			
			if (possible()) {
				break;
			} else {
				
				shuffle();
				answer++;

				boolean check = true;
				for (int i = 0; i < N; i++) {
					if(temp[i] != card[i]) {
						check = false;
					}
				}
				
				if(check) {
					answer = -1;
					break;
				}

			}

		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static boolean possible() {

		for (int i = 0; i < N; i++) {
			if (i % 3 == 0) {			
				if(!player0.contains(card[i])) {
					return false;
				}
			}
			
			if (i % 3 == 1) {
				if(!player1.contains(card[i])) {
					return false;
				}
			}
			
			if (i % 3 == 2) {
				if(!player2.contains(card[i])) {
					return false;
				}
			}
		}
		return true;
	}

	private static void shuffle() {
		int[] temp = new int[N];

		for (int i = 0; i < N; i++) {
			temp[i] = card[i];
		}

		for (int i = 0; i < N; i++) {
			card[S[i]] = temp[i];
		}

	}
}

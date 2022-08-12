package com.swea.mockTest.problem4012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 4012 - [모의 SW 역량테스트] 요리사
// 
public class Solution {

	static int N;
	static int[][] S;

	static boolean[] isSelected;

	static int min;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			S = new int[N][N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0);
			
			sb.append(min).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {

		if (cnt == N / 2) {
			int[] selectedTaste = new int[N / 2];
			int selectedTasteIdx = 0;
			int[] notSelectedTeste = new int[N / 2];
			int notSelectedTesteIdx = 0;

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					selectedTaste[selectedTasteIdx] = i;
					selectedTasteIdx++;
				} else {
					notSelectedTeste[notSelectedTesteIdx] = i;
					notSelectedTesteIdx++;
				}
			}

			int selectedTasteSum = 0;

			for (int i = 0; i < N / 2; i++) {
				int x = selectedTaste[i];
				for (int j = 0; j < N / 2; j++) {
					if (i == j) {
						continue;
					}
					int y = selectedTaste[j];

					selectedTasteSum += S[x][y];
				}
			}

			int notSelectedTasteSum = 0;

			for (int i = 0; i < N / 2; i++) {
				int x = notSelectedTeste[i];
				for (int j = 0; j < N / 2; j++) {
					if (i == j) {
						continue;
					}
					int y = notSelectedTeste[j];

					notSelectedTasteSum += S[x][y];
				}
			}
			
			
			
			min = Math.min(Math.abs(selectedTasteSum - notSelectedTasteSum), min);
			
			return;
		}

		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			comb(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}
}

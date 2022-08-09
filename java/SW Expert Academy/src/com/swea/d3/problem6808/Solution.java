package com.swea.d3.problem6808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//  SWEA 6808 - 규영이와 인영이의 카드게임, D3
public class Solution {

	static int[] numbers;
	static boolean[] isSelected;
	static int[] card;
	static int win;
	static int lose;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("s_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			card = new int[9];
			numbers = new int[9];
			isSelected = new boolean[19];
			win = 0;
			lose = 0;

			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				card[i] = num;
				isSelected[num] = true;
			}
			perm(0);
			
			sb.append(win).append(" ").append(lose).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	public static void perm(int cnt) {

		if (cnt == 9) {
			int winPoint = 0;
			int losePoint = 0;
			for (int i = 0; i < card.length; i++) {
				if (card[i] > numbers[i]) {
					winPoint += card[i] + numbers[i];
				} else {
					losePoint += card[i] + numbers[i];
				}
			}
			if(winPoint > losePoint) {
				win++;
			}
			if(winPoint < losePoint) {
				lose++;
			}
			return;
		}

		for (int i = 1; i <= 18; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				perm(cnt + 1);
				isSelected[i] = false;
			}
		}
	}
}

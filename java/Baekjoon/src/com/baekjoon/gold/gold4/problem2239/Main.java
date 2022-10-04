package com.baekjoon.gold.gold4.problem2239;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 골드 4, 2239번 스도쿠
public class Main {

	static int arr[][];
	static boolean check;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		arr = new int[9][9];

		for (int i = 0; i < 9; i++) {
			char[] split = in.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = split[j] - '0';
			}
		}

		// 0, 1, 2, 3, 4, 5, 6, 7, 8
		check = false;
		solve(0);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void solve(int depth) {
		if (depth == 81) {
			check = true;
			return;
		}

		int row = depth / 9;
		int col = depth % 9;

		if (arr[row][col] != 0) {
			solve(depth + 1);
		} else {
			for (int num = 1; num <= 9; num++) {
				if (checkBox(row, col, num) && checkRow(row, num) && checkCol(col, num)) {
					arr[row][col] = num;
					solve(depth + 1);
					if (check) {
						return;
					}
					arr[row][col] = 0;
				}
			}
		}
	}

	private static boolean checkCol(int col, int num) {
		for (int row = 0; row < 9; row++) {
			if (arr[row][col] == num) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkRow(int row, int num) {
		for (int col = 0; col < 9; col++) {
			if (arr[row][col] == num) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkBox(int x, int y, int num) {
		int row = (x / 3) * 3;
		int col = (y / 3) * 3;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (arr[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
}

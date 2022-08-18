package com.algo.java.backtracking;

import java.util.Scanner;

public class NQueenTest {

	static int N, ans;
	static int[] cols;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		cols = new int[N + 1]; // 1행부터 시작
		ans = 0;
		
		setQueen(1);
		System.out.println(ans);
	}

	private static void setQueen(int rowNo) { // 하나의 퀸만 가능한 모든 곳에 놓아보기

		if (rowNo > N) { // 퀸을 다 놓았으면
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			cols[rowNo] = i;
			
			if (isAvailable(rowNo)) { // 직전까지의 상황이 유망하지 않으면 현재 퀸을 놓을 필요가 없으니 백트랙
				setQueen(rowNo + 1);
			}
		}
	}

	private static boolean isAvailable(int rowNo) {

		for (int j = 1; j < rowNo; j++) {
			if (cols[j] == cols[rowNo] || rowNo - j == Math.abs(cols[rowNo] - cols[j])) {
				return false;
			}
		}

		return true;
	}
}

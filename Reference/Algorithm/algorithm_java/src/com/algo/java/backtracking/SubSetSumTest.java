package com.algo.java.backtracking;

import java.util.Scanner;

public class SubSetSumTest {

	// n개의 자연수를 입력받고 목표 합이 주어지면 목표 함에 해당하는 부분집합을 출력

	static int N, totalCount, S;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt(); // 목표 합
		totalCount = 0;
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		subset(0, 0);
		System.out.println("총 경우의 수: " + totalCount);
	}

	private static void subset(int index, int sum) {

		if (sum == S) {
			totalCount++;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					System.out.print(input[i] + "\t");
				}
			}
			System.out.println();

			return;
		}

		// 초과하면 그만, 끝까지 확인해본 경우
		if (sum > S || index == N) {
			return;
		}
		
		
		// sum < S
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1, sum + input[index]);

		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1, sum);
	}
}

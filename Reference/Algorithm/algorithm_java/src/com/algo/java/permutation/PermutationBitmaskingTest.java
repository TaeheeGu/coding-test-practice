package com.algo.java.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitmaskingTest {

	static int N, R, totalCount;
	static int[] numbers;
//	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCount = 0;

		numbers = new int[R];

		perm(0, 0);
		System.out.println("총 경우의 수 : " + totalCount);
	}

	// flag : 선택된 수들의 상태를 비트로 표현하고 있는 비트열(정수)
	private static void perm(int cnt, int flag) { // cnt : 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1 번째 해당하는 순열에 포함될 수를 뽑기

		if (cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 가능한 모든 수에 대해 시도
		for (int i = 1; i <= N; i++) {

			// 시도하는 수가 선택되었는지 판단
			if ((flag & 1 << i) != 0) {
				continue; // 사용 중이라면 다음 숫자 확인
			}

			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = i;

			// 다음수 뽑으러 가기
			perm(cnt + 1, flag | 1 << i);

		}
	}
}

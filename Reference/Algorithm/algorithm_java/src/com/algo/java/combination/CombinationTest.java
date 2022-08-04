package com.algo.java.combination;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {

	static int N, R, totalCount;
	static int[] numbers, input;

	// nCr : n 개의 입력받은 수 중 r개를 모두 뽑아 순서없이 나열한 것

	// r = n/2 일 때 경우의 수가 제일 많다.
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCount = 0;

		input = new int[N];
		numbers = new int[R];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		comb(0, 0);
		System.out.println("총 경우의 수 : " + totalCount);
	}

	// cnt : 직전까지 뽑은 조합에 포함된 수의 개수, cnt+1 번째 해당하는 조합에 포함될 수를 뽑기
	// start : 시도할 수의 시작 위치만 결정
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 가능한 모든 수에 대해 시도(input 배열의 가능한 수 시도)
		// start 부터 처리 시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지
		// 실제 처리할 숫자는 i
		for (int i = start; i < N; i++) { // 선택지
			// start 위치부터 처리했으면 중복 체크 필요 없음
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];

			// 다음수 뽑으러 가기
			comb(cnt + 1, i + 1);

		}
	}
}

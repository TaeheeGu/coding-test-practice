package com.algo.java.lis;

import java.util.Arrays;
import java.util.Scanner;

public class LisTset2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		int[] arr = new int[N]; // 수열의 수들
		int[] C = new int[N]; // 동적테이블C[k]: 해당(k) 길이를 만족하는 자리(k자리)에 오는 수 최솟값

		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}

		int size = 0;

		for (int i = 0; i < N; i++) {

			int pos = Arrays.binarySearch(C, 0, size, arr[i]);

			if (pos >= 0) {
				continue;
			}

			int insertPos = Math.abs(pos) - 1; // 맨 뒤, 기존원소 대체자리
			C[insertPos] = arr[i];

			if (insertPos == size) {
				size++;
			}
		}

		System.out.println(Arrays.toString(C));
		System.out.println(size);

	}
}

package com.algo.java;

import java.util.Scanner;

public class Factorial {

	// loop
	static int factorial_loop(int n) {

		int ans = 1;
		for (int i = n; i >= 1; i--) {
			ans *= i;
		}
		return ans;
	}

	// recursive function
	static int res = 1;

	static void factorial_recursive(int n) { // n 값을 기존 누적 값에 곱하는 방식으로

		if (n < 1) {
			return;
		}

		res *= n;
		factorial_recursive(n - 1);
	}

	static int factorial_recursive2(int n) {

		if (n <= 1) {
			return 1;
		}

		return n * factorial_recursive2(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(factorial_loop(N));

		factorial_recursive(N);
		System.out.println(res);
		
		System.out.println(factorial_recursive2(N));
	}
}

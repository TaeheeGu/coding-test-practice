package com.algo.java.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest1 {

	static int N, R, totalCount;
	static int[] numbers;
	static boolean[] isSelected;

	// nPn : 1부터 n까지의 수 중 n 개를 모두 뽑아 순차적으로 나열한 것
	// nPr : 1부터 n까지의 수 중 r 개를 모두 뽑아 순차적으로 나열한 것 (1 <= R <= N)
	
	// 시간 복잡도 n! 10! > 360만(거의 문제 입력 마지노선), 입력이 11 이상이된다면 순열이 아닐 가능성이 크다! 11! > 4,000만, 12! > 5억
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCount = 0;

		numbers = new int[R];
		isSelected = new boolean[N + 1]; // 숫자가 1부터 시작
		
		perm(0);
		System.out.println("총 경우의 수 : " + totalCount);
	}

	private static void perm(int cnt) { // cnt : 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1 번째 해당하는 순영레 포함될 수를 뽑기

		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		for (int i = 1; i <= N; i++) {

			// 시도하는 수가 선택되었는지 판단
			if (isSelected[i]) {
				continue; // 사용 중이라면 다음 숫자 확인
			}

			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = i;
			isSelected[i] = true;

			// 다음수 뽑으러 가기
			perm(cnt + 1);
			
			// 사용했던 수에 대해 선택 되돌리기
			isSelected[i]= false;
			

		}
	}
}

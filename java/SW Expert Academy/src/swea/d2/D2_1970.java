package swea.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 쉬운 거스름돈
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PsIl6AXIDFAUq&categoryId=AV5PsIl6AXIDFAUq&categoryType=CODE&problemTitle=1970&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

public class D2_1970 {

	static int[] change = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#" + t);

			for (int i = 0; i < 8; i++) {
				int cnt = 0;
				int temp = n / change[i];
				
				if (temp >= 1) {
					cnt = temp;
					n -= change[i] * temp;
				}
				System.out.print(cnt + " ");
			}
			System.out.println();
		}
	}
}

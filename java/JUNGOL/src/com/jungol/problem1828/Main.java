package com.jungol.problem1828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 정보올림피아드 1828번, 냉장고
public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());

		int[][] temper = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			temper[i][0] = Integer.parseInt(st.nextToken());
			temper[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temper, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		
		int cnt = 1;
		int refrigerator= temper[0][1];
		
		for (int i = 1; i < N; i++) {
			if(temper[i][0] <= refrigerator && refrigerator <= temper[i][1]) {
				continue;
			}
			else {
				cnt++;
				refrigerator = temper[i][1];
			}
		}
		
		sb.append(cnt);
		
		out.write(sb.toString());
		out.close();
	}
}

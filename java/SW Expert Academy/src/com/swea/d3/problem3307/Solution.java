package com.swea.d3.problem3307;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SWEA 3307 - 최장 증가 부분 수열
public class Solution {
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(in.readLine());

			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] lis = new int[N];

			lis[0] = 1;
			int max = 1;

			for (int i = 1; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
					}
				}
				max = Math.max(max, lis[i]);
			}

			sb.append(max).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}
}

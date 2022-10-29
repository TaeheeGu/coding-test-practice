package com.swea.d3.problem5515;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int[] M = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int[] dayOfWeek = { 3, 4, 5, 6, 0, 1, 2};

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());

			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			int yearOfDay = 0;
			for(int i = 0; i < month; i++) {
				yearOfDay += M[i];
			}
			yearOfDay += day;
			
			int answer = dayOfWeek[yearOfDay % 7];
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

}

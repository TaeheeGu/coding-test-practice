package com.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//  1208번, [S/W 문제해결 기본] 1일차 - Flatten D3
public class D3_1208 {

	static final int len = 100;

	public static void main(String[] args) throws IOException {

		 System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = 10; // test_case 개수

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			int dumpCount = Integer.parseInt(in.readLine()); // 제한된 덤프 횟수

			int[] boxes = new int[len]; // 상자 상태
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for (int i = 0; i < len; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}

			int dump = -1; // 최고 높이 - 최저 높이

			for (int i = 0; i < dumpCount; i++) {
				Arrays.sort(boxes); // 1000 * 100log100 = 1000,000
				
				if (boxes[len - 1] - boxes[0] <= 1) { // 더 이상 상자를 옮길 수 없는 경우
					break;
				}				
				++boxes[0];
				--boxes[len - 1];
			}
			Arrays.sort(boxes);
			dump = boxes[len - 1] - boxes[0];
			sb.append(dump + "\n");
		}
		out.write(sb.toString());
		out.close();
	}
}

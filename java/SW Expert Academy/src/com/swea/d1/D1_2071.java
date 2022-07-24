package com.swea.d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 평균값 구하기
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QRnJqA5cDFAUq&categoryId=AV5QRnJqA5cDFAUq&categoryType=CODE&problemTitle=2071&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
public class D1_2071 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");
			bw.flush();

			int sum = 0;
			String[] temp = br.readLine().split(" ");
			for (int i = 0; i < 10; i++) {
				sum += Integer.parseInt(temp[i]);
			}
			int avg = (int) Math.round(sum / 10.0);
			bw.write(avg + "\n");
			bw.flush();
		}

	}
}

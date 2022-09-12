package com.baekjoon.silver.silver5.problem1251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static int len;
	private static char[] word;
	private static int[] number;
	private static List<String> list;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		word = in.readLine().toCharArray();
		len = word.length;

		number = new int[2];
		list = new ArrayList<String>();


		comb(0, 0);
		
		Collections.sort(list);
		
		
		sb.append(list.get(0));
		out.write(sb.toString());
		out.close();
	}

	private static void comb(int start, int cnt) {
		
		if(cnt == 2) {
			String temp = "";
			int first = number[0]; // 0 ~ first
			int second= number[1]; // first + 1 ~ second
			int third = len; // second + 1 ~ len
			
			for(int i = first; i >= 0; i--) {
				temp += word[i];
			}
			for(int i = second; i > first; i--) {
				temp += word[i];
			}
			for(int i = third - 1; i > second; i--) {
				temp += word[i];
			}
			
			list.add(temp);
			
			return;
		}

		for (int i = start; i < len -1; i++) {
			number[cnt]= i; 
			comb(i + 1, cnt + 1);

		}
	}
}

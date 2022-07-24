package com.backjoon.bronze.bronze5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// 별 찍기 - 1
// https://www.acmicpc.net/problem/2438
public class Main_2438 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		int n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++) {
			String star = new String(new char[i]).replace("\0",  "*");
			bw.write(star + "\n");
			bw.flush();
		}
		bw.close();

	}
}

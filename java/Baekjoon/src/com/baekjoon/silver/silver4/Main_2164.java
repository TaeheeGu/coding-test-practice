package com.baekjoon.silver.silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164 {
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(in.readLine());
		
		// 1. 제일 위 카드 버리기
		// 2. 제일 위 카드 맨 아래로
		
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			cards.add(i);
		}
		
		while(cards.size() > 1) {
			cards.remove();
			cards.add(cards.peek());
			cards.remove();
		}
		
		out.write(cards.peek().toString());
		out.close();
	}
}

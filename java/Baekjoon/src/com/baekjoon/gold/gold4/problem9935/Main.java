package com.baekjoon.gold.gold4.problem9935;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		char[] input = in.readLine().toCharArray();

		char[] bomb = in.readLine().toCharArray();

		Stack<Character> stack = new Stack<>();
		
		for(Character c : input) {
			stack.add(c);
		}
		
		int idx = 0;
		int len = bomb.length;
		
		while(true) {
			
			if(stack.peek() != bomb[idx]) {
				
			}
		}


//		out.write(sb.toString());
//		out.close();

	}
}

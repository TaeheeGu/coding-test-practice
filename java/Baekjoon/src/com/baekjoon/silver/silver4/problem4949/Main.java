package com.baekjoon.silver.silver4.problem4949;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 4949번, 균형잡힌 세상, silver4
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		while (true) {
			char[] split = in.readLine().toCharArray();
			
			if(split.length == 1 && split[0] =='.') {
				break;
			}

			ArrayList<Character> list = new ArrayList<>();

			for (int i = 0; i < split.length; i++) {
				if (split[i] == '.') {
					if(list.isEmpty()) {
						sb.append("yes\n");
					} else {
						sb.append("no\n");
					}
					list.clear();
					continue;
				}
				if (split[i] == '(' || split[i] == '[') {
					list.add(split[i]);
				}
				if (split[i] == ')') {
					if(list.size() != 0 && list.get(list.size()-1) == '(') {
						list.remove(list.size()-1);
					} else {
						list.add(split[i]);
					}
				}
				
				if (split[i] == ']') {
					if(list.size() != 0 && list.get(list.size()-1) == '[') {
						list.remove(list.size()-1);
					} else {
						list.add(split[i]);
					}
				}
			}
		}
		out.write(sb.toString());
		out.close();
	}
}

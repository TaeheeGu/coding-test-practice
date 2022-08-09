package com.baekjoon.gold.gold4.problem1744;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		List<Integer> positivLlist = new ArrayList<Integer>();
		List<Integer> negativeLlist = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int element = Integer.parseInt(in.readLine());

			if (element > 0) {
				positivLlist.add(element);
			} else {
				negativeLlist.add(element);
			}

		}

		Collections.sort(positivLlist, Collections.reverseOrder());
		Collections.sort(negativeLlist);

		int sum = 0;

		for (int i = 0; i < positivLlist.size(); i += 2) {
			if (i == positivLlist.size() - 1) {
				sum += positivLlist.get(i);
				break;
			}
			if (positivLlist.get(i) == 1 || positivLlist.get(i + 1) == 1) {
				sum += positivLlist.get(i) + positivLlist.get(i + 1);
				continue;
			}
			sum += positivLlist.get(i) * positivLlist.get(i + 1);
		}

		for (int i = 0; i < negativeLlist.size(); i += 2) {
			if (i == negativeLlist.size() - 1) {
				sum += negativeLlist.get(i);
				break;
			}
			sum += negativeLlist.get(i) * negativeLlist.get(i + 1);
		}

		sb.append(sum);

		out.write(sb.toString());
		out.close();
	}
}

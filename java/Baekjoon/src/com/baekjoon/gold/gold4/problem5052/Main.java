package com.baekjoon.gold.gold4.problem5052;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main -{

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(in.readLine());

			HashMap<Integer, List<String>> map = new HashMap<>();
			List<Integer> keyList = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				String st = in.readLine();
				int len = st.length();

				if (map.containsKey(len)) {
					map.get(len).add(st);
				} else {
					List<String> list = new ArrayList<>();
					list.add(st);
					map.put(len, list);
					keyList.add(len);
				}
			}

			Collections.sort(keyList);

			String answer = "YES";

			loop: for (int i = 0; i < keyList.size() - 1; i++) {
				List<String> numbers = map.get(keyList.get(i));

				for (int j = 0; j < numbers.size(); j++) {
					String head = numbers.get(j);

					for (int k = i + 1; k < keyList.size(); k++) {

						List<String> nextNums = map.get(keyList.get(k));

						for (int h = 0; h < nextNums.size(); h++) {
							String next = nextNums.get(h);
							if (head.equals(next.substring(0, head.length()))) {
								answer = "NO";
								break loop;
							}
						}
					}
				}

			}

			sb.append(answer).append('\n');
		}

		out.write(sb.toString());
		out.close();

	}
}

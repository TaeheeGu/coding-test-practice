package com.swea.advanced.problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int[][] map;

	private static List<Point> checkPoint;
	private static List<Integer> monster;

	private static int answer;

	private static boolean[] isSelected;
	private static int[] numbers;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			map = new int[N][N];
			checkPoint = new ArrayList<Point>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						checkPoint.add(new Point(i, j));
					}
				}
			}
			
			isSelected = new boolean[checkPoint.size()];
			numbers = new int[checkPoint.size()];
			answer = Integer.MAX_VALUE;
			perm(0);

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {

		if (cnt == checkPoint.size()) {

//			System.out.println(Arrays.toString(numbers));

			monster = new ArrayList<Integer>();
			Point hunter = new Point(0, 0);
			int temp = 0;

			for (int i = 0; i < numbers.length; i++) {

				if (temp > answer) {
					return;
				}

				Point cur = checkPoint.get(numbers[i]);

				int r = cur.r;
				int c = cur.c;
//				System.out.println(r + " " + c);

				if (map[r][c] > 0) {

//					System.out.println(map[r][c] + " monster ");

					monster.add(map[r][c]);
					temp += getDist(hunter.r, hunter.c, r, c);
					hunter.r = r;
					hunter.c = c;
				}

				if (map[r][c] < 0) {
					if (monster.isEmpty()) {
						return;
					} else {
						boolean contain = false;
						for (int idx = 0; idx < monster.size(); idx++) {
							if (Math.abs(map[r][c]) == monster.get(idx)) {
//								System.out.println(Math.abs(map[r][c]) + " client ");

								temp += getDist(hunter.r, hunter.c, r, c);
								hunter.r = r;
								hunter.c = c;

								contain = true;
								break;
							}
						}

						if (!contain) {
							return;
						}
					}
				}
			}

			answer = Math.min(answer, temp);
//			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < checkPoint.size(); i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				perm(cnt + 1);

				isSelected[i] = false;
			}
		}

	}

	private static int getDist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}

class Point {
	public int r;
	public int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

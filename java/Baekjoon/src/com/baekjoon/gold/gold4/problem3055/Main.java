package com.baekjoon.gold.gold4.problem3055;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//  BJ 3055 - 탈출, 골드 4
// https://www.acmicpc.net/problem/3055
public class Main {

	private static int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 오른쪽, 왼쪽
	private static int[] dy = { 0, 0, 1, -1 };

	private static char[][] map;
	private static int R, C;
	private static int answer;

	private static Queue<Point> water;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		int startR = -1;
		int startC = -1;
		water = new ArrayDeque<Point>();

		for (int i = 0; i < R; i++) {
			char[] temp = in.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
				if (temp[j] == 'S') {
					startR = i;
					startC = j;
				}
				if (map[i][j] == '*') {
					water.offer(new Point(i, j));
				}
			}
		}

		answer = -1;

		move(new Point(startR, startC));

		if (answer == -1) {
			sb.append("KAKTUS");
		} else {
			sb.append(answer);
		}

		out.write(sb.toString());
		out.close();
	}

	private static void move(Point p) {

		Queue<Point> queue = new ArrayDeque<>();

		int[][] visited = new int[R][C];

		queue.offer(p);

		int cnt = 0;

		while (!queue.isEmpty()) {

			Point curP = queue.poll();

			if (map[curP.r][curP.c] == 'D') {
				answer = visited[curP.r][curP.c];
				break;
			}

			// 물
			if (cnt == visited[curP.r][curP.c]) {
				int size = water.size();
				for (int i = 0; i < size; i++) {
					Point temp = water.poll();

					for (int j = 0; j < 4; j++) {
						int nextR = temp.r + dx[j];
						int nextC = temp.c + dy[j];

						if (check(nextR, nextC) && map[nextR][nextC] == '.') {
							map[nextR][nextC] = '*';
							water.offer(new Point(nextR, nextC));
						}
					}
				}
//				System.out.println(Arrays.deepToString(map));
				cnt++;
			}

			// 고슴도치 이동
			for (int i = 0; i < 4; i++) {
				int nextR = curP.r + dx[i];
				int nextC = curP.c + dy[i];

				if (check(nextR, nextC) && (map[nextR][nextC] == '.' || map[nextR][nextC] == 'D')
						&& (visited[nextR][nextC] == 0)) {

					visited[nextR][nextC] = visited[curP.r][curP.c] + 1;

					queue.offer(new Point(nextR, nextC));

				}
			}
		}

//		System.out.println(Arrays.deepToString(visited));
//		System.out.println(Arrays.deepToString(map));
		return;
	}

	private static boolean check(int r, int c) {
		if ((0 <= r && r < R) && (0 <= c && c < C)) {
			return true;
		}
		return false;
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

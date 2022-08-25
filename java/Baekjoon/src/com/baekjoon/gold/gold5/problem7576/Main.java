package com.baekjoon.gold.gold5.problem7576;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 7576 - 토마토, 골드 5
// https://www.acmicpc.net/problem/7576
public class Main {

	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 };

	private static int M, N;
	private static int[][] box;
	private static Queue<Point> tomatoes;

	private static int answer;
	private static int last;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		// 1 : 익은 토마토
		// 0 : 익지 않은 토마토
		// -1 : 들어있지 않은 칸

		box = new int[N][M];

		tomatoes = new ArrayDeque<Point>();
		answer = -1;
		last = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				if (box[i][j] == 1) {
					tomatoes.offer(new Point(i, j, 0));
				}
				if (box[i][j] == 0) {
					last++;
				}
			}
		}


		bfs();

		if(last > 0) {
			answer = -1;
		}
		
		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void bfs() {

		while (!tomatoes.isEmpty()) {

			Point curP = tomatoes.poll();
			
			answer = curP.depth;

			for (int i = 0; i < 4; i++) {
				int nextR = curP.r + dx[i];
				int nextC = curP.c + dy[i];

				if ((0 <= nextR && nextR < N) && (0 <= nextC && nextC < M) 
						&& box[nextR][nextC] == 0) {
					
					box[nextR][nextC] = 1;
					tomatoes.offer(new Point(nextR, nextC, curP.depth + 1));
					last--;
				}

			}

		}

	}
}

class Point {
	public int r;
	public int c;
	public int depth;

	public Point(int r, int c, int depth) {
		this.r = r;
		this.c = c;
		this.depth = depth;
	}
}

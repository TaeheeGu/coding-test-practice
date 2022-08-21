package com.baekjoon.gold.gold4.problem3190;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준, 3190번, 뱀, 골드 4
// https://www.acmicpc.net/problem/3190
public class Main {

	private static int[] dx = { 0, 1, 0, -1 }; // 우, 하, 좌, 상
	private static int[] dy = { 1, 0, -1, 0 };

	private static int N;

	private static int sec;
	private static int[][] board;
	private static int[][] moving;
	private static Point head;
	private static Queue<Point> snake;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine()); // 보드의 크기 N * N
		int K = Integer.parseInt(in.readLine()); // 사과의 개수 k

		board = new int[N + 1][N + 1]; // 1, 1 부터 시작

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			board[r][c] = 1; // 사과
		}

		int L = Integer.parseInt(in.readLine());

		moving = new int[L][2];

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()); // 뱀의 이동시간, 이동 방향

			moving[i][0] = Integer.parseInt(st.nextToken());

			if (st.nextToken().equals("D")) {
				moving[i][1] = 5; // 오른쪽 (dir + 1)%4
			} else {
				moving[i][1] = 10; // 왼쪽 (dir + 3)%4
			}
		}

		board[1][1] = -1; // 뱀
		head = new Point(1, 1, 0);
		snake = new ArrayDeque<Point>();

		snake.offer(new Point(1, 1, 0));

		sec = 0;
		int idx = 0;

		while (true) {
			if (idx < L && sec == moving[idx][0]) {
				int dir = head.d;

				if (moving[idx][1] == 5) { // 오른쪽인 경우
					dir = (dir + 1) % 4;
				}
				if (moving[idx][1] == 10) { // 왼쪽인 경우
					dir = (dir + 3) % 4;
				}

				int newR = head.r + dx[dir];
				int newC = head.c + dy[dir];

				if (!move(newR, newC, dir)) {
					break;
				}
				idx++;
			}

			else if (idx < L && sec < moving[idx][0]) {
				int dir = head.d;
				int newR = head.r + dx[dir];
				int newC = head.c + dy[dir];

				if (!move(newR, newC, dir)) {
					break;
				}
			} 
			
			else {
				int dir = head.d;
				int newR = head.r + dx[dir];
				int newC = head.c + dy[dir];

				if (!move(newR, newC, dir)) {
					break;
				}
			}

		}

		sb.append(sec + 1);
		out.write(sb.toString());
		out.close();
	}

	private static boolean move(int r, int c, int d) {
		if ((0 < r && r < N + 1) && (0 < c && c < N + 1) && board[r][c] != -1) {
			if (board[r][c] == 1) { // 사과가 있는 경우

				board[r][c] = -1;
				head = new Point(r, c, d);
				snake.offer(new Point(r, c, d));
			} else if (board[r][c] == 0) { // 사과가 없는 경우

				board[r][c] = -1;
				head = new Point(r, c, d);
				snake.offer(new Point(r, c, d));

				Point tail = snake.poll(); // 꼬리 이동
				int tailR = tail.r;
				int tailC = tail.c;
				board[tailR][tailC] = 0;
//				System.out.println("tail" + tail);
			}
			sec++;
			return true;
		} else {
			return false;
		}
	}
}

class Point {
	public int r;
	public int c;
	public int d;

	public Point(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Point [r=" + r + ", c=" + c + ", d=" + d + "]";
	}

}

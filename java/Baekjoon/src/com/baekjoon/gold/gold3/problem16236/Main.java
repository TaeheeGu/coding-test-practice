package com.baekjoon.gold.gold3.problem16236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BJ 16236 - 아기 상어, 골드 3
// https://www.acmicpc.net/problem/16236
public class Main {

	private static int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	private static int[] dy = { 0, 0, -1, 1 };

	private static int[][] board;
	private static int N;
	private static List<Point> fishes;
//	private static Point shark;
	private static int answer;

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());

		board = new int[N][N];
		fishes = new ArrayList<>();
		Point shark = new Point(-1, -1, 2);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (board[i][j] == 9) {
					shark.r = i;
					shark.c = j;
					board[i][j] = 0;
				}
			}
		}

		answer = 0;

		eating(shark);

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void eating(Point shark) {

		int eatCnt = 0;
		boolean possible = true;

		while (possible) {

			dist(shark);

			possible = false;

			Collections.sort(fishes, new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {

					if (o1.dist != o2.dist) {
						return o1.dist - o2.dist;
					}

					else {
						if (o1.r != o2.r) {
							return o1.r - o2.r;
						} else {
							return o1.c - o2.c;
						}
					}
				}
			});

			for (int i = 0; i < fishes.size(); i++) {

				Point fish = fishes.get(i);

				if (fish.weight < shark.weight) {
					board[fish.r][fish.c] = 0;
					answer += fish.dist;

					shark.r = fish.r;
					shark.c = fish.c;

//					System.out.println("sec" + answer);
					eatCnt++;
					if (eatCnt == shark.weight) {
						shark.weight++;
						eatCnt = 0;
					}
//					System.out.println("weight" + shark.weight);
					possible = true;
					break;
				}
			}

//			System.out.println("board" + Arrays.deepToString(board));
			fishes.clear();

		}

	}

	private static void dist(Point shark) {
		Queue<Point> queue = new ArrayDeque<Point>();
		int[][] visited = new int[N][N];

		int weight = shark.weight;
		queue.offer(shark);

		while (!queue.isEmpty()) {

			Point curP = queue.poll();

			int curR = curP.r;
			int curC = curP.c;

			for (int i = 0; i < 4; i++) {
				int nextR = curR + dx[i];
				int nextC = curC + dy[i];

				if (check(nextR, nextC) && weight >= board[nextR][nextC] && board[nextR][nextC] != 9
						&& visited[nextR][nextC] == 0) {

					int distance = visited[curR][curC] + 1;
					visited[nextR][nextC] = distance;
					queue.offer(new Point(nextR, nextC));

					// 물고기인 경우
					if (0 < board[nextR][nextC] && board[nextR][nextC] <= 6) {
						fishes.add(new Point(nextR, nextC, board[nextR][nextC], distance));

					}
				}
			}

		}

//		System.out.println("dist" + Arrays.deepToString(visited));

	}

	private static boolean check(int r, int c) {
		if ((0 <= r && r < N) && (0 <= c && c < N)) {
			return true;
		}
		return false;
	}
}

class Point {
	public int r;
	public int c;
	public int dist;
	public int weight;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public Point(int r, int c, int weight) {
		this.r = r;
		this.c = c;
		this.weight = weight;
	}

	public Point(int r, int c, int weight, int dist) {
		this.r = r;
		this.c = c;
		this.weight = weight;
		this.dist = dist;
	}

}
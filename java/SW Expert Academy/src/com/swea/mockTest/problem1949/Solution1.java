//package com.swea.mockTest.problem1949;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Solution1 {
//
//	static int N, K, maxHeight, answer;
//	static int[][] map;
//
//	static List<Point> start;
//
//	static int[] dx = { -1, 1, 0, 0 };
//	static int[] dy = { 0, 0, -1, 1 };
//
//	public static void main(String[] args) throws Exception {
//
//		// System.setIn(new FileInputStream("input.txt"));
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		StringBuilder sb = new StringBuilder();
//
//		int T = Integer.parseInt(in.readLine());
//
//		for (int t = 1; t <= T; t++) {
//			sb.append("#").append(t).append(" ");
//
//			StringTokenizer st = new StringTokenizer(in.readLine());
//
//			N = Integer.parseInt(st.nextToken());
//			K = Integer.parseInt(st.nextToken());
//
//			map = new int[N][N];
//
//			maxHeight = 0;
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(in.readLine());
//				for (int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//					maxHeight = Math.max(maxHeight, map[i][j]);
//				}
//			}
//
//			answer = -1;
//			for (int k = 1; k <= K; k++) {
//				for (int r = 0; r < N; r++) {
//					for (int c = 0; c < N; c++) {
//						map[r][c] -= k;
//						start = new ArrayList<>();
//						findHeight();
//						bfs();
//						map[r][c] += k;
//					}
//				}
//			}
//
//			sb.append(answer).append("\n");
//		}
//
//		out.write(sb.toString());
//		out.close();
//	}
//
//	private static void bfs() {
//		Queue<Point> queue = new ArrayDeque<Point>();
//
//		for (Point point : start) {
//			queue.offer(point);
//		}
//
//		while (!queue.isEmpty()) {
//			Point cur = queue.poll();
//			int r = cur.r;
//			int c = cur.c;
//			int depth = cur.depth;
//
//			answer = Math.max(answer, depth);
//
//			for (int idx = 0; idx < 4; idx++) {
//				int nextR = r + dx[idx];
//				int nextC = c + dy[idx];
//
//				if ((0 <= nextR && nextR < N) && (0 <= nextC && nextC < N) && (map[nextR][nextC] < map[r][c])) {
//					queue.offer(new Point(nextR, nextC, depth + 1));
//				}
//			}
//		}
//
//	}
//
//	private static void findHeight() {
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				if (map[r][c] == maxHeight) {
//					start.add(new Point(r, c, 1));
//				}
//			}
//		}
//
//	}
//}
//
//class Point {
//	int r;
//	int c;
//	int depth;
//
//	public Point(int r, int c, int depth) {
//		this.r = r;
//		this.c = c;
//		this.depth = depth;
//	}
//}

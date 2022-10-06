package com.baekjoon.silver.silver1.problem9205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Point[] points;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());

			points = new Point[N + 2];

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Point point = new Point(x, y);
				points[i] = point;
			}

			String answer = "sad";
			visited = new boolean[N + 2];
			Queue<Point> queue = new ArrayDeque<Point>();
			queue.offer(points[0]);
			visited[0] = true;

			q: while (!queue.isEmpty()) {
				Point cur = queue.poll();

				for (int i = 0; i < N + 2; i++) {
					Point p = points[i];
					int dist = Math.abs(cur.x - p.x) + Math.abs(cur.y - p.y);
					if (!visited[i] && dist <= 1000) {
						if (i == N + 1) {
							answer = "happy";
							break q;
						}
						visited[i] = true;
						queue.offer(p);
					}
				}
			}
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

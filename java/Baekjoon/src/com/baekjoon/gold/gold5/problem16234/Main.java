package com.baekjoon.gold.gold5.problem16234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	static int[] dy = { 0, 1, 0, -1 };

	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 전체 상태 확인
		// L명 이상, R명 이하면 연합으로 연결
		// 연결된 연합은 (연합 인구수) / 칸의 개수
		// 한 번 확인이 끝나면 인구 이동 발생 +1
		// 더 이상 이동이 없으면 종료

		boolean checking = true;
		while (checking) {
			checking = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) { // 아직 확인하지 않는 국가인 경우
						boolean temp = bfs(i, j); // 인구이동 발생 여부 확인
						if (temp) { // 한 번이라도 인구 이동이 발생했다면 다음 단계에서 인구 이동이 발생하는지 확인한다.
							checking = true;
						}
					}
				}
			}
			if (checking) { // 인구 이동이 한 번도 발생하지 않는 경우, 더 이상 인구 이동이 불가능하다.
				answer++;
				visited = new boolean[N][N]; // 새로운 인구이동을 확인하기 위해 방문 여부 초기화
			}
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static boolean bfs(int row, int col) {

		List<Country> list = new ArrayList<>(); // 연합으로 묶이는 국가를 담기 위한 리스트
		Queue<Country> queue = new ArrayDeque<>(); // 연합으로 묶이는 국가의 여부를 확인, 너비 우선 탐색

		Country country = new Country(row, col, map[row][col]);

		list.add(country); // 시작 국가 추가
		queue.offer(country); // 시작 국가 추가

		int cnt = 1;
		int sum = map[row][col];
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Country current = queue.poll();

			int curRow = current.row;
			int curCol = current.col;
			int curSize = current.size;

			for (int idx = 0; idx < 4; idx++) { // 4방향 탐색, 인접한 국가 탐색
				int nextRow = curRow + dx[idx];
				int nextCol = curCol + dy[idx];

				if (check(nextRow, nextCol) && !visited[nextRow][nextCol]) { // map의 영역을 벗어나지 않고 아직 탐색하지 않는 국가인 경우
					int diffSize = Math.abs(map[nextRow][nextCol] - curSize); // 현재 국가와 인구 수 차이 계산
					if (L <= diffSize && diffSize <= R) { // 인구 수 차이가 주어진 범위 내에 있을 때
						Country nextCountry = new Country(nextRow, nextCol, map[nextRow][nextCol]);

						list.add(nextCountry); // 연합에 추가
						queue.offer(nextCountry); // 다음 탐색을 위해 큐에 추가

						sum += map[nextRow][nextCol]; // 연합의 전체 인구 수 증가
						cnt++; // 연합의 국가 수 증가

						visited[nextRow][nextCol] = true; // 탐색 여부 확인(연합 결성 여부)
						// 연합에 포함되지 않는 경우 다른 연합에 포함될 수 있기 때문에 현재 연합에 포함 여부를 확인한다.
					}
				}
			}
		}

		if (cnt > 1) { // 연합이 결성된 경우(연합의 국가 수 가 2이상인 경우)
			int newSize = sum / cnt; // 연합내 국가들의 새로운 인구 수

			for (int i = 0; i < list.size(); i++) { // 연합으로 국가들
				Country c = list.get(i);
				map[c.row][c.col] = newSize; // 새로운 인구수 정의
			}
			return true; // 인구 이동 발생 여부
		}
		return false;

	}

	private static boolean check(int nextRow, int nextCol) {
		return (0 <= nextRow && nextRow < N) && (0 <= nextCol && nextCol < N);
	}
}

class Country {
	int row;
	int col;
	int size;

	public Country(int row, int col, int size) {
		this.row = row;
		this.col = col;
		this.size = size;
	}

}

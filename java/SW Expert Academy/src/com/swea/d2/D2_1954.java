package com.swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


// 1954. 달팽이 숫자 D2
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
public class D2_1954 {

	public static int[] dx = { 0, 1, 0, -1 }; // 좌, 하, 우, 상
	public static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");
			int N = Integer.parseInt(in.readLine());

			int[][] arr = new int[N][N];

			int curX = 0;
			int curY = 0;
			int idx = 0;
			int cnt = 1;

			while (true) {		
				arr[curX][curY] = cnt; // 현재 위치 숫자
				
				int nextX = curX + dx[idx]; // 다음으로 갈 인덱스 확인
				int nextY = curY + dy[idx];
				
				if(cnt == N*N) {
					break;
				}
				
				if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) { // 범위를 벗어나는 경우 방향 바꾸기
					idx = (idx + 1) % 4;
					continue;
				}
				if(arr[nextX][nextY] != 0) { // 이미 값이 대입된 경우 방향 바꾸기
					idx = (idx + 1) % 4;
					continue;
				}
				curX = nextX; // 확인된 다음 인덱스
				curY = nextY;
				cnt++; // 대입할 값 증가
				
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}

		}
		out.write(sb.toString());
		out.close();
	}
}

package com.swea.d3.problem1873;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1873. 상호의 배틀필드 D3
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
public class Solution {

	public static char[] looks = { '^', 'v', '<', '>' }; // 현재 전차의 상태
	public static char[] dirs = { 'U', 'D', 'L', 'R' }; // 입력 받은 방향
	public static int[] dx = { -1, 1, 0, 0 }; // UDLR 방향에 따른 델타 값
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			// 입력 받기
			StringTokenizer st = new StringTokenizer(in.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];

			int x = 0; // 최초 전차의 위치
			int y = 0;

			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(in.readLine());
				char[] temp = st.nextToken().toCharArray();
				for (int w = 0; w < W; w++) {
					if (temp[w] == '^' || temp[w] == 'v' || temp[w] == '<' || temp[w] == '>') { // 최초 전차의 위치 찾기
						x = h; // 현재 전차 좌표
						y = w;
					}
					map[h][w] = temp[w];
				}
			}

			int N = Integer.parseInt(in.readLine());

			char[] inputs = in.readLine().toCharArray();

			// 문제 해결
			int look = -1;
			int dir = -1;
			
			for (int i = 0; i < N; i++) { // 입력받은 명령어 수 만큼 반복
				char input = inputs[i];
				// 포탄을 쏘는 경우
				if (input == 'S') {
					for (int idx = 0; idx < 4; idx++) {
						if (map[x][y] == looks[idx]) {
							look = idx; // 현재 전차가 바라보는 방향
							break;
						}
					}
					int shootX = x + dx[look]; // 포탄이 날아갈 다음 위치
					int shootY = y + dy[look];

					while (true) {
						if (shootX < 0 || shootX > H - 1 || shootY < 0 || shootY > W - 1) { // 포탄이 맵을 벗어나면 종료
							break;
						}
						if (map[shootX][shootY] == '.' || map[shootX][shootY] == '-') { // 포탄이 평지나 물을 지나가는 경우 진행 방향으로 계속 나아간다.
							shootX += dx[look];
							shootY += dy[look];
							continue;
						}
						if (map[shootX][shootY] == '*') { // 포탄이 벽을 만나면 벽을 평지로 바꾸고 종료
							map[shootX][shootY] = '.';
							break;
						}
						if (map[shootX][shootY] == '#') { // 포탄이 강철벽을 만나면 종료
							break;
						}
					}
				}

				// 이동하는 경우
				if (input != 'S') {
					for (int idx = 0; idx < 4; idx++) {
						if (input == dirs[idx]) {
							dir = idx;  // 4방향 중 입력된 방향
							break;
						}
					}
					map[x][y] = looks[dir]; // 입력된 방향으로 현재 전차가 바로보는 방향을 바꾼다.
					
					int moveX = x + dx[dir]; // 입력된 방향으로 나아갈 다음 위치
					int moveY = y + dy[dir];

					if (!(moveX < 0 || moveX > H - 1 || moveY < 0 || moveY > W - 1)) { // 다음 위치가 맵을 벗어나지 않는 경우
						if (map[moveX][moveY] == '.') { // 다음 위치가 이동 가능한 평지인 경우
							map[moveX][moveY] = map[x][y]; // 다음 위치로 전차 이동
							map[x][y] = '.'; // 기존의 위치는 평지로
							x = moveX; // 현재 전차 위치 변경
							y = moveY;
						}
					}
				}
			}
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		out.write(sb.toString());
		out.close();
	}
}

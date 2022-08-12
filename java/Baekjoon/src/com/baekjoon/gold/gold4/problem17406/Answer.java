package com.baekjoon.gold.gold4.problem17406;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//17406번 배열돌리기 4, 골드4
//https://www.acmicpc.net/problem/17406
public class Answer {

	static int N, M, K;

	static int[][] RCS; // 선택된 회전 연산 저장
	static int[][] input; // 회전 연산들을 저장하는 배열

	static boolean[] isSelected; // 순열에서 사용할 flag

	static int[][] A; // 문제에서 주어진 2차원 배열

	static int min; // 각 행의 합 중 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 배열 A에 값 넣기
		A = new int[N + 1][M + 1]; // 1번 인덱스부터 사용
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		input = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}

		// 전역변수 초기화
		RCS = new int[K][3];
		isSelected = new boolean[K];
		min = 100 * 50; // 한 칸에 들어갈 수 있는 최댓값 * 최대 열의 수

		perm(0);

		sb.append(min);
		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {

		// 기저 부분
		if (cnt == K) {

			// A 배열을 B 배열로 복사
			int[][] B = new int[N + 1][M + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					B[i][j] = A[i][j];
				}
			}

			// 순열에 의해 RCS에 입력된 회전 연산 순서대로 실행
			for (int k = 0; k < K; k++) {

				// 모든 연산 중 하나를 선택하여 RCS 배열에 담는다.
				// 선택된 연산을 RCS 배열을 이용하여 수행한다.

				// 회전 연산의 정고 r, c, s
				int r = RCS[k][0];
				int c = RCS[k][1];
				int s = RCS[k][2];

				// 가장 왼쪽 윗 칸
				int startX = r - s;
				int startY = c - s;

				// 가장 오른쪽 아랫칸
				int endX = r + s;
				int endY = c + s;

				// 돌려야할 사각형 개수
				int rectCount = Math.min(endX - startX + 1, endY - startY + 1) / 2;

				for (int idx = 0; idx < rectCount; idx++) {

					// 돌려야할 사각형 기준점 변경
					startX = r - s + idx;
					startY = c - s + idx;
					endX = r + s - idx;
					endY = c + s - idx;

					int temp = A[startX][startY]; // 사각형 좌측 상단의 값을 임시저장

					// 좌변 : 아래에서 위로 이동
					for (int i = startX; i < endX; i++) {
						A[i][startY] = A[i + 1][startY];
					}

					// 아랫변 : 오른쪽에서 왼쪽으로 이동
					for (int i = startY; i < endY; i++) {
						A[endX][i] = A[endX][i + 1];
					}

					// 우변 : 위에서 아래로 이동
					for (int i = endX; i > startX; i--) {
						A[i][endY] = A[i - 1][endY];
					}

					// 윗변 : 왼쪽에서 오른쪽으로 이동
					for (int i = endY; i > startY; i--) {
						A[startX][i] = A[startX][i - 1];
					}

					// 임시 값 다시 넣기
					A[startX][startY + 1] = temp;
				}
			}

			// 최솟값 구하기
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += A[i][j];
				}
				min = Math.min(min, sum);
			}

			// A배열 초기화
			A = B;

			return;
		}

		// 유도부분
		// 시도하는 연산이 선택되었는지 판단
		for (int i = 0; i < K; i++) {
			if (!isSelected[i]) { // 선택되지 않았다면 연산을 사용
				RCS[cnt] = input[i];
				isSelected[i] = true;

				// 다음 뽑을 연산
				perm(cnt + 1);

				// 사용했던 수 되돌리기
				isSelected[i] = false;
			}
		}
	}
}

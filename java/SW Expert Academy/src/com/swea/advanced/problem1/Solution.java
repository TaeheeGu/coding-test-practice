package com.swea.advanced.problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// No. 1 [연습문제] 낚시터 자리잡기
// https://swexpertacademy.com/main/talk/codeBattle/problemDetail.do?contestProbId=AYLNTUm6AswDFASv&categoryId=AYLNSmY6An0DFASv&categoryType=BATTLE&battleMainPageIndex=
public class Solution {

	private static int N;
	private static int[] gate;
	private static int[] watting;

	private static int answer;

	// perm
	private static int[] numbers;
	private static boolean[] isSelected;

	// dfs
	private static int[] visited;

	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			N = Integer.parseInt(in.readLine());

			gate = new int[3];
			watting = new int[3];

			for (int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());

				gate[i] = Integer.parseInt(st.nextToken());
				watting[i] = Integer.parseInt(st.nextToken());
			}

			answer = Integer.MAX_VALUE;

			isSelected = new boolean[3];
			numbers = new int[3];
			perm(0);

			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {

		if (cnt == 3) {
			visited = new int[N + 1];
//			System.out.println(Arrays.toString(numbers));
			dfs(0, 0, 0);
//			System.out.println(Arrays.toString(visited));
			return;
		}

		for (int i = 0; i < 3; i++) {

			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[cnt] = i;
				perm(cnt + 1);

				isSelected[i] = false;
			}
		}
	}

	private static void dfs(int idx, int cnt, int temp) {

		if (temp > answer) {
			return;
		}

		if (idx == 3) {
//
//			System.out.println(Arrays.toString(visited));
			answer = Math.min(answer, temp);
			return;
		}

		if (watting[numbers[idx]] == cnt) {
			dfs(idx + 1, 0, temp);
		} else {
			for (int i = 0; i <= N; i++) {

				int len = i + 1;

				if (watting[numbers[idx]] - cnt > 1) {

					if ((0 < gate[numbers[idx]] - i) && visited[gate[numbers[idx]] - i] == 0) {

						visited[gate[numbers[idx]] - i] = len;

						dfs(idx, cnt + 1, temp + len);

						visited[gate[numbers[idx]] - i] = 0;
						break;
					}

					if ((gate[numbers[idx]] + i <= N) && visited[gate[numbers[idx]] + i] == 0) {

						visited[gate[numbers[idx]] + i] = len;

						dfs(idx, cnt + 1, temp + len);

						visited[gate[numbers[idx]] + i] = 0;
						break;
					}

				}

				else {

					if ((0 < gate[numbers[idx]] - i && visited[gate[numbers[idx]] - i] == 0) && (gate[numbers[idx]] + i <= N && visited[gate[numbers[idx]] + i] == 0)) {

						visited[gate[numbers[idx]] - i] = len;
						dfs(idx, cnt + 1, temp + len);
						visited[gate[numbers[idx]] - i] = 0;

						visited[gate[numbers[idx]] + i] = len;
						dfs(idx, cnt + 1, temp + len);
						visited[gate[numbers[idx]] + i] = 0;

						break;
					} else if ((0 < gate[numbers[idx]] - i && visited[gate[numbers[idx]] - i] == 0)) {
						visited[gate[numbers[idx]] - i] = len;
						dfs(idx, cnt + 1, temp + len);
						visited[gate[numbers[idx]] - i] = 0;
						break;
					} else if ((gate[numbers[idx]] + i <= N && visited[gate[numbers[idx]] + i] == 0)) {
						visited[gate[numbers[idx]] + i] = len;
						dfs(idx, cnt + 1, temp + len);
						visited[gate[numbers[idx]] + i] = 0;
						break;

					}
				}
			}
		}

	}

}

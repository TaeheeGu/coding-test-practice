package com.swea.advanced.problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

// No. 1 [연습문제] 낚시터 자리잡기
// https://swexpertacademy.com/main/talk/codeBattle/problemDetail.do?contestProbId=AYLNTUm6AswDFASv&categoryId=AYLNSmY6An0DFASv&categoryType=BATTLE&battleMainPageIndex=
public class Solution {

	private static int N;
	private static int[] gate;
	private static int[] watting;
	private static boolean[] isSelected;
	private static int[] numbers;
	private static int[] visited;
	private static int answer;

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

			isSelected = new boolean[3];
			numbers = new int[3];
			answer = Integer.MAX_VALUE;
			perm(0);
		}

		sb.append(answer);
		out.write(sb.toString());
		out.close();
	}

	private static void perm(int cnt) {

		if (cnt == 3) {
			int[] visited = new int[N + 1];

			System.out.println("case");
			System.out.println(Arrays.toString(numbers));

			getDist(0, visited);
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

	private static void getDist(int idx, int[] visited) {

		if (idx == 3) {
			int temp = 0;
			for (int i = 1; i <= N; i++) {
				temp += visited[i];
			}
			answer = Math.min(answer, temp);
			System.out.println("visited");
			System.out.println(Arrays.toString(visited));
			return;
		}

		int gateNum = gate[numbers[idx]];
		int wattingNum = watting[numbers[idx]];

		if (visited[gateNum] == 0) {
			visited[gateNum] = 1;
			wattingNum--;
		}

		for (int i = 0; i < wattingNum - 1; i++) {
			int leftMove = getLeft(gateNum, visited);
			int rightMove = getRight(gateNum, visited);

			if (leftMove <= rightMove) {
				visited[gateNum - leftMove + 1] = leftMove;
			} else {
				visited[gateNum + rightMove - 1] = rightMove;
			}
		}

		int leftMove = getLeft(gateNum, visited);
		int rightMove = getRight(gateNum, visited);

		if (leftMove < rightMove) {
			visited[gateNum - leftMove + 1] = leftMove;
			getDist(idx + 1 , visited);
		} else if (leftMove > rightMove) {
			visited[gateNum + rightMove - 1] = rightMove;
			getDist(idx + 1 , visited);
		} else if (leftMove == rightMove) {
			visited[gateNum - leftMove + 1] = leftMove;
			getDist(idx + 1 , visited);
			
			visited[gateNum - leftMove + 1] = 0;
			visited[gateNum + rightMove - 1] = rightMove;
			getDist(idx + 1 , visited);
		}

	}

	private static int getRight(int gateNum, int[] visited) {
		int dist = 0;

		for (int i = gateNum + 1; i <= N; i++) {
			if (visited[i] == 0) {
				dist = i - gateNum + 1;
				break;
			}

		}

		return dist != 0 ? dist : Integer.MAX_VALUE;
	}

	private static int getLeft(int gateNum, int[] visited) {
		int dist = 0;

		for (int i = gateNum - 1; i > 0; i--) {
			if (visited[i] == 0) {
				dist = gateNum - i + 1;
				break;
			}

		}

		return dist != 0 ? dist : Integer.MAX_VALUE;
	}
}

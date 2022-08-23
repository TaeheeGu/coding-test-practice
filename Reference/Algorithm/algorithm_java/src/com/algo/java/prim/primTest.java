package com.algo.java.prim;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class primTest {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine()); // 정점의 개수

		int[][] adjMatrix = new int[N][N]; // 인접 행렬

		int[] minEdge = new int[N]; // 타 정점에서 자신으로의 간선 비용 중 최소 비용

		boolean[] visited = new boolean[N]; // 최소신장트리에 선택된 여부

		// input으로 주어진 인접 행렬 데이터 adjMatrix에 담기
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(split[j]);
			}
			minEdge[i] = Integer.MAX_VALUE; // 최솟값 초기화
		}

		int result = 0; // MST 비용
		minEdge[0] = 0; // 임의의 시작점 비용 0 설정

		// 모든 정점 수 만큼 반복
		for (int count = 0; count < N; count++) {

			// 신장트리에 연결되지 않은 정점 중 가장 유리한 비용의 정점을 선택
			int min = Integer.MAX_VALUE; // 초기값으로 정수의 최대치를 주고 시작'
			int minVertex = 0;

			// 1단계
			for (int i = 0; i < N; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			// 선택된 정점을 신장트리에 포함
			visited[minVertex] = true;
			result += min;

			// 2단계 : 선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고
			// 최솟값 갱신
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
		System.out.println(result);

	}
}

/**

<test data>

정점의 개수

정점에 대한 정보

5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175

*/
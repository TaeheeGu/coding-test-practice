package com.swea.mockTest.problem2477;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, K, A, B, answer, receptionIdx, repairIdx;
	static int[] a, b, tk;
	static Customer[] customers;
	static Queue<Integer> wating;
	static Queue<Integer> watingRepairing;
	static List<Customer> repairing;

	public static void main(String[] args) throws Exception {

		// System.setIn(new FileInputStream("input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); // 접수 창구
			M = Integer.parseInt(st.nextToken()); // 정비 창구
			K = Integer.parseInt(st.nextToken()); // 고객 수
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			a = new int[N + 1]; // 접수 창구 소요 시간
			b = new int[M + 1]; // 정비 창구 소요 시간
			tk = new int[K + 1]; // 고객 도착 시작
			customers = new Customer[K + 1]; // 고객 정보

			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= K; i++) {
				tk[i] = Integer.parseInt(st.nextToken());
				customers[i] = new Customer(i);
			}

			answer = 0;
			repairing = new ArrayList<>();
			reception();
			repair();

			answer = answer==0?-1:answer;
			sb.append(answer).append("\n");
		}

		out.write(sb.toString());
		out.close();
	}

	private static void repair() {
		int[] used = new int[M + 1];
		int[] desk = new int[M + 1]; // 데스트에서 남은 시간
		Arrays.fill(desk, -1);
		
		Customer start = repairing.get(0);
		int time = start.moveRepairTime;
		int cnt = 0;

		watingRepairing = new ArrayDeque<Integer>();
		
		addWaitingRepairing(time);
		
		while (cnt < K) {
			for (int i = 1; i <= M; i++) {
				if (desk[i] > 0) { // 창구에 사람이 있는 경우
					desk[i]--;
//					continue;
				}
				if (desk[i] == 0) { // 창구 작업이 끝난 경우
					desk[i] = -1;
					if(customers[used[i]].reception == A && i == B) {
						answer += customers[used[i]].num;
					}
					used[i] = 0;
					cnt++;
				}
			}

			// 기다리는 사람이 있는 경우
			if (!watingRepairing.isEmpty()) {
				for (int i = 1; i <= M; i++) {
					if (used[i] == 0) {
						used[i] = watingRepairing.poll(); // 비어있는 창구로
						desk[i] = b[i]; // 이동한 창구에서 걸리는 시간
						if (watingRepairing.isEmpty()) {
							break;
						}
					}
				}
			}

//			System.out.println(time + " " + Arrays.toString(used));

			time++;
			addWaitingRepairing(time);
		}

	}

	private static void addWaitingRepairing(int time) {
		for (int i = 0; i < K; i++) {
			if (time == repairing.get(i).moveRepairTime) {
				watingRepairing.offer(repairing.get(i).num);
			}
		}
		
	}

	private static void reception() {
		int[] used = new int[N + 1];
		int[] desk = new int[N + 1]; // 데스트에서 남은 시간
		Arrays.fill(desk, -1);

		wating = new ArrayDeque<Integer>();

		receptionIdx = 1; // 시작 고객 번호
		int cnt = 0; // 처리한 고객 수
		wating.offer(receptionIdx);
		int time = tk[receptionIdx];

		addWaiting(time);

		while (cnt < K) {
			for (int i = 1; i <= N; i++) {
				if (desk[i] > 0) { // 창구에 사람이 있는 경우
					desk[i]--;
				}
				if (desk[i] == 0) { // 창구 작업이 끝난 경우
					desk[i] = -1;
					customers[used[i]].reception = i;
					customers[used[i]].moveRepairTime = time;
					repairing.add(customers[used[i]]);
					used[i] = 0;
					cnt++;
				}
			}

			// 기다리는 사람이 있는 경우
			if (!wating.isEmpty()) {
				for (int i = 1; i <= N; i++) {
					if (used[i] == 0) {
						used[i] = wating.poll(); // 비어있는 창구로
						desk[i] = a[i]; // 이동한 창구에서 걸리는 시간
						if (wating.isEmpty()) {
							break;
						}
					}
				}
			}

//			System.out.println(time + " " + Arrays.toString(used));

			time++;
			if (receptionIdx < K) {
				addWaiting(time);
			}
		}
	}

	// 현재 방분한 고객과 같은 시간에 방문한 경우
	private static void addWaiting(int time) {
		for (int i = receptionIdx + 1; i <= K; i++) {
			if (time == tk[i]) {
				wating.offer(i);
				receptionIdx = i; // 동시에 도착한 사람 중 마지막
			} else {
				return;
			}
		}
	}
}

class Customer {
	int num;
	int reception;
	int repair;
	int moveRepairTime;

	public Customer(int num) {
		this.num = num;
	}

}

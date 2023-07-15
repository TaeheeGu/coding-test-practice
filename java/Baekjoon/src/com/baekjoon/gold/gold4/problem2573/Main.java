package com.baekjoon.gold.gold4.problem2573;

import java.io.*;
import java.util.*;

// 메모리 초과 큐 및 배열 temp 사용 X 방문기록 혹은 방문횟수 저장 생각 필요
public class Main {

    static int N, M;
    static int[][] arr;
    static int answer;
    static Queue<Ice> que;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String[] split = in.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[N][M];
        answer = 0;
        que = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            split = in.readLine().split(" ");
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(split[j]);
                if(arr[i][j] > 0) {
                    que.add(new Ice(i, j, arr[i][j]));
                }
            }
        }

        while(true){
            if(!melting()){
                break;
            }
        }

        sb.append(answer);
        out.write(sb.toString());
        out.close();

    }

    private static boolean melting() {

        int[][] temp = new int[N][M];

        if(que.isEmpty()){
            answer = 0;
            return false;
        }

        Queue<Ice> tempQue = new ArrayDeque<>();
        while(!que.isEmpty()){
            Ice cur = que.poll();
            int row = cur.row;
            int col = cur.col;
            int dep = cur.depth;

            for(int i = 0; i < 4; i++){
                if(arr[row + dx[i]][col + dy[i]] == 0){
                    dep--;
                }
            }
            if(dep > 0){
                tempQue.offer(new Ice(row, col, dep));
            }
            if(dep <= 0) {
                dep = 0;
            }
            temp[row][col] = dep;
        }

        while (!tempQue.isEmpty()){
            que.offer(tempQue.poll());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = temp[i][j];
            }
        }
        answer++;

        int divide = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j] > 0){
                    divide++;
                    if(divide >= 2){
                        return false;
                    }
                    Queue<Ice> queue = new ArrayDeque<>();
                    queue.offer(new Ice(i, j, temp[i][j]));
                    while (!queue.isEmpty()){
                        Ice cur = queue.poll();
                        int row = cur.row;
                        int col = cur.col;

                        temp[row][col] = 0;

                        for(int k = 0; k < 4; k++){
                            if(temp[row + dx[k]][col + dy[k]] > 0){
                                queue.offer(new Ice(row + dx[k], col + dy[k], 0));
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

class Ice{
    int row;
    int col;
    int depth;

    public Ice(int row, int col, int depth){
        this.row = row;
        this.col = col;
        this.depth = depth;
    }
}

package com.baekjoon.gold.gold5.problem7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int M, N, H, need, answer;
    static int[][][] box;
    static Queue<Tomato> que = new ArrayDeque<>();
    static int[] dDep = {-1, 1};
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        String[] state = in.readLine().split(" ");

        M = Integer.parseInt(state[0]);
        N = Integer.parseInt(state[1]);
        H = Integer.parseInt(state[2]);

        box = new int[H][N][M]; // 면, 행, 열
        need = 0;
        answer = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] split = in.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(split[k]);
                    box[i][j][k] = tomato;
                    if (tomato == 1) {
                        que.offer(new Tomato(i, j, k, 0));
                    }
                    if (tomato == 0) {
                        need++;
                    }
                }
            }
        }

        // bfs
        bfs();

        if(need != 0){
            answer = -1;
        }

        sb.append(answer);
        out.write(sb.toString());
        out.close();
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Tomato cur = que.poll();
            int dep = cur.dep;
            int row = cur.row;
            int col = cur.col;
            int day = cur.day;

            for (int i = 0; i <= 1; i++) {
                int newDep = dep + dDep[i];
                if (checkUpDown(newDep)) {
                    if (box[newDep][row][col] == 0) {
                        box[newDep][row][col] = 1;
                        que.offer(new Tomato(newDep, row, col, day + 1));
                        need--;
                    }
                }
            }

            for(int i = 0; i < 4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];
                if(checkBound(newRow, newCol)){
                    if (box[dep][newRow][newCol] == 0) {
                        box[dep][newRow][newCol] = 1;
                        que.offer(new Tomato(dep, newRow, newCol, day + 1));
                        need--;
                    }
                }
            }
            answer = day;
        }
    }

    private static boolean checkBound(int r, int c) {
        if(0 <= r && r < N && 0 <= c && c < M){
            return true;
        }
        return false;
    }

    private static boolean checkUpDown(int d) {
        if (0 <= d && d < H) {
            return true;
        }
        return false;
    }

    static class Tomato {
        int row;
        int col;
        int dep;

        int day;

        public Tomato(int dep, int row, int col, int day) {
            this.dep = dep;
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
}

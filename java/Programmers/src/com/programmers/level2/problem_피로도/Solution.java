package com.programmers.level2.problem_피로도;

import java.util.*;

class Solution {
    
    static int N, K, answer;
    static int[] numbers;
    static int[][] D;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        
        N = dungeons.length;
        K = k;
        D = dungeons;
        
        numbers = new int[N];
        visited = new boolean[N];
        perm(0);
        
        return answer;
    }
    
    public void perm(int cnt){
        if(cnt == N){
            // System.out.println(Arrays.toString(numbers));
            
            int temp = 0;
            int piro = K;
            for(int i = 0; i < N;i++){
                int need = D[numbers[i]][0];
                int use = D[numbers[i]][1];
                
                if(piro >= need){
                    temp++;
                    piro -= use;
                }
                else{
                    break;
                }
            }
            answer = Math.max(answer, temp);
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                numbers[cnt] = i;
                visited[i] = true;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
package com.programmers.level2.problem_위장;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++){
            String clothesName = clothes[i][0];
            String category = clothes[i][1];
            
            if(map.containsKey(category)){
                int cnt = map.get(category);
                cnt++;
                map.put(category, cnt);
            }
            else {
                map.put(category, 1);
            }
        }
        
        int n = map.size();
        int[] count = new int[map.size()];
        int idx = 0;
        for(Map.Entry m : map.entrySet()){
            count[idx] = (int)m.getValue() + 1;
            idx++;
        }
        
        for(int i = 0; i < n;i++){
            answer *= count[i];
        }
        
        return answer-1;
    }
}